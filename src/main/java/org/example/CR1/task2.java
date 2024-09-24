/*4)	Написать регулярное выражение, определяющее является ли данная строчка
шестнадцатиричным идентификатором цвета в HTML. Где #FFFFFF для белого, #000000 для черного, #FF0000 для красного и т.д.
– пример правильных выражений: #FFFFFF, #FF3421, #00ff00.
– пример неправильных выражений: 232323, f#fddee, #fd2.
*/

package org.example.CR1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task2 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        //Создание паттерна регулярного выражения и объекта проверки
        Pattern pattern = Pattern.compile("^#[\\d[abcdef][ABCDEF]]{6}$");
        Matcher matcher = pattern.matcher(inputData);
        //Выводим результат
        if (matcher.matches())
            System.out.println("Введенные данные подходят под шаблон цвета в html, все отлично!");
        else
            System.out.println("Такого цвета не существует! Неправильно введенные данные!");
    }
}
