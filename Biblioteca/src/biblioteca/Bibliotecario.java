/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.Date;

/**
 * Classe Bibliotecario, estende Persona.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class Bibliotecario extends Persona {
	/** Relazione tra Bibliotecario e Biblioteca */
    private Biblioteca bibliotecaRiferimento;
    
    /**
     * Costruttore di Bibliotecario. Richiama il costruttore di
     * Persona passandogli i parametri necessari
     *
     * @param nome nome del bibliotecario
     * @param cognome cognome del bibliotecario
     * @param indirizzo indirizzo del bibliotecario.
     * @param dataNascita data di nascita del bibliotecario
     * @param codiceFiscale codice fiscale del bibliotecario
     * @param telefono numero di telefono del bibliotecario
     * @param email email del bibliotecario, usata per il login
     * @param password password del bibliotecario, usata per il login
     * @param sistema SBU di riferimento del bibliotecario
     * @param biblioteca Biblioteca di riferimento del bibliotecario
     */
    public Bibliotecario(String nome, String cognome, String indirizzo, 
    		Date dataNascita, String codiceFiscale, String telefono, 
    		String email, String password, Sbu sistema, 
    		Biblioteca biblioteca) {
		super(nome, cognome, indirizzo, dataNascita, codiceFiscale, 
				telefono, email, password, sistema);
		this.setBibliotecaRiferimento(biblioteca);
	}

    /**
	 * Gets biblioteca di riferimento
	 * 
	 * @return bibliotecaRiferimento
	 */
	public Biblioteca getBibliotecaRiferimento() {
		return bibliotecaRiferimento;
	}

	/**
	 * Sets biblioteca di riferimento
	 * 
	 * @param bibliotecaRiferimento biblioteca di riferimento
	 */
	public void setBibliotecaRiferimento(Biblioteca bibliotecaRiferimento) {
		this.bibliotecaRiferimento = bibliotecaRiferimento;
	}

	
}
