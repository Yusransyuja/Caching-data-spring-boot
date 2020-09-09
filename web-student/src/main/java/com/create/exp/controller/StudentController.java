package com.create.exp.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.create.exp.message.StudentForm;
import com.create.exp.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	private static Logger logger = LogManager.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/")
	public String doShowListing(StudentForm form) throws Exception {
		try {
			
			List dataStudents = (List) this.studentService.getStudents();
			
			form.setDataList(dataStudents);
		}catch(Exception e) {
			logger.info("Exception "+e);
		}
		
		return "student/student_listing";
	}
}
