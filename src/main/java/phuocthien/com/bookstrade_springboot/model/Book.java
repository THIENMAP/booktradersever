package phuocthien.com.bookstrade_springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    long id;
    long categori_Id;
    String name;
    long price;
    String image;
    String text;

    public Book(long id, String name, long price, String image, String text) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.text = text;
    }

    public Book() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setPrice(long price) {
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
