import java.util.Scanner;
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Python", "David Beazley"));
        library.addBook(new Book("C Programming", "Dennis M. Ritchie"));
        library.addBook(new Book("Junglebook", "Rudyard Kipling."));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. List of Books Available");
            System.out.println("2. Check Out Book");
            System.out.println("3. Return Book");
            System.out.println("4. fine");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    library.listBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to check out: ");
                    String checkoutTitle = scanner.nextLine();
                    library.checkoutBook(checkoutTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                	System.out.println("pay the fine rupees 50");
                	String finetitle = scanner.nextLine();
                    library.fine(finetitle);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
