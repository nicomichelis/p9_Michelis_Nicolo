/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.Date;

/**
 * Classe Prestito. Il numero iniziale di rinnovi è NMax (vedi
 * vincolo nel documento SDD). In questa prima versione viene
 * impostato a 3.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class Prestito {
    /** Data di inizio del prestito */
    private Date dataInizio;
    
    /** Data di fine del prestito */
    private Date dataFine;
    
    /** Numero di rinnovi rimasti */
    private int rinnovi;

    /** Associazione fra Prestito e Articolo */
    private Articolo articolo;
    
    /** Associazione fra Predtito e UtenteRegistrato */
    private UtenteRegistrato richiestoDa;
    
    
    /**
     * Costruttore di Prestito.
     * 
	 * @param dataInizio data di inizio del prestito
	 * @param dataFine data di fine del prestito
	 * @param articolo articolo preso in prestito
	 * @param richiestoDa UtenteRegistrato che prende prestito
	 */
	public Prestito(Date dataInizio, Date dataFine, Articolo articolo, 
			UtenteRegistrato richiestoDa) {
		super();
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.rinnovi = 3;
		this.articolo = articolo;
		this.richiestoDa = richiestoDa;
	}

	/**
     * Prolungare il prestito. Se possibile, viene inserita la nuova data
     * di riconsegna, altrimenti viene ritornato falso.
     * 
     * @param dataRiconsegna data di riconsegna del libro
     * @return boolean
     */
    public boolean prolungaPrestito ( Date dataRiconsegna ) {
    	if (this.rinnovi > 0) {
    		this.dataFine = dataRiconsegna;
    		this.rinnovi--;
    		return true;
    	}
    	return false;
    }

	/**
	 * Gets numero rinnovi rimasti
	 * 
	 * @return rinnovi
	 */
	public int getRinnovi() {
		return rinnovi;
	}

	/**
	 * Sets numero rinnovi rimasti
	 * 
	 * @param rinnovi rinnovi rimasti da impostare
	 */
	public void setRinnovi(int rinnovi) {
		this.rinnovi = rinnovi;
	}

	/**
	 * Gets data di inizio
	 * 
	 * @return dataInizio
	 */
	public Date getDataInizio() {
		return dataInizio;
	}

	/**
	 * Gets data di fine
	 * 
	 * @return dataFine
	 */
	public Date getDataFine() {
		return dataFine;
	}

	/**
	 * Gets articolo in prestito
	 * 
	 * @return articolo
	 */
	public Articolo getArticolo() {
		return articolo;
	}

	/**
	 * Gets utente che ha il libro in prestito
	 * 
	 * @return richiestoDa
	 */
	public UtenteRegistrato getRichiestoDa() {
		return richiestoDa;
	}   
}
