<%@ include file="../header/header_def.jsp" %>

<!DOCTYPE html>

<jsp:include page="../header/header.jsp">
	<jsp:param value="jsp.addGame.title" name="title"/>
</jsp:include>

<table border="1">
	<tr>
		<th><s:text name="label.user.first.name"/></th>
		<th><s:text name="label.user.last.name"/></th>
		<th><s:text name="label.user.email"/></th>
	</tr>
	<tr>
    	<td>${user.firstName}</td>
    	<td>${user.lastName}</td>
    	<td>${user.email}</td>
  	</tr>
</table>
	
<jsp:include page="../header/footer.jsp" />