package it.corso.dao;
import org.springframework.data.repository.CrudRepository;
import it.corso.model.Comune;

public interface ComuneDao extends CrudRepository<Comune, Integer>
{
	Comune findByCodiceCatastale(String codiceCatastale);
}