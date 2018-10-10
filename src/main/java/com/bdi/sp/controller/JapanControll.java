package com.bdi.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.dao.JapanDAO;
import com.bdi.sp.vo.Japan;

@Controller
public class JapanControll {
	@Autowired
	private JapanDAO jdao;

	/*@RequestMapping(value="/japan",method=RequestMethod.GET)
	public ModelAndView japanList() {
		ModelAndView mav = new ModelAndView("japan/list");
		mav.addObject("jList",jdao.getJapanList(null));
		return mav;
	}*/
	
	@RequestMapping(value="/japan",method=RequestMethod.GET)
	public @ResponseBody List<Japan> japanList(@ModelAttribute Japan jp) {
		return jdao.getJapanList(jp);
	}
	
	@RequestMapping(value="/japan/{japan}",method=RequestMethod.GET) 
	public @ResponseBody Japan getJapan(@PathVariable("japan") int japan) {
		return jdao.getJapan(japan);
	}
	
	@RequestMapping(value="/japan",method=RequestMethod.PUT)
	public @ResponseBody String updateJapan(@RequestBody Japan jp) {
		return jdao.updateJapan(jp) + "";
	}

	@RequestMapping(value="/japan",method=RequestMethod.POST)
	public @ResponseBody String insertJapan(@RequestBody Japan jp) {
		return jdao.InsertJapan(jp)+"";
	}
		
	@RequestMapping(value="/japan/{jpnum}",method=RequestMethod.DELETE)
	public @ResponseBody String deleteJapan(@PathVariable int jpnum) {
		return jdao.deleteJapan(jpnum)+"";
	}

	/*@RequestMapping(value="/test",method=RequestMethod.GET)
	public @ResponseBody String bodyTest() {
		return "hello japan/list"; // 여기에 써진 값만 body로 간다. 
	}
	
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public String stringTest() { 
		return "japan/list";// 기존에 쓰던 방법 -> WEB-INF/japan/list.jsp
	}*/
}
