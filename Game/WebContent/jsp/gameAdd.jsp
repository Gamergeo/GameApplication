<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<html:html>
	<head>
		<title><bean:message key="jsp.addGame.title" bundle="label"/></title>
	</head>
	
	<body>
		<b><i><html:errors/></i></b><br/>
		<html:form action="/saveGame.do">
  			<bean:message key="jsp.gameAdd.form.gameName" bundle="form"/>
			<nested:text property="gameName"/><br>
			
  			<bean:message key="jsp.gameAdd.form.devName" bundle="form"/>
			<nested:text property="devName"/><br>
		  			
		  	<bean:message key="jsp.gameAdd.form.countryName" bundle="form"/>
			<nested:text property="countryName"/><br>
			
			<html:submit/>
		</html:form>
	</body>
</html:html>