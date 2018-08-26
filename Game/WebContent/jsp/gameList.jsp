<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>

<html>
	<head>
		<title><bean:message bundle="label" key="jsp.gameList.title"/></title>
	</head>
	<body>
		<table border="1">
			<thead>
				<tr>
					<th><bean:message bundle="label" key="jsp.gameList.column.id"/></th>
					<th><bean:message bundle="label" key="jsp.gameList.column.gameName"/></th>
					<th><bean:message bundle="label" key="jsp.gameList.column.devName"/></th>
					<th><bean:message bundle="label" key="jsp.gameList.column.countryName"/></th>
					<th><bean:message bundle="label" key="jsp.gameList.column.delete"/></th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate id="gameElement" name="GAME_LIST">
					<bean:define id="game" name="gameElement" type="com.tutorial.struts.bean.dto.Game" />
					<tr>
						<td><bean:write name="game" property="idNumber"/></td>
						<td><bean:write name="game" property="name"/></td>
						<td><bean:write name="game" property="developper.name"/></td>
						<td><bean:write name="game" property="developper.country.name"/></td>
						<td>
							<html:form action="/deleteGame.do">
								<input type="hidden" name="gameId" value="<bean:write name="game" property="idNumber"/>">
    							<button type="submit">Submit</button>
							</html:form>
							
<%-- 						<html:link action="deleteGame.do" paramName="game" paramProperty="idNumber" paramId="gameId">X</html:link> --%>
<!-- 						<a href="/deleteGame.do?gameId="<bean:write name="game" property="idNumber"/>>X</a></td> -->
					</tr>
				</logic:iterate>
			</tbody>
		</table>
		
		<br />
		<br />
		
		<a href="/struts/displayGameSave.do"><bean:message bundle="label" key="jsp.gameList.add"/></a>
	</body>
	
</html>