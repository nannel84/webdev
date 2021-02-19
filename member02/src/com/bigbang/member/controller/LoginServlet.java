package com.bigbang.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.member.service.MemberService;
import com.bigbang.member.vo.MemberVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//		select : 입력한 아이디와 비밀번호가 데이터베이스에 존재 여부 확인
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		int no=0;
		
		MemberService mService = new MemberService();
		MemberVO member = mService.selectByIdPw(id, pw, no);
		
		
		if(member.getId() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("name", member.getName());
			session.setAttribute("id", member.getId());
			session.setAttribute("no", member.getNo()); //
			
			response.sendRedirect("MainServlet");
		}else {
//		비정상 로그인	
			response.sendRedirect("reloginForm.jsp");
		}
	}

}
