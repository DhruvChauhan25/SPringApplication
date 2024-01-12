package com.mycompany.user;

import jakarta.persistence.*;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.enabled;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, unique=true)
    private String bookName;
    private String author;
    private Integer price;
    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}





//@Override
//public String toString() {
//    return "User{" +
//            "id=" + id +
//            ", bookName='" + getbookName() + '\'' +
//            ", author='" + getauthor() + '\'' +
//            ", price=" + price +
//            ", enabled=" + enabled +
//            '}';
//}

