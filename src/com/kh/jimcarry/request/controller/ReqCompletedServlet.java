package com.kh.jimcarry.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jimcarry.request.model.service.ReviewService;
import com.kh.jimcarry.request.model.vo.Reviews;


@WebServlet("/reqCompleted.jc")
public class ReqCompletedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReqCompletedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo = request.getParameter("userNo");
		String reqNo = request.getParameter("reqNo");
		String driverNo = request.getParameter("driverNo");
		
		int grade = Integer.parseInt(request.getParameter("grade"));
		String review = request.getParameter("review");
		
		System.out.println(userNo);
		System.out.println(reqNo);
		System.out.println(driverNo);
		
		System.out.println(grade);
		System.out.println(review);
		
		Reviews rev = new Reviews();
		rev.setUserNo(userNo);
		rev.setDriverNo(driverNo);
		rev.setGrade(grade);
		rev.setReview(review);
		rev.setReqNo(reqNo);
		
		int result = new ReviewService().insertReviews(rev);
		
		if(result>0) {
			System.out.println("review정보 입력 성공");
		}else {
			System.out.println("review정보 입력 실패");
		}
		
	
		
		
		
		
		
		/*int result1 = new RequestService().update*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
