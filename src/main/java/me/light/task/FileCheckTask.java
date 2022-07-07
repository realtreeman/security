package me.light.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import me.light.mapper.BoardAttachMapper;
import me.light.model.BoardAttachVO;

@Component
public class FileCheckTask {
	
	@Autowired
	private BoardAttachMapper attachMapper; 
	
	@Scheduled(cron = "0 0 2 * * *")
	public void checkeFile() {
		System.out.println("Check files ....");
		
		List<BoardAttachVO> fileList = attachMapper.getOldFiles();
		
		List<Path> fileListPaths = 
		fileList.stream()
		.map(vo-> Paths.get(
				"C:\\storage", vo.getUploadPath(),vo.getUuid()+"_"+vo.getFileName()))
		.collect(Collectors.toList());
		
		fileList
		.stream()
		.filter(vo -> vo.isFileType()==true)
		.map(vo-> Paths.get("C:\\storage", vo.getUploadPath(),"s_"+vo.getUuid()+"_"+vo.getFileName()))
		.forEach(p-> fileListPaths.add(p));
		
		File targetDir = Paths.get("c:/storage",getFolderYesterDay()).toFile(); 
		File[] removeFiles 
		= targetDir.listFiles(file -> fileListPaths.contains(file.toPath())==false);
		
		Arrays.asList(removeFiles).forEach(f->f.delete());
	}

	private String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 2022/07/06
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.DATE, -1);  // 2022/07/05
		return sdf.format(cal.getTime()).replace("-", File.separator);
	}
}
