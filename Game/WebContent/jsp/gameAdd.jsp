<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<jsp:include page="header/header.jsp">
	<jsp:param value="jsp.addGame.title" name="title"/>
</jsp:include>

<s:form action="saveGame" method="post">
	<s:textfield key="jsp.gameAdd.form.gameName" name="gameForm.gameName"/>
	<s:textfield key="jsp.gameAdd.form.devName" name="gameForm.devName"/>
	<s:textfield key="jsp.gameAdd.form.countryName" name="gameForm.countryName"/>
	<s:hidden name="gameForm.gameId" />
	<s:submit action="saveGame" value="Save"/>
</s:form>
	
<jsp:include page="header/footer.jsp" />