<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>BooksBuy - Painel de Controle</title>
	<link rel="stylesheet" type="text/css" href="../_css/estiloRoot.css"/>
</head>
<body>
	<div id="login">
		<form method="POST" action="../LoginUsuario?u=1">
			<h2>Painel de Controle BooksBuy</h2>
			<p id="admin">Usuário administrativo</p>
			<p>
				<label for="iTxtUsuario">Usuário</label>
				<input type="text" length="20" name="txtUsuario" id="iTxtUsuario"/>
			</p>
			<p>
				<label for="iTxtSenha">Senha&nbsp;&nbsp;</label>
				<input type="password" length="20" name="txtSenha" id="iTxtSenha"/>
			</p>
			<p><input type="submit" value="ENTRAR"/></p>
		</form>
	</div>
</body>
</html>