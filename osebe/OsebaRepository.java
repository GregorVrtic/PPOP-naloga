package fis.local.osebe;

import java.util.List;
import fis.local.osebe.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fis.local.oglas.oglas;

public interface OsebaRepository extends JpaRepository<Oseba, Integer>{
	
	//Sporočimo intiteto "Oseba" in tip primay key "Oid = Integery"
	//Za vsako entiteto v DB je svoj Repository!!!!

	//POVEZAVA Z DB preko Services
//	
//	@Query("FROM oseba WHERE poklic=?1")
//	public List<Oseba> getByPoklic(String poklic);
//	
	
}
