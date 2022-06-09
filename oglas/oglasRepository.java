package fis.local.oglas;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface oglasRepository extends JpaRepository<oglas, Integer>{
	
	public List<oglas> findByOsebaPoklic(String s);
		
	@Query("FROM oglas WHERE naslov=?1")
	public List<oglas> getByName(String naslov);

}
