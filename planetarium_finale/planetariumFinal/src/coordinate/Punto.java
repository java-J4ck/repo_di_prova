package coordinate;

/**
 * 
 * Implementa un oggetto rappresentante un punto nel piano.
 * Ogni punto e' caratterizzato da una coordinata X e una Y.
 *
 */

public class Punto {
	
	private float x;
	private float y;
	
	public Punto(float x, float y) {
		this.x = x;
		this.y = y;
	}

	
	/** 
	 * @return X del punto
	 */
	public float getX() {
		return x;
	}

	
	/**
	 * @return Y del punto
	 */
	public float getY() {
		return y;
	}


	/**
	 * Setter per la x del punto
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}

	
	
	/**
	 * Setter per la y del punto
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	
	
	
	

}
