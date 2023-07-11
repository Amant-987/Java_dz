// Урок 5. Хранение и обработка данных ч2: множество коллекций Map
// *Реализовать алгоритм пирамидальной сортировки (HeapSort)
import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();

        System.out.println("Исходный массив:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение пирамиды (Heapify)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из пирамиды
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец массива
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем heapify на уменьшенной пирамиде
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем largest как корень
        int left = 2 * i + 1; // Левый потомок
        int right = 2 * i + 2; // Правый потомок

        // Если левый потомок больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Если правый потомок больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Если самый большой элемент не является корнем
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно heapify поддерево
            heapify(arr, n, largest);
        }
    }
}