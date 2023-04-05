package phuocthien.com.bookstrade_springboot.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false,unique = true)
    int id;
    @Column(name = "CATEGORI_ID",nullable = false,unique = true)
    int categoriId;
    @Column(name = "NAME",nullable = false)
    @Size(min = 3, max = 255)
    @NotBlank(message = "Name is mandatory")
    String name;
    @Column(name = "PRICE")
    @Size(min = 0)
    int price;
    @Column(name = "IMAGE")
    String image;
    @Column(name = "QUANTITY")
    @Size(min = 0)
    int quantity;
    @Column(name = "AUTHOR")
    String author;
    @Column(name = "PUBLISHING_YEAR")
    String publishingYear;
    @Column(name = "TEXT")
    String text;


    public Book(int id, int categoriId, String name, int price, String image, int quantity, String author, String publishingYear, String text) {
        this.id = id;
        this.categoriId = categoriId;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.author = author;
        this.publishingYear = publishingYear;
        this.text = text;
    }

    public Book() {

    }

    public int getCategoriId() {
        return categoriId;
    }

    public void setCategoriId(int categoriId) {
        this.categoriId = categoriId;
    }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
