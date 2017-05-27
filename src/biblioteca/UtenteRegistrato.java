/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe UtenteRegistrato, estende Persona.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class UtenteRegistrato extends Persona {
	/** Associazione fra UtenteRegistrato e Prestito */
    private List<Prestito> prestiti;
    
    /** Associazione fra UtenteRegistrato e Articolo */
    private List<Articolo> prenotazioni;
    
    /**
     * Costruttore di UtenteRegistrato. Richiama il costruttore di
     * Persona passandogli i parametri necessari
     *
     * @param nome nome dell'utente
     * @param cognome cognome dell'utente
     * @param indirizzo indirizzo dell'utente.
     * @param dataNascita data di nascita dell'utente
     * @param codiceFiscale codice fiscale dell'utente
     * @param telefono numero di telefono dell'utente
     * @param email email dell'utente, usata per il login
     * @param password password dell'utente, usata per il login
     * @param sistema SBU di riferimento dell'utente
     */
    public UtenteRegistrato(String nome, String cognome, String indirizzo, 
    		Date dataNascita, String codiceFiscale, String telefono, 
    		String email, String password, Sbu sistema) {
		super(nome, cognome, indirizzo, dataNascita, codiceFiscale, 
				telefono, email, password, sistema);
		prestiti = new ArrayList<Prestito>();
		prenotazioni = new ArrayList<Articolo>();
	}
    
    /**
     * Inserisce una prenotazione effettuata. Ritorna false se
     * prenotazione è gia presente, altrimenti true
     *
     * @param articolo articolo prenotato
     * @return boolean
     */
    public boolean inserisciPrenotazione ( Articolo articolo ) {
    	if (prenotazioni.contains(articolo)) {
    		return false;
    	}
    	prenotazioni.add(articolo);
    	return true;
    }
    
    /**
     * Rimuove una prenotazione effettuata. Ritorna false se
     * articolo non è presente in prenotazioni, altrimenti true
     *
     * @param articolo articolo da rimuovere
     * @return boolean
     */
    public boolean rimuoviPrenotazione ( Articolo articolo ) {
    	return prenotazioni.remove(articolo);
    }

	/**
	 * Gets lista prestiti
	 * 
	 * @return prestiti
	 */
	public List<Prestito> getPrestiti() {
		return prestiti;
	}

	/**
	 * Gets lista prenotazioni
	 * 
	 * @return prenotazione
	 */
	public List<Articolo> getPrenotazioni() {
		return prenotazioni;
	}   
}
