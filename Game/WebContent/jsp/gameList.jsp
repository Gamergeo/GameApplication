<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<jsp:include page="header/header.jsp" />

	<head>
		<title><s:text name="jsp.gameList.title"/></title>
	</head>
	<body>
		<jsp:include page="gameList/gameListTable.jsp">
			<jsp:param value="listGame" name="listGameName"/>	
		</jsp:include>
		
		<br />
		<br />		
		
		<s:if test="listGameTest != null && !listGameTest.isEmpty()">
			<jsp:include page="gameList_test.jsp" />
		</s:if>
	</body>
	
</html>