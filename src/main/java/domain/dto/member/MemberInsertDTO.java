package domain.dto.member;

public class MemberInsertDTO {
	private String email;
	private String name;
	private String pass;
	private String userIp;
	
	public MemberInsertDTO(String email, String name, String pass, String userIp) {
		this.email = email;
		this.name = name;
		this.pass = pass;
		this.userIp = userIp;
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
	
	
}
