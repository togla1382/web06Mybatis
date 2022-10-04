package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import domain.dto.board2.Board2DTO;
import mybatis.MybatisConfig;


@WebServlet(urlPatterns = {"/board/list"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().print("<h1>board list page</h1>");
		///board/list 로직처리
		SqlSession sqlSession=MybatisConfig.getInstance().openSession();
		
		//다중행 조회쿼리        //"namespace.id"
		//다중행 처리결과를 List<각행의결과를 매핑하는 클래스>
		List<Board2DTO> result=sqlSession.selectList("BoardMapper.findAll");
		sqlSession.close();
		
		//응답할 페이지정보는 JSP파일로 지정해줄수있어요
		String path="/WEB-INF/views/board/list.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
