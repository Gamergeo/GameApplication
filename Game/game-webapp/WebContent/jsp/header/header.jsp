<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

<html>

<head>
	<title>${action.getText(param.title)}</title>
</head>

<body>

<table>
	<tr>
		<td>Date : <s:property value="localDate" /></td>
		<td>Time : <s:property value="localTime" /></td>
	</tr>	
	<tr>
		<td>USA Date : <s:property value="USADate" /></td>
		<td>Time : <s:property value="USATime" /></td>
	</tr>
</table>
<br />