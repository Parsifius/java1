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
        //Считываем в список
        ArrayList <String> names = new ArrayList<>();
        while (scanner.hasNextLine())
            names.add(scanner.nextLine().split(" ")[0]);
        // Перебираем список, подсчитывая количество вхождений в словарь
        TreeMap<String, Integer> counter = new TreeMap<>();
        for (Integer i = 0; i < names.size(); i++)
        {
            if (!counter.containsKey(names.get(i)))
                counter.put(names.get(i), 1);
            else
                counter.put(names.get(i), counter.get(names.get(i))+1);
        }
        //Заполняем новый массив в порядке убывания количества повторений
        ArrayList <String> sortedNames = new ArrayList<>();
        for (String c : counter.keySet())
        {
            if (sortedNames.size() == 0)
                sortedNames.add(c);
            else
            {
                Integer j = 0;
                while (j < sortedNames.size())
                {
                    if (counter.get(sortedNames.get(j))>counter.get(c))
                        j++;
                    else
                        break;
                }
                    sortedNames.add(j, c);
            }
        }
        //Выводим результаты
        System.out.println("Счетчик: " + counter);
        System.out.println("Отсортированный порядок: " + sortedNames);
    }
}
