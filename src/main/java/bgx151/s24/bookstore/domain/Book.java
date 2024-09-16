package bgx151.s24.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int pubyear;
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
    }

    public Book(Long id, String title, String author, int pubyear, String isbn, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.pubyear = pubyear;
        this.isbn = isbn;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPubyear() {
        return pubyear;
    }

    public void setPubyear(int pubyear) {
        this.pubyear = pubyear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", pubyear=" + pubyear + ", isbn="
                    + isbn + ", category=" + category + "]";
        else
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", pubyear=" + pubyear + ", isbn="
                    + isbn + "]";
    }

}