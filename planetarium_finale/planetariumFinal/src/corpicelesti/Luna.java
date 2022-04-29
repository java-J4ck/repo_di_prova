package corpicelesti;

import coordinate.Bare;
import coordinate.OperazioniCoordinate;
import coordinate.Punto;

public class Luna extends CorpoCeleste{

	private static final int MAX_ORBIT_DISTANCE = 35;
	private static final String WARNING_MSG_COORDS = "Attenzione! La luna e' troppo lontano per poter orbitare attorno al pianeta %s";
	private static int id_num;
	private Bare absolute_coords = new Bare(0, 0);                      // Coordinate del pianeta (rispetto al centro del sistema solare)
	private Bare relative_coords = new Bare(0, 0, new Punto(0, 0));		// Coordinate del corpo celeste rispetto al corpo celeste attorno a cui ruota
	private Pianeta orbitAround;  // Pianeta attorno al quale orbita la luna
	
	
	/**
	 * Costruttore della classe.
	 * L'id della luna viene assegnato in automatico nel formato "xLn", dove n e' il numero delle lune create fin ora e	
	 * x e' l'iniziale del nome del pianeta attorno al quale la luna orbita.
	 * 
	 * @param name Nome della luna
	 * @param massa Massa della luna
	 * @param orbitAround Pianeta attorno al quale orbita la luna
	 */
	
	public Luna(String name, int massa, Pianeta orbitAround) {
		super(name, massa);
		this.orbitAround = orbitAround;
		this.setId(String.format("%cL%d", this.orbitAround.getName().charAt(0), id_num));;
		id_num++;
	}

	

	/**
	 * @return Il pianeta attorno al quale orbita la luna
	 */
	
	public Pianeta getOrbitAround() {
		return orbitAround;
	}
	
	
	
	/**
	 * @return Le coordinate assolute della luna (rispetto al centro del sistema solare)
	 */
	
	public Bare getAbsolute_coords() {
		return absolute_coords;
	}
	
	
	
	/**
	 * Setter per impostare le coordinate assolute della luna.
	 * 
	 * @param x Coordinata X assoluta del corpo celeste
	 * @param y Coordinata Y assoluta del corpo celeste
	 */
	
	public void setAbsolute_coords(float x, float y) {
		if(Math.abs(x - this.orbitAround.getAbsolute_coords().getX()) > MAX_ORBIT_DISTANCE | 
				Math.abs(y - this.orbitAround.getAbsolute_coords().getY()) > MAX_ORBIT_DISTANCE) {       // Verifica se sono state inserite delle coordinate relative improbabili
			System.out.println(String.format(WARNING_MSG_COORDS, this.orbitAround.getName()));
		}
		else {
			// Se vengono modificate (o settate per la prima volta) le coordinate assolute della luna, ricalcola anche le coordinate relative rispetto
			this.absolute_coords.setX(x);		// al pianeta attorno al quale essa orbita.	
			this.absolute_coords.setY(y);
			
			recalcRelative_coords(); 
		}
	}
	
	
	
	private void recalcRelative_coords() {
		this.relative_coords=OperazioniCoordinate.cambioCoordinate(absolute_coords, orbitAround.getAbsolute_coords());
	}
	
	
	
	/**
	 * @return Le coordinate relative della luna (rispetto al pianeta attorno alla quale orbita)
	 */
	
	public Bare getRelative_coords() {
		return relative_coords;
	}
	
	
	
	/**
	 * Setter per impostare le coordinate relative della luna.
	 * Il metodo include una operazione di verifica, la quale si assicura che non siano state inserite delle coordinate
	 * tali per cui la luna sarebbe troppo distante dal pianeta (e dunque impossibilitata di orbitare attorno ad esso).  
	 * 
	 * @param x Coordinata X relativa del pianeta
	 * @param y Coordinata Y relativa del pianeta
	 */
	
	
	public void setRelative_coords(float x, float y) {
		if(x > MAX_ORBIT_DISTANCE | y > MAX_ORBIT_DISTANCE) {       // Verifica se sono state inserite delle coordinate relative improbabili
			System.out.println(String.format(WARNING_MSG_COORDS, this.orbitAround.getName()));
		}
		else {
			// Se vegono modificate (o settate per la prima volta) le coordinate relative della luna, calcola anche 
			this.relative_coords.setX(x);			// le coordinate assolute rispetto al pianeta attorno al quale la luna orbita
			this.relative_coords.setY(y);
			this.relative_coords.setOrigine(this.orbitAround.getAbsolute_coords());
			recalcAbsolute_coords();
		}
	}
	
	
	
	private void recalcAbsolute_coords() {
		this.absolute_coords=OperazioniCoordinate.cambioCoordinate(relative_coords, new Punto(0,0));
	}
	
}
