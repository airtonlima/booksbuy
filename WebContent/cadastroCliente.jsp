<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BooksBuy | Cadastro de Clientes</title>
		<link rel="stylesheet" type="text/css" href="_css/estiloBase.css"/>
		<link rel="stylesheet" type="text/css" href="_css/estiloCadastroCliente.css"/>
	</head>
	<body>
		<jsp:include page="_componente/topo.jsp"/>
		<div id="containerPrincipal">
			<h1>Cadastro de Clientes</h1>
			<c:if test="${mensagem != null}">
				<div class="alert-danger">${mensagem}</div>
			</c:if>
			<form action="CadastroCliente" method="POST">
				<fieldset id="fieldStyle">
					<legend id="legendStyle">DADOS PESSOAIS</legend>
					<table>
						<tr>
							<td><label for="iCpf" class="label-style">CPF:*&nbsp;</label></td>
							<td><input type="text" name="txtCpf" id="iCpf" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iNomeCompleto" class="label-style">Nome Completo:*&nbsp;</label></td>
							<td><input type="text" name="txtNomeCompleto" id="iNomeCompleto" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iEmail" class="label-style">E-mail:*&nbsp;</label></td>
							<td><input type="email" name="txtEmail" id="iEmail" value="${emailValidado}" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iDataNasc" class="label-style">Data de Nascimento:*&nbsp;</label></td>
							<td><input type="date" name="txtDataNasc" id="iDataNasc" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iSexo" class="label-style">Sexo:*&nbsp;</label></td>
							<td>
								<select name="txtSexo" id="iSexo" required class="barraSelect">
									<option value="F">Feminino</option>
									<option value="M" selected>Masculino</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="iCelular" class="label-style">Celular:*&nbsp;</label></td>
							<td><input type="text" name="txtCelular" id="iCelular" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iTelefoneFixo" class="label-style">Telefone Fixo:&nbsp;</label></td>
							<td><input type="text" name="txtTelefoneFixo" id="iTelefoneFixo" class="barraTexto"/></td>
						</tr>
					</table>
				</fieldset>
				<fieldset id="fieldStyle">
					<legend id="legendStyle">ENDEREÇO RESIDENCIAL</legend>
					<table>
						<tr>
							<td><label for="iLogradouro" class="label-style">Logradouro:*&nbsp;</label></td>
							<td><input type="text" name="txtLogradouro" id="iLogradouro" required class="barraTexto" placeholder="Av, Rua, Trav, ..."/></td>
						</tr>
						<tr>
							<td><label for="iNumeroResid" class="label-style">Número:*&nbsp;</label></td>
							<td><input type="number" name="txtNumeroResid" id="iNumeroResid" required class="barraTexto" min="0" max="99999"/></td>
						</tr>
						<tr>
							<td><label for="iCep" class="label-style">CEP:*&nbsp;</label></td>
							<td><input type="text" name="txtCep" id="iCep" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iBairro" class="label-style">Bairro:*&nbsp;</label></td>
							<td><input type="text" name="txtBairro" id="iBairro" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iComplemento" class="label-style">Complemento:&nbsp;</label></td>
							<td><input type="text" name="txtComplemento" id="iComplemento" class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iMunicipio" class="label-style">Município:*&nbsp;</label></td>
							<td><input type="text" name="txtMunicipio" id="iMunicipio" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iEstado" class="label-style">Estado:*&nbsp;</label></td>
							<td>
								<select name="txtEstado" id="iEstado" class="barraSelect" required>
									<optgroup label="Região Sudeste">
										<option value="ES">Espírito Santo</option>
										<option value="MG">Minas Gerais</option>
										<option value="RJ">Rio de Janeiro</option>
										<option value="SP" selected>São Paulo</option>
									</optgroup>
									<optgroup label="Região Sul">
										<option value="PR">Paraná</option>
										<option value="SC">Santa Catarina</option>
										<option value="RS">Rio Grande do Sul</option>
									</optgroup>
								</select>
							</td>
						</tr>
					</table>
				</fieldset>
				<fieldset id="fieldStyle">
					<legend id="legendStyle">DADOS DE ACESSO AO SISTEMA</legend>
					<table>
						<tr>
							<td><label for="iUsuario" class="label-style">Usuário:*</label></td>
							<td><input type="text" name="txtUsuario" id="iUsuario" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iSenha" class="label-style">Senha:*</label></td>
							<td><input type="password" name="txtSenha" id="iSenha" required class="barraTexto"/></td>
						</tr>
						<tr>
							<td><label for="iSenhaConfirm" class="label-style">Confirme a Senha:*</label></td>
							<td><input type="password" name="txtSenhaConfirm" id="iSenhaConfirm" required class="barraTexto"/></td>
						</tr>
					</table>
				</fieldset>
				<br/>
				<p><input type="submit" name="btnEnviarCadCli" value="Enviar" class="btn"/></p>
			</form>
		</div>
		<jsp:include page="_componente/rodape.jsp"/>
	</body>
</html>