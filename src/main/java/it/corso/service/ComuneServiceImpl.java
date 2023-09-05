package it.corso.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.dao.ComuneDao;
import it.corso.helper.ResponseManager;
import it.corso.model.Comune;
import it.corso.model.Coordinata;

@Service
public class ComuneServiceImpl implements ComuneService
{
	@Autowired
	private ComuneDao comuneDao;
	
	@Override
	public List<Comune> getComuni()
	{
		return (List<Comune>) comuneDao.findAll();
	}

	@Override
	public Comune getComuneByCodiceCatastale(String codiceCatastale)
	{
		Comune comune = comuneDao.findByCodiceCatastale(codiceCatastale);
		if(comune == null)
			return new Comune();
		return comune;
	}
	
	@Override
	public ObjectNode createComune(Comune comune)
	{
		if(comuneDao.findByCodiceCatastale(comune.getCodiceCatastale()) != null)
			return new ResponseManager("406", "Codice Catastale già presente").getResponse();
		comuneDao.save(comune);
		return new ResponseManager("201", "Comune registrato").getResponse();
	}
	
	@Override
	public ObjectNode updateComune(Comune comune)
	{
		Comune esistente = comuneDao.findByCodiceCatastale(comune.getCodiceCatastale());
		if(esistente == null)
			return new ResponseManager("404", "Comune non trovato").getResponse();
		sovrascriviDatiComune(esistente, comune);
		comuneDao.save(esistente);
		return new ResponseManager("202", "Comune aggiornato").getResponse();
	}
	
	private void sovrascriviDatiComune(Comune esistente, Comune ricevuto)
	{
		//sovrascrittura dati Comune
		esistente.setNome(ricevuto.getNome());
		esistente.setProvincia(ricevuto.getProvincia());
		esistente.setCap(ricevuto.getCap());
		esistente.setPrefisso(ricevuto.getPrefisso());
		esistente.setMail(ricevuto.getMail());
		esistente.setPec(ricevuto.getPec());
		esistente.setTelefono(ricevuto.getTelefono());
		esistente.setFax(ricevuto.getFax());
		//acquisizione coordinate e sovrascrittura dati
		Coordinata coordinata = esistente.getCoordinate();
		coordinata.setLat(ricevuto.getCoordinate().getLat());
		coordinata.setLng(ricevuto.getCoordinate().getLng());
		//riassegnazione coordinate modificate al comune
		esistente.setCoordinate(coordinata);
	}

	@Override
	public ObjectNode deleteComune(String codiceCatastale)
	{
		Comune comune = comuneDao.findByCodiceCatastale(codiceCatastale);
		if(comune == null)
			return new ResponseManager("404", "Comune non trovato").getResponse();
		comuneDao.delete(comune);
		return new ResponseManager("202", "Comune eliminato").getResponse();
	}
}