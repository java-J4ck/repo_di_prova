package main;


import java.util.Scanner;

import corpicelesti.Luna;
import corpicelesti.Pianeta;

public class GestoreLune {
	
	
	/**
	 * Crea una luna
	 * @param pianetaCuiOrbita Pianeta attorno alla quale la luna orbita
	 * @return Luna creata
	 */
	public static Luna creaLuna(Pianeta pianetaCuiOrbita) {
		String nome;
		int massa;
		String nome_e_massa;
		// Crea la luna
		System.out.println("Creazione della luna...");
		System.out.println("Inserisci una stringa del tipo 'nome-massa' (esempio : Europa-12) ");
		nome_e_massa = Main.LettoreStdin.next();             //  in questa parte, legge da stdin la massa e il nome della luna
		nome_e_massa = nome_e_massa.replace('-',' ');        //  preparo la stringa per lo scanner
		Scanner in2 = new Scanner(nome_e_massa);             //  e con l'utilizzo di scanner inserisco i valori in due variabili
		nome = in2.next();
		massa = in2.nextInt();
		Luna l = new Luna(nome, massa, pianetaCuiOrbita);
		creaCoordinate(l);	
		in2.close();
		return l;
	}
	
	
	/**
	 * Restituisce tutti i dati della luna in stringa
	 * @param luna Luna di cui si desiderano le informazioni
	 * @return Le informazioni sulla luna
	 */
	public static StringBuffer getSchedaLuna(Luna luna) {
		StringBuffer scheda =new StringBuffer("Tipo: Luna ");
		scheda.append(String.format("Nome: %s, id: %s ", luna.getName(),luna.getId()));
		scheda.append(String.format("Massa: %d, Coordinate: %s | %s", luna.getMassa(), luna.getAbsolute_coords().toString(), luna.getRelative_coords().toString()));		
		return scheda;
	}
	
	/**
	 * Crea e setta le coordinate per una nuova luna
	 * @param l La luna a cui bisogna impostare le cordinate
	 */
	
	//	RICORDATI DI CONSIDERARE IL CASO IN CUI LA LUNA SIA TROPPO LONTANA!!!!!!!
	public static void creaCoordinate(Luna l) {
		String coord_e_origine = "", coord = "";
		int x, y;
		Scanner in3;
		System.out.println("Inserisci le coordinate del tipo x;y per coordinate assolute oppure x;y-R per coordinate relative");
		System.out.println("Esempio: 12;40 oppure 23;7-R (le coordinate sono (23;7) ripetto al corpo celeste attorno a cui ruota)");
		coord_e_origine = Main.LettoreStdin.next();
		
	    if((coord_e_origine).toUpperCase().indexOf("-R") == -1) { // se non trova la stringa "-R", significa che l'utente ha inserito le coordinate assolute
	    	coord = coord_e_origine.replace(';', ' '); // preparo la stringa per lo scanner
	    	in3 = new Scanner(coord);
			x = in3.nextInt(); 
			y = in3.nextInt();
			l.setAbsolute_coords(x, y); // leggo le due coordinate e le inserisco nella luna come assolute
			in3.close();
	    }
	    else {
	    	coord = coord_e_origine.replace(';', ' ');
	    	coord = coord.toUpperCase().replace("-R", " "); // leggo le coordinate e le inserisco come relative
	    	in3 = new Scanner(coord);
			x = in3.nextInt(); 
			y = in3.nextInt();
			l.setRelative_coords(x, y); 
			in3.close();
	    }
	}

	

}
