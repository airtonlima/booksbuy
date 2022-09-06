<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>BooksBuy | Detalhe de Produto.</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="_css/estiloBase.css" />
		<link rel="stylesheet" type="text/css" href="_css/estiloDetalhe.css"/>
		
	</head>
	<body>
		<jsp:include page="_componente/topo.jsp"/>
		
		<div id="interfacePrincipal">
			<header>
				<h1>${livroDetalhe.tituloLivro}</h1>
			</header>
			<section id="livro">
					<figure>
						<img src="${livroDetalhe.fotoLivro}"/>
					</figure>
					<div id="info">
						<h3>Autor: ${livroDetalhe.autorLivro}</h3>
						<h2>R$ ${livroDetalhe.precoLivro}</h2>
						<a href="Cesto?id=${livroDetalhe.idLivro}" class="btnComprar">Comprar agora !</a>
					</div>
			</section>
			<aside id="detalhe">
				<h2>Características detalhadas</h2>
				<ul>
					<li>I.S.B.N. : ${livroDetalhe.isbnLivro}</li>
					<li>Categoria : ${livroDetalhe.nomeCategoriaLivro}</li>
					<li>Edição : ${livroDetalhe.edicaoLivro} / ${livroDetalhe.anoEdicaoLivro}</li>
					<li>Editora : ${livroDetalhe.editoraLivro}</li>
					<li>Idioma : ${livroDetalhe.idiomaLivro}</li>
					<li>Número de páginas : ${livroDetalhe.qtdePaginas}</li>
				</ul>
			</aside>
			<footer id="sinopse">
				<h2>Sinopse:</h2>
				<p style="text-align:justify;">${livroDetalhe.sinopseLivro}</p>
			</footer>
		</div>
		
		<jsp:include page="_componente/rodape.jsp"/>
	</body>
</html>