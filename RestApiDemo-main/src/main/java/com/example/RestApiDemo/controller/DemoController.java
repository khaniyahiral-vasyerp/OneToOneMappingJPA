package com.example.RestApiDemo.controller;

import com.example.RestApiDemo.dto.ResponseDTO;
import com.example.RestApiDemo.model.Book;
import com.example.RestApiDemo.model.Student;
import com.example.RestApiDemo.service.BookServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class DemoController {

	@Autowired
	private BookServiceimpl bookService;

	@PostMapping("/booksadd")
	public ResponseEntity<ResponseDTO<Book>> saveBook(@RequestBody Book book) {
		Book savedBook = bookService.saveBook(book);
		ResponseDTO<Book> responseDTO = new ResponseDTO<>("Book added successfully", "success", savedBook);
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}

	@GetMapping("/books")
	public ResponseEntity<ResponseDTO<List<Book>>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		ResponseDTO<List<Book>> responseDTO = new ResponseDTO<>("Books retrieved successfully", "success", books);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/booksupdate/{id}")
	public ResponseEntity<ResponseDTO<Book>> updateBook(@RequestBody Book book, @PathVariable("id") Integer id) {
		Book updatedBook = bookService.updateBook(book, id);
		ResponseDTO<Book> responseDTO = new ResponseDTO<>("Book updated successfully", "success", updatedBook);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<ResponseDTO<Void>> deleteBookById(@PathVariable("id") Integer id) {
		bookService.deletebookbyid(id);
		ResponseDTO<Void> responseDTO = new ResponseDTO<>("Book deleted successfully", "success", null);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/students")
	public ResponseEntity<ResponseDTO<List<Student>>> getAllStudents() {
		List<Student> students = bookService.getAllStudent();
		ResponseDTO<List<Student>> responseDTO = new ResponseDTO<>("Students retrieved successfully", "success",
				students);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/studentsadd")
	public ResponseEntity<ResponseDTO<Student>> createStudent(@RequestBody Student student) {
		Student savedStudent = bookService.createStudent(student);
		ResponseDTO<Student> responseDTO = new ResponseDTO<>("Student added successfully", "success", savedStudent);
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<ResponseDTO<Student>> updateStudent(@RequestBody Student student,
			@PathVariable("id") Integer id) {
		Student updatedStudent = bookService.updateStudent(student, id);
		ResponseDTO<Student> responseDTO = new ResponseDTO<>("Student updated successfully", "success", updatedStudent);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<ResponseDTO<Void>> deleteStudent(@PathVariable("id") Integer id) {
		bookService.deleteStudent(id);
		ResponseDTO<Void> responseDTO = new ResponseDTO<>("Student deleted successfully", "success", null);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/assign/{studentId}/{bookId}")
	public ResponseEntity<ResponseDTO<Void>> assignBookToStudent(@PathVariable Integer studentId,
			@PathVariable Integer bookId) {
		bookService.assignBookToStudent(bookId, studentId);
		ResponseDTO<Void> responseDTO = new ResponseDTO<>("Book assigned to student successfully", "success", null);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
