package service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.dto.board2.Board2DTO;
import mybatis.MybatisConfig;
import service.BoardService;

public class BoardServiceProc implements BoardService {
	private SqlSessionFactory sqlSessionFactory=MybatisConfig.getInstance();
	@Override
	public String selectList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		///board/list 로직처리
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//다중행 조회쿼리        //"namespace.id"
		//다중행 처리결과를 List<각행의결과를 매핑하는 클래스>
		List<Board2DTO> result=sqlSession.selectList("BoardMapper.findAll");
		System.out.println("result 개수 : "+result.size());
		sqlSession.close();
		
		//requestScope 저장소에 "list"이름으로 쿼리의 결과(List<Board2DTO>)를 저장
		request.setAttribute("list", result);
		
		return "/WEB-INF/views/board/list.jsp";
		
	}

	@Override
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//글쓰기 처리 하기위한 uri
		System.out.println("글쓰기 처리!!!!");
		//
		//request.setCharacterEncoding("utf-8");//필터에서 처리
		Board2DTO dto=new Board2DTO();
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setWriter(request.getParameter("writer"));
		
		SqlSession sqlSession= sqlSessionFactory.openSession(true);//쿼리실행후 commit
		sqlSession.insert("BoardMapper.save", dto);
		sqlSession.close();
		//응답객체 response uri정보를 재요청합니다.
		response.sendRedirect("list");
		
	}

	@Override
	public String detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		boolean flag=true;
		for(Cookie cookie:cookies) {
			String n=cookie.getName();
			String v=cookie.getValue();
			System.out.println(n +" : "+ v);
			if(n.equals("myCookie")) {
				flag=false;
			}
		}
		
		String ip=request.getRemoteHost();
		System.out.println("ip : "+ip);
		
		
		long bno=Long.parseLong(request.getParameter("bno"));
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//조회결과가 단일행 결과인경우
		Board2DTO result=sqlSession.selectOne("BoardMapper.findById", bno);
		String referer=request.getHeader("Referer");
		System.out.println("Referer(detail이전페이지) : "+referer);
		if(!referer.contains("detail") && flag ) {
			sqlSession.update("BoardMapper.readCountPP", bno);
			sqlSession.commit();
			
			Cookie cookie=new Cookie("myCookie", "쿠키에요");
			cookie.setPath(request.getContextPath());
			cookie.setMaxAge(60);
			response.setCharacterEncoding("utf-8");
			response.addCookie(cookie);
		}
		sqlSession.close();
		
		request.setAttribute("detail", result);
		
		return "/WEB-INF/views/board/detail.jsp";
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long bno=Long.parseLong(request.getParameter("bno"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		
		//mapper에 전달할 data
		Board2DTO dto=new Board2DTO();
		dto.setBno(bno);
		dto.setTitle(title);
		dto.setContent(content);
		
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		sqlSession.update("BoardMapper.update", dto);
		//sqlSession.commit();
		sqlSession.close();
		
		//리턴페이지??? JSP이면 return "경로" 
		response.sendRedirect("detail?bno="+bno);
		return null;//path=null
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long bno=Long.parseLong(request.getParameter("bno"));
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		sqlSession.delete("BoardMapper.deleteById", bno);
		sqlSession.close();
		
		response.sendRedirect("list");
		return null;
	}

}
