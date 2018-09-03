<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<jsp:include page="header/header.jsp">
	<jsp:param value="jsp.addGame.title" name="title"/>
</jsp:include>

<script>
	function setMethod(method) {
		document.forms['saveGame'].elements['method'].value = method;
		return true;
	}
</script>

<s:form action="saveGame" method="post">
	<s:textfield key="jsp.gameAdd.form.gameName" name="game.name"/>
	<s:textfield key="jsp.gameAdd.form.devName" name="game.developper.name"/>
	<s:textfield key="jsp.gameAdd.form.countryName" name="game.developper.country.name"/>
	<s:hidden name="game.id" />
	<s:hidden name="method" />
	<s:submit action="saveGame" value="Save" onclick="return setMethod('save');"/>
	<s:submit action="saveGame" value="Save and Add"  onclick="return setMethod('saveAndAdd');"/>
</s:form>
	
<jsp:include page="header/footer.jsp" />