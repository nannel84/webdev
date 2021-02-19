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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  HttpSession session = request.getSession();
	      String name = (String)session.getAttribute("name");
	      String id = (String) session.getAttribute("id");
	      
	      if(name == null || id == null) {
//	         로그인 하지 않은 사용자인 경우
	         System.out.println("name == null || id == null 전");
	         response.sendRedirect("loginForm.jsp");
	         System.out.println("name == null || id == null 후");
	      }else {
//	         2. 정상 로그인 한 경우 처리
	            MemberService mService = new MemberService();
				MemberVO member = mService.selectMaxNo(id); // id는 session 추출한것

				request.setAttribute("member", member);
	    	  
				RequestDispatcher disp = 
	               request.getRequestDispatcher("insertForm.jsp");
	         disp.forward(request, response);
			}
	   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	  	
			 String id = request.getParameter("id");
		     String no = request.getParameter("no");
	      	 String name = request.getParameter("name");
	         String phone1 = request.getParameter("phone1");
	         String phone2 = request.getParameter("phone2");
	         String phone3 = request.getParameter("phone3");
	         String groupcode = request.getParameter("groupcode");
	          
	         MemberVO member = new MemberVO();
	           
	           	 member.setId(id);
	          	 member.setNo(Integer.parseInt(no));
	           	 member.setName(name);
	             member.setPhone1(phone1);
	             member.setPhone2(phone2);
	             member.setPhone3(phone3);
	             member.setGroupcode(Integer.parseInt(groupcode));
	             
	             MemberService mService = new MemberService();
	             mService.insertMember(member);
	             
	             
	             response.sendRedirect("MainServlet");
	             
	     }

	   }
	


