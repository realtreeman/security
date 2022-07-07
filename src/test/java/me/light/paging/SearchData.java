package me.light.paging;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.mapper.BoardMapper;
import me.light.model.Board;

public class SearchData extends AppTest{
	
	@Autowired
	BoardMapper mapper; 
	
	@Test
	@Ignore
	public void dataInsert() {
		for (int i = 1; i <= 212; i++) {
			Board board = new Board();
			board.setTitle("검색 처리 연습 : Spring "+i);
			board.setContent("검색처리 연습 : Spring Boot"+i);
			board.setWriter("홍길동");
			mapper.insert(board);
		}
	}
	
	@Test
	public void dataInsert2() {
		for (int i = 1; i <= 212; i++) {
			Board board = new Board();
			board.setTitle("검색 처리 연습 : Java "+i);
			board.setContent("검색처리 연습 : JSP"+i);
			board.setWriter("고길동");
			mapper.insert(board);
		}
	}
}
