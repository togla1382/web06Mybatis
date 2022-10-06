package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.impl.MemberServiceProc;

@WebServlet(urlPatterns = {"/signup","/member/*","/signin","/signout"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService service=new MemberServiceProc();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController 실행!");
		String uri=request.getRequestURI();// "/web06Mybatis"
		System.out.println("uri : "+uri);
		String root=request.getContextPath();
		
		
		String path=null;
		if(uri.equals(root+"/signup")) {   // "/web06Mybatis/signup"
			path="/WEB-INF/views/member/reg.jsp";
		}else if( uri.equals(root+"/signin") ){
			path="/WEB-INF/views/member/login.jsp";
		}else if( uri.equals(root+"/member/reg") ){
			path=service.save(request, response);
		}else if( uri.equals(root+"/member/login") ){
			path=service.login(request, response);
		}else if( uri.equals(root+"/signout") ) {
			path=service.logout(request, response);
		}
		//end if
		
		//jsp페이지로...
		if(path!=null)
			request.getRequestDispatcher(path).forward(request, response);
	}//end doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
