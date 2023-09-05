package it.corso.helper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ResponseManager
{
	private ObjectMapper mapper;
	private String code;
	private String message;
	
	public ResponseManager(String code, String message)
	{
		mapper = new ObjectMapper();
		this.code = code;
		this.message = message;
	}
	
	public ObjectNode getResponse()
	{
		ObjectNode response = mapper.createObjectNode();
		response.put("code", this.code);
		response.put("message", this.message);
		return response;
	}
}