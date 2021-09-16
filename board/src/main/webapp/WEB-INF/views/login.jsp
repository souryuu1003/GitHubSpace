<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/standard/header.jsp"/>
<jsp:include page="/WEB-INF/views/standard/aside.jsp"/>
<body>
<div id="Frame_Set">
login
<form id="Login_Join_Form" action="/board/login" method="post">
	<table style="margin: auto; width: 80%;">
		<tr>
			<td colspan="4">ログイン</td>
		</tr>
		<tr>
			<td>メールアドレス</td>
			<td colspan="3"><input></td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td colspan="3"><input></td>
		</tr>
		<tr>
			<td colspan="4"><button type="submit">ログイン</button></td>
		</tr>
	</table>
</form>
</div>
</body>
<jsp:include page="/WEB-INF/views/standard/footer.jsp"/>