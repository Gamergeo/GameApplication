<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<c:set var="listGameTable" value="${requestScope[param.listGameName]}" scope="page" />

<table border="1">
	<thead>
		<tr>
			<th><s:text name="jsp.gameList.column.id"/></th>
			<th><s:text name="jsp.gameList.column.gameName"/></th>
			<th><s:text name="jsp.gameList.column.devName"/></th>
			<th><s:text name="jsp.gameList.column.countryName"/></th>
			<th><s:text name="jsp.gameList.column.edit"/></th>
			<th><s:text name="jsp.gameList.column.delete"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listGameTable}" var="game">
			<tr>
				<td>${game.id}</td>
				<td>${game.name}</td>
				<td>${game.developper.name}</td>
				<td>${game.developper.country.name}</td>
				<td>
					<s:url action="displayGameSave" var="urlEdit">
  						<s:param name="gameForm.gameId">${game.id}</s:param>
					</s:url>
					<s:a href="%{urlEdit}"> O </s:a>
				</td>
				<td>
					<s:url action="saveGame" method="delete" var="urlDelete">
  						<s:param name="gameForm.gameId">${game.id}</s:param>
					</s:url>
					<s:a href="%{urlDelete}"> X </s:a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	
</html>