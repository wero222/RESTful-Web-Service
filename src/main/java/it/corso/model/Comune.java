package it.corso.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comuni")
public class Comune
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "codice_catastale")
	private String codiceCatastale;
	
	@Column(name = "provincia")
	private String provincia;
	
	@Column(name = "cap")
	private String cap;
	
	@Column(name = "prefisso")
	private String prefisso;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "pec")
	private String pec;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "fax")
	private String fax;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_coordinata", referencedColumnName = "id")
	private Coordinata coordinate;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getCodiceCatastale()
	{
		return codiceCatastale;
	}
	public void setCodiceCatastale(String codiceCatastale)
	{
		this.codiceCatastale = codiceCatastale;
	}
	public String getProvincia()
	{
		return provincia;
	}
	public void setProvincia(String provincia)
	{
		this.provincia = provincia;
	}
	public String getCap()
	{
		return cap;
	}
	public void setCap(String cap)
	{
		this.cap = cap;
	}
	public String getPrefisso()
	{
		return prefisso;
	}
	public void setPrefisso(String prefisso)
	{
		this.prefisso = prefisso;
	}
	public String getMail()
	{
		return mail;
	}
	public void setMail(String mail)
	{
		this.mail = mail;
	}
	public String getPec()
	{
		return pec;
	}
	public void setPec(String pec)
	{
		this.pec = pec;
	}
	public String getTelefono()
	{
		return telefono;
	}
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	public String getFax()
	{
		return fax;
	}
	public void setFax(String fax)
	{
		this.fax = fax;
	}
	public Coordinata getCoordinate()
	{
		return coordinate;
	}
	public void setCoordinate(Coordinata coordinate)
	{
		this.coordinate = coordinate;
	}
}