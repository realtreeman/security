package me.light.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;

public class ReplyServiceImplTest extends AppTest{

	@Autowired
	ReplyService service; 
	
	@Test
	public void test() {
		service.get(4L);
	}
}
