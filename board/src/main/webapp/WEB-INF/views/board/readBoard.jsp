<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/standard/header.jsp"/>
<jsp:include page="/WEB-INF/views/standard/aside.jsp"/>
<body>
<div id="Frame_Set">
readForm
<form id="Create_Read_Update_Form" action="/board/updateBoard" method="get">
	<table border="1">
		<thead>
			<tr>
				<th>NO</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>CONTENT</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input name="boardNo" hidden="hidden" value="${readBoard.boardNo}"> ${readBoard.boardNo}</td>
				<td>${readBoard.boardTitle}</td>
				<td><input id="BOARD_WRITER" hidden="hidden" value="${readBoard.boardWriter}"> ${readBoard.boardWriter}</td>
				<td>${readBoard.boardContent}</td>
			</tr>
		</tbody>
		<thead>
			<tr>
				<th>NO</th>
				<th>CONTENT</th>
				<th>WRITER</th>
				<th>BNO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cl" items="${commentList}">
				<tr>
					<td>${cl.commentNo}</td>
					<td>${cl.commentContent}</td>
					<td>${cl.commentWriter}</td>
					<td>${cl.fkBoardNo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button id="Update_Board_Button" type="submit">修正</button>
</form>
<form id="Delete_Board_Form" action="deleteBoard" method="post">
	<input name="boardNo" hidden="hidden" value="${readBoard.boardNo}">
	<button id="Delete_Board_Button" type="submit" onclick="return deleteCheck()">削除</button>
</form>
</div>
</body>
<script type="text/javascript">
loginUser = document.getElementById('Login_User').value;
let boardWriter = document.getElementById('BOARD_WRITER').value;

if(loginUser == '' 
	|| !(loginUser.split(',')[1].split('=')[1] == boardWriter)){
	document.getElementById('Update_Board_Button').style.display = 'none';
	document.getElementById('Delete_Board_Button').style.display = 'none';
}
</script>
<jsp:include page="/WEB-INF/views/standard/footer.jsp"/>