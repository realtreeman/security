package me.light.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.model.MemberVO;

public class MemberMapperTest extends AppTest{

	@Autowired
	MemberMapper mapper;
	
	@Test
	public void selectMember() {
		MemberVO read = mapper.read("admin");
		read.getAuthList().forEach(System.out::println);
	}

}
