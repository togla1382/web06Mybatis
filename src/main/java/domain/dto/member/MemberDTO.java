package domain.dto.member;

import java.time.LocalDateTime;

public class MemberDTO {
	private long mno;
	private String email;
	private String name;
	private String pass;
	private String userIp;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
	
	
	@Override
	public String toString() {
		return "MemberDTO [mno=" + mno + ", email=" + email + ", name=" + name + ", pass=" + pass + ", userIp=" + userIp
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	public long getMno() {
		return mno;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public String getUserIp() {
		return userIp;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	
}
