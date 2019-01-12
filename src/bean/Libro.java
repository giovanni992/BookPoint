package bean;

import java.io.Serializable;

public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String isbn;
	private String titolo;
	private String trama;
	private String foto;
	private String casaEditrice;
	private double prezzo;
	private int quantit�;
	private String categoria;
	
	
	
	public Libro() {
		super();
	}

	public Libro(String isbn, String titolo, String trama, String foto, String casaEditrice, double prezzo, int quantit�,
			String categoria) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.trama = trama;
		this.foto = foto;
		this.casaEditrice = casaEditrice;
		this.prezzo = prezzo;
		this.quantit� = quantit�;
		this.categoria = categoria;
	}
	
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return this.titolo;
	}

	/**
	 * 
	 * @param titolo
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTrama() {
		return this.trama;
	}

	/**
	 * 
	 * @param trama
	 */
	public void setTrama(String trama) {
		this.trama = trama;
	}

	public String getFoto() {
		return this.foto;
	}

	/**
	 * 
	 * @param foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCasaEditrice() {
		return this.casaEditrice;
	}

	/**
	 * 
	 * @param casaEditrice
	 */
	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	/**
	 * 
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantit�() {
		return this.quantit�;
	}

	/**
	 * 
	 * @param quantit�Disponibile
	 */
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	public String getCategoria() {
		return this.categoria;
	}

	/**
	 * 
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


}