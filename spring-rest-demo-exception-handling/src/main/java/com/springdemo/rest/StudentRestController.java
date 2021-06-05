package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoint for "/students" - return list of students
	
	List<Student> theStudents;
	
	@PostConstruct
	private void load() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student(101,"Poornima", "Patel"));
		theStudents.add(new Student(102,"Mario", "Rossi"));
		theStudents.add(new Student(103,"Mary", "Smith"));		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable("studentId") int stuId) {
		
		Student s = theStudents.stream()
				.filter(student -> stuId==student.getStudentId())
				.findAny()
				.orElseThrow(() -> new StudentNotFoundException("Id not found ="+stuId));
		
		return s;
		
	
	}
}









