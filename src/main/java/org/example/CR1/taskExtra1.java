//4.4. Во входном файле (вы можете читать данные из файла input.txt) записан текст.
//Словом считается последовательность непробельных символов идущих подряд,
//слова разделены одним или большим числом пробелов или символами конца строки.
//Определите, сколько различных слов содержится в этом тексте.

//Замечание: дополнительно реализовал вывод всех слов с количеством их встречи, отсортированный по количеству от самого редкого к самому частому

package org.example.CR1;
import java.util.*;
import java.io.*;


public class taskExtra1{
    public static void main(String[] args) throws IOException{
        FileReader fileReader = new FileReader("src/main/java/org/example/CR1/extra1.txt");
        //Считываем данные из файла построчно
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        //Создаем множество для хранения слов
        Map<String, Integer> allWords = new HashMap<>();
        //Пока текст не закончился
        while((line = bufferedReader.readLine()) != null){
            //Сплитуем
            String[] words = line.split("[\\s,!?.()\\[\\]\\d…–„“»]");
            //Добавляем слова в словарь
            for(String word : words)
                allWords.put(word.toLowerCase(Locale.ROOT), allWords.getOrDefault(word.toLowerCase(Locale.ROOT), 0) + 1);
        }
        System.out.println("Количество различных слов: " + allWords.size());
        //Выводим все слова, предварительно отсортировав их сначала по количеству встречи, затем по слову
        List<Map.Entry<String, Integer>> list = new ArrayList<>(allWords.entrySet());
        list.sort((w1, w2) ->
            {
                int result = w1.getValue().compareTo(w2.getValue());
                if (result != 0)
                    return result;
                else
                    return w1.getKey().compareTo(w2.getKey());
            });
        for(Map.Entry<String, Integer> entry : list)
            System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
