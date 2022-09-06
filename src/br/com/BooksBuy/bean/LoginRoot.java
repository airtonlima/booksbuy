package br.com.BooksBuy.bean;

public class LoginRoot{
	
	private Integer idUsuarioRoot;
	private String usernameUsuario;
	private String senhaUsuario;
	
	public Integer getIdUsuario() {
		return idUsuarioRoot;
	}
	public void setIdUsuario(Integer idUsuarioRoot) {
		this.idUsuarioRoot = idUsuarioRoot;
	}
	public String getUsernameUsuario() {
		return usernameUsuario;
	}
	public void setUsernameUsuario(String usernameUsuario) {
		this.usernameUsuario = usernameUsuario;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
}
