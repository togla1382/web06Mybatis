package service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.dto.member.LogInfo;
import domain.dto.member.MemberDTO;
import domain.dto.member.MemberInsertDTO;
import mybatis.MybatisConfig;
import service.MemberService;
import utils.PasswordEncoder;

public class MemberServiceProc implements MemberService {
	
	private SqlSessionFactory ssf= MybatisConfig.getInstance();
	
	//회원가입 처리
	@Override
	public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.페이지에서 넘어온 데이터 처리
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String pass= PasswordEncoder.encode( request.getParameter("pass"));
		//비밀번호 암호화 
		// 2. ip
		String userIp=request.getRemoteHost(); // 127.0.0.1
		
		// 3. 수집한 데이터를 DB저장
		MemberInsertDTO dto=new MemberInsertDTO(email, name, pass, userIp);
		SqlSession sqlSession=ssf.openSession(true);
		//mybatis의 insert(매퍼지정, 데이터)
		sqlSession.insert("MemberMapper.save", dto);
		sqlSession.close();
		
		response.sendRedirect(request.getContextPath());
		return null;
	}

	//로그인 처리 로직
	@Override
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.페이지에서 넘어온 데이터 처리
		String email=request.getParameter("email");
		//2.회원여부확인
		SqlSession sqlSession=ssf.openSession();
		MemberDTO result=sqlSession.selectOne("MemberMapper.findByEmail", email);
		//존재하지 않으면 null을 리턴
		sqlSession.close();
		
		//회원이 존재하면 비밀번호 체크
		if(result != null) {
			String inputPass= PasswordEncoder.encode( request.getParameter("pass") );
			if( result.getPass().equals(inputPass) ) {
				//비밀번호 일치: 로그인 성공처리
				//sessionScope 활용 : HttpSession 객체
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(60*5);
				session.setAttribute("aaa", "에이");
				request.setAttribute("bbb", "비비");
				
				session.setAttribute("logData", new LogInfo(result.getEmail(), result.getName()));
				//인덱스페이지로 이동하기위해 ContextPath 적용
				response.sendRedirect( request.getContextPath() );
				return null;
			}
		}
		//아래문장을 실행하는 경우는 로고인 실패시..
		response.sendRedirect( request.getContextPath()+"/signin?opt=error" );   
		return null;
	}

	//로그아웃
	@Override
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.getSession().removeAttribute("logData");//특정 세션제거
		request.getSession().invalidate();//모든세션 제거
		
		response.sendRedirect( request.getContextPath() );
		return null;
	}

}
