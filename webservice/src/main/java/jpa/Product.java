package jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Towary")
public class Product {
	@Id
	@Column(name="idTowaru")
	private int idTowaru;
	
	@Column(name="rodzaj")
	private String rodzaj;
	
	@Column(name="model")
	private String model;
	
	@Column(name="dataProdukcji")
	private Date dataProdukcji;
	
	@Column(name="cena")
	private int cena;
	
	@Column(name="dostepnaIloœæ")
	private int dostepnaIlosc;
	
	@Column(name="idZamówienia")
	private int idZamowienia;
	
	@Column(name="idDostawy")
	private int idDostawy;
	
	@Column(name="idMagazynu")
	private int idMagazynu;
	
	@Column(name="idHurtowni")
	private int idHurtowni;
	
	public Product(int idTowaru, String rodzaj, String model
			, int cena, int dostepnaIlosc, Date dataProdukcji,int idZamowienia
			, int idDostawy, int idMagazynu, int idHurtowni) {
		this.idTowaru=idTowaru;
		this.rodzaj=rodzaj;
		this.model=model;
		this.cena=cena;
		this.dataProdukcji=dataProdukcji;
		this.dostepnaIlosc=dostepnaIlosc;
		this.idZamowienia=idZamowienia;
		this.idDostawy=idDostawy;
		this.idMagazynu=idMagazynu;
		this.idHurtowni=idHurtowni;
	}
	
	public Product() {
		
	}
	public void setIdTowaru(int idTowaru) {
		this.idTowaru=idTowaru;
	}
	
	public void setModel(String model) {
		this.model=model;
	}
	
	public void setRodzaj(String rodzaj) {
		this.rodzaj=rodzaj;
	}
	
	public void setDataProdukcji(Date dataProdukcji) {
		this.dataProdukcji=dataProdukcji;
	}
	
	public void setCena(int cena) {
		this.cena=cena;
	}
	
	public void setDostepnaIlosc(int dostepnaIlosc) {
		this.dostepnaIlosc=dostepnaIlosc;
	}
	
	public void setIdZamowienia(int idZamowienia) {
		this.idZamowienia=idZamowienia;
	}
	
	public void setIdDostawy(int idDostawy) {
		this.idDostawy=idDostawy;
	}
	
	public void setIdMagazynu(int idMagazynu) {
		this.idMagazynu=idMagazynu;
	}
	
	public void setIdHurtowni(int idHurtowni) {
		this.idHurtowni=idHurtowni;
	}
	
	public int getIdTowaru() {
		return this.idTowaru;
	}
	
	public String getRodzaj() {
		return this.rodzaj;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public Date getDataProdukcji() {
		return this.dataProdukcji;
	}
	
	public int getCena() {
		return this.cena;
	}
	
	public int getDostepnaIlosc() {
		return this.dostepnaIlosc;
	}
	
	public int getIdZamowienia() {
		return this.idZamowienia;
	}
	
	public int getIdDostawy() {
		return this.idDostawy;
	}
	
	public int getIdMagazynu() {
		return this.idMagazynu;
	}
	
	public int getIdHurtowni() {
		return this.idHurtowni;
	}
}
