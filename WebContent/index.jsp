<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>BooksBuy | Livraria Virtual.</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="_css/_slider/normalize.css"/>
		<link rel="stylesheet" type="text/css" href="_css/_slider/gallery.css"/>
		<link rel="stylesheet" type="text/css" href="_css/_slider/gallery.theme.css"/>
		<link rel="stylesheet" type="text/css" href="_css/estiloBase.css" />
		<link rel="stylesheet" type="text/css" href="_css/estiloLivroThumb.css"/>
	</head>
	<body>
		<header>
			<jsp:include page="_componente/topo.jsp"/>
			<jsp:include page="_componente/slider.jsp"/>
		</header>
		<section id="interfaceMenu">
			<h2>Livros:</h2>
			<ul>
				<c:forEach items="${listaCategorias}" var="c">
					<li><a href="home?id=${c.idCategoriaLivro}">${c.nomeCategoriaLivro}</a></li>
				</c:forEach>
			</ul>
		</section>
		<aside id="interfacePrincipal">
			<c:if test="${mensagem != null}">
				<div class="alert-danger">${mensagem}</div>
			</c:if>
			<c:forEach items="${listaLivros}" var="l">
				<div class="livro-Thumb">
					<figure>
						<img src="${l.fotoLivro}" width="120px" height="160px"/>
						<figcaption>
							<p>${l.tituloLivro}</p>
							<h3>R$ ${l.precoLivro}</h3>
						</figcaption>
					</figure>
					<a href="Detalhe?id=${l.idLivro}">+ Detalhes</a>
				</div>
			</c:forEach>
		</aside>
		<jsp:include page="_componente/rodape.jsp"/>
	</body>
</html>