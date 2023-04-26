package org.example;
import java.util.Scanner;

public class Menu {
    private ContactBook contactBook;

    public Menu(ContactBook contactBook) {
        this.contactBook = contactBook;
    }

    public void displayMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Просмотреть список контактов");
            System.out.println("2. Добавить контакт");
            System.out.println("3. Найти контакт");
            System.out.println("4. Экспортировать контакты");
            System.out.println("5. Импортировать контакты");
            System.out.println("6. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    viewContacts();break;
                case 2:
                    addContact();
                    break;
                case 3:
                    searchContacts();
                    break;
                case 4:
                    exportContacts();
                    break;
                case 5:
                    importContacts();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Некорректный выбор");
            }
        }
    }

    private void viewContacts() {
        List<Contact> contacts = contactBook.getContacts();
        if (contacts.isEmpty()) {
            System.out.println("Список контактов пуст");
            addContact();
        } else {
            System.out.println("Список контактов:");
            for (Contact contact : contacts) {
                System.out.println(contact.getFirstName() + " " + contact.getLastName() + " (" + contact.getPhoneNumber() + ")");
            }
        }
    }

    private void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactBook.addContact(contact);
        System.out.println("Контакт успешно добавлен");
    }

    private void searchContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя, фамилию или номер телефона контакта: ");
        String query = scanner.nextLine();
        List<Contact> searchResults = contactBook.searchContacts(query);
        if (searchResults.isEmpty()) {
            System.out.println("Контакт не найден");
        } else {
            System.out.println("Найденные контакты:");
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i).getFirstName() + " " + searchResults.get(i).getLastName() + " (" + searchResults.get(i).getPhoneNumber() + ")");
            }
        }
    }

    private void exportContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите формат экспорта (csv, xml, json): ");
        String format = scanner.nextLine();
        contactBook.exportContacts(format);
        System.out.println("Контакты успешно экспортированы");
    }

    private void importContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите формат импорта (csv, xml, json): ");
        String format = scanner.nextLine();
        contactBook.importContacts(format);
        System.out.println("Контакты успешно импортированы");
    }
}