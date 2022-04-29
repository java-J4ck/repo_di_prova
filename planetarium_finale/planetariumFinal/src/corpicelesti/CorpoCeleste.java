package corpicelesti;



public class CorpoCeleste {
	
	private String id;					// Sigla identificativa della stella 
	private String name;				// Nome del corpo celeste
	private int massa;  				// Massa del corpo celeste 
	
	
	
	/**
	 * Costruttore della classe.
	 * 
	 * @param name Nome del corpo celeste
	 * @param massa Massa del corpo celeste
	 */
	
	public CorpoCeleste(String name, int massa) {
		this.name = name;
		this.massa = massa;
	}

	
	
	/**
	 * @return Il nome del corpo celeste
	 */
	
	public String getName() {
		return name;
	}

	

	/**
	 * @return La massa del corpo celeste
	 */
	
	public int getMassa() {
		return massa;
	}
	
	
	
	/**
	 * Setter per l'id del corpo celeste 
	 *
	 * @param id Id del corpo celeste
	 */
	
	public void setId(String id) {
		this.id = id;
	}
	
	

	/**
	 * @return Il codice identificativo (id) del corpo celeste
	 */
	
	public String getId() {
		return id;
	}
	
	
	

	
	
	
	
	




	
	
	
	
	
	

	
	
	
	
}
