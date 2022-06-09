package fis.local.osebe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
//HTTP ->(controlerji samo mapirajo REQUESTE z Jason HTTP zahtevami --> services --> repository --> DB
//DRUGA ZADEVA!!!! ne uporablja DB ampak arraylist
@RestController 				//naloga je samo da poveže/pokaže http zahteve z metodami, katere imamo napisane
public class OsebeController {	//nato metode povežemo s storitvami/servisi!

	@Autowired
	OsebaServices osebaServices;//Povežemo z paketom kamor prenesemo metode! #cServices
	//ArrayList<Oseba> osebe = null; Ko prenesemo v Services izbrišemo!!

	public OsebeController() { //ko se bomo povezali z bazo bomo omaknili listo!
		super();
	}
	
	@CrossOrigin(origins= "*")
	@RequestMapping("/osebe/getAllOsebe")
	public List<Oseba> getAllOsebe(){
		//return osebe; ker smo prenesli v Services spremenimo!!! z spodnjo potjo!
		//osebaServices.vstaviOsebo(); --> za vstaviti osebe
		return osebaServices.getAllOsebe(); // dodamo metodo v Services!!!
	}
	
	// Dela tako VARIANTA 1
	@CrossOrigin(origins= "*")
	@GetMapping("/osebe/getOsebaById/{i}")  //Isto kot Request z metodo get (uporabimo GET)
	public Optional<Oseba> getOsebaById(@PathVariable int i) { //PathVariable pokaže pot do url z istim imenom v {}
		return osebaServices.getOsebaById(i); //to dodamo ko dodamo @Autowired in prestavimo metodo v services - jo usmerimo!
		//ker v servicah nastavimo optional moramo tudi tukaj zaradi JPA Repositorija
	}
		/* Od tu naprej smo prenesli v Services!!!
		Iterator<Oseba> it = osebe.iterator();
		Oseba temp = null;
		while(it.hasNext()) {
			temp=it.next();
			if(temp.getOid() == i) {
				return temp;
			}
		}
		return null;
	}
		//Dela tudi tako VARIANTA 2
	@GetMapping("/osebe/getOsebaById/{i}")  //Isto kot Request z metodo get (uporabimo GET)
	public Oseba getOsebaById(@PathVariable int i) {
		return osebe.stream().filter(t -> (t.getOid()==i)).findFirst().get(); //poišče osebo
	}*/
	
	@CrossOrigin(origins= "*")
	@DeleteMapping("/osebe/deleteOseba/{i}")  //izbrišemo osebo z ID = i metoda "DELETE"
	public String deleteOseba(@PathVariable int i) {
		return osebaServices.deleteOseba(i);
	}
	
	/*IZBRIŠEMO ko prenesemo v SERVICES
	 * public String deleteOseba(@PathVariable int i) {
		Iterator<Oseba> it = osebe.iterator();
		Oseba temp = null;
		while(it.hasNext()) {
			temp=it.next();
			if(temp.getOid() == i) {
				osebe.remove(temp);
				return "Oseba je bila izbrisana!";
				}
			}
		return "Oseba s tem ID ni bila izbrisana ali ne obstaja! ";
	}*/
	
	@CrossOrigin(origins= "*")
	@RequestMapping(value="/osebe/createOseba", method = RequestMethod.POST)
	public String createOseba(@RequestBody Oseba o) {
		return osebaServices.createOseba(o);
	}
	
	@CrossOrigin(origins= "*")
	@RequestMapping(value = "/osebe/updateOseba/{i}", method= RequestMethod.PUT) //metoda PUT v postmanu
	public String updateOseba(@RequestBody Oseba o) {
		//osebaServices.vstaviOsebo();
		return osebaServices.updateOseba(o);
	}
	
	
	
}
