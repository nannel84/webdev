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
 * Servlet implementation class ModifyServlet2
 */
@WebServlet("/ModifyServlet2")
public class ModifyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyServlet2() {
        super();
    }

    protected void doGet(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {
//         session => id 추출
         HttpSession session = request.getSession();
         String id = (String)session.getAttribute("id");
         int no = Integer.parseInt(request.getParameter("no"));
         if(id.equals("")) {
            response.sendRedirect("MainServlet");
         }else {
            MemberService mService = new MemberService();
			MemberVO member = mService.selectByIdNo(id, no); // id는 session 추출한것
//         request에 select한 결과를 담는다
            request.setAttribute("member", member);
        
            RequestDispatcher disp = request.getRequestDispatcher("modifyForm.jsp");
            disp.forward(request, response);
         }
      }

      protected void doPost(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {
    	  request.setCharacterEncoding("UTF-8");
      
    	  String phone1 = request.getParameter("phone1");
    	  String phone2 = request.getParameter("phone2");
    	  String phone3 = request.getParameter("phone3");
    	  String groupcode = request.getParameter("groupcode");
    	  String no = request.getParameter("no");
    	  String name = request.getParameter("name");
         
    	  MemberVO member = new MemberVO();
           	
             member.setPhone1(phone1);
             member.setPhone2(phone2);
             member.setPhone3(phone3);
             member.setGroupcode(Integer.parseInt(groupcode));
             member.setNo(Integer.parseInt(no));
             member.setName(name);
             
             MemberService mService = new MemberService();
             mService.modifyMember(member);
             
             response.sendRedirect("MainServlet");
             
     }

   }
