package com.example.RestApiDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import com.example.RestApiDemo.model.Book;
import com.example.RestApiDemo.model.Student;
import com.example.RestApiDemo.repository.BookRepository;
import com.example.RestApiDemo.repository.StudentRepository;

import io.micrometer.common.lang.NonNull;

@Service
public class BookServiceimpl implements BookService {
	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookrepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return (List<Book>) bookrepository.findAll();
	}

	@Override
	public Book updateBook(Book book, Integer id) {
		// TODO Auto-generated method stub
		Book b = bookrepository.findById(id).get();
		if (Objects.nonNull(book.getBooknanme()) && !"".equalsIgnoreCase(book.getBooknanme())) {
			b.setBooknanme(book.getBooknanme());
		}
		return b;
	}

	@Override
	public void deletebookbyid(Integer id) {
		bookrepository.deleteById(id);

	}

	@Override
	public List<Student> getAllStudent() {
		return studentrepository.findAll();
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentrepository.save(student);
	}

	public Student updateStudent(Student student, Integer id) {
		Student existingStudent = studentrepository.findById(id)
				.orElseThrow(() -> new RuntimeException("student  not found "));
		existingStudent.setStudentName(student.getStudentName());
		return studentrepository.save(existingStudent);
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studentrepository.deleteById(id);
	}

	@Override
	public void assignBookToStudent(@NonNull Integer bookId, @NonNull Integer studentIds) {
		Book book = bookrepository.findById(bookId).get();
		Student students = studentrepository.findById(studentIds)
				.orElseThrow(() -> new RuntimeException("Student not found"));
		// one book is assigned to student
		students.setBook(book);
		bookrepository.save(book);
		studentrepository.save(students);

	}

}
