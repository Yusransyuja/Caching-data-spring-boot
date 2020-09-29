package com.create.exp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.create.exp.entity.Student;
import com.create.exp.repository.StudentDAO;

@Service
@CacheConfig(cacheNames = "Student Cache")
public class StudentServiceImpl implements StudentService {
	
	private static Logger logger = LogManager.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Cacheable
	public List getStudents()throws Exception {
		List dataStudents = new ArrayList();
		try {
			
			dataStudents = (List) this.studentDAO.getAll(Student.class);
			
		}catch(Exception e) {
			logger.info("Exception "+ e);
			throw e;
		}
		
	return dataStudents;
	}
	
	@Cacheable(key = "#idStudent")
	public Student getStudent(String idStudent)throws Exception {
		Student student = new Student();
		try {
			
			 student = (Student) this.studentDAO.getById(Student.class, idStudent);
			
		}catch(Exception e) {
			logger.info("Exception "+ e);
			throw e;
		}
		
	return student;
	}
}
