package fis.local.delodajalci;

import java.util.ArrayList;
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

import fis.local.oglas.oglas;
import fis.local.oglas.oglasServices;

@RestController
public class delodajalecController {

	
	@Autowired   //potrebujemo za prenos metod v services!!!!
	delodajalecServices delodajalecservices;
	
	//controler samo povzroči metodo, katera se izvede v SERVICAH!!!
	//ArrayList<delodajalec> delodajalci = null;

	public delodajalecController() {
		super();
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping("/delodajalec/getAllDelodajalci")
	public List<delodajalec> getAllDelodajalci() {
		return delodajalecservices.getAllDelodajalci();
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/delodajalec/getDelodajalecById/{i}")
	public Optional<delodajalec> getDelodajalecById(@PathVariable int i) {
		return delodajalecservices.getDelodajalecById(i);
	}
	
	@CrossOrigin(origins="*")
	@DeleteMapping("/delodajalec/deleteDelodajalec/{i}")  //izbrišemo osebo z ID = i metoda "DELETE"
		public String deleteDelodajalec(@PathVariable int i) {
		return delodajalecservices.deleteDelodajalec(i);
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value= "/delodajalec/createDelodajalec", method= RequestMethod.POST) //to je metoda POST
	public String createDelodajalec(@RequestBody delodajalec d) {
		return delodajalecservices.createDelodajalec(d);
	}
		
	 @CrossOrigin(origins="*")
	 @PutMapping("/delodajalec/updateDelodajalec")
	 public String updateDelodajalec(@RequestBody delodajalec d) {
	 return delodajalecservices.updateDelodajalec(d);
	 }
	
//	 @CrossOrigin(origins="*") dodano 9.6
//	 @GetMapping("/delodajalec/getByKraj/{k}")
//	 public Optional<delodajalec> getByKraj(@PathVariable String k) {
//			return delodajalecservices.getByKraj(k);
//		}
	
	
	
	
	
	
	
}
