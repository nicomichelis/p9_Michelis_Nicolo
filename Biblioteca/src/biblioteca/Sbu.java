/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe SBU (Sistema Bibliotecario Urbano).
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class Sbu {
    /** Nome del sistema */
    private String nome;
    
    /** Lista di titoli consigliati da utenti (anche non registrati) */
    private List<String> listaConsigli;
    
    /** Associazione fra Sbu e Recensione */
    private List<Recensione> recensioni;
    
    /** Associazione fra Sbu e Biblioteca */
    private List<Biblioteca> biblioteche;
    
    /** Associazione fra Sbu e Persona */
    private List<Persona> utenti;
    
    /**
     * Costruttore di Sbu
     *
     * @param nome nome dell'SBU
     */
	public Sbu(String nome) {
		super();
		this.nome = nome;
		listaConsigli = new ArrayList<String>();
		recensioni = new ArrayList<Recensione>();
		utenti = new ArrayList<Persona>();
		biblioteche = new ArrayList<Biblioteca>();
	}
    
    /**
     * Login (controllo username e password). Ritorna true se email e
     * password corrispondono a quelle di una Persona contenuta nella
     * lista utenti
     *
     * @param email email da controllare
     * @param password password da controllare
     * @return boolean
     */
    public boolean login ( String email, String password ) {
    	for (Persona p: utenti) {
    		if (p.getEmail().equals(email)&&p.getPassword().equals(password)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Ricerca di un articolo a partire da una stringa
     *
     * @param arg stringa di ricerca dell'articolo
     * @return articoli
     */
    public List<Articolo> ricercaArticolo ( String arg ) {
    	List<Articolo> articoli = new ArrayList<Articolo>();
		for (Biblioteca b:biblioteche) {
			for (Articolo a:b.ricercaArticolo(arg)){
				articoli.add(a);
			}
		}
		return articoli;
    }
    
    /**
     * Ricerca di un utente a partire da una stringa
     *
     * @param arg stringa di ricerca della persona
     * @return personeTrovate
     */
    public List<Persona> ricercaUtente ( String arg ) {
    	List<Persona> personeTrovate = new ArrayList<Persona>();
		for(Persona p: utenti) {
			if (p.ricercaPersona(arg)) {
				personeTrovate.add(p);
			}
		}
		return personeTrovate;
    }
    
    /**
     * Inserisce nel sistema un nuovo utente. Ritorna false se
     * utente è gia presente nel sistema, altrimenti true
     *
     * @param utente utente da inserire nel sistema
     * @return boolean
     */
    public boolean inserisciUtente ( Persona utente ) {
    	if (utenti.contains(utente)) {
    		return false;
    	}
    	utenti.add(utente);
    	return true;
    }
    
    /**
     * Rimuove dal sistema un utente esistente. Ritorna false se
     * utente non è presente nel sistema, altrimenti true
     *
     * @param utente utente da rimuovere
     * @return boolean
     */
    public boolean rimuoviUtente ( Persona utente ) {
    	return utenti.remove(utente);
    }

	/**
	 * Gets nome SBU
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets nome SBU
	 * 
	 * @param nome nome dell'SBU
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets lista libri consigliati dagli utenti
	 * 
	 * @return listaConsigli
	 */
	public List<String> getListaConsigli() {
		return listaConsigli;
	}

	/**
	 * Gets lista Recensione
	 * 
	 * @return recensioni
	 */
	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	/**
	 * Gets lista Biblioteca
	 * 
	 * @return biblioteche
	 */
	public List<Biblioteca> getBiblioteche() {
		return biblioteche;
	}

	/**
	 * Gets lista Persona (utenti del sistema)
	 * 
	 * @return utenti
	 */
	public List<Persona> getUtenti() {
		return utenti;
	}
    
}