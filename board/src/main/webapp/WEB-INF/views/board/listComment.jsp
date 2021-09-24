<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<table border="1">
	<c:forEach var="list" items="${commentList}" varStatus="content">
		<c:if test="${(paging.pageNo-1)*paging.pageSize <= content.index and content.index < paging.pageNo*paging.pageSize}">
			<tr>
				<td>${list.commentWriter}</td><td style="width: 100%;">${list.commentContent}</td>
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
</html>