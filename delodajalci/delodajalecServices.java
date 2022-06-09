package fis.local.delodajalci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.local.delodajalci.delodajalec;
import fis.local.osebe.Oseba;

@Service
public class delodajalecServices {
	
//	  ArrayList<delodajalec> delodajalci = null;
	 
	 @Autowired
	 DelodajalecRepository delodajalecRepository;
	 public delodajalecServices() {
		 super(); //ko se povezemo z DB odmaknemo ARRAY LIST
//		 delodajalci = new ArrayList<delodajalec>();
//		 delodajalci.add(new delodajalec( 1, "OMW Frnetiči", "Sežana", "Prodajalec", "ni potrebna", "mojedelo@gmail.com", 06436632, 8.50));
	 }
	 
	 
	 public List<delodajalec> getAllDelodajalci() {
		 return delodajalecRepository.findAll();
	 }
	 

	 public Optional<delodajalec> getDelodajalecById(int i) { //ni potrebno imeti @PathVariables
		 return delodajalecRepository.findById(Integer.valueOf(i));
	 }
	
	public String deleteDelodajalec(int i) {
		try {delodajalecRepository.deleteById(Integer.valueOf(i));
			} catch (Exception e) {
				e.printStackTrace();
				return "Ta delodajalec ne obstaja!";
				}
				return "Delodajalec je bil izbrisal iz baze!";
	}
	 
	 	 	 
	public String createDelodajalec(delodajalec d) {
		try {delodajalecRepository.save(d);
				} catch (Exception e) {
					e.printStackTrace();
					return "ERROR --> Delodajalec ni bil ustvarjen!!!";
				}
				return "Delodajalec se je uspešno prijavil!";
			}
	 
	
	public String updateDelodajalec(delodajalec d) {
		try {delodajalecRepository.save(d);
			} catch (Exception e) 
			{e.printStackTrace();
			return "Dolodajalec ni bil posodobljen ali ne obstaja v bazi!";			
					}
			return "Uspešno ste opravili posodobitev podatkov za delodajalca!";
	}
	
	public List<delodajalec> getByDelavnoMesto(String delovnoMesto) {
		return delodajalecRepository.getByDelavnoMesto(delovnoMesto);
	}
	
	public List<delodajalec> getByKraj(String kraj) {
		return delodajalecRepository.getByKraj(kraj);
	}
	
		

}
