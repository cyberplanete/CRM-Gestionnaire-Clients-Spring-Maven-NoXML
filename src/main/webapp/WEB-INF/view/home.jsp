<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Cyberplanete Page d'accueil</title>
</head>

<body>
	<h2>Cyberplanete Page d'accueil</h2>
	<hr>
	
	<p>
Bienvenue sur la page d'accueil de la société Cyberplanete!
	</p>
	
	<hr>
	
	<!-- display user name and role -->
	
	<p>
		Utilisateur: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<security:authorize access="hasRole('MANAGER')">
	
		<!-- Ajouter un lien pour pointer vers / leaders ... c'est pour les gestionnaires -->
		
		<p>
			<a href="${pageContext.request.contextPath}/leaders">En cours de dev</a>
			
		</p>

	</security:authorize>	
	
	
	<security:authorize access="hasRole('ADMIN')">  

		<!-- Ajouter un lien pour pointer vers / systems ... ceci est pour les admins -->
		
		<p>
			<a href="${pageContext.request.contextPath}/utilisateurs/liste">Liste des utilisateurs</a>
			
		</p>
	
	</security:authorize>
	
	<hr>
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Déconnexion" />
	
	</form:form>
	
</body>

</html>









