<%@ include file="../header/header_def.jsp" %>

<!DOCTYPE html>

<html>

<head>
  	<link rel="stylesheet" href="<c:url value='/css/style.css'/>" type="text/css">
	<title>${action.getText(param.title)}</title>
</head>

<body>

<div id="bodyWithHeaderInfos">
	<div id="headerInfos">
		<table>
			<tr>
				<td>Version ${revision}</td>
				<td> ${ceci.test} : ${environment}</td>
			</tr>
			<tr>
				<td>Date : <s:property value="localDate" /></td>
				<td>Time : <s:property value="localTime" /></td>
			</tr>	
			<tr>
				<td>USA Date : <s:property value="USADate" /></td>
				<td>Time : <s:property value="USATime" /></td>
			</tr>
		</table>
	</div>

	<div id="bodyWithMenu">
		<jsp:include page="../menu/menu.jsp" />
		<div id="body">
