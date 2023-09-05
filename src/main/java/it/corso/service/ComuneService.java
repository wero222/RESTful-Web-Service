package it.corso.service;
import java.util.List;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.model.Comune;

public interface ComuneService
{
	List<Comune> getComuni();
	Comune getComuneByCodiceCatastale(String codiceCatastale);
	ObjectNode createComune(Comune comune);
	ObjectNode updateComune(Comune comune);
	ObjectNode deleteComune(String codiceCatastale);
}