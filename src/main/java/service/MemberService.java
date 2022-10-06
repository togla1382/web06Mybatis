package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {

	String save(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

	String login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

	String logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

}
