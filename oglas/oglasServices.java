package fis.local.oglas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import fis.local.osebe.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class oglasServices {
//	//prevzamemo metodo iz Controllerjev!!!
//	//Tretja zadeva PREVZAMEJO REQVESTE Z WEB/SPLETA - 
//	
	 //ArrayList<oglas> oglasi = null;
	 
	 @Autowired
	 oglasRepository OglasRepository;
	 
//	 @Autowired
//	 OsebaRepository OsebaRepo;
	 
	 public oglasServices() {
	 super(); 
//ko se povezemo z DB odmaknemo ARRAY LIST
//		 oglasi = new ArrayList<oglas>();
//		 oglasi.add(new oglas(1,"Oglas št. 1", "To je opis za prvi oglas"));
//		 oglasi.add(new oglas(2,"Oglas št. 2", "To je opis za drugi drugi oglas"));
//		 oglasi.add(new oglas(3,"Oglas št. 3", "To je opis za tretji tretji tretji oglas"));
	 }
	 
	 public List<oglas> getAllOglasi() {
		return OglasRepository.findAll();  //po Autowired povezemo kam naj vrača --> repo!
		}//Retrive

	 public Optional<oglas> getOglasById(int i) { //ni potrebno imeti @PathVariables
		 return OglasRepository.findById(Integer.valueOf(i));
	 } //Retrive
	 
	 public String deleteOglas(int i) {
		try {OglasRepository.deleteById(Integer.valueOf(i));
			} catch (Exception e) {
				e.printStackTrace();
				return "Oglas s to številko ne obstaja!";
				}
				return "Oglas je bil odstranjen!";
	 }//Delete
	 
	 public String updateOglas(oglas o) {
		 try {OglasRepository.save(o);
				} catch (Exception e) 
				{e.printStackTrace();
				return "Oglas ni bil posodobljena ali ne obstaja!";			
						}
				return "Uspešno ste opravili posodobitev oglasa!";
		}//Update
	 
	 
	 public String createOglas(oglas o) {
		 try {OglasRepository.save(o);
				} catch (Exception e) 
				{e.printStackTrace();
				return "Vnosa za omenjen oglas ni bilo mogoče opraviti!";			
						}
				return "Oglas ste uspešno oddali!";
	} //Create 
	 
//	 
//	 public String ustvariOglas(oglas o) {
//		 try {OglasRepository.save(o);
//				} catch (Exception e) 
//				{e.printStackTrace();
//				return "Vnosa za omenjen oglas ni bilo mogoče opraviti!";			
//						}
//				return "Oglas ste uspešno oddali!";
//	} //Create dodano 9.6
	 
	//dodana metoda v REpositoriju
	 public List<oglas> getByName(String name) {
			return OglasRepository.getByName(name);
		}
	 
	 public List<oglas> getOglasByNaslov(String naslov){
		 return OglasRepository.getByName(naslov);
	 } //Retrive
	
	
}
