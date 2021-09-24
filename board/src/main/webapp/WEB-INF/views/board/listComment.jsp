<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<input name="commentWriter" value="${loginUser.userId}" hidden="hidden">
<table border="1">
	<tr>
		<td style="width: 60%;">
			<input name="commentContent" placeholder="ここにコメントが入力できます。" onkeyup="limiteCommentContent(this)"></td>
		<td><button type="submit" onclick="moveComment()">コメント</button></td>
	</tr>
	<c:forEach var="list" items="${commentList}" varStatus="content">
		<c:if test="${(paging.pageNo-1)*paging.pageSize <= content.index and content.index < paging.pageNo*paging.pageSize}">
			<tr>
				<td id="Comment_Writer">${list.commentWriter}</td>
				<td>${list.commentContent}
					<c:if test="${list.commentWriter == loginUser.userId}">
						<a onclick="deleteComment(${list.commentNo})" style="padding-right: 12px; float: right; color: red;">X</a>
					</c:if>
				</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	<jsp:include page="/WEB-INF/views/standard/paging.jsp" flush="true">
	    <jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
	    <jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
	    <jsp:param name="startPageNo" value="${paging.startPageNo}" />
	    <jsp:param name="pageNo" value="${paging.pageNo}" />
	    <jsp:param name="endPageNo" value="${paging.endPageNo}" />
	    <jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
	    <jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
	</jsp:include>
<script type="text/javascript">
	function moveComment(){
		document.getElementById('Create_Read_Update_Form').action = '/board/createComment';
		document.getElementById('Create_Read_Update_Form').method = 'post';
	}
	function deleteComment(n){
		location.href = '/board/deleteComment' 
						+ '?boardNo=' + document.getElementsByName('boardNo')[0].value
						+ '&commentNo=' + n
						+ '&commentWriter=' + document.getElementById('Comment_Writer').textContent;
	}
</script>
</html>