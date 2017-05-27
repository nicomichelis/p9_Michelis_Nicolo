/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.Date;

/**
 * Classe ManagerDiSistema, estende Persona.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class ManagerDiSistema extends Persona {
	/**
     * Costruttore di ManagerDiSistema. Richiama il costruttore di
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
     */
	public ManagerDiSistema(String nome, String cognome, 
			String indirizzo, Date dataNascita, String codiceFiscale, 
			String telefono, String email, String password, Sbu sistema) {
		super(nome, cognome, indirizzo, dataNascita, codiceFiscale, 
				telefono, email, password, sistema);
	}
}
