// Урок 5. Хранение и обработка данных ч2: множество коллекций Map
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }

    public List<String> getPhoneNumbers(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("John", "1234567890");
        phoneBook.addContact("John", "9876543210");
        phoneBook.addContact("Alice", "5555555555");

        List<String> johnPhoneNumbers = phoneBook.getPhoneNumbers("John");
        System.out.println("Телефоны John: " + johnPhoneNumbers);

        List<String> alicePhoneNumbers = phoneBook.getPhoneNumbers("Alice");
        System.out.println("Телефоны Alice: " + alicePhoneNumbers);
    }
}