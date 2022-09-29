package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	@RequestMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("melon");
		fruits.add("apple");
		fruits.add("pear");
		fruits.add("mango");
		fruits.add("watermelon");
		
		model.addAttribute("fruits", fruits);
		
		// List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "권예지");
		map.put("age", 99);
		map.put("hobby", "운동");
		users.add(map);
		
		map = new HashMap<>();
		map.put("name", "김뽀삐");
		map.put("age", 16);
		map.put("hobby", "짖기");
		users.add(map);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
	@RequestMapping("ex03")
	public String ex03(Model model) {
		
		Date now = new Date();
		model.addAttribute("today", now);
		
		return "lesson05/ex03";
	}
	
	@RequestMapping("ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
}
