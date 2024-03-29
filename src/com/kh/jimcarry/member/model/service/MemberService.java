package com.kh.jimcarry.member.model.service;

import com.kh.jimcarry.member.model.dao.MemberDao;
import com.kh.jimcarry.member.model.vo.AttachmentMember;
import com.kh.jimcarry.member.model.vo.DriverList;
import com.kh.jimcarry.member.model.vo.Member;
import com.kh.jimcarry.member.model.vo.UserList;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.jimcarry.common.JDBCTemplate.*;

public class MemberService {
	
	public int insertMember(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertMember(con, m);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public Member loginCheck(String userId, String userPwd) {
		Connection con = getConnection();
		
		Member loginUser = new MemberDao().loginCheck(con, userId, userPwd);
		
		close(con);
		
		return loginUser;
	}

	/*public int insertDriver(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertDriver(con, m);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		
		return result;
	}*/
	//사용자 중복
	public int userIdCheck(String userId) {
		Connection con = getConnection();
		
		int result = new MemberDao().userIdCheck(con, userId);
		
		close(con);
		
		return result;
	}

	public int insertDriver(Member m, ArrayList<AttachmentMember> fileList) {
		Connection con = getConnection();
		int result = 0;
		
		int result1 = new MemberDao().insertDriver(con, m);
		
		if(result1 > 0) {
			String driverNo = new MemberDao().selectCurrval(con);
			System.out.println(driverNo);
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setDriverNo(driverNo);
			}
		}
		int result2 = new MemberDao().insertAttachment(con, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int updateMember(Member m) {
		Connection con = getConnection();
		int result = new MemberDao().updateMember(con, m);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public Member driverLoginCheck(String userId, String userPwd) {
		Connection con = getConnection();
		
		Member loginDriver = new MemberDao().driverLoginCheck(con, userId, userPwd);
		
		close(con);
		
		return loginDriver;
	}

	public int updateDriver(Member m, ArrayList<AttachmentMember> fileList) {
		Connection con = getConnection();
		int result = 0;
		
		int result1 = new MemberDao().updateMember(con, m);
		if(result1 > 0) {
			int result2 = new MemberDao().updateDriver(con, m);
			if(result2 > 0) {
				commit(con);
				System.out.println("r2 : " +result2);
			}
			int result3 = new MemberDao().updateAttachment(con, fileList);
			System.out.println("r3 :" +result3);
			if(result1 > 0 && result2 > 0 && result3 > 0) {
				commit(con);
				result = 1;
			}else {
				rollback(con);
			}
			close(con);
		}
		System.out.println(result);
		return result;
	}

	public ArrayList<DriverList> driverList(String seqNo) {
		Connection con = getConnection();
		
		ArrayList<DriverList> list = new MemberDao().driverList(con, seqNo);
		
		close(con);
		
		return list;
	}

	public ArrayList<UserList> userList(String seqNo) {
		Connection con = getConnection();
		
		ArrayList<UserList> list = new MemberDao().UserList(con, seqNo);
		
		close(con);
		
		return list;
	}

	public int userDelete(Member m) {
		Connection con = getConnection();
		int result = new MemberDao().userDelete(con, m);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public ArrayList<AttachmentMember> driverAttachment(String userId, String userPwd) {
		Connection con = getConnection();
		
		ArrayList<AttachmentMember> attachment = new MemberDao().driverAttachment(con, userId, userPwd);
		
		close(con);
		
		return attachment;
	}

	public Member searchId(String phone, String userName) {
		Connection con = getConnection();
		
		Member m = new MemberDao().searchID(con, phone, userName);
		
		close(con);
		
		return m;
  }
	public Member idSelect(Member m) {
		Connection con = getConnection();
		
		Member idSelect = new MemberDao().idSelect(con, m);
		
		close(con);
		
		return idSelect;
	}

	
}














