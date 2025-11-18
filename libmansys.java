import java.util.ArrayList;
import java.util.Scanner;
// Book class
class Book {
    private String title;
    private String author;
    private boolean isIssued;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isIssued() {
        return isIssued;
    }
    public void issue() {
        isIssued = true;
    }
    public void returnBook() {
        isIssued = false;
    }
    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}
// Library class
class Library {
    private ArrayList<Book> books = new ArrayList<>();
    public void addBook(Book book) {
        books.add(book);
        System.out.println(" Book added: " + book.getTitle());
    }
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("⚠ No books in the library.");
            return;
        }
        System.out.println("\n Books in the library:");
        for (Book book : books) {
            System.out.println(" - " + book);
        }
    }
    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isIssued()) {
                    book.issue();
                    System.out.println(" Book issued: " + title);
                    return;
                } else {
                    System.out.println("⚠ Book is already issued.");
                return;
                }
            }
        }
        System.out.println(" Book not found.");
    }
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isIssued()) {
                    book.returnBook();
                    System.out.println(" Book returned: " + title);
                    return;
                } else {
                    System.out.println("⚠ Book was not issued.");
                    return;
                }
            }
        }
        System.out.println(" Book not found.");
    }
}
// Main class with main method
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                Book newBook = new Book(title, author);
                library.addBook(newBook);
                break;
                case 2:
                library.showBooks();
                break;
                case 3:
                System.out.print("Enter title to issue: ");
                String issueTitle = scanner.nextLine();
                library.issueBook(issueTitle);
                break;
                case 4:
                System.out.print("Enter title to return: ");
                String returnTitle = scanner.nextLine();
                library.returnBook(returnTitle);
                break;
                case 5:
                System.out.println(" Exiting system. Goodbye!");
                scanner.close();
                return;
                default:
                System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}