package com.create.exp.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.create.exp.entity.Student;
import com.create.exp.message.StudentForm;
import com.create.exp.service.StudentService;

@Controller
public class StudentController {

	private static Logger logger = LogManager.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/")
	public String doShowStudents(StudentForm form) throws Exception {
		try {
			
			List dataStudents = (List) this.studentService.getStudents();
			
			form.setDataList(dataStudents);
		}catch(Exception e) {
			logger.info("Exception "+e);
		}
		
		return "student/student_listing";
	}
	
	@GetMapping(value = "/get")
	public String doShowStudent(StudentForm form) throws Exception{
		try {
			
			Student student = this.studentService.getStudent(form.getId());
			
			ArrayList dataStudent = new ArrayList();
			dataStudent.add(student.getName());
			dataStudent.add(student.getCreatedBy());
			dataStudent.add(student.getCreatedDate());
			
			form.setDataList(dataStudent);
		}catch(Exception e) {
			logger.info("Exception "+e);
		}
		
		return "student/student_listing";
	}
}
