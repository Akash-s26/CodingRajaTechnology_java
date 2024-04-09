import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void checkout() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }
    public void fine() {
    	available = false;
    }
    

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available: " + available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        System.out.println("Library Catalog:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }

    public void checkoutBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            book.checkout();
            System.out.println("You have checked out: " + book.getTitle());
        } else {
            System.out.println("Book not found or already borrowed.");
        }
    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            book.returnBook();
            System.out.println("You have returned: " + book.getTitle());
        } else {
            System.out.println("Book returned successfully.");
        }
    }
    public Book fine(String title) {
    	Book book = fine(title);
        if (book != null) {
            book.fine();
            System.out.println("you have not returned: " + book.getTitle());
        } else {
            System.out.println("pay fine");
        }
		return book;
    }
    }
