package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.corso.model.Comune;
import it.corso.service.ComuneService;

@RestController
@RequestMapping("/api/comuni")
public class ComuneController
{
	@Autowired
	private ComuneService service;
	
	// endpoint #1: elenco completo comuni  localhost:8080/api/comuni/get
	@GetMapping("/get")
	public List<Comune> getComuni()
	{
		return service.getComuni();
	}
	
	// endpoint #2: ricerca comune per codice catastale  localhost:8080/api/comuni/get/{codiceCatastale}
	@GetMapping("/get/{code}")
	public Comune getComuneByCodiceCatastale(@PathVariable("code") String code)
	{
		return service.getComuneByCodiceCatastale(code);
	}
	
	// endpoint #3: registrazione nuovo comune  localhost:8080/api/comuni/add
	@PostMapping("/add")
	public ObjectNode createComune(@RequestBody Comune comune)
	{
		return service.createComune(comune);
	}
	
	// endpoint #4: aggiornamento dati comune  localhost:8080/api/comuni/update
	@PutMapping("/update")
	public ObjectNode updateComune(@RequestBody Comune comune)
	{
		return service.updateComune(comune);
	}
	
	// endpoint #5: cancellazione comune  localhost:8080/api/comuni/delete/{codiceCatastale}
	@DeleteMapping("/delete/{code}")
	public ObjectNode deleteComune(@PathVariable("code") String code)
	{
		return service.deleteComune(code);
	}
}