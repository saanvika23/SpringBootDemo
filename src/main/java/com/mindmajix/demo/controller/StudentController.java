package com.mindmajix.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mindmajix.demo.dao.StudentDao;
import com.mindmajix.demo.entity.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentDao studentDao;
	
	/**
	 * Prints in console the students added
	 * @return
	 */
	@RequestMapping("/studentList")
	public ModelAndView getStudent() {
		List<Student> studentList= studentDao.findAll();
		for(Student s:studentList) {
		System.out.println("List of students added in db:"+s);
		}
		return new ModelAndView(studentList.toString());
	}
	/**
	 * Adds student into database
	 * @param model
	 * @return
	 */
	@RequestMapping("/addStudent")
	public ModelAndView saveStudent(Model model) {
		
		Student s1=new Student("Saanvika","4564564654");
		Student s2= new Student("Reshma", "422423423");
		List<Student> studentList=new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentDao.saveAll(studentList);
		return new ModelAndView("Students added");
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	

}
