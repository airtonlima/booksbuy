<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>BooksBuy | Livraria Virtual.</title>
	<link rel="stylesheet" type="text/css" href="_css/estiloBase.css"/>
	<link rel="stylesheet" type="text/css" href="_css/estiloIdentificacao.css"/>
</head>
<body>
	<jsp:include page="_componente/topo.jsp"/>
	<div id="containerPrincipal">
		<div id="tituloIdentificacao">
			<img src="_imagens/_icones/ico-Identificacao.png"/>
		</div>
		<div id="login">
			<form method="POST" action="LoginUsuario?u=0">
				<h2>Já é cadastrado?</h2>
				<h3>Acesse.</h3>
				<p>
					<label for="iTxtUsuario">E-mail&nbsp;</label>
					<input type="text" length="20" name="txtUsuario" id="iTxtUsuario" class="barraTexto"/>
				</p>
				<p>
					<label for="iTxtSenha">Senha&nbsp;&nbsp;</label>
					<input type="password" length="20" name="txtSenha" id="iTxtSenha" class="barraTexto"/>
				</p>
				<p><input type="submit" name="btnEntrar" value="Entrar" class="btn"/></p>
			</form>
		</div>
		<div id="cadastro">
			<form method="POST" action="CadastroCliente">
				<h2>Não possui cadastro?</h2>
				<h3>Cadastre-se.</h3>
				<p id="cadastroEmail">Começe digitando seu e-mail.</p>
				<p>
					<label for="iEmail">Seu e-mail</label>
					<input type="email" length="50" size="40" name="txtEmail" id="iEmail" class="barraTexto"/>
				</p>
				<p><input type="submit" name="btnProsseguir" value="Prosseguir" class="btn"/></p>
			</form>
		</div>
	</div>
</body>
</html>