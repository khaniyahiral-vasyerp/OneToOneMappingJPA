package com.example.RestApiDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApiDemo.model.Book;
import com.example.RestApiDemo.model.Student;
import com.example.RestApiDemo.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/books")
public class DemoController {

	@Autowired
	private BookService bookservice1;

	// save operation
	@PostMapping("/booksadd")
	public Book saveBoook(@RequestBody Book book) {
		return bookservice1.saveBook(book);

	}

	// read operation
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookservice1.getAllBooks();

	}

	// update
	@PutMapping("/booksupdate/{id}")
	public Book updateBook(@RequestBody Book boook, @PathVariable("id") Integer id) {
		return bookservice1.updateBook(boook, id);
	}

	// delete
	@DeleteMapping("books/{id}")
	public String deletebookbyid(@PathVariable("id") Integer id) {
		bookservice1.deletebookbyid(id);
		return "deleted";
	}

	// for student
	@GetMapping("/students")

	public List<Student> getAllStudents() {
		return bookservice1.getAllStudent();
	}

	@PostMapping("/studentsadd")
	public Student createStudent(@RequestBody Student student) {
		return bookservice1.createStudent(student);
	}

	@PutMapping("/students/{id}")

	public Student updateStudent(@RequestBody Student student, @PathVariable("id") Integer id) {
		return bookservice1.updateStudent(student, id);
	}

	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		bookservice1.deleteStudent(id);
		return "deleted";
	}

	@PostMapping("assign/{studentId}/{bookId}")
	public void assignBookToStudent(@PathVariable Integer bookId, @PathVariable Integer studentId) {
		bookservice1.assignBookToStudent(bookId, studentId);
	}

}
