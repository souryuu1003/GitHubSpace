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
		<th>CONTENT</th>
		<th>WRITER</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${boardList}">
		<tr>
			<td>${list.boardNo}</td>
			<td>${list.boardTitle}</td>
			<td>${list.boardContent}</td>
			<td>${list.boardWriter}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
</body>
<jsp:include page="/WEB-INF/views/standard/footer.jsp"/>