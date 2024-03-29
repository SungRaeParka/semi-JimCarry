<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.jimcarry.member.model.vo.*"%>
<%
	Member loginDriver = (Member) session.getAttribute("loginDriver");
	ArrayList<DriverList> list = (ArrayList<DriverList>) session.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="https://fonts.googleapis.com/css?family=Cute+Font&display=swap&subset=korean" rel="stylesheet">
<title>Insert title here</title>
<style>
	html, body{
		height:100%;
		margin: 0;
		padding: 0;
	}
	.checkPwd, .updateMemberInfo {
		margin-left:90px;
	}
		
	#main {
		min-height: 100%;
		text-align: center;
	}	
	
	table {
 	 	border-collapse: separate;
 		border-spacing: 0 20px;
 		text-align:center;
	}
	#updateMemberbtn, #checkPwdbtn, #updatebtn, #deletebtn {
		height:30px;
		width:220px;
		border:3px solid #5e5e5e;
		border-radius:10px;
		margin-top:5px;
		margin-left:110px;
		font-size:15px;
		background:#5e5e5e; 
		color:#ffffff;
	}
	#checkPwdbtn {
		margin-left: 80px;
	}
	#btn {
		margin-left:-130px;
		border:3px solid #5e5e5e;
		border-radius:10px;
		text-align:center;
		font-size:15px;
		background:#5e5e5e;
		color:#ffffff;
	}
	input[type=file]{
		height:35px;
		width:300px; 
		border:1px solid white;
		margin-top:5px;
		margin-left:90px;
		font-size:15px;
		background:white;
		color:black;
	}
	#tel1 {
		height:30px;
		width:210px;
	}
	#tel {
		height:30px;
		width:57px;
	}
	#ca {
		height:30px;
		width:100px;
	}
	#main {
		margin-top: 10%;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/driver_TopBar.jsp" %>
	<div id="main">
		<div style="display: inline-block; padding-top: 7%;">
			<b style="font-size: 50px; font-family:Sunflower, sans-serif;">마이 페이지</b>
		</div>
    	<form action="<%=request.getContextPath()%>/driverList.me" method="post">
		<hr>
		<div class="container" style="display: inline-block">
  			<ul class="nav nav-tabs">
    			<li class="active"><a href="#home">회원정보</a></li>
    			<li><a onclick="driverList();">이용내역</a></li>
  			</ul>
  			<div class="tab-content">
    			<div id="home" class="tab-pane fade in active" style="border: 1px solid black">
    				<table align="center">
    					<tr class="showMemberInfo">
    						<td><label>아이디 : </label></td>
    						<td><input type="text" name="userId" value="<%=loginDriver.getUserId() %>" readonly></td>
    						<td><input type="hidden" name="hid" value="<%=loginDriver.getSeqNo() %>"></td>
    					</tr>    					
    					<tr class="showMemberInfo">
    						<td><label>이름 : </label></td>
    						<td><input type="text" name="userName" value="<%=loginDriver.getUserName() %>" readonly></td>
    					</tr>
    					<tr class="showMemberInfo">
							<td><label>휴대폰 번호 :</label>&nbsp;&nbsp;</td>
							<td>
							<input type="text" maxlength="3" name="tel1" id="tel" value="<%=loginDriver.getPhone().substring(0, 3) %>" readonly> -
							<input type="text" maxlength="4" name="tel2" id="tel" value="<%=loginDriver.getPhone().substring(4, 8) %>" readonly> -
							<input type="text" maxlength="4" name="tel3" id="tel" value="<%=loginDriver.getPhone().substring(9, 13) %>" readonly>
							</td>
						</tr>
						<tr class="showMemberInfo">
							<td><label>대표자</label>
							<td><input type="text" name="agent" id="box" readonly value="<%=loginDriver.getAgent() %>"></td>	
						</tr>
						<tr class="showMemberInfo">
							<td><label>사업자등록번호 :</label>
							<td><input type="text" name="businessNumber" id="box" readonly value="<%=loginDriver.getBusinessNo() %>"></td> 
						<tr class="showMemberInfo">
							<td><label>우편 번호</label></td>
							<td><input type="text" id="sample6_postcode" name = "address1" placeholder="우편번호" value="<%=loginDriver.getBusinessAddress() %>" readonly></td>
       				  	</tr>
						<tr class="showMemberInfo">
							<td><label>차총 :</label>
							<td><input type="text" name="carType" id="box" readonly value="<%=loginDriver.getCarType() %>"></td>
						</tr>
						<tr class="showMemberInfo">
							<td><label>차량번호 :</label>
							<td>
							<input type="text" name="carNumber" id="ca1" readonly value="<%=loginDriver.getCarNo() %>">
							</td>
						</tr>
						<tr class="showMemberInfo">
    						<td><label>블랙리스트 유무 :</label></td>
    						<td><input type="text" name="BlacklistCheck" readonly value="<%=loginDriver.getBlacklistCheck() %>"></td>
    					</tr>
    					<tr class="showMemberInfo">
    						<td colspan="2"><input type="button" value="회원정보 변경" id="updatebtn"></td>    						
    					</tr>
    					<tr class="showMemberInfo">
    						<td colspan="2"><input type="button" value="회원 탈퇴" id="deletebtn"></td>
    					</tr>
    				</table>			
    			</div>
    			<div id="menu1" class="tab-pane fade">
    				<div class="container">
    				</div>
    			</div>    	
  			</div>
		</div>
    	</form>
	</div>

	<script>
	function sample6_execDaumPostcode(){
	       new daum.Postcode({
	             oncomplete: function(data) {
	                 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                 // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                 // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                 var addr = ''; // 주소 변수
	                 var extraAddr = ''; // 참고항목 변수

	                 //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                 if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                     addr = data.roadAddress;
	                 } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                     addr = data.jibunAddress;
	                 }

	                 // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                 if(data.userSelectedType === 'R'){
	                     // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                     // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                     if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                         extraAddr += data.bname;
	                     }
	                     // 건물명이 있고, 공동주택일 경우 추가한다.
	                     if(data.buildingName !== '' && data.apartment === 'Y'){
	                         extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                     }
	                     // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                     if(extraAddr !== ''){
	                         extraAddr = ' (' + extraAddr + ')';
	                     }
	                     // 조합된 참고항목을 해당 필드에 넣는다.
	                     document.getElementById("sample6_detailAddress").value = extraAddr;
	                 
	                 } else {
	                     document.getElementById("sample6_detailAddress").value = '';
	                 }

	                 // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                 document.getElementById('sample6_postcode').value = data.zonecode;
	                 document.getElementById("sample6_address").value = addr;
	                 // 커서를 상세주소 필드로 이동한다.
	                 document.getElementById("sample6_detailAddress").focus();
	             }
	         }).open();
	    }
		$(function() {
			$("#updatebtn").click(function(){
				location.href = "DriverCrystal.jsp";
			});
			$("#deletebtn").click(function(){
				window.confirm("회원을 탈퇴하시겠습니까?");
				location.href = "DriverDelete.jsp";
			});
		});
		function driverList(){
			$("form").submit();
		}
	</script>

</body>
</html>