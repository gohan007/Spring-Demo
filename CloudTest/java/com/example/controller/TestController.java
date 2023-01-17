package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Student;
import com.example.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	TestService testservice;
	
	public TestController(TestService testservice) {
		super();
		this.testservice = testservice;
	}

	@GetMapping
	public ResponseEntity<Student> getStudents(){
		return testservice.getStudent();
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		return testservice.addStudent(student);
	}
}

