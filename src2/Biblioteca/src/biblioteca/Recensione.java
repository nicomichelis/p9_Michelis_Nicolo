/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

/**
 * Classe Recensione generica. Valida per qualsiasi recensione
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class Recensione {
    /** testo della recensione */
    private String testo;
    
    /** Associazione fra Recensione e UtenteRegistrato */
    private UtenteRegistrato autore;
    
    /**
     * Costruttore di Recensione
     * 
	 * @param testo testo della recensione
	 * @param autore autore della recensione
	 */
	public Recensione(String testo, UtenteRegistrato autore) {
		super();
		this.testo = testo;
		this.autore = autore;
	}

	/**
     * Costruttore di default di Recensione
     * 
	 */
	public Recensione() {
		super();
	}

	/**
	 * Gets testo della recensione.
	 *
	 * @return testo
	 */
	public String getTesto() {
		return testo;
	}

	/**
	 * Sets testo della recensione.
	 *
	 * @param testo testo della recensione
	 */
	public void setTesto(String testo) {
		this.testo = testo;
	}

	/**
	 * Gets autore (UtenteRegistrato) della recensione.
	 *
	 * @return autore
	 */
	public UtenteRegistrato getAutore() {
		return autore;
	}
	
	/**
	 * Sets autore della recensione.
	 *
	 * @param autore autore della recensione
	 */
	public void setAutore(UtenteRegistrato autore) {
		this.autore = autore;
	}
}