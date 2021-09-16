<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/standard/header.jsp"/>
<jsp:include page="/WEB-INF/views/standard/aside.jsp"/>
<body>
<div id="Frame_Set">
join
<form id="Login_Join_Form" action="/board/join" method="post">
	<table>
		<tr>
			<td colspan="4">会員登録</td>
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
			<td colspan="4"><button type="submit">登録</button></td>
		</tr>
	</table>
</form>
</div>
</body>
<jsp:include page="/WEB-INF/views/standard/footer.jsp"/>