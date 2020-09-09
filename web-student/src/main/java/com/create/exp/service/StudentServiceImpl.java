package com.create.exp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.create.exp.entity.Student;
import com.create.exp.repository.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {
	
	private static Logger logger = LogManager.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentDAO studentDAO;
	
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
}
