package me.light.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.mapper.BoardAttachMapper;
import me.light.model.BoardAttachVO;
import me.light.service.BoardService;

public class BoardControllerTest extends AppTest{

	@Autowired
	BoardController controller;
	
	
	@Test
	public void fileDeleteTest() {
	
	}

}
