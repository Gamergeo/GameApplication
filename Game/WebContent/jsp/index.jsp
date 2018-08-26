<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<html>
	<head>
		<title><bean:message bundle="label" key="jsp.index.title"/></title>
	</head>
	<body>
		euh
		<bean:message bundle="label" key="jsp.index.libelle"/><br />
		<bean:message bundle="form" key="jsp.index.form"/><br />
		<a href="/game/displayGameList.do">Clique ici fdp</a>
	</body>
</html>