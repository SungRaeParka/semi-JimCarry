
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.jimcarry.board.model.vo.*"
	import="java.util.Date" import="java.text.SimpleDateFormat"
	import="java.util.ArrayList"%>



<%
		Board b = (Board) request.getAttribute("b");
		ArrayList<Attachment> fileList = (ArrayList<Attachment>) request.getAttribute("fileList");

		Attachment photo1 = fileList.get(0);
		Attachment photo2 = fileList.get(1);


		System.out.println("포토 1 : " + photo1);
		System.out.println("포토 2 : " + photo2);

		Date now = new Date();
		String date1 = String.format("%tF",now);

/*
		SimpleDateFormat postDate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = postDate.parse(date1);
 */

	%>

<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
.outer {
	width: 800px;
	height: 650px;

	color: black;
	margin-left: auto;
	margin-right: auto;
	margin-top: auto;
}

table {
	border: 5px solid #eeeeee;
	/* width: 100%; */
}

.insertform {
	width: 500px;
	height: 450px;
	margin: 0 auto;
}

.btnArea {
	color: white;
	margin: 0 auto;
	width: 200px;
}
button {
	-moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
	-webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
	box-shadow:inset 0px 1px 0px 0px #ffffff;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffffff), color-stop(1, #f6f6f6));
	background:-moz-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
	background:-webkit-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
	background:-o-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
	background:-ms-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
	background:linear-gradient(to bottom, #ffffff 5%, #f6f6f6 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#f6f6f6',GradientType=0);
	background-color:#ffffff;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #dcdcdc;
	display:inline-block;
	cursor:pointer;
	color:#666666;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:1px 8px;
	text-decoration:none;
	text-shadow:0px 1px 0px #ffffff;
}
button:hover {
background:linear-gradient(to bottom, #f6f6f6 5%, #ffffff 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f6f6f6', endColorstr='#ffffff',GradientType=0);
	background-color:#f6f6f6;
}
.imgrog{
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	width:85px;
	margin-left: 100px;




}
</style>
<%-- <script type="text/javascript">
	$(document).ready(function(){
		$('#contentImg1').src(<%=photo1.getOriginName()%>)
	});


</script> --%>


<!-- <style>
#div1 {
	margin: 0 auto;
	height: 700px;
	width: 50%;
}

table {
	margin: 0 auto;
	width: 60%;
}

h2 {
	text-align: center;
}

td {
	border: 4px solid #eeeeee;
	background-color: #dddddd;
}

.wo {
	border: 1px solid skyblue;
	background-color: rgba(0, 0, 0, 0);
	color: skyblue;
	padding: 5px;
}

.wo:hover {
	color: white;
	background-color: skyblue;
}
</style> -->
<style>
/* label{
	display: inline-block;
	padding: .5em, .75em;
	color: #fff;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #5cb85c;
	cursor: pointer;
	border: 1px solid #4ace4c;
	border-radius: .25em;
	-webkit-transition: background-color 0.2s;
	-moz-transition: background-color 0.2s;
	-ms-transition: background-color 0.2s;
	-o-transition: background-color 0.2s;
	transition: background-color 0.2s;
} */
/* input[type="file"]{
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
	}  */
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/views/common/user_TopBar.jsp"%>
		<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br><br><br><br><br><br><br><br><br><br>


		<div
			style="margin: 0 auto; width: 300px; height: 100px;">
			<img src="/semi/images/main_logo.png" class="imgrog"><h2 style="text-align: center;">짐캐리 사용후기  수정</h2>
		</div>

	<br>
	<br>


	<div class="outer">
		<form action="<%=request.getContextPath()%>/update.bo" method="post" enctype="multipart/form-data">
			<div class="insertArea">
				<table align="center" border=1>
					<tr>
						<td width="100px" height="50px" align="center" style="background: #abccff;">제목</td>
						<td colspan="4"><input type="text" size=40 name="btitle"
							value="<%=b.getPostTitle()%>"> <input type="hidden"
							name="pagebno" value="<%=b.getPostCode()%>" />
							<input type="hidden" name="attno1" value="<%=fileList.get(0).getAttachNo() %>"  />
							<input type="hidden" name="attno2"value="<%=fileList.get(1).getAttachNo()%>">
							</td>

					</tr>
					<tr align="center">
						<td height="50x" style="background: #abccff;">작성자</td>
						<td style="width: 150px; background: #e3f2fd;"><label for=""><%=loginUser.getUserId() %></label></td>
						<td style="background: #abccff;">작성일자</td>
						<td style="background: #e3f2fd;"><label for=""><%=date1%></label></td>
					</tr>

					<tr>
						<td style="height: 50px; background: #abccff;" align="center" >기존 이미지</td>

						<td colspan="3" style="text-align: center;">

						<img  style="width: 100px; height: 100px;" src="<%=request.getContextPath()%>/images_uploadFiles/<%=photo1.getChangeName()%>">
							<input type="hidden" name="img1" value="<%=photo2.getOriginName() %>">
						<img style="width: 100px; height: 100px;"  src="<%=request.getContextPath()%>/images_uploadFiles/<%=photo2.getChangeName()%>">
							<input type="hidden" name="img2" value="<%=photo1.getOriginName() %>">

						</td>

					</tr>


					<tr>
						<td height="100px" style="height: 50px; background: #abccff;"
							align="center" rowspan="2">이미지</td>


						<td colspan="3"><input type="file" name=photo2 id="contentImgArea1"></td>


					</tr>
						<tr>
						<td colspan="3">
							<input type="file" name=photo1 id="contentImgArea2" />
						</td>

						</tr>




					<tr>
						<th align="center" style="background: #abccff;">내용</th>
						<td colspan="4"><textarea cols="40%" rows="10%"
								maxlength="2048" placeholder="글 내용" name="bcontent"><%=b.getPostContents() %></textarea>

						</td>

					</tr>
				</table>
				<div class="btnArea">
					<button type="reset">취소하기</button>
					&nbsp; &nbsp;
					<button type="submit">수정하기</button>
				</div>

			</div>


		</form>

	</div>

	<script>
	function loadImg(value, num) {
		if(value.files && value.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				switch(num){
					case 1 : $("#contentImgArea1").attr("src", e.target.result); break;
					case 2 : $("#contentImgArea2").attr("src", e.target.result); break;
				}
			}

			reader.readAsDataURL(value.files[0]);
		}
	}
	</script>


</body>
</html>