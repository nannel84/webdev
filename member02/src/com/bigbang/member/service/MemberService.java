package com.bigbang.member.service;

import java.util.ArrayList;

import com.bigbang.member.dao.MemberDAO;
import com.bigbang.member.vo.MemberVO;

public class MemberService {
//   모든 회원 검색
   public ArrayList<MemberVO> selectAll(String id){
	ArrayList<MemberVO> members = new MemberDAO().selectAll(id);
	return members;
   }
//   
   public MemberVO selectByIdPw(String id, String pw, int no) {
      MemberVO member = new MemberDAO().selectByIdPw(id, pw, no);
      return member;
   }
   
   public MemberVO selectByIdNo(String id, int no) {
	      MemberVO member = new MemberDAO().selectByIdNo(id, no);
	      return member;
	   }
   
   public MemberVO selectMaxNo(String id) {
	      MemberVO member = new MemberDAO().selectMaxNo(id);
	      return member;
	   }

   public void insertMember(MemberVO member) {
      MemberDAO mDao = new MemberDAO();
      mDao.insertMember(member);
   }
   
   public void joinMember(MemberVO member) {
	      MemberDAO mDao = new MemberDAO();
	      mDao.joinMember(member);
	   }

   public MemberVO selectById(String id) {
      MemberVO member = null;
      MemberDAO mDao = new MemberDAO();
      member = mDao.selectById(id);
      return member;
   }

   public void modifyMember(MemberVO member) {
      MemberDAO mDao = new MemberDAO();
      mDao.modifyMember(member);
   }
   
   public void updateMember(MemberVO member) {
	      MemberDAO mDao = new MemberDAO();
	      mDao.updateMember(member);
	   }
   
   public void deleteMember(MemberVO member) {
	  MemberDAO mDao = new MemberDAO();
	  mDao.deleteMember(member);
	   }
   
}





