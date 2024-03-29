package com.kh.jimcarry.payment.model.service;

import static com.kh.jimcarry.common.JDBCTemplate.close;
import static com.kh.jimcarry.common.JDBCTemplate.commit;
import static com.kh.jimcarry.common.JDBCTemplate.getConnection;
import static com.kh.jimcarry.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.jimcarry.payment.model.dao.PaymentDao;
import com.kh.jimcarry.payment.model.vo.Payment;

public class PaymentService {

	public int insertPayment(Payment pay) {
		Connection con = getConnection();
		
		int result = new PaymentDao().insertPayment(con,pay);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public Payment selectRefundPayInfo(String reqNo) {
		Connection con = getConnection();
		Payment pay=null;
		
		pay = new PaymentDao().selectRefundPayInfo(con,reqNo);
		
		close(con);
		
		return pay;
	}

	public String selectpay(String reqNo, String driverNo) {
		Connection con = getConnection();
		
		String payNo = new PaymentDao().selectpay(con,reqNo,driverNo);
		
		close(con);
		
		return payNo;
	}

}

