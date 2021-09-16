<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/standard/header.jsp"/>
<jsp:include page="/WEB-INF/views/standard/aside.jsp"/>
<body>
<div id="Frame_Set">
readForm

	<table border="1">
	<thead>
	<tr>
		<th>NO</th>
		<th>CONTENT</th>
		<th>WRITER</th>
		<th>BNO</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${commentList}">
		<tr>
			<td>${list.commentNo}</td>
			<td>${list.commentContent}</td>
			<td>${list.commentWriter}</td>
			<td>${list.fkBoardNo}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
</body>
<jsp:include page="/WEB-INF/views/standard/footer.jsp"/>