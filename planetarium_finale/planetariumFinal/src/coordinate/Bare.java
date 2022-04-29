package coordinate;

/**
 * 
 * @author I JAVACHADS
 * 
 * Questa sottoclasse di Punto implementa delle generiche coordinate.
 * Ogni oggetto di tipo coordinate, oltre a una X e una Y, ha un attributo contenente l'origine del sistema di riferimento rispetto al quale
 * sono riferite le coordinate.
 * Sono presenti due costruttori che permettono di scegliere se specificare l'origine o meno.
 * Nel caso non venga specificata l'origine, essa viene settata di default a (0,0)
 *
 */

public class Bare extends Punto{
	
	private Punto origine = new Punto(0,0);

	
	/**
	 * Costruttore con origine. 
	 * 
	 * @param x Coordinata X 
	 * @param y Coordinata Y
	 * @param origine Origine del sistema di riferimento
	 */
	
	public Bare(float x, float y, Punto origine) {
		super(x, y);
		this.origine = origine;
	}

	
	/**
	 * Costruttore senza origine.
	 * 
	 * @param x Coordinata X 
	 * @param y Coordinata Y
	 */

	public Bare(float x, float y) {
		super(x, y);
	}


	
	
	/**
	 * @return L'origine 
	 */
	
	public Punto getOrigine() {
		return origine;
	}

	
	
	/**
	 * Setter per l'origine.
	 * @param origine Nuova origine
	 */
	public void setOrigine(Punto origine) {
		this.origine = origine;
	}
	
	
	/**
	 *  @return Le coordinate in stringa
	 */
	public String toString() {
		String stringaCoordinate;
		stringaCoordinate = String.format("(%.2f ; %.2f)", this.getX() , this.getY());
		if(this.origine.getX() == 0 && this.origine.getY() == 0) { // Se l'origine è 0;0, le coordinate sono assolute
			stringaCoordinate += " --> Assolute";
		}
		else { // altrimenti le coordinate sono relative, stampa quindi anche l'origine
			stringaCoordinate += String.format(" - Origine: (%.2f ; %.2f) --> Relative", this.origine.getX(), this.origine.getY());
		}
		return stringaCoordinate;
	}
	
	


	
	
	
	
	

}
