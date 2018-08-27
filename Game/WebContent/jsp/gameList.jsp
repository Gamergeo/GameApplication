<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title><s:text name="jsp.gameList.title"/></title>
	</head>
	<body>
		<table border="1">
			<thead>
				<tr>
					<th><s:text name="jsp.gameList.column.id"/></th>
					<th><s:text name="jsp.gameList.column.gameName"/></th>
					<th><s:text name="jsp.gameList.column.devName"/></th>
					<th><s:text name="jsp.gameList.column.countryName"/></th>
					<th><s:text name="jsp.gameList.column.delete"/></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listGame">
<!-- 					<bean:define id="game" name="gameElement" type="com.tutorial.struts.bean.dto.Game" /> -->
					<tr>
						<td><s:property value="idNumber"/></td>
						<td><s:property value="name"/></td>
						<td><s:property value="developper.name"/></td>
						<td><s:property value="developper.country.name"/></td>
						<td>
							<s:url action="saveGame" method="delete" var="urlDelete">
    							<s:param name="gameId"><s:property value="idNumber" /></s:param>
							</s:url>
							<s:a href="%{urlDelete}"> X </s:a>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		
		<br />
		<br />
		
		<s:a action="displayGameSave"><s:text name="jsp.gameList.add"/></s:a>
	</body>
	
</html>