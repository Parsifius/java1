/* 3)	Пользователь вводит текст, состоящий из слов, разделенных пробелами.
В словах, начинающихся на «А» заменить эту букву на «а».
В полученном текст подсчитать количество слов, начинающихся на «а». */

//А, а - русские символы в программе

package org.example.CR1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task1
{
    public static void main(String[] args)
    {
        //Считываем текст
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        //Переводим в массив StringBuilder
        ArrayList <String> stringArrayList = new ArrayList<>(List.of(inputData.split(" ")));
        ArrayList <StringBuilder> stringBuilderArrayList = new ArrayList<>();
        for (Integer i = 0; i < stringArrayList.size(); i++)
        {
            StringBuilder newStr = new StringBuilder(stringArrayList.get(i));
            stringBuilderArrayList.add(newStr);
        }
        //Перебираем список строк. Если строка начинается на А - заменяем на а
        for (Integer i = 0; i < stringBuilderArrayList.size(); i++)
        {
            if (stringBuilderArrayList.get(i).charAt(0)=='А')
                stringBuilderArrayList.set(i, new StringBuilder("а" + stringBuilderArrayList.get(i).substring(1).toString()));
        }
        //Подсчитываем слова на а. Если строка начинается на а - увеличиваем счетчик
        Integer count = 0;
        for (Integer i = 0; i < stringBuilderArrayList.size(); i++)
        {
            if (stringBuilderArrayList.get(i).charAt(0)=='а')
                count++;
        }
        //Выводим обновленный текст
        for (Integer i = 0; i < stringBuilderArrayList.size(); i++)
        {
            System.out.print(stringBuilderArrayList.get(i) + " ");
        }
        System.out.println("");
        //Выводим количество слов на а
        System.out.print("Слов, начинающихся на букву а: " + count);
    }
}
