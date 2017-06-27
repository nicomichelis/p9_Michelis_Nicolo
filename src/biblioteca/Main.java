/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe Main, utile a mostrare le funzionalita'.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class Main {
	/**
     * Main function
     *
     * @param args argomenti
     */
	public static void main(String[] args) {
		System.out.println("Creo nuovo SBU");
		Sbu sistema = new Sbu("nomeSBU");
		System.out.println("Creato");
		// ---
		System.out.println("Creo nuovo Biblioteca");
		Biblioteca b1 = new Biblioteca("nomeBiblioteca", "Via Biblioteca",
				sistema);
		sistema.getBiblioteche().add(b1);
		System.out.println("Creato");
		// ---
		System.out.println("Creo nuovo Libro in Biblioteca1");
		b1.getPossiede().add(new Libro("TitoloL1", "AutoreL1", "GenereL1", 
				"CollocazioneL1", b1, 012345 , "CasaEditriceL1", 123));
		System.out.println("Creato");
		// ---
		System.out.println("Creo nuova Miscellanea in Biblioteca1");
		b1.getPossiede().add(new Miscellanea("TitoloM1", "AutoreM1", "GenereM1", 
				"CollocazioneM1", b1, "TipoM1"));
		System.out.println("Creato");
		// ---
		System.out.println("Creo nuovo UtenteRegistrato");
		sistema.inserisciUtente(new UtenteRegistrato("NomeU1", "CognomeU1", 
				"IndirizzoU1", new Date(), "codiceFiscaleU1", "01234561", 
				"email@U1.it", "pass", sistema));
		System.out.println("Creato");
		// ---
		System.out.println("Creo nuovo ManagerDiSistema");
		sistema.inserisciUtente(new ManagerDiSistema("NomeM1", "CognomeM1", 
				"IndirizzoM1", new Date(), "codiceFiscaleM1", "01234562", 
				"email@M1.it", "pass", sistema));
		System.out.println("Creato");
		// ---
		System.out.println("Creo nuovo Bibliotecario (UC49)");
		sistema.inserisciUtente(new Bibliotecario("NomeB1", "CognomeB1", 
				"IndirizzoB1", new Date(), "codiceFiscaleB1", "01234563", 
				"email@B1.it", "pass", sistema, b1));
		System.out.println("Creato");
		// ---
		System.out.println("Ricerco utente 'Nom' (UC55)");
		String inputRicercaUtente = "Nom";
		List<Persona> trovati = new ArrayList<Persona>();
		trovati = sistema.ricercaUtente(inputRicercaUtente);
		for (Persona p:trovati) {
			System.out.println("Trovato " + p.getNome() + " " 
					+ p.getCognome());
		}
		// ---
		System.out.println("Ricerco Libro di 'Aut' (UC3)");
		String inputRicercaArticolo = "Aut";
		List<Articolo> articoliTrovati = new ArrayList<Articolo>();
		articoliTrovati = sistema.ricercaArticolo(inputRicercaArticolo);
		for (Articolo a:articoliTrovati) {
			System.out.println("Trovato "+ a.getTitolo());
		}
		// ---
		System.out.println("Login utente (UtenteRegistrato) (UC1)");
		String inputEmail = "email@U1.it";
		String inputPass = "pass";
		Persona p = sistema.login(inputEmail, inputPass);
		
		// ---
		System.out.println("Inserimento Recensione di 'NomeU1' "
				+ "in 'TitoloL1' (UC33)");
		UtenteRegistrato recensore = (UtenteRegistrato) p;
		String inputRicerca = "TitoloL1";
		sistema.ricercaArticolo(inputRicerca).get(0).scriviRecensione(
				"TestoR2", recensore);
		System.out.println("Inserito!");
		// ---
		System.out.println("Visualizzazione Recensioni di 'TitoloL1' (UC34)");
		String inputRicercaRecensione = "TitoloL1";
		for (Recensione r: sistema.ricercaArticolo(
				inputRicercaRecensione).get(0).getRecensioni()) {
			System.out.println(r.getAutore().getNome() + " " + 
				r.getAutore().getCognome() + ": " + r.getTesto());
		}
		System.out.println("Fine Recensioni");
		// ---
		System.out.println("Modifica Recensione di 'NomeU1' in "
				+ "'TitoloL1' (UC35)");
		UtenteRegistrato recensore1 = (UtenteRegistrato) p;
		String inputRicerca1 = "TitoloL1";
		sistema.ricercaArticolo(inputRicerca1).get(0).modificaRecensione(
				recensore1, "TestoR2");
		System.out.println("Modificato!");
		// ---
		System.out.println("Prenotazione Articolo 'TitoloL1' da "
				+ "'NomeU1 (UC33)");
		UtenteRegistrato prenotante = (UtenteRegistrato) p;
		String inputRicercaArt = "TitoloL1";
		sistema.ricercaArticolo(inputRicercaArt).get(0).prenota(prenotante);
		System.out.println("Prenotato!");
	}
}
