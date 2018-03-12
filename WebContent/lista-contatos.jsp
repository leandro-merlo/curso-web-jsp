<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<!-- cria o DAO -->
		
	<table style="border: 1px solid black; border-collapse: collapse;">
		<thead>
			<tr style="border: 1px solid black">
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<!-- percorre contatos montando as linhas da tabela -->
			<c:forEach var="contato" items="${contatos}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
					<td>${contato.nome}</td>
					<td><c:choose>
							<c:when test="${not empty contato.email}">
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:when>
							<c:otherwise>
								Email não informado
							</c:otherwise>
						</c:choose> ${contato.email}</td>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
					<td>
						<a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a>
					</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>