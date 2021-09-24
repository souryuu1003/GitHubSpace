<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/standard/header.jsp"/>
<jsp:include page="/WEB-INF/views/standard/aside.jsp"/>
<body>
<div id="Frame_Set">
<form id="Login_Join_Form" action="#" method="post">
	<table>
		<tr>
			<td colspan="4">会員登録</td>
		</tr>
		<tr>
			<td>メールアドレス</td>
			<td colspan="3"><input name="userId" onkeyup="lengthCheck(this, 1)" placeholder="例）example@gmail.com"></td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td colspan="3"><input name="userPw" type="password" onkeyup="lengthCheck(this, 2)" placeholder="例）英語と特殊文字を含めて作成してください。"></td>
		</tr>
		<tr>
			<td colspan="4"><button type="submit" onclick="joinCheck()">登録</button></td>
		</tr>
	</table>
</form>
</div>
</body>
<jsp:include page="/WEB-INF/views/standard/footer.jsp"/>