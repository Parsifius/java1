/*6. Пусть дан список сотрудников:
•	Иван Иванов
•	Светлана Петрова
•	Кристина Белова
•	Анна Мусина
•	Анна Крутова
•	Иван Юрин
•	Петр Лыков
•	Павел Чернов
•	Петр Чернышов
•	Мария Федорова
•	Марина Светлова
•	Мария Савина
•	Мария Рыкова
•	Марина Лугова
•	Анна Владимирова
•	Иван Мечников
•	Петр Петин
•	Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */

//Пометка: считывание происходит из файла

package org.example.CR1;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class task3
{
    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader("cr1task3.txt");
        Scanner scanner = new Scanner(fileReader);
        // Считываем новое имя: если есть, то увеличиваем счетчик в словаре, иначе добавляем его туда
        TreeMap<String, Integer> counter = new TreeMap<>();
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine().split(" ")[0];
            counter.put(name, counter.getOrDefault(name, 0) + 1);
        }
        // Создаем список Map.Entry и сортируем его по значению (количество повторений) в порядке убывания
        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(counter.entrySet());
        sortedNames.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        //Выводим результаты
        System.out.println("Счетчик: " + sortedNames);
    }
}
