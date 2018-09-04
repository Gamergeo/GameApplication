<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<jsp:include page="../header/header.jsp">
	<jsp:param value="jsp.addGame.title" name="title"/>
</jsp:include>

<table border="1">
	<tr>
		<th><s:text name="label.game.id"/></th>
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
	<s:url action="../user/displayUserView" var="urlManagerView">
		<s:param name="user.id">${game.manager.id}</s:param>
	</s:url>
	<s:a href="%{urlManagerView}"> Show manager </s:a>
</div>

<c:if test="${not empty game.manager.managedGames}">
	<div>
		<p> Other Managed Games <br /> </p>
		<table border="1">
			<tr>
				<th><s:text name="label.game.id"/></th>
				<th><s:text name="label.game.name"/></th>
				<th><s:text name="label.general.view"/></th>
			</tr>
			
			<c:forEach items="${game.manager.managedGames}" var="game">
				<tr>
			    	<td>${game.id}</td>
			    	<td>${game.name}</td>
					<td>
						<s:url action="../game/displayGameView" var="urlView">
							<s:param name="game.id">${game.id}</s:param>
						</s:url>
						<s:a href="%{urlView}"> View game </s:a>
					</td>
			    </tr>
			</c:forEach>
		</table>
	</div>
</c:if>

	
<jsp:include page="../header/footer.jsp" />