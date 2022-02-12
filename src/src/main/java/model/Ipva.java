package model;

public class Ipva {

	private int id;
	private Integer ano;
	

	public Ipva(Integer ano) {
		super();
		this.ano = ano;
	}








	public int getId() {
		return id;
	}








	public void setId(int id) {
		this.id = id;
	}








	public Integer getAno() {
		return ano;
	}








	public void setAno(Integer ano) {
		this.ano = ano;
	}








	public String toString() {
		return this.id + " - " + this.ano;
	}
	
}
