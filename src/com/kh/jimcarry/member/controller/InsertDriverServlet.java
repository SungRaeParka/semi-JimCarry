package com.kh.jimcarry.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.jimcarry.common.MyFileRenamePolicy;
import com.kh.jimcarry.member.model.service.MemberService;
import com.kh.jimcarry.member.model.vo.AttachmentMember;
import com.kh.jimcarry.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertDriverServlet
 */
@WebServlet("/insertDriver.me")
public class InsertDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			//전송 파일 용량 제한 : 10Mbyte로 제한
			int maxSize = 1024 * 1024 * 10;
			
			//웹서버 컨테이너 경로 추출
			String root = request.getSession().getServletContext().getRealPath("/");
			
			System.out.println(root);
			//파일 저장 경로(web/thumbnail_uploadFiles)
			String savePath = root + "thumbnail_uploadFiles/";
			
			//사용자가 올린 파일의 이름을 그대로 저장하지 않는 것이 일반적이다.
			//1. 같은 파일명이 있는 경우 이전 파일을 덮어쓸 수 있다.
			//2. 한글로된 파일명, 특수기호나 띄어쓰기 등은 서버에 따라 문제가 생길 수 도 있다.
			//DefaultFileRenamePolicy는 cos.jar안에 존재하는 클래스로
			//같은 파일명이 존재하는지를 검사하고, 있을 경우에 파일 뒤에 숫자를 붙인다.
			//ex : aaa.zip, aaa1.zip, aaa2.zip
			
			//DefaultFileRenamePolicy 사용
			//MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			//다중파일을 묶어서 업로드를 하기 위해 컬렉션 이용
			//저장한 파일(변경된 파일의) 이름을 저장할 ArrayList 객체 생성
			ArrayList<String> saveFiles = new ArrayList<String>();
			//원본 파일의 이름을 저장할 ArrayList 생성
			ArrayList<String> originFiles = new ArrayList<String>();
			
			//파일이 전송된 이름을 반환한다
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				//System.out.println("name : " + name);
				
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
				
				//넘어온 파일은 역순으로 꺼내옴
				System.out.println("fileSystem name : " + multiRequest.getFilesystemName(name));
				System.out.println("originFile name : " + multiRequest.getOriginalFileName(name));
				
				
			}
			//MultipartRequest 객체를 이용하여 파일 외의 값들도 꺼낼 수 있다.
			String multiuserId = multiRequest.getParameter("userId");
			String multiuserName = multiRequest.getParameter("userName");
			String multiuserPwd = multiRequest.getParameter("password");
			String multitel1 = multiRequest.getParameter("tel1");
			String multitel2 = multiRequest.getParameter("tel2");
			String multitel3 = multiRequest.getParameter("tel3");
			String multiPhone = multitel1 + "-" + multitel2 + "-" + multitel3;
			String multiAgent = multiRequest.getParameter("agent");
			String multiBusinessNo = multiRequest.getParameter("businessNumber");
			String multiCarType = multiRequest.getParameter("carType");
			String multiCarNo = multiRequest.getParameter("carNo");
			String multiBankName = multiRequest.getParameter("bankName");
			String multiAccountNo = multiRequest.getParameter("accountNo");
			
			/*System.out.println(multiTitle);
			System.out.println(multiContent);*/
			
			//Member객체 생성
			Member m = new Member();
			m.setUserId(multiuserId);
			m.setUserName(multiuserName);
			m.setUserPwd(multiuserPwd);
			m.setPhone(multiPhone);
			m.setAgent(multiAgent);
			m.setBusinessNo(multiBusinessNo);
			m.setCarType(multiCarType);
			m.setCarNo(multiCarNo);
			m.setBankName(multiBankName);
			m.setAccountNo(multiAccountNo);
			
			
			
			//Attachment 객체 생성하여 ArrayList객체에 저장
			ArrayList<AttachmentMember> fileList = new ArrayList<AttachmentMember>();
			//전송순서 역순으로 저장되기 때문에 반복문을 역으로 돌려 list에 저장
			for(int i = originFiles.size() -1; i >= 0; i--) {
				AttachmentMember at = new AttachmentMember();
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				
				fileList.add(at);
			}
			
			System.out.println("controller Member : " + m);
			System.out.println("controller attachment list : " + fileList);
			
			/*int result = new MemberService().insertDriver(m, fileList);	*/		
			/*if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/selectList.tn");
			}else {
				//실패시 저장된 사진 삭제
				for(int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(savePath + saveFiles.get(i));
					failedFile.delete();
				}
				request.setAttribute("msg", "사진게시판 등록 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}*/
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
