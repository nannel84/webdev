package com.bigbang.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigbang.member.service.MemberService;
import com.bigbang.member.vo.MemberVO;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

   protected void doGet(HttpServletRequest request
         , HttpServletResponse response) throws ServletException, IOException {
//      회원가입 화면 이동
      response.setCharacterEncoding("utf-8");

      RequestDispatcher disp = request.getRequestDispatcher("joinForm.jsp");
      disp.forward(request, response);
   }

   protected void doPost(HttpServletRequest request
         , HttpServletResponse response) throws ServletException, IOException {
	   	request.setCharacterEncoding("UTF-8");
		
	   	String id = request.getParameter("id");
	    String pw = request.getParameter("pw");
      	String name = request.getParameter("name");
        String phone1 = request.getParameter("phone1");
        String phone2 = request.getParameter("phone2");
        String phone3 = request.getParameter("phone3");
        String gender = request.getParameter("gender");
         	
        MemberVO member = new MemberVO();
           
           	 member.setId(id);
          	 member.setPw(pw);
           	 member.setName(name);
             member.setPhone1(phone1);
             member.setPhone2(phone2);
             member.setPhone3(phone3);
             member.setGender(gender);
             
             MemberService mService = new MemberService();
             mService.joinMember(member);
             
             
             response.sendRedirect("MainServlet");
             
      }
      
      
   

}





