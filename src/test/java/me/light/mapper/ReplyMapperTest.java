package me.light.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.model.Criteria;
import me.light.model.ReplyVO;

public class ReplyMapperTest extends AppTest{

	@Autowired
	ReplyMapper mapper; 
	
	@Test
	@Ignore
	public void test() {
		System.out.println(mapper.getListAll());
	}
	
	@Test
	@Ignore
	public void insertTest(){
		ReplyVO vo = new ReplyVO(); 
		vo.setBno(1L);
		vo.setReply("댓글 작업중.....");
		vo.setReplyer("댓글러");
		int result = mapper.insert(vo);
		System.out.println("뭐가 찍히니 ? : " + result);
	}
	
	@Test
	@Ignore
	public void findByRnoTest() {
		System.out.println(mapper.read(4L));
	}
	
	@Test
	@Ignore
	public void deleteTest() {
		mapper.delete(2L); 
	}
	
	@Test
	@Ignore
	public void updateTest() {
		ReplyVO vo = new ReplyVO(); 
		vo.setRno(4L);
		vo.setReply("댓글 작업중 ... 수정합니다.");
		mapper.update(vo);
	}

	@Test
	public void getListWithPagingTest() {
		List<ReplyVO> listWithPaging
			= mapper.getListWithPaging(new Criteria(),1L);
		System.out.println(listWithPaging);
	}

}
