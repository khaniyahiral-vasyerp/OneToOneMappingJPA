package com.example.RestApiDemo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {

	public Book(Integer id, String booknanme, String author, int price) {
		this.id = id;
		Booknanme = booknanme;
		this.author = author;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Book(Integer id, String booknanme, String author, Integer price) {
		super();
		this.id = id;
		this.Booknanme = booknanme;
		this.author = author;
		this.price = price;
	}

	private String Booknanme;
	private String author;
	private int price;

	public Book() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBooknanme() {
		return Booknanme;
	}

	public void setBooknanme(String booknanme) {
		Booknanme = booknanme;
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

	@Override
	public String toString() {
		return "Book [  id=" + id + ", Booknanme=" + Booknanme + ", author=" + author
				+ ", price=" + price + "]";
	}

}
