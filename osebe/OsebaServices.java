package fis.local.osebe;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;

//daja navodila Repositorijam --> repositoriji se preko JPA povežejo z DB!
import org.springframework.web.bind.annotation.RequestBody;

@Service //spring bean -  ustvari storitve na zahteve http CRUD
public class OsebaServices {
	//prevzamemo metodo iz Controllerjev!!!
	//Tretja zadeva //povezava za vnos v DB
	
	//ArrayList<Oseba> osebe = null;
	
	@Autowired
	OsebaRepository osebaRepository; //povezemo z repositorijo za dostop do DB ko nastavimo Avtowired
	public OsebaServices() {
		super(); 
		//Prenesemo iz Controllerja po AutoWired! - ko pa bomo ustvarili DB izbrišemo od tukaj!
//		osebe = new ArrayList<Oseba>(); 
//		osebe.add(new Oseba(1, "Gregor", "Vrtič", "031268831", "vrtich@gmail.com", "kriminalist"));
//		osebe.add(new Oseba(2, "Andrej", "Mitič", "051289921", "andrej2@gmail.com", "voznik"));
//		osebe.add(new Oseba(3, "Marko", "Marancin", "070654371", "maremare5@gmail.com", "varilec"));
//		osebe.add(new Oseba(4, "Tim", "Lakoše", "040344371", "timil45@gmail.com", "voznik tovrnjaka"));
//		osebe.add(new Oseba(5, "Aleš", "Velički", "031631600", "velicki@gmail.com", "varilec"));
//		osebe.add(new Oseba(6, "Marko", "Medved", "051371000", "mmedo665@yahoo.com", "varilec"));
//		osebe.add(new Oseba(7, "Rok", "Valič", "031321456", "rokiboban@gmail.com", "trgovec"));
//		osebe.add(new Oseba(8, "Sandi", "Mandarić", "", "sandi@gmail.com", "taxi voznik"));
//		osebe.add(new Oseba(9, "Nina", "Rudolf", "041687901", "", "računovodja"));
		}
	
	public List<Oseba> getAllOsebe() {
		return osebaRepository.findAll();  //po Autowired povezemo kam naj vrača --> repo!
	}
	
	
	public Optional<Oseba> getOsebaById(int i) { //PathVariable pokaže pot do url z istim imenom v {}
		return osebaRepository.findById(Integer.valueOf(i));
		
//		Iterator<Oseba> it = osebe.iterator();
//		Oseba temp = null;
//		while(it.hasNext()) {
//			temp=it.next();
//			if(temp.getOid() == i) {
//				return temp;
//			}
//		}
//		return null;
	}
				
	public String deleteOseba(int i) {
		try {osebaRepository.deleteById(Integer.valueOf(i));
		} catch (Exception e) {
			e.printStackTrace();
			return "Ta Id oz. oseba ne obstaja!";
			}
			return "Oseba je izbrisana!";
		
	}
	
	public String updateOseba(Oseba o) {
		try {
			osebaRepository.save(o);
			} catch (Exception e) 
			{e.printStackTrace();
			return "Osebo ni bila posodobljena ali ne obstaja!";			
					}
			return "Uspešno ste opravili posodobitev podatkov!";
				
	}
	
		
	public String createOseba(Oseba o) { // @RequestBody -- če hočemo ustvari  osebo potrebujemo//RequestBody - zato potrebujemo Postmana
		try {
		osebaRepository.save(o);
		} catch (Exception e) 
		{e.printStackTrace();
		return "Vnosa za omenjeno osebo ni bilo mogoče opraviti!";			
				}
		return "Oseba je bila uspešno vnešena!";
		
//		try {
//		osebe.add(o);
//	} catch (Exception e) {
//		e.printStackTrace();
//		return "ERROR; Oseba ni bila vnešena!";
//	}
//	return "Oseba je bila vnešena!";
//	}
	}

}	


