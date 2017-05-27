/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Articolo generico. Esteso da Miscellanea e Libro.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public abstract class Articolo {
    /** Titolo dell'articolo */
    private String titolo;
    
    /** Autore dell'articolo */
    private String autore;
    
    /** Genere dell'articolo */
    private String genere;
    
    /** Collocazione all'interno della biblioteca dell'articolo */
    private String collocazione;
    
    /** Associazione fra Articolo e Recensione */
    private List<Recensione> recensioni;
    
    /** Associazione fra Articolo e Biblioteca di appartenenza */
    private Biblioteca biblio;
    
    /** 
     * Associazione fra Articolo e UtenteRegistrato per
     * la gestione delle prenotazioni
     */
    private List<UtenteRegistrato> prenotato;
    
    /** 
     * Associazione fra Articolo e Prestito per la gestione 
     * dei prestiti
     */
    private Prestito prestito;
    
    /**
     * Costruttore di Articolo
     *
     * @param titolo titolo dell'articolo
     * @param autore autore dell'articolo
     * @param genere genere dell'articolo
     * @param collocazione collocazione nella biblioteca dell'articolo
     * @param biblio biblioteca di riferimento dell'articolo
     */
    public Articolo(String titolo, String autore, String genere, 
    				String collocazione, Biblioteca biblio) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.collocazione = collocazione;
		this.biblio = biblio;
		prenotato = new ArrayList<UtenteRegistrato>();
	}
    
	/**
     * Ricerca articolo attraverso una stringa
     *
     * @param arg stringa di ricerca dell'articolo
     * @return boolean
     */
    public boolean ricercaArticolo ( String arg ) {
		if ((this.titolo.contains(arg)) 
				|| (this.autore.contains(arg)) 
				|| (this.genere.contains(arg))) {
			return true;
		}
		return false;
    }
    
    /**
     * Inserimento di una recensione
     *
     * @param recensione recensione contiene la recensione e l'autore
     */
    public void inserisciRecensione ( Recensione recensione ) {
    	for (Recensione r: recensioni) {
    		if (r.getAutore().equals(recensione.getAutore())) {
    			
    			/* 
    			 * Se l'utente ha già inserito una recensione viene
    			 * rimossa quella precedente ed inserita quella
    			 * nuova
    			 */
    			recensioni.remove(r);
    		}
    	}
    	recensioni.add(recensione);
    }
    
    /**
     * Rimozione di una recensione di un utente
     *
     * @param autore autore della recensione da rimuovere
     */
    public void rimuoviRecensione ( UtenteRegistrato autore ) {
    	for (Recensione r: recensioni) {
    		if (r.getAutore().equals(autore)) {
    			this.recensioni.remove(r);
    		}
    	}
    }
    
    /**
     * Prenotazione di un articolo
     *
     * @param utente utente che desidera prenotare
     * @return boolean
     */
    public boolean prenota ( UtenteRegistrato utente ) {
    	if (this.prenotato.contains(utente)) {
    		return false;
    	}
    	prenotato.add(utente);
    	return true;
    }
    
    /**
     * Rimuove la prenotazione di un determinato utente
     *
     * @param utente utente del quale si vuole rimuovere la recensione
     * @return boolean
     */
    public boolean rimuoviPrenotazione ( UtenteRegistrato utente ) {
    	if (this.prenotato.contains(utente)) {
    		this.prenotato.remove(utente);
    		return true;
    	}
    	return false;
    }
    
    /**
     * Inserimento di una nuova Recensione da parte di un
     * Utente Registrato
     *
     * @param testo testo nuova recensione
     * @param autore autore nuova recensione
     */
    public void scriviRecensione ( String testo, UtenteRegistrato autore){
    	Recensione r = new Recensione(testo, autore);
    	inserisciRecensione(r);
    }
    
    
	/**
	 * Gets titolo.
	 *
	 * @return titolo
	 */
	public String getTitolo() {
		return titolo;
	}
	
	/**
	 * Sets titolo.
	 *
	 * @param titolo titolo dell'articolo 
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	/**
	 * Gets autore.
	 *
	 * @return autore
	 */
	public String getAutore() {
		return autore;
	}
	
	/**
	 * Sets autore.
	 *
	 * @param autore autore dell'articolo
	 */
	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	/**
	 * Gets genere.
	 *
	 * @return genere
	 */
	public String getGenere() {
		return genere;
	}
	
	/**
	 * Sets genere.
	 *
	 * @param genere genere dell'articolo
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	/**
	 * Gets collocazione.
	 *
	 * @return collocazione
	 */
	public String getCollocazione() {
		return collocazione;
	}
	
	/**
	 * Sets collocazione.
	 *
	 * @param collocazione collocazione dell'articolo
	 */
	public void setCollocazione(String collocazione) {
		this.collocazione = collocazione;
	}
	
	/**
	 * Gets lista recensioni.
	 *
	 * @return recensioni
	 */
	public List<Recensione> getRecensioni() {
		return recensioni;
	}
	
	/**
	 * Gets biblioteca di riferimento.
	 *
	 * @return biblio
	 */
	public Biblioteca getBiblio() {
		return biblio;
	}
	
	/**
	 * Sets biblioteca di riferimento.
	 *
	 * @param biblio biblioteca di riferimento
	 */
	public void setBiblio(Biblioteca biblio) {
		this.biblio = biblio;
	}
	
	/**
	 * Gets lista prenotazioni.
	 *
	 * @return prenotato
	 */
	public List<UtenteRegistrato> getPrenotato() {
		return prenotato;
	}
	
	/**
	 * Gets prestito.
	 *
	 * @return prestito
	 */
	public Prestito getPrestito() {
		return prestito;
	}   
}
