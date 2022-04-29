package corpicelesti;



import java.util.ArrayList;

import coordinate.Coordinate;



public class Stella extends CorpoCeleste{

	private static int id_num;
	private ArrayList<Pianeta> orbitingPlanets = new ArrayList<Pianeta>();	// ArrayList di pianeti che orbitano attorno alla stella
	private Coordinate absolute_coords = new Coordinate(0, 0);     			// Coordinate della stella, considerata il centro del sistema solare (immutabili)
	
	
	/**
	 * Costruttore della classe.
	 * L'id della stella viene generato in automatico nel formato "Sn", dove n e' il numero di stelle create fin ora. 
	 * 
	 * @param name Nome della stella
	 * @param massa Massa della stella
	 */
	
	public Stella(String name, int massa) {
		super(name, massa);
		this.setId(String.format("S%d", id_num));
		id_num++; 
	}		
	
	
	
	/**
	 * @return Le coordinate assolute della stella (il centro del sistema solare)
	 */
	
	public Coordinate getAbsolute_coords() {
		return absolute_coords;
	}
	
	
	
	/**
	 * Aggiungi un pianeta orbitante attorno alla stella.
	 * 
	 * @param p Pianeta da aggiungere
	 */
	
	public void addOrbitingPlanet(Pianeta p) {
		orbitingPlanets.add(p);
	}
	
	
	
	/**
	 * Rimuovi un pianeta dalla orbita.
	 * 
	 * @param index Indice dell'ArrayList del pianeta da rimuovere
	 */
	public void removeOrbitingPlanet(int index) {
		orbitingPlanets.remove(index);
	}
	
	
	
	/**
	 * Rimuovi un pianeta dalla orbita.
	 * 
	 * @param p Pianeta da rimuovere
	 */
	public void removeOrbitingPlanet(Pianeta p) {
		orbitingPlanets.remove(p);
	}
	
	
	/**
	 * @return ArrayList dei pianeti orbitanti attorno alla stella.
	 */
	public ArrayList<Pianeta> getOrbitingPlanets(){
		return orbitingPlanets;
	}
	
	
	
	
}
