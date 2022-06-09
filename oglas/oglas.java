package fis.local.oglas;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import fis.local.delodajalci.*;
import fis.local.osebe.*;


//to je beans

@Entity
@Table(name="OGLAS", schema="FIS")
public class oglas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen") //dodano 9.6
	@SequenceGenerator(name="my_seq_gen", sequenceName="ENTITY_SEQ") //dodano 9.6
	private int ogid;
	private String naslov;
	private String vsebina;
	
	//več oseb lahko ima en oglasa  eno osebo // oglas bo kazal osebo -- oseba ne kazala oglasa
	@OneToOne(
			cascade = CascadeType.ALL) //naj bi izbrisalo vse podatke vezano na osebo
	private Oseba oseba;
	
	//@OneToMany če bi oseba imela več oglasov
	//@ManyToOne če bi oglas imel več oseb
	
//	@OnetoOne //več oseb to je dodano 9.6
//	@JoinTable (
//			naslov2 = "osebaZoglasi"
//			joinColums = @JoinColumn(naslov2 = "ogid"),
//			inverseJoinColumns = @JoinColumn(name = "oid")
//			)
//	Set<oseba> osebaZoglasi = new HashSet<>();
	
//	@OneToOne //en oglas lahko ima enega delodajalca -- oglas bo kazal delodajalca delodajalec ne bo kazal oglasa
//	private delodajalec Delodajalec; //če hočem zamenjat, da se vidijo oglasi na strani delodajlca daš
////	to oglas v delodajalca z notacijo OneToMany
	
			
	public oglas() {
		super();
	}
	
	public oglas(int ogid, String naslov, String vsebina, Oseba o) {
		super();
		this.ogid = ogid;
		this.naslov = naslov;
		this.vsebina = vsebina;
		this.oseba = o;
		
	}
	
	public int getOgid() {
		return ogid;
	}
	public void setOgid(int ogid) {
		this.ogid = ogid;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getVsebina() {
		return vsebina;
	}
	public void setVsebina(String vsebina) {
		this.vsebina = vsebina;
	}
	
	public Oseba getOseba() {
		return oseba;
	}
	
	public void setOseba(Oseba o) {
		this.oseba = o;
	}
	
	//	public Set<oseba> getosebeZoglasi() { //ta funkcija je dodana 9.6
//		return osebeZoglasi;
//	}


}
