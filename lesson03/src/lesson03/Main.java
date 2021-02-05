package lesson03;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
        String[] ltWords = {
                "Создать", "массив", "с", "набором", "слов", "10", "слов", "среди",
                "которых", "должны", "встречаться", "повторяющиеся", "повторяющиеся"
        };
//Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//Можно решить так:
        HashSet<String> ltHSWords = new HashSet<>();
        for (String s: ltWords) {
            ltHSWords.add(s);
        }
        System.out.println(ltHSWords.toString());

//А можно объединить решение со следующим:
//Посчитать, сколько раз встречается каждое слово.
        HashMap<String,Integer> ltHMWords = new HashMap<>();
        for (String s: ltWords) {
            Integer lvHMWordsValue = ltHMWords.get(s);
            if ( lvHMWordsValue == null)
                ltHMWords.put(s, 1);
            else
                ltHMWords.replace(s,++lvHMWordsValue);

        }
        System.out.println(ltHMWords.keySet().toString());
        System.out.println(ltHMWords.toString());
//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        PhoneBook ltPhoneBook = new PhoneBook();
//В этот телефонный справочник с помощью метода add() можно добавлять записи.
        ltPhoneBook.add("Вася", "+7(912)342-54-67");
        ltPhoneBook.add("Петя", "+7(913)333-11-22");
        ltPhoneBook.add("Вася", "+7(913)555-33-44");
        ltPhoneBook.add("Саша", "+7(916)111-33-88");
        ltPhoneBook.add("Маша", "+7(342)666-66-66");
        ltPhoneBook.add("Маша", "+7(342)444-44-44");
//С помощью метода get() искать номер телефона по фамилии.
//Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//тогда при запросе такой фамилии должны выводиться все телефоны.
        System.out.println("Контакты Маши: " + ltPhoneBook.get("Маша").toString());
        System.out.println(ltPhoneBook.toString());
    }
}
