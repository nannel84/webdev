package com.bigbang.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbang.member.service.MemberService;
import com.bigbang.member.vo.MemberVO;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteServlet() {
    }

	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		int no = Integer.parseInt(request.getParameter("no"));
		if(id.equals("")) {
			response.sendRedirect("MainServlet");
		}else {
			MemberService mService = new MemberService();
			MemberVO member = mService.selectByIdNo(id, no); // id는 session 추출한것
            
			request.setAttribute("member", member);

            RequestDispatcher disp = request.getRequestDispatcher("deleteForm.jsp");
            disp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
        
        MemberVO member = new MemberVO();
        
        member.setNo(Integer.parseInt(no));
        
        MemberService mService = new MemberService();
        mService.deleteMember(member);
        
        response.sendRedirect("MainServlet");
	}

}
