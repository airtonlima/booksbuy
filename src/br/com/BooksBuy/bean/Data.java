package br.com.BooksBuy.bean;

public class Data extends Cliente{
	
	private String dia;
	private String mes;
	private String ano;
	
	public Data(String dia, String mes, String ano){
	
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public String getDia() {
		return dia;
	}
	public String getMes() {
		return mes;
	}
	public String getAno() {
		return ano;
	}
}
