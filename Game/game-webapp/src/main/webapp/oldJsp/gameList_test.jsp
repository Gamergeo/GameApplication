<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<jsp:include page="gameList/gameListTable.jsp">
	<jsp:param value="listGameTest" name="listGameName"/>	
</jsp:include>

<br />
<br />

<s:a action="displayGameSave"><s:text name="jsp.gameList.add"/></s:a>