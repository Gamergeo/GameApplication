<%@ include file="../header/header_def.jsp" %>

<!DOCTYPE html>

<jsp:include page="../header/header.jsp">
	<jsp:param value="jsp.userList.title" name="title"/>
</jsp:include>

<jsp:include page="userList/userListTable.jsp">
	<jsp:param value="listUser" name="listUser"/>	
</jsp:include>

<br />
<br />

<jsp:include page="../header/footer.jsp" />