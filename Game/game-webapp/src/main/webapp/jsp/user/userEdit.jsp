<%@ include file="../header/header_def.jsp" %>

<!DOCTYPE html>

<jsp:include page="../header/header.jsp">
	<jsp:param value="jsp.addUser.title" name="title"/>
</jsp:include>

<script>
	function setMethod(method) {
		document.forms['save'].elements['method'].value = method;
		return true;
	}
</script>

<s:form action="save" namespace="/user" method="post">
	<s:textfield key="jsp.userEdit.form.firstName" name="user.firstName"/>
	<s:textfield key="jsp.userEdit.form.lastName" name="user.lastName"/>
	<s:textfield key="jsp.userEdit.form.email" name="user.email"/>
	<s:hidden name="user.id" />
	<s:hidden name="method" />
	<s:submit action="saveGame" value="Save" onclick="return setMethod('save');"/>
	<s:submit action="saveGame" value="Save and Add"  onclick="return setMethod('saveAndAdd');"/>
</s:form>
	
<jsp:include page="../header/footer.jsp" />