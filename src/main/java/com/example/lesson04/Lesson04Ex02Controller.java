package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {

	@Autowired
	private StudentBO studentBO;
	
	// 요청url: http://localhost/lesson04/ex02/add_student_view
	@RequestMapping("/add_student_view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 요청url: http://localhost/lesson04/ex02/add_student
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute Student student,  // name(request param)과 일치하는 필드에 값이 들어간다. 어노테이션은 생략 가능.
			Model model) {
		
		// db insert
		studentBO.addStudent(student);
		
		// db select
		// System.out.println("!!!!!!!!!!!!!!" + student.getId());
		Student currentStudent = studentBO.getStudentById(student.getId());
		
		// model에 담는다
		model.addAttribute("student", currentStudent);
		model.addAttribute("subject", "학생 정보");
		
		// jsp 경로 리턴
		return "lesson04/afterAddStudent";
	}
}
