package fis.local.delodajalci;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DELODAJALEC", schema="FIS")
public class delodajalec {
	
	@Id
	private int did;
	private String imeDruzbe;
	private String kraj;
	private String opis;
	private String delovnoMesto;
	private String izobrazba;
	private String elektronskinaslov;
	private int kontaktnastevilka;	
	private double ura;
	
		
	public delodajalec() {
		super();
	}

	public delodajalec(int did, String imeDruzbe, String kraj, String opis, String delovnoMesto, String izobrazba,
			String elektronskinaslov, int kontaktnastevilka, double ura) {
		super();
		this.did = did;
		this.imeDruzbe = imeDruzbe;
		this.kraj = kraj;
		this.opis = opis;
		this.delovnoMesto = delovnoMesto;
		this.izobrazba = izobrazba;
		this.elektronskinaslov = elektronskinaslov;
		this.kontaktnastevilka = kontaktnastevilka;
		this.ura = ura;
	}
	
	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getImeDruzbe() {
		return imeDruzbe;
	}
	public void setImeDruzbe(String imeDruzbe) {
		this.imeDruzbe = imeDruzbe;
	}
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public String getDelovnoMesto() {
		return delovnoMesto;
	}
	public void setDelovnoMesto(String delovnoMesto) {
		this.delovnoMesto = delovnoMesto;
	}
	public String getIzobrazba() {
		return izobrazba;
	}
	public void setIzobrazba(String izobrazba) {
		this.izobrazba = izobrazba;
	}
	public String getElektronskinaslov() {
		return elektronskinaslov;
	}
	public void setElektronskinaslov(String elektronskinaslov) {
		this.elektronskinaslov = elektronskinaslov;
	}
	public int getKontaktnastevilka() {
		return kontaktnastevilka;
	}
	public void setKontaktnastevilka(int kontaktnastevilka) {
		this.kontaktnastevilka = kontaktnastevilka;
	}
	public double getUra() {
		return ura;
	}
	public void setUra(double ura) {
		this.ura = ura;
	}
	

}
