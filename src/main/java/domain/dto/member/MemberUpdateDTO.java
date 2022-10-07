package domain.dto.member;

public class MemberUpdateDTO {
	
	private String email;
	private String pass;
	
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	
	public MemberUpdateDTO(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}
	
}
