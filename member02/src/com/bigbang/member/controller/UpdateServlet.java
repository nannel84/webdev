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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

   protected void doGet(HttpServletRequest request
         , HttpServletResponse response) throws ServletException, IOException {
//      session => id 추출
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("id");
      if(id.equals("")) {
//      로그인이 안된 상태 => MainServlet 보낸다. => loginForm.jsp
         response.sendRedirect("MainServlet");
      }else {
//      select id
         MemberService mService = new MemberService();
         MemberVO member = mService.selectById(id); // id는 session 추출한것
//      request에 select한 결과를 담는다
         request.setAttribute("member", member);

         RequestDispatcher disp = request.getRequestDispatcher("updateForm.jsp");
         disp.forward(request, response);
      }
   }

   protected void doPost(HttpServletRequest request
         , HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	   //      request => 사용자가 입력한 정보 추출
	  HttpSession session = request.getSession();
      String id = (String)session.getAttribute("id");
	  String phone1 = request.getParameter("phone1");
      String phone2 = request.getParameter("phone2");
      String phone3 = request.getParameter("phone3");
      String gender = request.getParameter("gender");
      String pw =request.getParameter("pw");
      

      MemberVO member = new MemberVO();
        	
          member.setPw(pw);
          member.setPhone1(phone1);
          member.setPhone2(phone2);
          member.setPhone3(phone3);
          member.setGender(gender);
          member.setId(id);
          
          MemberService mService = new MemberService();
          mService.updateMember(member);
          
          response.sendRedirect("MainServlet");
          
  }

}
