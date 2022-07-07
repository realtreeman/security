package me.light.model;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
	private Long rno; 
	private Long bno; 
	private String reply; 
	private String replyer; 
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
}
