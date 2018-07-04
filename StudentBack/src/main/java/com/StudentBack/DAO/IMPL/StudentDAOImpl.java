package com.StudentBack.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentBack.DAO.StudentDAO;
import com.StudentBack.model.Student;

@Repository("studentDAO")//object of our interface StudentDAO
@Transactional
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addStudent(Student student) {
		try {
			sessionFactory.getCurrentSession().save(student);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); //prints complete detailed exception
			return false;
		}
	
	}

	public boolean updateStudent(Student student) {
		try {
			sessionFactory.getCurrentSession().update(student);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); //prints complete detailed exception
			return false;
		}
	}

	public boolean deletewStudent(int rollno) {
		try {
			sessionFactory.getCurrentSession().delete(getSingleStudent(rollno));;
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); //prints complete detailed exception
			return false;
		}
	}

	public Student getSingleStudent(int rollno) {
		try {
			return sessionFactory.getCurrentSession().get(Student.class, rollno);
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); //prints complete detailed exception
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Student").list(); //warning removed as the warning is about the list not being used.
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); //prints complete detailed exception
			return null;
		}
	}

}
