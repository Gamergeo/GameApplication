<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<jsp:include page="../header/header.jsp">
	<jsp:param value="jsp.gameList.title" name="title"/>
</jsp:include>

<jsp:include page="gameList/gameListTable.jsp">
	<jsp:param value="listGame" name="listGameName"/>	
</jsp:include>

<br />
<br />