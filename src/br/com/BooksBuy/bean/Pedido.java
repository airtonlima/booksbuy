package br.com.BooksBuy.bean;

public class Pedido {

	private Integer idPedido;
	private Integer dataPedido;
	private Integer qtdeLivroPedido;
	private Integer valorUnitarioLivroPedido;
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Integer getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Integer dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Integer getQtdeLivroPedido() {
		return qtdeLivroPedido;
	}
	public void setQtdeLivroPedido(Integer qtdeLivroPedido) {
		this.qtdeLivroPedido = qtdeLivroPedido;
	}
	public Integer getValorUnitarioLivroPedido() {
		return valorUnitarioLivroPedido;
	}
	public void setValorUnitarioLivroPedido(Integer valorUnitarioLivroPedido) {
		this.valorUnitarioLivroPedido = valorUnitarioLivroPedido;
	}
}
