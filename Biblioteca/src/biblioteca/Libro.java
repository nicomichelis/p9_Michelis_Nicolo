/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

/**
 * Classe Libro, estende Articolo.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class Libro extends Articolo {
	/** ISBN del libro */
    private int isbn;
    
    /** Casa editrice del libro */
    private String casaEditrice;
    
    /** Numero pagine del libro */
    private int pagine;
	
    /**
     * Costruttore di Libro. Richiama il costruttore di
     * Articolo passandogli i parametri necessari
     *
     * @param titolo titolo del libro
     * @param autore autore del libro
     * @param genere genere del libro
     * @param collocazione collocazione nella biblioteca del libro
     * @param biblio biblioteca di riferimento del libro
     * @param isbn ISBN del libro
     * @param casaEditrice casa editrice del libro
     * @param pagine pagine del libro
     * 
     */
	public Libro(String titolo, String autore, String genere, 
			String collocazione, Biblioteca biblio, int isbn,
			String casaEditrice, int pagine) {
		super(titolo, autore, genere, collocazione, biblio);
		this.isbn = isbn;
		this.casaEditrice = casaEditrice;
		this.pagine = pagine;
	}

	
	/**
	 * Gets isbn.
	 *
	 * @return isbn
	 */
	public int getIsbn() {
		return this.isbn;
	}
	
	/**
	 * Sets isbn.
	 *
	 * @param isbn isbn del libro
	 */
	public void setISBN(int isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * Gets casa editrice.
	 *
	 * @return casaEditrice
	 */
	public String getCasaEditrice() {
		return casaEditrice;
	}
	
	/**
	 * Sets casa editrice.
	 *
	 * @param casaEditrice casa editrice del libro
	 */
	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}
	
	/**
	 * Gets numero di pagine.
	 *
	 * @return pagine
	 */
	public int getPagine() {
		return pagine;
	}
	
	/**
	 * Sets numero pagine.
	 *
	 * @param pagine numero pagine
	 */
	public void setPagine(int pagine) {
		this.pagine = pagine;
	} 
    
    
}