package uebung5;

public class Book {

    private double price;
    private String title;
    private String isbn;

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book(double price, String title, String isbn){
        this.price = price;
        this.title = title;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Buch{" +
                "preis=" + price +
                ", titel='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}