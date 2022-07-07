package me.light.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	int page; 
	int perPageNum;
	
	String type; 
	String keyword;
	
	public Criteria() {
		this.page = 1; 
		this.perPageNum = 10; 
	}

	public Criteria(int page, int perPageNum) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}
	
	public String[] getTypeCollection() { // #{typeCollection}
		return type !=null ? type.split("") : new String[] {};  
	}



	
}
