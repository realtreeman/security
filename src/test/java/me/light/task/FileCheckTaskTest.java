package me.light.task;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class FileCheckTaskTest {

	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
		//cal.add(Calendar.DATE, -1);
		String str = sdf.format(cal.getTime()).replace("-", File.separator);
		System.out.println(str);
		
		
		
	}

}
