<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title><s:text name="jsp.addGame.title"/></title>
	</head>
	
	<body>
		<s:form action="saveGame" method="post">
			 <s:textfield key="jsp.gameAdd.form.gameName" name="gameName"/><br />
			 <s:textfield key="jsp.gameAdd.form.devName" name="devName"/><br />
			 <s:textfield key="jsp.gameAdd.form.countryName" name="countryName"/><br />
			 
      		<s:submit action="saveGame" value="Save"/>
		</s:form>
	</body>
</html>