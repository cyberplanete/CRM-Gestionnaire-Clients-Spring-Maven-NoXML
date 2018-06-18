<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<html>

<head>
	<title>Custom Login Page</title>
	
	<style>
		.failed {
			color: red;
		}
	</style>
	
</head>

<body>

<h3>My Custom Login Page</h3>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
			   method="POST">
	
		<!-- Check for login error -->
	
		<c:if test="${param.error != null}">
		
			<i class="failed">Vous avez entré un nom d'utilisateur / mot de passe invalide.</i>
			
		</c:if>
			
		<p>
			
Nom d'utilisateur: <input type="text" name="username" />
		</p>

		<p>
			Mot de passe: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login" />
		
	</form:form>

</body>

</html>












