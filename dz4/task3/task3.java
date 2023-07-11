// Урок 4. Хранение и обработка данных ч1: приоритетные коллекции
// Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
import java.util.LinkedList;
import java.util.ListIterator;

public class task3 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int sum = calculateSum(list);

        System.out.println("Сумма элементов списка: " + sum);
    }

    private static int calculateSum(LinkedList<Integer>list) {
        int sum = 0;
        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }
}