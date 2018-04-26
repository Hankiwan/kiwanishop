<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<c:forEach var="menuList" items="${ajaxSelectMenu }" varStatus="j">
	<c:choose>
		<c:when test="${fn:length(ajaxSelectMenu) eq j.count}">
			<c:out value="${menuList.menuCode}" />
		</c:when>
		<c:otherwise>
			<c:out value="${menuList.menuCode}" />,
		</c:otherwise>
	</c:choose>
</c:forEach>

