<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/standard/header.jsp"/>
<jsp:include page="/WEB-INF/views/standard/aside.jsp"/>
<body>
<div id="Frame_Set">
	boardList

	<table border="1">
	<thead>
	<tr>
		<th>NO</th>
		<th>TITLE</th>
		<th>WRITER</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${boardList}">
		<tr id="Board_List">
			<td>${list.boardNo}</td>
			<td>
				<form action="/board/readBoard" method="get">
					<input name="boardNo" hidden="hidden" value="${list.boardNo}">
					<button id="Read_Button" type="submit" onclick="rollCheck('${loginUser.userId})'">${list.boardTitle}</button>
				</form>
			</td>
			<td>${list.boardWriter}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<button id="Create_Board_Button" onclick="location.href='/board/createBoard'">登録</button>
</div>
</body>
<script type="text/javascript">
if(document.getElementById('Login_User').value == ''){
	document.getElementById('Create_Board_Button').style.display = 'none';
}
</script>
<jsp:include page="/WEB-INF/views/standard/footer.jsp"/>