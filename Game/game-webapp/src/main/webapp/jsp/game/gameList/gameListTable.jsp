<%@ include file="../../header/header_def.jsp" %>

<c:set var="listGameTable" value="${requestScope[param.listGameName]}" scope="page" />

<table border="1">
	<thead>
		<tr>
			<th><s:text name="label.general.id"/></th>
			<th><s:text name="label.game.name"/></th>
			<th><s:text name="label.user.first.name"/></th>
			<th><s:text name="label.user.last.name"/></th>
			<th><s:text name="label.general.view"/></th>
			<th><s:text name="label.general.edit"/></th>
			<th><s:text name="label.general.delete"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listGameTable}" var="game">
			<tr>
				<td>${game.id}</td>
				<td>${game.name}</td>
				<td>${game.manager.firstName}</td>
				<td>${game.manager.lastName}</td>
				<td>
					<s:url action="view" namespace="/game" var="urlView">
  						<s:param name="game.id">${game.id}</s:param>
					</s:url>
					<s:a href="%{urlView}"> O </s:a>
				</td>
				<td>
					<s:url action="displayGameSave" var="urlEdit">
  						<s:param name="game.id">${game.id}</s:param>
					</s:url>
					<s:a href="%{urlEdit}"> O </s:a>
				</td>
				<td>
					<s:url action="saveGame" method="delete" var="urlDelete">
  						<s:param name="game.id">${game.id}</s:param>
					</s:url>
					<s:a href="%{urlDelete}"> X </s:a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	
</html>