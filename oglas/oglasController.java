package fis.local.oglas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fis.local.osebe.Oseba;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class oglasController {
	
	@Autowired   //potrebujemo za prenos metod v services!!!!
	oglasServices oglasiservices;
	
	//controler samo povzroči metodo, katera se izvede v SERVICAH!!!
//	ArrayList<oglas> oglasi = null;

	public oglasController() {
		super();
//		Ker smo se povezali z servisi odmaknemo arralist
//		oglasi = new ArrayList<oglas>();
//		oglasi.add(new oglas(1,"Oglas št. 1", "To je opis za prvi oglas"));
//		oglasi.add(new oglas(2,"Oglas št. 2", "To je opis za drugi drugi oglas"));
//		oglasi.add(new oglas(3,"Oglas št. 3", "To je opis za tretji tretji tretji oglas"));
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping("/oglasi/getAllOglasi")
	public List<oglas> getAllOglasi() {
		return oglasiservices.getAllOglasi();
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/oglasi/getOglasById/{i}")
	public Optional<oglas> getOglasById(@PathVariable int i) {
		return oglasiservices.getOglasById(i);
		
//		Iterator<oglas> it = oglasi.iterator();
//		oglas temp = null;
//		while(it.hasNext()) {
//			temp=it.next();
//			if(temp.getOgid() == i) {
//				return temp;
//			}
//		}
//		return null; --> PRENESEMO V SERVICES POTREBUJEMO SAMO NAKAZATI POT potrebujemo AUTOWIRED!!!
		
//		ali  za JAVA LAMBDA!!!!
//		public oglas getOglasById(@PathVariable int 1) {
//			return oglasi.stream().filter(t -> (t.getOgid()== i).findFirst().get());
//		}
		
	}
	
	@CrossOrigin(origins="*")
	@DeleteMapping("/oglasi/deleteOglas/{i}")  //izbrišemo osebo z ID = i metoda "DELETE"
		public String deleteOglas(@PathVariable int i) {
		return oglasiservices.deleteOglas(i);
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value= "/oglasi/createOglas", method= RequestMethod.POST) //to je metoda POST
	public String createOglas(@RequestBody oglas o) {
		return oglasiservices.createOglas(o);
	}
	
	@CrossOrigin(origins="*")
	 @PutMapping("/oglasi/updateOglas")
	 public String updateOglas(@RequestBody oglas o) { //@PathVariable int i
	 return oglasiservices.updateOglas(o);
	 }
	
	
//	@CrossOrigin(origins="*")   dodano 9.6
//	@RequestMapping(value= "/oglasi/ustvariOglas", method= RequestMethod.POST) //to je metoda POST
//	public String ustvariOglas(@RequestBody oglas o) {
//		return oglasiservices.ustvariOglas(o);
//	}
	
	 
	
}