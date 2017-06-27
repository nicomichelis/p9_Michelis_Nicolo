/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.Date;

/**
 * Classe Persona generica. Esteso da ManagerDiSistema e
 * UtenteRegistrato.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public abstract class Persona {
    /** Nome della persona */
    private String nome;
    
    /** Cognome della persona */
    private String cognome;
    
    /** Indirizzo della persona */
    private String indirizzo;
    
    /** Data di nascita della persona */
    private Date dataNascita;
    
    /** Codice Fiscale della persona */
    private String codiceFiscale;
    
    /** Numero di telefono della persona */
    private String telefono;
    
    /** Email della persona, usata per il login */
    private String email;
    
    /** Password della persona, usata per il login */
    private String password;
    
    /** Associazione fra utente e sistema */
    private Sbu sistema;
    
	/**
	 * Costruttore di Persona.
	 *
	 * @param nome il nome della persona
	 * @param cognome il cognome della persona
	 * @param indirizzo l'indirizzo della persona
	 * @param dataNascita la data di nascita della persona
	 * @param codiceFiscale il codice fiscale della persona
	 * @param telefono il numero di telefono della persona
	 * @param email l'indirizzo email della persona
	 * @param password la password della persona
	 * @param sistema l'SBU di riferimento della persona
	 */
	public Persona(String nome, String cognome, String indirizzo, 
			Date dataNascita, String codiceFiscale, String telefono, 
			String email, String password, Sbu sistema) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.sistema = sistema;
	} 
    
    /**
     * Ricerca di una persona a partire da una stringa
     *
     * @param arg stringa di ricerca
     * @return boolean
     */
    public boolean ricercaPersona ( String arg ) {
		if (nome.contains(arg) || cognome.contains(arg)) {
			return true;
		}
		if (codiceFiscale.equals(arg)) {
			return true;
		}
		if (email.equals(arg)) {
			return true;
		}
		return false;
    }
    
	/**
	 * Gets nome.
	 *
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets nome.
	 *
	 * @param nome nome della persona
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets cognome.
	 *
	 * @return cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Sets cognome.
	 *
	 * @param cognome cognome della persona
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Gets indirizzo.
	 *
	 * @return indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Sets indirizzo.
	 *
	 * @param indirizzo indirizzo della persona
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Gets data di nascita.
	 *
	 * @return dataNascita
	 */
	public Date getDataNascita() {
		return dataNascita;
	}

	/**
	 * Sets data di nascita.
	 *
	 * @param dataNascita data di nascita della persona
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * Gets codice fiscale.
	 *
	 * @return codiceFiscale
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * Sets codice fiscale.
	 *
	 * @param codiceFiscale codice fiscale della persona
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Gets numero di telefono.
	 *
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Sets numero di telefono.
	 *
	 * @param telefono numero di telefono della persona
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Gets email.
	 *
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets email.
	 *
	 * @param email email della persona
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets password.
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets password.
	 *
	 * @param password password della persona
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets SBU di riferimento della persona.
	 *
	 * @return sistema
	 */
	public Sbu getSistema() {
		return sistema;
	}

	/**
	 * Sets SBU di riferimento della persona.
	 *
	 * @param sistema sistema di riferimento della persona
	 */
	public void setSistema(Sbu sistema) {
		this.sistema = sistema;
	} 
}