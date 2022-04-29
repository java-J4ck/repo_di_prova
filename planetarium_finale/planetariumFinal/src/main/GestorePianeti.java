package main;


import java.util.Scanner;

import corpicelesti.Luna;
import corpicelesti.Pianeta;
import corpicelesti.Stella;


public class GestorePianeti {
	
	
	/**
	 * Crea una pianeta
	 * @param stella Stella attorno al quale il pianeta orbita
	 * 
	 */
	public static Pianeta creaPianeta(Stella stella) {
		String nome;
		int massa;
		String nome_e_massa;
		// Crea il pianeta
		System.out.println("Creazione del pianeta..."); // Stesso procedimento di creaLuna
		System.out.println("Inserisci una stringa del tipo 'nome-massa' (esempio : mercurio-30) ");
		nome_e_massa = Main.LettoreStdin.next();
		nome_e_massa = nome_e_massa.replace('-',' ');
		Scanner in2 = new Scanner(nome_e_massa);
		nome = in2.next();
		massa = in2.nextInt();
		Pianeta p = new Pianeta(nome, massa, stella);
		creaCoordinate(p);
		in2.close();
		return p;
		
	}
	

	/**
	 * Ritorna i dati del pianeta in stringa
	 * @param pianeta Pianeta su cui si voglio avere informazioni
	 * @return Scheda del pianeta
	 */
	public static StringBuffer getSchedaPianeta(Pianeta pianeta) {
		StringBuffer scheda =new StringBuffer("Tipo: pianeta  ");
		scheda.append(String.format("Nome: %s, id: %s  ", pianeta.getName(), pianeta.getId()));
		scheda.append(String.format("Massa: %d, Coordinate: %s  ", pianeta.getMassa(), pianeta.getAbsolute_coords().toString()));
		scheda.append(String.format("Numero di lune orbitanti: %d", pianeta.getOrbitingMoons().size()));
		
		return scheda;
	}
	
	/**
	 * Crea e setta le coordinate per il pianeta
	 * @param p Pianeta di cui si vogliono impostare le coordinate
	 */
	public static void creaCoordinate(Pianeta p) {
		String coord_e_origine = "", coord = "";
		int x, y;
		Scanner in3;
		System.out.println("Inserisci le coordinate nel formato x;y");
		System.out.println("Esempio: 12;40");
		coord_e_origine = Main.LettoreStdin.next();
					
    	coord = coord_e_origine.replace(';', ' ');
    	in3 = new Scanner(coord);
		x = in3.nextInt(); 
		y = in3.nextInt();
		p.setAbsolute_coords(x, y);
		in3.close();
	   
	}
	
	
	/**
	 * Restituisci la lista delle luna di un pianeta
	 * 
	 * @param pianeta
	 * @return
	 */
	
	public static StringBuffer getListaLune(Pianeta pianeta) { // visualizza tutte le lune di un pianeta
		StringBuffer lista=new StringBuffer("Lune orbitanti:\n");
		for(Luna luna: pianeta.getOrbitingMoons()) {
			lista.append(String.format("-%s\n", GestoreLune.getSchedaLuna(luna)));
		}
		
		return lista;
	}
	
	
	
}
