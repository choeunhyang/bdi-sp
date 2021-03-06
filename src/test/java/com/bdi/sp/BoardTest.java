package com.bdi.sp;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bdi.sp.vo.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardTest {

	@Autowired
	private SqlSession ss;
	
	@Test
	public void selectTest() {
		List<Board> biList = ss.selectList("SQL.BOARD.selectBoard");
		assertEquals(biList.size(), 1005);
	}
}
