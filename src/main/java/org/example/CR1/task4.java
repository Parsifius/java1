/*3. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк по длине. */

package org.example.CR1;
import java.util.*;
import java.io.*;

public class task4
{
    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader("cr1task4.txt");
        Scanner scanner = new Scanner(fileReader);
        ArrayList <String> stringArrayList = new ArrayList<>();
        //Считываем строки в массив
        while (scanner.hasNextLine())
        {
            stringArrayList.add(scanner.nextLine());
        }
        //Сортируем по длине
        for (Integer i = 0; i < stringArrayList.size()-1; i++)
        {
            for (Integer j = i+1; j < stringArrayList.size(); j++)
            {
                if (stringArrayList.get(i).length()>stringArrayList.get(j).length()) {
                    String dopStr = stringArrayList.get(i);
                    stringArrayList.set(i, stringArrayList.get(j));
                    stringArrayList.set(j, dopStr);
                }
            }
        }
        //Выводим
        for (Integer i = 0; i < stringArrayList.size(); i++)
        {
            System.out.println(stringArrayList.get(i));
        }
    }
}
