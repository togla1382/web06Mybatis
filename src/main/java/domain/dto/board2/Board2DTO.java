package domain.dto.board2;

import java.time.LocalDateTime;

public class Board2DTO {
	//DB의 Board2테이블의 결과를 매핑하기위한 클래스
	private long bno; //number
	private String title;//VARCHAR2
	private String content;//CLOB : 긴문자열
	private String writer;
	//카멜설정시 적용가능 : read_count to readCount
	private int readCount; 
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
	public long getBno() {
		return bno;
	}
	public void setBno(long bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

}
