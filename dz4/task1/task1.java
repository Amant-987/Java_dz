// Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список. Постараться не обращаться к листу по индексам.

import java.util.LinkedList;
import java.util.ListIterator;

public class task1 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        LinkedList<Integer> reversedList = reverseLinkedList(list);

        System.out.println("Исходный список: " + list);
        System.out.println("Перевернутый список: " + reversedList);
    }

    private static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversed = new LinkedList<>();
        ListIterator<Integer> iterator = list.listIterator(list.size());

        while (iterator.hasPrevious()) {
            reversed.add(iterator.previous());
        }
        return reversed;
    }
}