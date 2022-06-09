package fis.local.osebe;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fis.local.oglas.*;

//to je bean
//@Table(name="Oseba", schema="oseba")
//@NamedQuery(name="Oseba.findAll", query="SELECT a FROM Oseba a") -- to na vajah ni comentirano
//PRVA ZADEVA!!!


@Entity
@Table(name="OSEBA", schema="FIS")
public class Oseba {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) //to dodano 9.6
	private int Oid;
	private String ime;
	private String priimek;
	private String tel;
	private String email;
	private String poklic;
	
//	@JsonIgnore  //to je dondano 9.6
//	@OneToOne(mappedBy="osebeZoglasi")
//	private Set<oglas> oglasi = new HashSet<>(); //do sem

		
	public Oseba() {
		super();
	}
	
	public Oseba(int oid, String ime, String priimek, String tel, String email, String poklic) {
		super();
		this.Oid = oid;
		this.ime = ime;
		this.priimek = priimek;
		this.tel = tel;
		this.email = email;
		this.poklic = poklic;
		
	}
	
	public int getOid() {
		return Oid;
	}
	public void setOid(int oid) {
		this.Oid = oid;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPriimek() {
		return priimek;
	}
	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPoklic() {
		return poklic;
	}
	public void setPoklic(String poklic) {
		this.poklic = poklic;
	}
	
	
}
