<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<title>CRM -Gestionnaire des Clients - Recherche utilisateurs</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM -Gestionnaire des utilisateurs</h2>
		</div>
		<div id="container">
			<h3>Recherche utilisateur</h3>

		</div>
		<form:form action="process-recherche-utilisateur" modelAttribute="utilisateurClassJSP"
			method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>Nom :</label></td>
						<td><form:input path="nom" /></td>
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