package com.mc.bootstart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;



@Controller
//@RestController // @Controller + @ResponseBody
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/home")
	@ResponseBody 
	//@ResponseBody를 붙이는 순간 return 에서 view 페이지인 home.jsp로 가는게 아니라,
	//return에 있는 값이 바로 출력됨
	public List<Map<String,String>> home(String merong, String huk){
		//view로 데이터를 보내고 싶다면 model에 담는다!
		
		System.out.print("merong: "+merong);
		System.out.print("huk: "+huk);
		
		List<Map<String,String>> myList = new ArrayList<>();
		
		Map<String, String> saram;
		for(int i=1; i<=4; i++) {
			saram = new HashMap<>();
			saram.put("이름", "민채"+i);
			saram.put("별명", "짱"+i);
			myList.add(saram);
		}
		/*
		 * myList.add("로제"); myList.add("제니"); myList.add("리사"); myList.add("지수");
		 */
		
		//JSP로 보낼때만! AJAX에선 model 필요없음
		//jsonview 등의 라이브러리엔 필요하기도 함! (무시)
		//model.addAttribute("myName", myList);
		
		//response.getWriter().write("Hello!");
		
		return myList;
	}
	
	
	/* JS 배열 -> LIST, JS {}는 Map으로 받는다 */
	@PostMapping("/myPost")
	@ResponseBody
	public String myPost(@RequestBody List<Map<String, String>> mc) {
		System.out.print("mc: "+mc);
		
		return "OK";
	}
	
	//put, delete는 근본적으로 post와 같음
	//현실에 비유하면 모두가 깃발인데 색깔(의미)만 다른 것
	@PutMapping("/myPut")
	@ResponseBody
	public List<Map<String,String>> myPut(@RequestBody List<Map<String, String>> mc) {
		System.out.print("mc: "+mc);
		
		return mc;
	}
	
}
	
	
	
	
	
	
	
	
