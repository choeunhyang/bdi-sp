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

import com.bdi.sp.dao.BoardDAO;
import com.bdi.sp.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO bdao;
	
	@RequestMapping(value="/board",method=RequestMethod.GET)
	public @ResponseBody List<Board> BoardList(@ModelAttribute Board b){
		return bdao.getBoardList(b);
	}
	@RequestMapping(value="/board/{board}",method=RequestMethod.GET)
	public @ResponseBody Board getBoard(@PathVariable int binum) {
		return bdao.getBoard(binum);
	}
	@RequestMapping(value="/board/{board}",method=RequestMethod.DELETE)
	public @ResponseBody String deleteBoard(@PathVariable int binum) {
		return bdao.deleteBoard(binum)+"";
	}
	@RequestMapping(value="/board/{board}",method=RequestMethod.PUT)
	public @ResponseBody String updateBoard(@RequestBody Board b) {
		return bdao.updateBoard(b)+"";
	}
	@RequestMapping(value="/board/{board}",method=RequestMethod.POST)
	public @ResponseBody String insertBoard(@RequestBody Board bi) {
		return bdao.insertBoard(bi);
	}
	
}
