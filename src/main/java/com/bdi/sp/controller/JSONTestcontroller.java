package com.bdi.sp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.vo.BoardInfo;
import com.bdi.sp.vo.Japan;

@Controller
public class JSONTestcontroller {
	
	/*@RequestMapping(value="/test/{b}",method=RequestMethod.GET)
	public @ResponseBody String getTest(@RequestParam(value="a",required=false) String str, // a라는 키값이 반드시 들어가야 함 아니면 ,required=false 이걸 쓴다.
			@PathVariable String b) {
		System.out.println("str : " + str);
		System.out.println("b : " + b);
		return str + "," + b;
	}*/
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public @ResponseBody Japan getTest(@ModelAttribute Japan j,@RequestParam(required=false) String str) {
		System.out.println("str : " + str);
		return j;
	}
	
	/*@RequestMapping(value="/test",method=RequestMethod.POST)
	public @ResponseBody Japan postTest(@ModelAttribute Japan j,@RequestParam(required=false) String str) {
		System.out.println("str : " + str);
		return j;
	}*/
	/*@RequestMapping(value="/test",method=RequestMethod.POST)
	public @ResponseBody List<Japan> postTest(@RequestBody List<Japan> j,@RequestParam(required=false) String str) {
		System.out.println("str : " + str);
		return j;
	}*/
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public @ResponseBody BoardInfo postTest(@RequestBody BoardInfo bi) {
		System.out.println(bi);
		return bi;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.PUT)
	public @ResponseBody BoardInfo putTest(@RequestBody BoardInfo bi) {
		System.out.println(bi);
		return bi;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.DELETE)
	public @ResponseBody BoardInfo deleteTest(@RequestBody BoardInfo bi) {
		System.out.println(bi);
		return bi;
	}
}
