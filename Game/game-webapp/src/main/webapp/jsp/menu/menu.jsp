<%@ include file="../header/header_def.jsp" %>

<!DOCTYPE html>

<nav id="menu"> 

	<p>
		<s:a action="list" namespace="/game"><s:text name="label.menu.list.game"/></s:a>
	</p>
	<p>	
		<s:a action="list" namespace="/user"><s:text name="label.menu.list.user"/></s:a>
	</p>
	<p>	
		<s:a action="edit" namespace="/user"><s:text name="label.menu.add.user"/></s:a>
	</p>

</nav>