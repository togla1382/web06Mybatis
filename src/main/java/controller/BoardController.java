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


@WebServlet(urlPatterns = {"/board/list","/board/write","/board/proc"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().print("<h1>board list page</h1>");
		String uri=request.getRequestURI();
		String path=null;
		if(uri.contains("list")) {
			///board/list 로직처리
			SqlSession sqlSession=MybatisConfig.getInstance().openSession();
			
			//다중행 조회쿼리        //"namespace.id"
			//다중행 처리결과를 List<각행의결과를 매핑하는 클래스>
			List<Board2DTO> result=sqlSession.selectList("BoardMapper.findAll");
			System.out.println("result 개수 : "+result.size());
			sqlSession.close();
			
			//requestScope 저장소에 "list"이름으로 쿼리의 결과(List<Board2DTO>)를 저장
			request.setAttribute("list", result);
			
			//응답할 페이지정보는 JSP파일로 지정해줄수있어요
			path="/WEB-INF/views/board/list.jsp";
		}else if(uri.contains("write")) {
			path="/WEB-INF/views/board/write.jsp";
		}else if(uri.contains("proc")) {
			//글쓰기 처리 하기위한 uri
			System.out.println("글쓰기 처리!!!!");
			//
			request.setCharacterEncoding("utf-8");
			Board2DTO dto=new Board2DTO();
			dto.setTitle(request.getParameter("title"));
			dto.setContent(request.getParameter("content"));
			dto.setWriter(request.getParameter("writer"));
			
			SqlSession sqlSession= MybatisConfig.getInstance().openSession(true);//쿼리실행후 commit
			sqlSession.insert("BoardMapper.save", dto);
			sqlSession.close();
			//응답객체 response uri정보를 재요청합니다.
			response.sendRedirect("list");
		}
		//End if()
		if(path!=null)
			request.getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
