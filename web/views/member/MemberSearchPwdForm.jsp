<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	div {
		margin-top:50px;
	}
	#box {
		height:40px;
		width:200px;
	}
	#tel {
		height:40px;
		width:52px;
	}
	#join{
		height:50px;
		width:200px;
		border:3px solid #5e5e5e;
		border-radius:10px;
		margin-top:20px;
		font-size:15px;
		background:#5e5e5e;
		color:#ffffff;
	}
	#btn{
		height:40px;
		width:80px;
		border:3px solid #5e5e5e;
		border-radius:10px;
		margin-top:5px;
		font-size:15px;
		background:#5e5e5e;
		color:#ffffff;
	}
</style>
</head>
<body>
		<br><br>
		<h1 align="center">비밀번호 찾기</h1>
		<div align="center">
		<table>
			<tr>
				<td><label>이름</label></td>
				<td><input type="text" name="userName" id="box"></td>
			</tr>
			<tr>
				<td><label>아이디</label>
				<td><input type="text" name="userId" id="box"></td>
				<td><button id="btn" onclick="check();">중복확인</button></td>
			</tr>
			<tr>
				<td><label>휴대폰 번호</label></td>
				<td>
					<input type="text" maxlength="3" name="tel1" value="010" id="tel"> -
					<input type="text" maxlength="4" name="tel2" value="0000" id="tel"> -
					<input type="text" maxlength="4" name="tel3" value="0000" id="tel">
				</td>
					<td><button id="btn" onclick="Confirm();">인증</button></td>	
			</tr>
			<tr>
				<td></td>
				<td><a href="/semi/views/member/popup/MemberPwdView.jsp"><button id="join" onclick="ok();">비밀번호 재설정</button></a></td>
			</tr>
		</table>
		</div>
		<script>
			function check(){
				window.alert("중복확인!");
			}
			function Confirm(){
				window.alert("인증완료!");
			}
			function ok(){
				window.alert("비밀번호 재설정화면으로 이동!");
			}
		</script>
	
</body>
</html>



