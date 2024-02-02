package com.example.RestApiDemo.service;

import java.util.List;

import com.example.RestApiDemo.model.Book;
import com.example.RestApiDemo.model.Student;

public interface BookService {

	// save operation
	Book saveBook(Book book);

	// read operation
	List<Book> getAllBooks();

	// update operation
	Book updateBook(Book book, Integer id);

	// delete operation
	void deletebookbyid(Integer id);

	void assignBookToStudent(Integer bookId, Integer studentId);

	// operation for student
	List<Student> getAllStudent();

	Student createStudent(Student student);

	Student updateStudent(Student student, Integer id);

	void deleteStudent(Integer id);
}
