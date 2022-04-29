package corpicelesti;


import java.util.ArrayList;

import coordinate.Bare;


public class Pianeta extends CorpoCeleste{

	private static final int MAX_ORBIT_DISTANCE = 50;
	private static final String WARNING_MSG_COORDS = "Attenzione! Il pianeta e' troppo lontano per poter orbitare attorno alla stella %s";
	private static int id_num;
	private Bare absolute_coords = new Bare(0, 0);     // Coordinate del pianeta (rispetto al centro del sistema solare) 
	private Stella orbitAround;										// Stella attorno alla quale il pianeta orbita	
	private ArrayList<Luna> orbitingMoons = new ArrayList<Luna>();	// ArrayList di luna che orbitano attorno al pianeta
	
	
	/**
	 * Costruttore della classe.
	 * L'id del pianeta viene assegnato in automatico nel formato "xPn", dove n e' il numero di pianeti creati fin ora e
	 * x e' l'iniziale del nome della stella attorno alla quale il pianeta orbita.
	 * 
	 * @param name Nome del pianeta
	 * @param massa Massa del pianeta
	 * @param orbitAround Stella attorno alla quale il pianeta orbita
	 */
	
	public Pianeta(String name, int massa, Stella orbitAround) {
		super(name, massa);
		this.orbitAround = orbitAround;
		this.setId(String.format("%cP%d", this.orbitAround.getName().charAt(0), id_num));;
		id_num++;
	}

	

	/**
	 * @return La stella attorno alla quale il pianeta orbita
	 */
	
	public Stella getOrbitAround() {
		return orbitAround;
	}
	
	
	
	/**
	 * Aggiungi una luna orbitante attorno al pianeta.
	 * 
	 * @param l Luna da aggiungere
	 */
	
	public void addOrbitingMoon(Luna l) {
		orbitingMoons.add(l);
	}
	
	
	
	/**
	 * Rimuovi una luna dall'orbita del pianeta.
	 * 
	 * @param index Indice dell'ArrayList della luna da rimuovere
	 */
	public void removeOrbitingMoon(int index) {
		orbitingMoons.remove(index);
	}
	
	
	
	/**
	 * Rimuovi una luna dall'orbita del pianeta.
	 * 
	 * @param l Luna da rimuovere
	 */
	public void removeOrbitingMoon(Luna l) {
		orbitingMoons.remove(l);
	}
	
	
	
	/**
	 * @return ArrayList delle luna orbitanti attorno al pianeta
	 */
	public ArrayList<Luna> getOrbitingMoons(){
		return orbitingMoons;
	}
	
	
	
	/**
	 * @return Le coordinate assolute del pianeta (rispetto al centro del sistema solare)
	 */
	
	public Bare getAbsolute_coords() {
		return absolute_coords;
	}

	
	
	/**
	 * Setter per impostare le coordinate assolute del pianeta.
	 * 
	 * @param x Coordinata X assoluta del corpo celeste
	 * @param y Coordinata Y assoluta del corpo celeste
	 */
	
	public void setAbsolute_coords(float x, float y) {
		if(x  > MAX_ORBIT_DISTANCE | y > MAX_ORBIT_DISTANCE) {       // Verifica se sono state inserite delle coordinate relative improbabili
			System.out.println(String.format(WARNING_MSG_COORDS, this.orbitAround.getName()));
		}
		else {
			float tempX = this.absolute_coords.getX();  // Salva temporaneamente le coordinate non aggiornate del pianeta (necessarie al fine di calcolare le nuove coordinate assolute delle lune  
			float tempY = this.absolute_coords.getY();  // che orbitano attorno al pianeta, operazione che va fatta, per motivi progettuali, dopo aver settato le nuove coordinate del pianeta)
			this.absolute_coords.setX(x);
			this.absolute_coords.setY(y);			
			recalc_moons_coords(tempX - x, tempY - y);	// Se viene "spostato" un pianeta, ricalcola le coordinate assolute delle lune che gli orbitano attorno (quelle relative rimangono uguali).													
		}
	}
	
	
	private void recalc_moons_coords(float x, float y) {
		for(Luna l : this.orbitingMoons) {
			l.setAbsolute_coords(l.getAbsolute_coords().getX() - x, l.getAbsolute_coords().getY() - y);
		}
	}
	
	

	
	
	
	
	
	
	
	
	
}
