import java.util.*;

public class BracketsCheckService {

    public static String getValidBracketsString(String string) {
        if (string.isBlank()) return "0"; // проверка строки на пустоту или содержание только пробелов

        /* Замена Stack на ArrayDeque. Stack - более старый и частично синхронизированный класс, работает медленнее.
        * ArrayDeque - более новый класс, не потокобезопасный, работает быстрее */

        Deque<Integer> incorrectBracketsIndexes = new ArrayDeque<>(); // стек для записи индексов некорректных скобок
        StringBuilder clearString = new StringBuilder();

        for (int i = 0; i < string.length(); i++) { // цикл по всей исходной строке
            if (string.charAt(i) == '(') {
                incorrectBracketsIndexes.push(i); // открывающая скобка помещается в стек
            } else if (!incorrectBracketsIndexes.isEmpty() && string.charAt(incorrectBracketsIndexes.peek()) == '(') {
                /* если стек не пуст и последний элемент - открывающая скобка, то текущий элемент - парная закрывающая скобка,
                * следовательно эта пара корректна, открывающую скобку нужно удалить */
                incorrectBracketsIndexes.pop();
            } else {
                /* иначе текущий элемент - закрывающая скобка без пары, записываем ее индекс в стек */
                incorrectBracketsIndexes.push(i);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            if (!incorrectBracketsIndexes.contains(i)) { // проверка на содержание каждого индекса в стеке
                clearString.append(string.charAt(i)); // если индекса нет, то символ корректен, запись в новую строку
            }
        }

        //проверка длины полученной строки
        return clearString.length() == 0 ? "0" : clearString.toString();
    }
}
