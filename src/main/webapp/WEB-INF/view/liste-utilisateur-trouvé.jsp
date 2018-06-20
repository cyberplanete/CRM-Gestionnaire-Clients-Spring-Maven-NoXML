<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>CRM Gestion des utilisateurs</title>
<!-- Ajout dossier CSS -->
	<link 	type="text/css" 
			rel="stylesheet" 
			href="${pageContext.request.contextPath}/styles/style.css">
</head>
<body>
	

	<div id="wrapper">
		<div id="header">
		<h2>CRM -Gestionnaire des utilisateurs</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
				
			<table>
				<tr>
					<th>Prenom</th>
					<th>Nom</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			
			<!-- une boucle pour obtenir la liste des clients depuis le controlleur -->
				<c:forEach var="tempUtilisateurs" items="${ListeUtilisateurClassTrouvéJSP}">
				
					<!-- lien de mise à jour dans la variable lienMiseAJour - id obtenu dans une boucle for -->
					<c:url var="lienMiseAJour" value="/utilisateurs/formulaireMAJUtitilisateur">
						<c:param name="idUtilisateurJSP" value="${tempUtilisateurs.nom}">
						</c:param>
					</c:url>
					<!-- lien de suppression dans une variable lienSuppression - id obtenu dans une boucle for -->
						<c:url var="lienSuppression" value="/utilisateurs/suppressionUtilisateur">
						<c:param name="idUtilisateurJSP" value="${tempUtilisateurs.nom}">
						</c:param>
					</c:url>
				
					<tr>
						<td>${tempUtilisateurs.prenom}</td>
						<td>${tempUtilisateurs.nom}</td>
						<td>${tempUtilisateurs.email}</td>
						<td><a href="${lienMiseAJour}">Mise à jour </a>
						|<a href="${lienSuppression}" onclick="if (!(confirm('Confirmer vous la suppression ?')))return false"> Suppression</a> </td>
					</tr>
				</c:forEach>

			</table>
</div>
<p>
			<a href="${pageContext.request.contextPath}/utilisateurs/liste">Retour
				vers la liste</a>
		</p>	
	</div>
</body>
</html>