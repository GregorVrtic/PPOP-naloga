package fis.local.delodajalci;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DelodajalecRepository extends JpaRepository<delodajalec, Integer> {
	
	@Query("FROM delodajalec WHERE delavnoMesto =?1")
	public List<delodajalec> getByDelavnoMesto(String delavnoMesto);
	
	@Query("FROM delodajalec WHERE kraj =?1")
	public List<delodajalec> getByKraj(String kraj);

}
