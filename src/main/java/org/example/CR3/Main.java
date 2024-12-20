package org.example.CR3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    //Задаем статичное поле логгера, чтобы вызывать актуальную конфигурацию через методы
    static Logger logger;

    //Статичный метод получения списка пользователей из JSON-файла
    public static List<Person> getPersons() throws IOException {
        //Создаем объект ObjectMapper для перевода JSON-файла в структуру дерева JSON-node
        ObjectMapper objectMapper = new ObjectMapper();
        //Инициализируем список возвращаемых пользователей
        List<Person> persons = new ArrayList<>();
        //Пытаемся считать пользователей
        try {
            //Переводим JSON-файл в структуру дерева JSON-node
            JsonNode jsonNode = objectMapper.readTree(new FileReader("persons.json"));
            //Извлекаем из дерева JSON-node под одному узлу
            for (JsonNode person : jsonNode) {
                //Парсим узел, создавая из него нового пользователя, которого добавляем в итоговый список
                //Парсинг осуществляем путем извлечения из JSON-узлов свойств, которые преобразовываем к нужным типам Int или Text

                String personName = person.get("name").asText();
                Date personAge = new Date(Integer.parseInt(person.get("birthDate").asText().substring(6, 10)),
                        Integer.parseInt(person.get("birthDate").asText().substring(3, 5)) - 1,
                        Integer.parseInt(person.get("birthDate").asText().substring(0, 2)));
                String personEmail = person.get("email").asText();
                persons.add(new Person(personName, personAge, personEmail));
            }
            //В конце логируем информационное сообщение об успешном считывании файла
            logger.log(Level.INFO, "JSON файл успешно считан");
        }
        //При необходимости выбрасываем исключение с соответствующим сообщением ошибки в лог-файл
        catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        //Возвращаем список пользователей
        return persons;
    }

    //Статичный метод фильтрации списка персон по возрасту
    public static List<Person> getFilteredPersons(List<Person> persons) throws IOException {
        //Задаем фильтр (через лямбду и функциональный интерфейс), например - пользователи старше 18 лет
        PersonFilter ageFilter = person -> person.getAge() > 18;
        //Получаем результирующий список
        //Фильтрацию проводим через StreamAPI
        List<Person> filteredPersons = persons.stream().filter(ageFilter::filter).toList();
        //Поочередно логгируем все отфильтрованные имена
        for (int i = 0; i < filteredPersons.size(); i++) {
            logger.log(Level.INFO, "Проверку на совершеннолетие прошла персона с именем " + filteredPersons.get(i).getName());
        }
        //Возвращаем отфильтрованный список пользователей
        return filteredPersons;
    }

    //Статичный метод фильтрации списка персон по признаку рождения в високосный год
    public static List<Person> getLeapYearPersons(List<Person> persons) throws IOException {
        //Задаем фильтр (через лямбду и функциональный интерфейс), например - персона родилась в високосный год
        PersonFilter birthYearFilter = person -> (person.getBirthDate().getYear() % 4 == 0 && person.getBirthDate().getYear() % 100 != 0)
                                                 || (person.getBirthDate().getYear() % 400 == 0);
        //Получаем результирующий список
        //Фильтрацию проводим через StreamAPI
        List<Person> filteredPersons = persons.stream().filter(birthYearFilter::filter).toList();
        //Поочередно логгируем все отфильтрованные имена
        for (int i = 0; i < filteredPersons.size(); i++) {
            logger.log(Level.INFO, "Проверку на високосный год рождения прошла персона с именем " + filteredPersons.get(i).getName());
        }
        //Возвращаем отфильтрованный список пользователей
        return filteredPersons;
    }

    //Статичный метод группировки списка персон по группе возраста
    public static Map<String, List<Person>> getPersonGroups(List<Person> persons) throws IOException {
        //Определяем фильтры для принадлежности персон к группе
        PersonFilter personGroupFilter1 = person -> person.getAge() < 18;
        PersonFilter personGroupFilter2 = person -> person.getAge() >= 18 && person.getAge() < 50;
        PersonFilter personGroupFilter3 = person -> person.getAge() >= 50;
        //Получаем результирующий список детей
        List <Person> personGroup1 = persons.stream().filter(personGroupFilter1::filter).toList();
        //Получаем результирующий список детей
        List <Person> personGroup2 = persons.stream().filter(personGroupFilter2::filter).toList();
        //Получаем результирующий список детей
        List <Person> personGroup3 = persons.stream().filter(personGroupFilter3::filter).toList();
        //Соединяем группы в единый словарь
        Map<String, List<Person>> personGroups = new HashMap<>();
        personGroups.put("Дети", personGroup1);
        personGroups.put("Взрослые", personGroup2);
        personGroups.put("Пенсионеры", personGroup3);
        //Логгируем информацию о количестве персон в каждой группе
        logger.log(Level.INFO, "Количество детей в группе: " + personGroup1.size());
        logger.log(Level.INFO, "Количество взрослых в группе: " + personGroup2.size());
        logger.log(Level.INFO, "Количество пенсионеров в группе: " + personGroup3.size());
        //Возвращаем словарь с группами персон
        return personGroups;
    }

    //Статичный метод получение среднего возраста персон
    public static Double getMeanAge (List<Person> persons) throws IOException{
        //Получаем средний возраст персон в списке
        Double averageAge = persons.stream().mapToDouble(Person::getAge).average().getAsDouble();
        //Логгируем информацию о среднем возрасте всех персон из исходного списка
        logger.log(Level.INFO, "Средний возраст всех персон в списке равен " + averageAge);
        //Возвращаем средний возраст персон
        return averageAge;
    }

    //Статичный метод сортировки списка персон по полному возрасту
    public static List<Person> getSortedPersons(List<Person> persons) throws IOException {
        //Засекаем стартовое время
        long SortStartTime = System.currentTimeMillis();
        //Сортируем список персон по возрасту
        persons.sort(Comparator.comparing(Person::getAge));
        //Фиксируем конечное время работы
        long SortEndTime = System.currentTimeMillis();
        //Логгируем информацию о времени работы сортировки
        logger.log(Level.INFO, "Сортировка отработала за " + (SortEndTime - SortStartTime) + " мс");
        //Возвращаем отсортированный список пользователей
        return persons;
    }

    //Статичный метод записи списка пользователей в JSON-файл
    public static void writeUsers(List<Person> persons, String fileName) throws IOException {
        //Создаем объект ObjectMapper для перевода JSON-файла в структуру дерева JSON-node
        ObjectMapper objectMapper = new ObjectMapper();
        //Создаем объект ObjectNode узла (записи)
        ObjectNode jsonNode;
        //Создаем JSON-массив
        ArrayNode arrayNode = objectMapper.createArrayNode();
        //Перебираем список пользователей
        for (Person person : persons) {
            //Инициализируем пустой узел
            jsonNode = objectMapper.createObjectNode();
            //Добавляем данные: поле name, данные user.getId()
            jsonNode.put("name", person.getName());
            //Добавляем данные: поле birthDate, данные user.getName()
            //Предварительно парсим дату до строчного вида ДД.ММ.ГГГГ
            String dateString = "";
            //Получаем дату, месяц, год
            Integer date = person.getBirthDate().getDate();
            Integer month = person.getBirthDate().getMonth();
            Integer year = person.getBirthDate().getYear();
            //Парсим дату до ДД.
            if (date < 10)
                dateString += "0" + date;
            else
                dateString += date;
            dateString += ".";
            //Парсим месяц до ММ.
            if (month < 10)
                dateString += "0" + month;
            else
                dateString += month;
            dateString += ".";
            //Парсим год до ГГГГ
            dateString += year;
            //Добавляем данные: поле birthDate, данные dateString
            jsonNode.put("birthDate", dateString);
            //Добавляем данные: поле email, данные user.getAge()
            jsonNode.put("email", person.getEmail());
            //Добавляем узел в JSON-массив
            arrayNode.add(jsonNode);
        }
        //Записываем JSON-массив в файл "filteredUsers.json"
        objectMapper.writeValue(new FileWriter(fileName), arrayNode);
    }

    public static void main(String[] args) throws IOException{
        //Создаем логгер с заданной конфигурацией для класса Main.java
        logger = LoggerConfig.createLogger(Main.class);
        //Получаем список пользователей из файла "users.json"
        List<Person> persons = getPersons();
        //Получаем средний возраст персон
        Double meanAge = getMeanAge(persons);
        //Фильтруем пользователей по совершеннолетию
        List<Person> filteredPersons1 = getFilteredPersons(persons);
        //Фильтруем пользователей по високосному году
        List<Person> filteredPersons2 = getLeapYearPersons(persons);
        //Записываем пользователей, отфильтрованных по совершеннолетию, в JSON-файл "filteredPersons1.json"
        writeUsers(filteredPersons1, "filteredPersons1.json");
        //Записываем пользователей, отфильтрованных п в JSON-файл "filteredPersons1.json"
        writeUsers(filteredPersons2, "filteredPersons2.json");
        //Сортируем список пользователей с логгированием времени работы операции сортировки
        List<Person> sortedPersons = getSortedPersons(persons);
        //Группируем персон по возрасту
        Map <String, List<Person>> groupedPersons = getPersonGroups(persons);
    }
}
