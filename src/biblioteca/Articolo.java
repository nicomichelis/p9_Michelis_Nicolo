/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
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
		recensioni = new ArrayList<Recensione>();
	}
    
	/**
     * Ricerca articolo attraverso una stringa
     *
     * @param arg stringa di ricerca dell'articolo
     * @return boolean true se il titolo, autore o genere
     * contengono la stringa, false altrimenti
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
    	/* 
		 * Se l'utente ha gia inserito una recensione viene
		 * rimossa quella precedente ed inserita quella
		 * nuova
		 */
    	for (Iterator<Recensione> iterator = recensioni.iterator(); 
    			iterator.hasNext();) {
    	    Recensione rece = iterator.next();
    	    if (rece.getAutore().equals(recensione.getAutore())) {
    	        iterator.remove();
    	    }
    	}
    	recensioni.add(recensione);
    }
    
    /**
     * Rimozione di una recensione di un utente
     *
     * @param autore autore della recensione da rimuovere
     * @return boolean true se la rimozione e' avvenuta correttamente
     * altrimenti false
     */
    public boolean rimuoviRecensione ( UtenteRegistrato autore ) {
    	for (Iterator<Recensione> iterator = recensioni.iterator(); 
    			iterator.hasNext();) {
    	    Recensione recensione = iterator.next();
    	    if (recensione.getAutore().equals(autore)) {
    	        iterator.remove();
    	        return true;
    	    }
    	}
    	return false;
    }
    
    /**
     * Modifica di una recensione di un utente
     *
     * @param autore autore della recensione da modificare
     * @param recensioneNuova nuova recensione da inserire
     * @return boolean true se la modifica e' avvenuta correttamente
     * false altrimenti
     */
    public boolean modificaRecensione ( UtenteRegistrato autore, 
    		String recensioneNuova ) {
    	if (recensioneNuova.length() > 20) {
    		return false;
    	}
    	for (Iterator<Recensione> iterator = recensioni.iterator(); 
    			iterator.hasNext();) {
    	    Recensione recensione = iterator.next();
    	    if (recensione.getAutore().equals(autore)) {
    	        recensione.setTesto(recensioneNuova);
    	        return true;
    	    }
    	}
    	return false;
    }
    
    /**
     * Prenotazione di un articolo
     *
     * @param utente utente che desidera prenotare
     * @return boolean true se la prenotazione e' avvenuta correttamente
     * false altrimenti
     */
    public boolean prenota ( UtenteRegistrato utente ) {
    	utente.inserisciPrenotazione(this);
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
     * @return boolean true se la rimozione e' avvenuta correttamente
     * false altrimenti
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
     * @return boolean se la recensione e' scritta correttamente
     * false altrimenti
     */
    public boolean scriviRecensione ( String testo, UtenteRegistrato autore){
    	if (testo.length() > 20)
    		return false;
    	Recensione r = new Recensione();
    	r.setAutore(autore);
    	r.setTesto(testo);
    	inserisciRecensione(r);
    	return recensioni.contains(r);
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
	 * @return String
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
	
	/**
	 * Sets prestito.
	 *
	 * @param prestito oggetto prestito
	 */
	public void setPrestito(Prestito prestito) {
		this.prestito = prestito;
	}   
}
