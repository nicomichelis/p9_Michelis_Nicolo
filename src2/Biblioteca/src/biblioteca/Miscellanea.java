/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

/**
 * Classe Miscellanea, estende Articolo.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class Miscellanea extends Articolo {
    /** tipo della miscellanea (CD/DVD/riviste ecc) */
    private String tipo;

    /**
     * Costruttore di Miscellanea. Richiama il costruttore di
     * Articolo passandogli i parametri necessari
     *
     * @param titolo titolo del libro
     * @param autore autore del libro
     * @param genere genere del libro
     * @param collocazione collocazione nella biblioteca del libro
     * @param biblio biblioteca di riferimento del libro
     * @param tipo tipo di miscellanea (CD, DVD, riviste ecc.)
     * 
     */
	public Miscellanea(String titolo, String autore, String genere, 
			String collocazione, Biblioteca biblio, String tipo) {
		super(titolo, autore, genere, collocazione, biblio);
		this.setTipo(tipo);
	}

	/**
	 * Gets tipo miscellanea
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets tipo miscellanea
	 * 
	 * @param tipo tipo di miscellanea (CD/DVD/riviste ecc.)
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
