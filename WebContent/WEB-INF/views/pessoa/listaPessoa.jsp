<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Lista Pessoa</title>
</head>
<body>
	<a href="cadastroPessoa">Novo</a>
	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>E-mail</th>
		</tr>
		<c:forEach items="${pessoas}" var="pessoa">
			<tr>
				<td>${pessoa.id}</td>
				<td>${pessoa.nome}</td>
				<td>${pessoa.cpf}</td>
				<td>${pessoa.email}</td>
			</tr>
			<td><a href="removePessoa?id=${pessoa.id}">Remover</a></td>
			<td><a href="editarPessoa?id=${pessoa.id}">Alterar</a></td>
		</c:forEach>
	</table>
</body>
</html>