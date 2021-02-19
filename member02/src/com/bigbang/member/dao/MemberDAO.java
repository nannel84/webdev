package com.bigbang.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bigbang.member.vo.MemberVO;

public class MemberDAO {

   
//   로그인한 회원의 모든 연락처
   public ArrayList<MemberVO> selectAll(String id){
      Connection con         = null;
      PreparedStatement pstmt = null;
      ResultSet rs          = null;
      DBConnection dbCon       = null;
      
      ArrayList<MemberVO> members = new ArrayList<MemberVO>();
      String query = "select no,name,phone1,phone2,phone3,groupcode from contact where id=? order by no";
      
      try {
         dbCon = DBConnection.getInstance();
         con = dbCon.getConnection();
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            MemberVO member = new MemberVO();
            member.setNo(rs.getInt("no"));
            member.setName(rs.getString("name"));
            member.setPhone1(rs.getString("phone1"));
            member.setPhone2(rs.getString("phone2"));
            member.setPhone3(rs.getString("phone3"));
            member.setGroupcode(rs.getInt("groupcode"));
            
            members.add(member);
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         dbCon.close(con, pstmt);
      }
      return members;
   }
   
//   로그인 처리
   public MemberVO selectByIdPw(String id, String pw, int no) {
      Connection con          = null;
      PreparedStatement pstmt = null;
      ResultSet rs          = null;
      MemberVO member       = new MemberVO();
      StringBuilder query = new StringBuilder();
      query.append("select name, id 	");
      query.append("  from members    	");
      query.append("   where id =?    	");
      query.append("   and pw=?      	");

      DBConnection dbCon       = DBConnection.getInstance();
      
      try {
         con = dbCon.getConnection();
         pstmt = con.prepareStatement(query.toString());
         pstmt.setString(1, id);
         pstmt.setString(2, pw);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            member.setName(rs.getString("name"));
            member.setId(rs.getString("id"));
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs != null) {
               rs.close();
            }
            dbCon.close(con, pstmt);
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
      
      return member;
   }

// Max번호 구하기
   public MemberVO selectMaxNo(String id) {
	   Connection con          = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs          = null;
	   MemberVO member       = new MemberVO();
	   StringBuilder query = new StringBuilder();
	   query.append(" select max(no)as no   ");
	   query.append("   from contact     	");
	   query.append("   where id=?     		");

    DBConnection dbCon       = DBConnection.getInstance();
    
    	try {
    		con = dbCon.getConnection();
    		pstmt = con.prepareStatement(query.toString());
    		pstmt.setString(1, id);
    		rs = pstmt.executeQuery();
       
    		if(rs.next()) {
    	   
    		member.setNo(rs.getInt("no"));
       }
       }catch(Exception e) {
    	   e.printStackTrace();
       }finally {
    	   try {
    		   if(rs != null) {
    			   rs.close();
               }
    		   dbCon.close(con, pstmt);
    	   }catch(Exception e) {
    		   e.printStackTrace();
    	   }
       }
    
    	return member;
   }
//회원 가입
   public int joinMember(MemberVO member) {
	   Connection con = null;
	   PreparedStatement pstmt = null;
	   DBConnection dbCon = DBConnection.getInstance();

	   int rowcnt=0;
	   String query = "insert into members values (?,?,?,?,?,?,?)";
  
	   try {
		   con = dbCon.getConnection();
		   pstmt = con.prepareStatement(query);
		   pstmt.setString(1, member.getName());
		   pstmt.setString(2, member.getId());
		   pstmt.setString(3, member.getPw());
		   pstmt.setString(4, member.getPhone1());
		   pstmt.setString(5, member.getPhone2());
		   pstmt.setString(6, member.getPhone3());
		   pstmt.setString(7,member.getGender());
     
		   rowcnt = pstmt.executeUpdate();
	   } catch (Exception e) {
		   e.printStackTrace();
		   //데이터베이스 연결종료(close)		
	   } finally {
		   try {
			   con.close();
			   pstmt.close();
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   return rowcnt;
   }
//   회원 추가
   public int insertMember(MemberVO member) {
      Connection con = null;
      PreparedStatement pstmt = null;
      DBConnection dbCon = DBConnection.getInstance();

      int rowcnt=0;
      String query = "insert into contact values (?,?,?,?,?,?,?)";
      
      try {
         con = dbCon.getConnection();
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, member.getId());
         pstmt.setInt(2, member.getNo());
         pstmt.setString(3, member.getName());
         pstmt.setString(4, member.getPhone1());
         pstmt.setString(5, member.getPhone2());
         pstmt.setString(6, member.getPhone3());
         pstmt.setInt(7,member.getGroupcode());
         
         rowcnt = pstmt.executeUpdate();
      } catch (Exception e) {
			e.printStackTrace();
		//데이터베이스 연결종료(close)		
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
      return rowcnt;
	}
   
// 이름 검색
   public MemberVO selectById(String id) {
      Connection con          = null;
      PreparedStatement pstmt = null;
      ResultSet rs         = null;
      MemberVO member         = null;
      DBConnection dbCon      = DBConnection.getInstance();
      String query = "select * from members where id = ?";
      
      try {
         con = dbCon.getConnection();
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            member = new MemberVO();
            member.setName(rs.getString("name"));
            member.setId(rs.getString("id"));
            member.setPw(rs.getString("pw"));
            member.setPhone1(rs.getString("phone1"));
            member.setPhone2(rs.getString("phone2"));
            member.setPhone3(rs.getString("phone3"));
            member.setGender(rs.getString("gender"));
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs != null) {
               rs.close();
            }
            dbCon.close(con, pstmt);
         }catch(Exception e) {
            e.printStackTrace();
         }
      }
      
      return member;
   }
// 연락처목록검색
   public MemberVO selectByIdNo(String id, int no) {
	      Connection con          = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs          = null;
	      MemberVO member       = new MemberVO();
	      StringBuilder query = new StringBuilder();
	      query.append("select no,name,phone1,phone2,phone3,groupcode   	");
	      query.append("from contact     	");
	      query.append(" where id = ?      	");
	      query.append("   and no = ?      	");

	      DBConnection dbCon       = DBConnection.getInstance();
	      
	      try {
	         con = dbCon.getConnection();
	         pstmt = con.prepareStatement(query.toString());
	         pstmt.setString(1, id);
	         pstmt.setInt(2, no);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	             member = new MemberVO();
	             member.setNo(rs.getInt("no"));
	             member.setName(rs.getString("name"));
	             member.setPhone1(rs.getString("phone1"));
	             member.setPhone2(rs.getString("phone2"));
	             member.setPhone3(rs.getString("phone3"));
	             member.setGroupcode(rs.getInt("groupcode"));
	         }    
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs != null) {
	               rs.close();
	            }
	            dbCon.close(con, pstmt);
	         }catch(Exception e) {
	            e.printStackTrace();
	         }
	      }
	      
	      return member;
	   }
   
// 로그인한 목록의 회원중에 수정
   public int modifyMember(MemberVO member) {
      Connection con          = null;
      PreparedStatement pstmt = null;
      DBConnection dbCon = DBConnection.getInstance();
      
      int rowcnt=0;
      StringBuilder query = new StringBuilder();
      query.append("update contact     	");
      query.append("    set phone1 = ? 	");
      query.append("     , phone2 = ? 	");
      query.append("     , phone3 = ? 	");
      query.append("	 , groupcode=?  ");
      query.append("	where no = ?		");
      query.append("	and name = ?		");
      try {
         con  = dbCon.getConnection();
         pstmt = con.prepareStatement(query.toString());
         pstmt.setString(1, member.getPhone1());
         pstmt.setString(2, member.getPhone2());
         pstmt.setString(3, member.getPhone3());
         pstmt.setInt(4, member.getGroupcode());
         pstmt.setInt(5, member.getNo());
         pstmt.setString(6, member.getName());
        
         rowcnt= pstmt.executeUpdate();
         
		//에러시 화면 출력	
		} catch (Exception e) {
			e.printStackTrace();
		//데이터베이스 연결종료(close)		
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	return rowcnt;
	}
   
// 회원 수정
   public int updateMember(MemberVO member) {
      Connection con          = null;
      PreparedStatement pstmt = null;
      DBConnection dbCon = DBConnection.getInstance();
      
      int rowcnt=0;
      StringBuilder query = new StringBuilder();
      query.append("update members    	");
      query.append("     set pw = ? 	");
      query.append("     , phone1 = ? 	");
      query.append("     , phone2 = ? 	");
      query.append("     , phone3 = ? 	");
      query.append("	 , gender=?  ");
      query.append("	where id = ?		");
      try {
         con  = dbCon.getConnection();
         pstmt = con.prepareStatement(query.toString());
         pstmt.setString(1, member.getPw());
         pstmt.setString(2, member.getPhone1());
         pstmt.setString(3, member.getPhone2());
         pstmt.setString(4, member.getPhone3());
         pstmt.setString(5, member.getGender());
         pstmt.setString(6, member.getId());
        
         rowcnt= pstmt.executeUpdate();
         
		//에러시 화면 출력	
		} catch (Exception e) {
			e.printStackTrace();
		//데이터베이스 연결종료(close)		
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	return rowcnt;
	}
   

   
//  연락처 목록중 정보 삭제
   
   public int deleteMember(MemberVO member) {
	      Connection con          = null;
	      PreparedStatement pstmt = null;
	      DBConnection dbCon = DBConnection.getInstance();
	      
	      int rowcnt=0;
	      StringBuilder query = new StringBuilder();
	      query.append("delete from contact      ");
	      query.append(" where no = ?      	");
	      
	      try {
	         con  = dbCon.getConnection();
	         pstmt = con.prepareStatement(query.toString());
	         pstmt.setInt(1, member.getNo());
	         
	         rowcnt = pstmt.executeUpdate();
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	    	  try {
					con.close();
					pstmt.close();
			} catch (Exception e) {
					e.printStackTrace();
				}
	      }
	      return rowcnt;
   }
}   
	
