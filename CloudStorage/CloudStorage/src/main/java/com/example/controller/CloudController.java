package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Student;
import com.example.repository.CloudRepository;

@Controller
@RequestMapping("/cloud")
public class CloudController {
	
	CloudRepository cloudRepository;
	
	public CloudController(CloudRepository cloudRepository) {
		super();
		this.cloudRepository = cloudRepository;
	}

	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		
		return new ResponseEntity<List<Student>>(cloudRepository.findAll(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(cloudRepository.save(student),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentbyId(@PathVariable Integer id){
		return new ResponseEntity<Student>(cloudRepository.findById(id).orElse(null),HttpStatus.OK);
	}

}
