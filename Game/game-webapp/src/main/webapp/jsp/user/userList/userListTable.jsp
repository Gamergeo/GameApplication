<%@ include file="../../header/header_def.jsp" %>

<c:set var="listUserTable" value="${requestScope[param.listUser]}" scope="page" />

<table border="1">
	<thead>
		<tr>
			<th><s:text name="label.general.id"/></th>
			<th><s:text name="label.user.first.name"/></th>
			<th><s:text name="label.user.last.name"/></th>
			<th><s:text name="label.general.view"/></th>
			<th><s:text name="label.general.edit"/></th>
			<th><s:text name="label.general.delete"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listUserTable}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>
					<s:url action="view" namespace="/user" var="urlView">
  						<s:param name="user.id">${user.id}</s:param>
					</s:url>
					<s:a href="%{urlView}"> <s:text name="label.general.view"/></s:a>
				</td>
				<td>
					<s:url action="edit" namespace="/user" var="urlEdit">
  						<s:param name="user.id">${user.id}</s:param>
					</s:url>
					<s:a href="%{urlEdit}"> <s:text name="label.general.edit"/> </s:a>
				</td>
				<td>
					<s:url action="delete" namespace="/user" var="urlDelete">
  						<s:param name="user.id">${user.id}</s:param>
					</s:url>
					<s:a href="%{urlDelete}"> <s:text name="label.general.delete"/> </s:a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	
</html>