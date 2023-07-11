// Урок 5. Хранение и обработка данных ч2: множество коллекций Map
// Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.

import java.util.*;

public class EmployeeList {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<String>(Arrays.asList(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов"
        ));

        Map<String, Integer> nameCountMap = new TreeMap<>(Collections.reverseOrder());

        for (String employee : employees) {
            nameCountMap.put(employee, nameCountMap.getOrDefault(employee, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : nameCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Имя: " + entry.getKey() + ", Количество повторений: " + entry.getValue());
            }
        }
    }
}
