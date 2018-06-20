
<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/style.css ">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/add-customer-style.css ">
	<style>.erreur {color: red;}</style>
<title>CRM -Gestionnaire des Clients - Sauvegarde client</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM -Gestion des utilisateurs</h2>
		</div>
		<div id="container">
			<h3>Ajouter un utilisateur</h3>

		</div>
		<form:form action="processAjoutUtilisateur"
			modelAttribute="utilisateurClassJSP" method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>Nom :</label></td>
						<td><form:input path="nom" /> <form:errors path="nom" cssClass="erreur"></form:errors></td>

					</tr>

					<tr>
						<td><label>Prénom :</label></td>
						<td><form:input path="prenom" /> <form:errors path="prenom" cssClass="erreur"></form:errors></td>

					</tr>

					<tr>
						<td><label>Email :</label></td>
						<td><form:input path="email" /> <form:errors path="email" cssClass="erreur"></form:errors></td>

					</tr>

					<tr>
						<td><label>Nom utilisateur :</label></td>
						<td><form:input path="nomUtilisateur" /> <form:errors path="nomUtilisateur" cssClass="erreur"></form:errors></td>

					</tr>

					<tr>
						<td><label>Mot de passe :</label></td>
						<td><form:input path="motDePasse" /> <form:errors path="motDePasse" cssClass="erreur"></form:errors></td>

					</tr>



					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Valider" class="save"></td>
					</tr>
				</tbody>
			</table>
			<br>
		</form:form>
		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/utilisateurs/liste">Retour
				vers la liste</a>
		</p>
	</div>
</body>
</html>