<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div id="barraFixa">
	<a href="http://localhost:8080/BooksBuy/home">
		<div id="logotipo">
			<h2>BooksBuy</h2>
			<p>Sua livraria virtual.</p>
		</div>
	</a>
	<div id="pesquisa">
		<form action="Pesquisa" method="GET">
			<input type="text" name="p" class="barraTexto" autocomplete="off" value="Digite o nome do livro que você deseja encontrar" 
			onfocus="if (this.value=='Digite o nome do livro que você deseja encontrar') this.value='';" 
			onblur="if (this.value=='') this.value='Digite o nome do livro que você deseja encontrar'">
			<input type="submit" value="Pesquisar" class="btn" />
		</form>
	</div>
	<div id="botaoMeuCarrinho">
		<a href="">
				<img src="_imagens/_icones/ico-meuCarrinho.png"/>
			<p>Meu Carrinho</p>
		</a>
	</div>
	<div id="areaLogin">
		<a href="login.jsp">
			<p>Entre ou Cadastre-se</p>
		</a>
	</div>
</div>