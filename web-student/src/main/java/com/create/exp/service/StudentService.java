package com.create.exp.service;

import java.util.List;

import com.create.exp.entity.Student;

public interface StudentService {

	public List getStudents()throws Exception;
	public Student getStudent(String idStudent)throws Exception;
}
