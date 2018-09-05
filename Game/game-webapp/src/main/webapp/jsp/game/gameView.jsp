<%@ include file="../header/header_def.jsp" %>

<!DOCTYPE html>

<jsp:include page="../header/header.jsp">
	<jsp:param value="jsp.addGame.title" name="title"/>
</jsp:include>

<table border="1">
	<tr>
		<th><s:text name="label.general.id"/></th>
		<th><s:text name="label.game.name"/></th>
		<th><s:text name="label.user.first.name"/></th>
		<th><s:text name="label.user.last.name"/></th>
	</tr>
	<tr>
    	<td>${game.id}</td>
    	<td>${game.name}</td>
    	<td>${game.manager.firstName}</td>
    	<td>${game.manager.lastName}</td>
  	</tr>
</table>

<div>
	<s:url action="view" namespace="/user" var="urlManagerView">
		<s:param name="user.id">${game.manager.id}</s:param>
	</s:url>
	<s:a href="%{urlManagerView}"> Show manager </s:a>
</div>

<c:if test="${not empty game.manager.managedGames}">
	<div>
		<p> Other Managed Games <br /> </p>
		
	  	<c:set var="managedGames" value="${game.manager.managedGames}" scope="request"/>
		<jsp:include page="gameList/gameListTable.jsp">
			<jsp:param value="managedGames" name="listGameName"/>	
		</jsp:include>
	</div>
</c:if>

	
<jsp:include page="../header/footer.jsp" />