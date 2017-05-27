/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Biblioteca.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class Biblioteca {
	/** Nome della biblioteca */
    private String nome;
    
    /** Indirizzo della biblioteca */
    private String indirizzo;
    
    /** SBU di riferimento della biblioteca */
    private Sbu sistema;
    
    /** Lista Articoli posseduti dalla biblioteca */
    private List<Articolo> possiede;
    
    /** Lista Recensione della biblioteca */
	private List<Recensione> recensioni;
    
	/**
     * Costruttore di Biblioteca
     *
     * @param nome nome della biblioteca
     * @param indirizzo indirizzo della biblioteca
     * @param sistema SBU di riferimento della biblioteca
     */
    public Biblioteca(String nome, String indirizzo, Sbu sistema) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.sistema = sistema;
		possiede = new ArrayList<Articolo>();
		recensioni = new ArrayList<Recensione>();
	}

	/**
     * Ricerca un articolo con una determinata stringa
     *
     * @param arg stringa da ricercare
     * @return articoliTrovati
     */
    public List<Articolo> ricercaArticolo ( String arg ) {
    	List<Articolo> articoliTrovati = new ArrayList<Articolo>();
		for (Articolo a:possiede) {
			if (a.ricercaArticolo(arg)){
				articoliTrovati.add(a);
			}
		}
		return articoliTrovati;
    }

	/**
	 * Gets nome biblioteca
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets nome biblioteca
	 * 
	 * @param nome nome della biblioteca
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets indirizzo biblioteca
	 * 
	 * @return indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Sets indirizzo biblioteca
	 * 
	 * @param indirizzo indirizzo biblioteca
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Gets SBU di riferimento
	 * 
	 * @return sistema
	 */
	public Sbu getSistema() {
		return sistema;
	}

	/**
	 * Sets sistema di riferimento
	 * 
	 * @param sistema sistema di riferimento
	 */
	public void setSistema(Sbu sistema) {
		this.sistema = sistema;
	}

	/**
	 * Gets lista Articolo posseduti dalla biblioteca
	 * 
	 * @return possiede
	 */
	public List<Articolo> getPossiede() {
		return possiede;
	}

	/**
	 * Gets lista Recensione della biblioteca
	 * 
	 * @return recensioni
	 */
	public List<Recensione> getRecensioni() {
		return recensioni;
	}
    
}
