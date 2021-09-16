<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/standard/header.jsp"/>
<jsp:include page="/WEB-INF/views/standard/aside.jsp"/>
<body>
<div id="Frame_Set">
createForm
<form id="Create_Read_Update_Form" action="createBoard" method="post">
	<table>
		<tr>
			<td colspan="1">Title</td>
			<td colspan="4"><input onkeyup="limiteBoardTitle(this)"></td>
		</tr>
		<tr>
			<td colspan="3"></td>
			<td colspan="1">Writer</td>
			<td colspan="1"><input readonly="readonly"></td>
		</tr>
		<tr>
			<td colspan="1">Content</td>
			<td colspan="4"><textarea cols="30" rows="20" onkeyup="limiteBoardContent(this)"></textarea></td>
		</tr>
		<tr>
			<td colspan="5"><button type="submit">登録</button></td>
		</tr>
	</table>
</form>
</div>
</body>
<jsp:include page="/WEB-INF/views/standard/footer.jsp"/>