package model;

public class Carro {

	private Integer  idcarro;
	private String modelo;
	private Integer ano;
	
	













	public Carro(String modelo, Integer ano) {
		super();
		this.modelo = modelo;
		this.ano = ano;
	}















	public Integer getIdcarro() {
		return idcarro;
	}















	public void setIdcarro(Integer idcarro) {
		this.idcarro = idcarro;
	}















	public String getModelo() {
		return modelo;
	}















	public void setModelo(String modelo) {
		this.modelo = modelo;
	}















	public Integer getAno() {
		return ano;
	}















	public void setAno(Integer ano) {
		this.ano = ano;
	}















	public String toString() {
		return this.idcarro + " - " + this.modelo + " - " + this.ano;
	}
}
