// Урок 6. Хранение и обработка данных ч3: множество коллекций Set
// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
// Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
// Работу сдать как обычно ссылкой на гит репозиторий
// Частые ошибки:
// 1. Заставляете пользователя вводить все существующие критерии фильтрации
// 2. Невозможно использовать более одного критерия фильтрации одновременно
// 3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
// 4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно


import java.util.*;

public class Notebook {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();

        // Создаем несколько ноутбуков и добавляем их в множество
        notebooks.add(new Notebook("Acer", 8, 256, "Windows", "Silver"));
        notebooks.add(new Notebook("Lenovo", 16, 512, "Windows", "Black"));
        notebooks.add(new Notebook("Apple", 16, 512, "macOS", "Silver"));
        notebooks.add(new Notebook("Dell", 8, 128, "Windows", "Black"));
        notebooks.add(new Notebook("HP", 12, 256, "Windows", "White"));

        // Запрашиваем у пользователя критерии фильтрации
        Map<Integer, Object> filterCriteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        
        int criterion = scanner.nextInt();
        
        switch (criterion) {
            case 1:
                System.out.print("Введите минимальное значение ОЗУ: ");
                int ram = scanner.nextInt();
                filterCriteria.put(1, ram);
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД: ");
                int storage = scanner.nextInt();
                filterCriteria.put(2, storage);
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                String os = scanner.next();
                filterCriteria.put(3, os);
                break;
            case 4:
                System.out.print("Введите цвет: ");
                String color = scanner.next();
                filterCriteria.put(4, color);
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;}

        // Фильтруем ноутбуки по заданным критериям
        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filterCriteria);

        // Выводим отфильтрованные ноутбуки
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<Integer, Object> filterCriteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean satisfiesCriteria = true;

            for (Map.Entry<Integer, Object> entry : filterCriteria.entrySet()) {
                int criterion = entry.getKey();
                Object value = entry.getValue();

                switch (criterion) {
                    case 1:
                        if (notebook.getRam() < (int) value) {
                            satisfiesCriteria = false;
                        }
                        break;
                    case 2:
                        if (notebook.getStorage() < (int) value) {
                            satisfiesCriteria = false;
                        }
                        break;
                    case 3:
                        if (!notebook.getOs().equals(value)) {satisfiesCriteria = false;
                        break;}
                    case 4:
                        if (!notebook.getColor().equals(value)) {
                            satisfiesCriteria = false;
                        }
                        break;
                    default:
                        System.out.println("Некорректный критерий фильтрации.");
                        return filteredNotebooks;
                }
            }

            if (satisfiesCriteria) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}