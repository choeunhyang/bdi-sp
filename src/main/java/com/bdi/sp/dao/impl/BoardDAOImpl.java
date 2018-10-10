package com.bdi.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.BoardDAO;
import com.bdi.sp.vo.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<Board> getBoardList(Board b) {
		return ss.selectList("SQL.BOARD.selectBoardList",b);
	}

	@Override
	public Board getBoard(int binum) {
		return ss.selectOne("SQL.BOARD.selectBoard",binum);
	}

	@Override
	public int updateBoard(Board b) {
		return ss.update("SQL.BOARD.updateBoard",b);
	}

	@Override
	public int deleteBoard(int binum) {
		return ss.delete("SQL.BOARD.deleteBoard",binum);
	}

	@Override
	public String insertBoard(Board bi) {
		return ss.insert("SQL.BOARD.insertBoard",bi) + "";
	}

}
