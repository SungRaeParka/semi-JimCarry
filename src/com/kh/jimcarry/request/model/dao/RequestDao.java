package com.kh.jimcarry.request.model.dao;

import static com.kh.jimcarry.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.tomcat.util.collections.SynchronizedStack;
import org.eclipse.jdt.internal.compiler.lookup.PolymorphicMethodBinding;

import com.kh.jimcarry.request.model.vo.Product;
import com.kh.jimcarry.request.model.vo.Request;
import com.kh.jimcarry.request.model.vo.RequestAttachment;
import com.kh.jimcarry.request.model.vo.ShowRP;

public class RequestDao {

	private Properties prop = new Properties();

	public RequestDao(){
		String fileName = RequestDao.class.getResource("/sql/request/request-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	//게시물 수 조회_사용자,기사
	public int getListCount(Connection con,String logUserNo) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query;
		if(logUserNo.charAt(0)=='U') {
			query = prop.getProperty("selectListCount");
		}else {
			query = prop.getProperty("selectDriverListCount");
		}
		System.out.println(query);


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, logUserNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}



	//페이징처리후 게시물 조회_사용자
	public ArrayList<Request> selectList(Connection con, int currentPage, int limit, String logUserNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Request> list = null;

		String query = prop.getProperty("selectList");
		System.out.println(query);

		try {

			pstmt = con.prepareStatement(query);

			int startRow = (currentPage-1)*limit + 1;
			int endRow = startRow + limit -1;

			pstmt.setString(1, logUserNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<Request>();
			
			String reqStart = "";
			String reqArrive = "";

			while(rset.next()) {
				Request req = new Request();
				
				req.setReservationDate(rset.getString("RESERVATION_DATE"));
								
				if(rset.getString("START_POINT").contains("강남구")) {
					reqStart = "서울시 강남구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("강동구")) {
					reqStart = "서울시 강동구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("강북구")) {
					reqStart = "서울시 강북구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("강서구")) {
					reqStart = "서울시 강서구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("관악구")) {
					reqStart = "서울시 관악구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("광진구")) {
					reqStart = "서울시 광진구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("구로구")) {
					reqStart = "서울시 구로구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("금천구")) {
					reqStart = "서울시 금천구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("노원구")) {
					reqStart = "서울시 노원구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("도봉구")) {
					reqStart = "서울시 도봉구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("동대문구")) {
					reqStart = "서울시 동대문구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("동작구")) {
					reqStart = "서울시 동작구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("마포구")) {
					reqStart = "서울시 마포구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("서대문구")) {
					reqStart = "서울시 서대문구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("서초구")) {
					reqStart = "서울시 서초구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("성동구")) {
					reqStart = "서울시 성동구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("성북구")) {
					reqStart = "서울시 성북구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("송파구")) {
					reqStart = "서울시 송파구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("강동구")) {
					reqStart = "서울시 강동구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("양천구")) {
					reqStart = "서울시 양천구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("영등포구")) {
					reqStart = "서울시 영등포구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("용산구")) {
					reqStart = "서울시 용산구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("은평구")) {
					reqStart = "서울시 은평구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("종로구")) {
					reqStart = "서울시 종로구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("중구")) {
					reqStart = "서울시 중구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("중랑구")) {
					reqStart = "서울시 중랑구";
					req.setStartPoint(reqStart);
				}
				
				
				if(rset.getString("ARRIVE_POINT").contains("강남구")) {
					reqArrive = "서울시 강남구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("강동구")) {
					reqArrive = "서울시 강동구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("강북구")) {
					reqArrive = "서울시 강북구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("강서구")) {
					reqArrive = "서울시 강서구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("관악구")) {
					reqArrive = "서울시 관악구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("광진구")) {
					reqArrive = "서울시 광진구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("구로구")) {
					reqArrive = "서울시 구로구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("금천구")) {
					reqArrive = "서울시 금천구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("노원구")) {
					reqArrive = "서울시 노원구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("도봉구")) {
					reqArrive = "서울시 도봉구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("동대문구")) {
					reqArrive = "서울시 동대문구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("동작구")) {
					reqArrive = "서울시 동작구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("마포구")) {
					reqArrive = "서울시 마포구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("서대문구")) {
					reqArrive = "서울시 서대문구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("서초구")) {
					reqArrive = "서울시 서초구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("성동구")) {
					reqArrive = "서울시 성동구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("성북구")) {
					reqArrive = "서울시 성북구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("송파구")) {
					reqArrive = "서울시 송파구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("강동구")) {
					reqArrive = "서울시 강동구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("양천구")) {
					reqArrive = "서울시 양천구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("영등포구")) {
					reqArrive = "서울시 영등포구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("용산구")) {
					reqArrive = "서울시 용산구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("은평구")) {
					reqArrive = "서울시 은평구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("종로구")) {
					reqArrive = "서울시 종로구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("중구")) {
					reqArrive = "서울시 중구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("중랑구")) {
					reqArrive = "서울시 중랑구";
					req.setArrivalPoint(reqArrive);
				}	
				req.setReqStart(rset.getDate("REQ_START"));
				req.setReqFinish(rset.getDate("REQ_FINISH"));
				//req.setUserNo(rset.getString("USER_NO"));
				req.setReqNo(rset.getString("REQ_NO"));
				//req.setProNo(rset.getString("PRODUCT_NO"));
				req.setConditionReq(rset.getString("CONDITION_REQ"));
				req.setReqCount(rset.getInt("COUNT"));
				

				list.add(req);

				System.out.println("리스트에 담김");
				System.out.println(list.get(0));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		return list;
	}



	//페이징처리후 게시물 조회_기사
	public ArrayList<Request> selectDriverList(Connection con, int currentPage, int limit, String logUserNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Request> list = null;

		String query = prop.getProperty("selectDriverList");
		
		System.out.println("기사 짐캐리 리스트 logUserNo :: " + logUserNo);
		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage-1)*limit + 1;
			int endRow = startRow + limit -1;
			

			pstmt.setString(1, logUserNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<Request>();
			String reqStart = "";
			String reqArrive = "";

			while(rset.next()) {
				Request req = new Request();

				req.setReqNo(rset.getString("REQ_NO"));
				
				if(rset.getString("START_POINT").contains("강남구")) {
					reqStart = "서울시 강남구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("강동구")) {
					reqStart = "서울시 강동구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("강북구")) {
					reqStart = "서울시 강북구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("강서구")) {
					reqStart = "서울시 강서구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("관악구")) {
					reqStart = "서울시 관악구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("광진구")) {
					reqStart = "서울시 광진구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("구로구")) {
					reqStart = "서울시 구로구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("금천구")) {
					reqStart = "서울시 금천구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("노원구")) {
					reqStart = "서울시 노원구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("도봉구")) {
					reqStart = "서울시 도봉구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("동대문구")) {
					reqStart = "서울시 동대문구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("동작구")) {
					reqStart = "서울시 동작구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("마포구")) {
					reqStart = "서울시 마포구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("서대문구")) {
					reqStart = "서울시 서대문구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("서초구")) {
					reqStart = "서울시 서초구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("성동구")) {
					reqStart = "서울시 성동구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("성북구")) {
					reqStart = "서울시 성북구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("송파구")) {
					reqStart = "서울시 송파구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("강동구")) {
					reqStart = "서울시 강동구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("양천구")) {
					reqStart = "서울시 양천구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("영등포구")) {
					reqStart = "서울시 영등포구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("용산구")) {
					reqStart = "서울시 용산구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("은평구")) {
					reqStart = "서울시 은평구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("종로구")) {
					reqStart = "서울시 종로구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("중구")) {
					reqStart = "서울시 중구";
					req.setStartPoint(reqStart);
				}else if(rset.getString("START_POINT").contains("중랑구")) {
					reqStart = "서울시 중랑구";
					req.setStartPoint(reqStart);
				}
				
				
				if(rset.getString("ARRIVE_POINT").contains("강남구")) {
					reqArrive = "서울시 강남구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("강동구")) {
					reqArrive = "서울시 강동구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("강북구")) {
					reqArrive = "서울시 강북구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("강서구")) {
					reqArrive = "서울시 강서구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("관악구")) {
					reqArrive = "서울시 관악구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("광진구")) {
					reqArrive = "서울시 광진구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("구로구")) {
					reqArrive = "서울시 구로구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("금천구")) {
					reqArrive = "서울시 금천구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("노원구")) {
					reqArrive = "서울시 노원구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("도봉구")) {
					reqArrive = "서울시 도봉구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("동대문구")) {
					reqArrive = "서울시 동대문구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("동작구")) {
					reqArrive = "서울시 동작구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("마포구")) {
					reqArrive = "서울시 마포구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("서대문구")) {
					reqArrive = "서울시 서대문구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("서초구")) {
					reqArrive = "서울시 서초구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("성동구")) {
					reqArrive = "서울시 성동구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("성북구")) {
					reqArrive = "서울시 성북구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("송파구")) {
					reqArrive = "서울시 송파구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("강동구")) {
					reqArrive = "서울시 강동구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("양천구")) {
					reqArrive = "서울시 양천구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("영등포구")) {
					reqArrive = "서울시 영등포구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("용산구")) {
					reqArrive = "서울시 용산구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("은평구")) {
					reqArrive = "서울시 은평구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("종로구")) {
					reqArrive = "서울시 종로구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("중구")) {
					reqArrive = "서울시 중구";
					req.setArrivalPoint(reqArrive);
				}else if(rset.getString("ARRIVE_POINT").contains("중랑구")) {
					reqArrive = "서울시 중랑구";
					req.setArrivalPoint(reqArrive);
				}	
				req.setReservationDate(rset.getString("RESERVATION_DATE"));
				req.setReqFinish(rset.getDate("REQ_FINISH"));
				req.setUserName(rset.getString("MEMBER_NAME"));
				req.setReqCount(rset.getInt("COUNT"));
				req.setOrderPrice(rset.getInt("ORDER_PRICE"));
				req.setConditionDo(rset.getString("CONDITION_DO"));

				list.add(req);

				System.out.println("리스트에 담김");
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	//입찰내역 리스트
	public HashMap<String, Request> selectOrderList(Connection con, String logUserNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Request> orderMap = null;

		String query = prop.getProperty("selectorder");
		System.out.println("입찰내역 리스트 쿼리 :: "+query);
		System.out.println("입찰내역 logUserNo :: " + logUserNo);

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, logUserNo);
			pstmt.setString(2, "매칭대기");
			pstmt.setString(3, "매칭대기");

			rset = pstmt.executeQuery();

			orderMap = new HashMap<String, Request>();

			while(rset.next()) {
				Request or = new Request();

				or.setReqNo(rset.getString("REQ_NO"));
				or.setOrderPrice(rset.getInt("ORDER_PRICE"));
				or.setDriverNo(rset.getString("DRIVER_NO"));
				or.setDriverName(rset.getString("MEMBER_NAME"));
				or.setGrade(rset.getString("GRADE_AVG"));

				System.out.println(or.getReqNo());
				orderMap.put(or.getReqNo(),or);
				System.out.println(orderMap.get(or.getReqNo()));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}


		return orderMap;
	}		


	//입찰내역확인
	public ArrayList<Request> checkOrder(Connection con, String no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Request> rolist = null;
		
		System.out.println("no ::::"+ no);

		String query = prop.getProperty("checkOrder");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, no);

			rset = pstmt.executeQuery();

			rolist = new ArrayList<Request>();

			while(rset.next()) {
				Request ro = new Request();

				ro.setReqNo(rset.getString("REQ_NO"));
				ro.setDriverNo(rset.getString("DRIVER_NO"));
				ro.setOrderPrice(rset.getInt("ORDER_PRICE"));
				ro.setDriverName(rset.getString("MEMBER_NAME"));
				ro.setGrade(rset.getString("GRADE_AVG"));
				//ro.setReview(rset.getString("REVIEW"));
				ro.setReqFinish(rset.getDate("REQ_FINISH"));

				rolist.add(ro);
				
			}
			System.out.println("Dao ro"+rolist);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}


		return rolist;
	}


	//최저가 가져오기
	public int minPriceCal(Connection con, String no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int minPrice = 0;

		String query = prop.getProperty("minPriCal");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, no);

			rset = pstmt.executeQuery();

			while(rset.next()) {
				Request r = new Request();
				r.setOrderPrice(rset.getInt("MIN(ORDER_PRICE)"));

				minPrice = r.getOrderPrice();
				System.out.println(minPrice);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return minPrice;
	}

	//결제정보 가져기
	public Request makePayInfo(Connection con, String reqNo, String roNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Request payInfo = null;
		
		String query = prop.getProperty("makePayInfo");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, reqNo);
			pstmt.setString(2, roNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				payInfo = new Request();
				
				payInfo.setUserNo(rset.getString("USER_NO"));
				payInfo.setUserName(rset.getString("MEMBER_NAME"));
				payInfo.setReqNo(rset.getString("REQ_NO"));
				payInfo.setDriverNo(rset.getString("DRIVER_NO"));
				payInfo.setOrderPrice(rset.getInt("ORDER_PRICE"));
				
				System.out.println(payInfo.getUserNo());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return payInfo;
	}
	
	public int updateConditionReq(Connection con, String reqNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateConditionReq");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "이용대기");
			pstmt.setString(2, reqNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

	public int updateConditionDo(Connection con, String reqNo, String driverNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateConditionDo");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "이용대기");
			pstmt.setString(2, reqNo);
			pstmt.setString(3, driverNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	public int updateConditionCancel(Connection con, String reqNo, String driverNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateConditionCancel");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "취소");
			pstmt.setString(2, reqNo);
			pstmt.setString(3, driverNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int updateConditionReq2(Connection con, String reqNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateConditionReq");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "이용완료");
			pstmt.setString(2, reqNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updateConditionDo2(Connection con, String reqNo, String driverNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateConditionDo");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "이용완료");
			pstmt.setString(2, reqNo);
			pstmt.setString(3, driverNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	

	public int updateConditionDo3(Connection con, String reqNo, String driverNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateConditionDo");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "정산대기");
			pstmt.setString(2, reqNo);
			pstmt.setString(3, driverNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateConditionReq4(Connection con, String reqNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateConditionReq");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "취소");
			pstmt.setString(2, reqNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int updateConditionDo4(Connection con, String reqNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateConditionDo2");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "취소");
			pstmt.setString(2, reqNo);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	
	

	public int insertRequest(Connection con, Request r) {
		PreparedStatement pstmt = null;
		int result = 0;
		long a = r.getReqFinish().getTime();

		String query = prop.getProperty("insertRequestInfo");

		java.sql.Date reqFinishSql = new java.sql.Date(a);

		System.out.println("dao  r.getReservationDate() ::" +  r.getReservationDate());

		try {
			pstmt = con.prepareStatement(query);


			pstmt.setString(1, r.getReservationDate());
			pstmt.setString(2, r.getStartPoint());
			pstmt.setString(3, r.getArrivalPoint());
			pstmt.setDate(4, reqFinishSql);
			pstmt.setString(5, r.getUserNo());
			pstmt.setString(6, "R" + r.getReqNo());
			pstmt.setString(7, r.getProNo());
			pstmt.setString(8, r.getMemo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		return result;
	}




	public int insertPIMG(Connection con, ArrayList<RequestAttachment> fileList, String reqNo, String proNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertPIMG"); 

		try {
			for(int i = 0; i < fileList.size(); i++) {
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, fileList.get(i).getOriginName());
				pstmt.setString(2, fileList.get(i).getChangeName());
				pstmt.setString(3, fileList.get(i).getFilePath());

				int level = 0;

				pstmt.setInt(4, level);

				level++;

				pstmt.setString(5, "견적물품사진");
				pstmt.setString(6, "R"+reqNo);
				//pstmt.setString(7, "");

				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}


	public ShowRP selectRequestInfo(Connection con, String reqNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ShowRP requestInfo = null;

		String query = prop.getProperty("requestInfo");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "R"+reqNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				requestInfo = new ShowRP();

				requestInfo.setReqNo(rset.getString("REQ_NO"));
				requestInfo.setReservDate(rset.getString("RESERVATION_DATE"));
				requestInfo.setStartPoint(rset.getString("START_POINT"));
				requestInfo.setArrivePoint(rset.getString("ARRIVE_POINT"));
				requestInfo.setReqStart(rset.getDate("REQ_START"));
				requestInfo.setReqFinish(rset.getDate("REQ_FINISH"));
				requestInfo.setMemo(rset.getString("MEMO"));			

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return requestInfo;
	}



	public ArrayList<HashMap<String, Object>> selectRequestImg(Connection con, String reqNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> requestImg = null;
		HashMap<String, Object> hmap = null;	

		String query = prop.getProperty("selectRequestImg");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "R"+reqNo);

			rset = pstmt.executeQuery();

			requestImg = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {

				hmap = new HashMap<String, Object>();

				hmap.put("reqNo", rset.getString("REQ_NO"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("changeName", rset.getString("CHANGE_NAME"));

				requestImg.add(hmap);

				System.out.println("requestImg :::" + requestImg);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return requestImg;
	}



	public ArrayList<HashMap<String, Object>> selectProductInFo(Connection con, String reqNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> ProductInfo = null;
		HashMap<String, Object> hmap = null;

		String query = prop.getProperty("selectProductInfo");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "R" + reqNo);

			rset = pstmt.executeQuery();

			ProductInfo = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String, Object>();

				hmap.put("proKind", rset.getString("PRODUCT_KIND"));
				hmap.put("proName", rset.getString("PRODUCT_NAME"));				

				System.out.println("hmap.get(proName) ::: " + hmap.get("proName"));

				if(rset.getString("PRODUCT_NAME").equals("냉장고")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("세탁기")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("TV/모니터")) {

					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("에어컨")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proUni", rset.getString("UNIQUNESS"));
				}else if(rset.getString("PRODUCT_NAME").equals("정수기")){

					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
					hmap.put("proUni", rset.getString("UNIQUNESS"));
				}else if(rset.getString("PRODUCT_NAME").equals("PC/노트북")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
				}else if(rset.getString("PRODUCT_NAME").equals("전자레인지")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
				}else if(rset.getString("PRODUCT_NAME").equals("침대")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("의자")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));

				}else if(rset.getString("PRODUCT_NAME").equals("책상/테이블")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
					hmap.put("proMat", rset.getString("MATERIAL"));
					hmap.put("proWidth", rset.getString("WIDTH"));

				}else if(rset.getString("PRODUCT_NAME").equals("책장")) {

					hmap.put("proWidth", rset.getString("WIDTH"));
					hmap.put("proHeight", rset.getString("HEIGHT"));

				}else if(rset.getString("PRODUCT_NAME").equals("옷장")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proUni", rset.getString("UNIQUNESS"));
					hmap.put("proWidth", rset.getString("WIDTH"));

				}else if(rset.getString("PRODUCT_NAME").equals("진열장")) {

					hmap.put("proWidth", rset.getString("WIDTH"));
					hmap.put("proHeight", rset.getString("HEIGHT"));
					hmap.put("proGck", rset.getString("GLASS_CHECK"));

				}else if(rset.getString("PRODUCT_NAME").equals("쇼파")) {

					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));

				}else if(rset.getString("PRODUCT_NAME").equals("행거")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proWidth", rset.getString("WIDTH"));

				}else if(rset.getString("PRODUCT_NAME").equals("거울")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));

				}else if(rset.getString("PRODUCT_NAME").equals("화장대")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proMat", rset.getString("MATERIAL"));

				}else if(rset.getString("PRODUCT_NAME").equals("피아노")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));

				}

				ProductInfo.add(hmap);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return ProductInfo;
	}



	public ShowRP selectRequestInfo2(Connection con, String reqNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ShowRP requestInfo = null;

		String query = prop.getProperty("requestInfo");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, reqNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				requestInfo = new ShowRP();

				requestInfo.setReqNo(rset.getString("REQ_NO"));
				requestInfo.setReservDate(rset.getString("RESERVATION_DATE"));
				requestInfo.setStartPoint(rset.getString("START_POINT"));
				requestInfo.setArrivePoint(rset.getString("ARRIVE_POINT"));
				requestInfo.setReqStart(rset.getDate("REQ_START"));
				requestInfo.setReqFinish(rset.getDate("REQ_FINISH"));
				requestInfo.setMemo(rset.getString("MEMO"));			

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return requestInfo;
	}

	public ArrayList<HashMap<String, Object>> selectRequestImg2(Connection con, String reqNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> requestImg = null;
		HashMap<String, Object> hmap = null;

		String query = prop.getProperty("selectRequestImg");

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, reqNo);

			rset = pstmt.executeQuery();

			requestImg = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {

				hmap = new HashMap<String, Object>();

				hmap.put("reqNo", rset.getString("REQ_NO"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("changeName", rset.getString("CHANGE_NAME"));

				requestImg.add(hmap);

				System.out.println("requestImg :::" + requestImg);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return requestImg;
	}

	public ArrayList<HashMap<String, Object>> selectProductInFo2(Connection con, String reqNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> ProductInfo = null;
		HashMap<String, Object> hmap = null;

		String query = prop.getProperty("selectProductInfo");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "R" + reqNo);

			rset = pstmt.executeQuery();

			ProductInfo = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String, Object>();

				hmap.put("proKind", rset.getString("PRODUCT_KIND"));
				hmap.put("proName", rset.getString("PRODUCT_NAME"));				

				System.out.println("hmap.get(proName) ::: " + hmap.get("proName"));

				if(rset.getString("PRODUCT_NAME").equals("냉장고")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("세탁기")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("TV/모니터")) {

					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("에어컨")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proUni", rset.getString("UNIQUNESS"));
				}else if(rset.getString("PRODUCT_NAME").equals("정수기")){

					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
					hmap.put("proUni", rset.getString("UNIQUNESS"));
				}else if(rset.getString("PRODUCT_NAME").equals("PC/노트북")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
				}else if(rset.getString("PRODUCT_NAME").equals("전자레인지")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
				}else if(rset.getString("PRODUCT_NAME").equals("침대")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("의자")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));

				}else if(rset.getString("PRODUCT_NAME").equals("책상/테이블")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
					hmap.put("proMat", rset.getString("MATERIAL"));
					hmap.put("proWidth", rset.getString("WIDTH"));

				}else if(rset.getString("PRODUCT_NAME").equals("책장")) {

					hmap.put("proWidth", rset.getString("WIDTH"));
					hmap.put("proHeight", rset.getString("HEIGHT"));

				}else if(rset.getString("PRODUCT_NAME").equals("옷장")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proUni", rset.getString("UNIQUNESS"));
					hmap.put("proWidth", rset.getString("WIDTH"));

				}else if(rset.getString("PRODUCT_NAME").equals("진열장")) {

					hmap.put("proWidth", rset.getString("WIDTH"));
					hmap.put("proHeight", rset.getString("HEIGHT"));
					hmap.put("proGck", rset.getString("GLASS_CHECK"));

				}else if(rset.getString("PRODUCT_NAME").equals("쇼파")) {

					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));

				}else if(rset.getString("PRODUCT_NAME").equals("행거")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proWidth", rset.getString("WIDTH"));

				}else if(rset.getString("PRODUCT_NAME").equals("거울")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));

				}else if(rset.getString("PRODUCT_NAME").equals("화장대")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proMat", rset.getString("MATERIAL"));

				}else if(rset.getString("PRODUCT_NAME").equals("피아노")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));

				}

				ProductInfo.add(hmap);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return ProductInfo;
	}



	public ArrayList<HashMap<String, Object>> selectreqNoList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> tempReqNoList = null;
		HashMap<String, Object> hmap = null;

		String query = prop.getProperty("selectreqNoList");

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, "매칭대기");

			rset = pstmt.executeQuery();

			tempReqNoList = new ArrayList<HashMap<String, Object>>();
			while(rset.next()) {
				hmap = new HashMap<String, Object>();

				hmap.put("reqNo", rset.getString("REQ_NO"));

				tempReqNoList.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return tempReqNoList;
	}



	public ArrayList<HashMap<String, Object>> selectReqList(Connection con, ArrayList<HashMap<String, Object>> reqNoList) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> reqList = null;
		HashMap<String, Object> hmap = null;
		String reqStart = "";
		String reqArrive = "";

		String query = prop.getProperty("selectReqList");
		
		reqList = new ArrayList<HashMap<String, Object>>();

		for(int i = 0; i < reqNoList.size(); i++) {
			HashMap<String, Object> reqNoHmap = reqNoList.get(i);			

			try {
				pstmt = con.prepareStatement(query);


				pstmt.setString(1, (String)reqNoHmap.get("reqNo"));
				pstmt.setString(2, "매칭대기");

				rset = pstmt.executeQuery();

				while(rset.next()) {					
					hmap = new HashMap<String, Object>();
					
					hmap.put("memberNo", rset.getString("MEMBER_NO"));
					hmap.put("memberName", rset.getString("MEMBER_NAME"));
					hmap.put("reservDate", rset.getString("RESERVATION_DATE"));
					
					if(rset.getString("START_POINT").contains("강남구")) {
						reqStart = "서울시 강남구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("강동구")) {
						reqStart = "서울시 강동구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("강북구")) {
						reqStart = "서울시 강북구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("강서구")) {
						reqStart = "서울시 강서구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("관악구")) {
						reqStart = "서울시 관악구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("광진구")) {
						reqStart = "서울시 광진구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("구로구")) {
						reqStart = "서울시 구로구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("금천구")) {
						reqStart = "서울시 금천구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("노원구")) {
						reqStart = "서울시 노원구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("도봉구")) {
						reqStart = "서울시 도봉구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("동대문구")) {
						reqStart = "서울시 동대문구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("동작구")) {
						reqStart = "서울시 동작구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("마포구")) {
						reqStart = "서울시 마포구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("서대문구")) {
						reqStart = "서울시 서대문구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("서초구")) {
						reqStart = "서울시 서초구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("성동구")) {
						reqStart = "서울시 성동구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("성북구")) {
						reqStart = "서울시 성북구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("송파구")) {
						reqStart = "서울시 송파구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("강동구")) {
						reqStart = "서울시 강동구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("양천구")) {
						reqStart = "서울시 양천구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("영등포구")) {
						reqStart = "서울시 영등포구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("용산구")) {
						reqStart = "서울시 용산구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("은평구")) {
						reqStart = "서울시 은평구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("종로구")) {
						reqStart = "서울시 종로구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("중구")) {
						reqStart = "서울시 중구";
						hmap.put("reqStart", reqStart);
					}else if(rset.getString("START_POINT").contains("중랑구")) {
						reqStart = "서울시 중랑구";
						hmap.put("reqStart", reqStart);
					}
					
					if(rset.getString("ARRIVE_POINT").contains("강남구")) {
						reqArrive = "서울시 강남구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("강동구")) {
						reqArrive = "서울시 강동구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("강북구")) {
						reqArrive = "서울시 강북구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("강서구")) {
						reqArrive = "서울시 강서구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("관악구")) {
						reqArrive = "서울시 관악구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("광진구")) {
						reqArrive = "서울시 광진구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("구로구")) {
						reqArrive = "서울시 구로구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("금천구")) {
						reqArrive = "서울시 금천구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("노원구")) {
						reqArrive = "서울시 노원구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("도봉구")) {
						reqArrive = "서울시 도봉구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("동대문구")) {
						reqArrive = "서울시 동대문구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("동작구")) {
						reqArrive = "서울시 동작구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("마포구")) {
						reqArrive = "서울시 마포구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("서대문구")) {
						reqArrive = "서울시 서대문구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("서초구")) {
						reqArrive = "서울시 서초구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("성동구")) {
						reqArrive = "서울시 성동구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("성북구")) {
						reqArrive = "서울시 성북구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("송파구")) {
						reqArrive = "서울시 송파구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("강동구")) {
						reqArrive = "서울시 강동구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("양천구")) {
						reqArrive = "서울시 양천구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("영등포구")) {
						reqArrive = "서울시 영등포구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("용산구")) {
						reqArrive = "서울시 용산구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("은평구")) {
						reqArrive = "서울시 은평구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("종로구")) {
						reqArrive = "서울시 종로구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("중구")) {
						reqArrive = "서울시 중구";
						hmap.put("reqArrive", reqArrive);
					}else if(rset.getString("ARRIVE_POINT").contains("중랑구")) {
						reqArrive = "서울시 중랑구";
						hmap.put("reqArrive", reqArrive);
					}	
					
					hmap.put("reqCount", rset.getString("COUNT"));
					
					reqList.add(hmap);						
				}				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

		}
		return reqList;					
	}



	public ShowRP selectRequestInfo3(Connection con, String reqNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ShowRP requestInfo = null;

		String query = prop.getProperty("requestInfo");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, reqNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				requestInfo = new ShowRP();

				requestInfo.setReqNo(rset.getString("REQ_NO"));
				requestInfo.setReservDate(rset.getString("RESERVATION_DATE"));
				requestInfo.setStartPoint(rset.getString("START_POINT"));
				requestInfo.setArrivePoint(rset.getString("ARRIVE_POINT"));
				requestInfo.setReqStart(rset.getDate("REQ_START"));
				requestInfo.setReqFinish(rset.getDate("REQ_FINISH"));
				requestInfo.setMemo(rset.getString("MEMO"));			
				
				System.out.println("dao requestInfo :: " + requestInfo.getStartPoint());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return requestInfo;
	}



	public ArrayList<HashMap<String, Object>> selectRequestImg3(Connection con, String reqNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> requestImg = null;
		HashMap<String, Object> hmap = null;

		String query = prop.getProperty("selectRequestImg");

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, reqNo);

			rset = pstmt.executeQuery();

			requestImg = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {

				hmap = new HashMap<String, Object>();

				hmap.put("reqNo", rset.getString("REQ_NO"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("changeName", rset.getString("CHANGE_NAME"));

				requestImg.add(hmap);

				System.out.println("requestImg :::" + requestImg);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return requestImg;
	}



	public ArrayList<HashMap<String, Object>> selectProductInFo3(Connection con, String reqNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> ProductInfo = null;
		HashMap<String, Object> hmap = null;

		String query = prop.getProperty("selectProductInfo");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, reqNo);

			rset = pstmt.executeQuery();

			ProductInfo = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String, Object>();

				hmap.put("proKind", rset.getString("PRODUCT_KIND"));
				hmap.put("proName", rset.getString("PRODUCT_NAME"));				

				System.out.println("hmap.get(proName) ::: " + hmap.get("proName"));

				if(rset.getString("PRODUCT_NAME").equals("냉장고")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("세탁기")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("TV/모니터")) {

					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("에어컨")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proUni", rset.getString("UNIQUNESS"));
				}else if(rset.getString("PRODUCT_NAME").equals("정수기")){

					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
					hmap.put("proUni", rset.getString("UNIQUNESS"));
				}else if(rset.getString("PRODUCT_NAME").equals("PC/노트북")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
				}else if(rset.getString("PRODUCT_NAME").equals("전자레인지")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
				}else if(rset.getString("PRODUCT_NAME").equals("침대")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
				}else if(rset.getString("PRODUCT_NAME").equals("의자")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));

				}else if(rset.getString("PRODUCT_NAME").equals("책상/테이블")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));
					hmap.put("proMat", rset.getString("MATERIAL"));
					hmap.put("proWidth", rset.getString("WIDTH"));

				}else if(rset.getString("PRODUCT_NAME").equals("책장")) {

					hmap.put("proWidth", rset.getString("WIDTH"));
					hmap.put("proHeight", rset.getString("HEIGHT"));

				}else if(rset.getString("PRODUCT_NAME").equals("옷장")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proUni", rset.getString("UNIQUNESS"));
					hmap.put("proWidth", rset.getString("WIDTH"));

				}else if(rset.getString("PRODUCT_NAME").equals("진열장")) {

					hmap.put("proWidth", rset.getString("WIDTH"));
					hmap.put("proHeight", rset.getString("HEIGHT"));
					hmap.put("proGck", rset.getString("GLASS_CHECK"));

				}else if(rset.getString("PRODUCT_NAME").equals("쇼파")) {

					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));

				}else if(rset.getString("PRODUCT_NAME").equals("행거")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proWidth", rset.getString("WIDTH"));

				}else if(rset.getString("PRODUCT_NAME").equals("거울")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proSize", rset.getString("PRODUCT_SIZE"));

				}else if(rset.getString("PRODUCT_NAME").equals("화장대")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));
					hmap.put("proMat", rset.getString("MATERIAL"));

				}else if(rset.getString("PRODUCT_NAME").equals("피아노")) {

					hmap.put("proType", rset.getString("PRODUCT_TYPE"));

				}

				ProductInfo.add(hmap);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return ProductInfo;
	}



	public ArrayList<HashMap<String, Object>> selectDriverReqList(Connection con, String driver) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> reqInfoList = null;
		HashMap<String, Object> hmap = null;

		String query = prop.getProperty("selectreqInfoList");

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,driver);

			rset = pstmt.executeQuery();

			reqInfoList = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				System.out.println(rset.getString("REQ_NO"));

				hmap.put("reqNo", rset.getString("REQ_NO"));

				reqInfoList.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return reqInfoList;
		
		
		
		
	}


	public ArrayList<Request> selectList(Connection con, String logUserNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Request> list = null;
		
		String query = prop.getProperty("selectList2");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, logUserNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Request>();
			
			while(rset.next()) {
				Request r = new Request();
				
				r.setReqNo(rset.getString("REQ_NO"));
				r.setReservationDate(rset.getString("RESERVATION_DATE"));
				r.setReqStart(rset.getDate("REQ_START"));
				r.setReqFinish(rset.getDate("REQ_FINISH"));
				r.setConditionReq(rset.getString("CONDITION_REQ"));
				
				list.add(r);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	
	


	

	



	


	

	





}	