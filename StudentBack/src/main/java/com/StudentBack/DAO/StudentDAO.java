package com.StudentBack.DAO;

import java.util.List;

import com.StudentBack.model.Student;

public interface StudentDAO {

	public boolean addStudent(Student student);
	public boolean updateStudent(Student student);
	public boolean deletewStudent(int rollno);
	
	public Student getSingleStudent(int rollno);
	public List<Student> getAllStudent();

}
