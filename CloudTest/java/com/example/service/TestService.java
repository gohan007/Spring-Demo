package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import com.example.dto.Student;


@Service
@CrossOrigin
public class TestService {
	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<Student> getStudent(){
		return restTemplate.getForEntity("http://localhost:8100/cloud/4", Student.class);
		
	}
	
	public ResponseEntity<Student> addStudent(Student student){
		return restTemplate.postForEntity("http://localhost:8100/cloud/", student, Student.class);
	}

}
