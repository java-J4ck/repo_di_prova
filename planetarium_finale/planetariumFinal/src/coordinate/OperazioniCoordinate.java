package coordinate;



public class OperazioniCoordinate {
	
	/**
	 * Riceve in ingresso due punti, e restituisce le coordinate del primo punto rispetto all'altro (considerato quindi come origine)
	 * 
	 * @param punto Punto 
	 * @param origine Origine
	 * @return coordinate Coordinate del punto rispetto all'origine
	 */
	
	public static Coordinate getCoordinate(Punto punto, Punto origine) {
		float x, y;
		// In un sistema di riferimento con assi perpendicolari per trovare le coordinate basta fare la sottrazione delle x e delle y dei punti
		x = punto.getX() - origine.getX();
		y = punto.getY() - origine.getY();
		return new Coordinate(x, y, origine);
	}
	
	
	/**
	 * Riceve in ingresso un oggetto coordinate e restituisce un punto rappresentate le coordinate rispetto all'origine di default (0, 0)
	 *  
	 * @param coord Coordinata
	 * @return punto Punto rappresentate la coordinata rispetto all'origine (0, 0)
	 */
	
	public static Punto getPunto(Coordinate coord) {
		float x, y;
		x = coord.getX() + coord.getOrigine().getX();
		y = coord.getY() + coord.getOrigine().getY();
		return new Punto(x,y);
	}
	
	
	/**
	 * Trasla le coordinate in una nuova origine
	 * @param coord Coordinate da traslare
	 * @param origine Nuova origine
	 * @return Nuove coordinate rispetto alla nuova origine
	 */
	public static Coordinate cambioCoordinate(Coordinate coord, Punto origine) {
		// Prende le coordinate dell'origine vecchia rispetto alla nuova origine
		Coordinate o1 = getCoordinate(coord.getOrigine(), origine);
		float x, y;
		// Per trovare le nuove coordinate di coord rispetto alla nuova origine, sommo le coordinate dell'origine vecchia rispetto alla nuova origine
		// con le coordinate di coord rispetto alla vecchia origine
		x = o1.getX() + coord.getX();
		y = o1.getY() + coord.getY();
		
		return new Coordinate(x,y,origine);
	}
	
	
	
	/**
	 * Calcola la distanza fra due coordinate.
	 * @param c1 Coordinata 1
	 * @param c2 Coordinata 2
	 * @return Distanza fra c1 e c2
	 */
	
	public static float distanzaPunti(Coordinate c1, Coordinate c2) {
		float distanza;
		// Porta entrambi i punti allo stesso sistema di riferimento
		c2 = cambioCoordinate(c2,c1.getOrigine());
		// Uso il teorema di pitagora per trovare la distanza
		distanza = (float) Math.sqrt((Math.pow(c1.getX()-c2.getX(), 2)+Math.pow(c1.getY()-c2.getY(),2)));
		
		return distanza;
	}
	

}
