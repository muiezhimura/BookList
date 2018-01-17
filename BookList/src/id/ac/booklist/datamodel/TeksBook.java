package id.ac.booklist.datamodel;

import id.ac.booklist.service.Action;

public class TeksBook extends BukuItem implements Action{
	private String id_buku;
	private String judul;
	private int tahun;
	

	private Kategori kategori;
	private String pengarang;
	private String isbn;
	private String penerbit;
	
	public TeksBook (String id_buku, String judul, int tahun) {
		super(id_buku, judul, tahun);	
	}

	public String getPengarang() {
		return pengarang;
	}

	public void setPengarang(String pengarang) {
		this.pengarang = pengarang;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPenerbit() {
		return penerbit;
	}

	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}
	
	public Kategori getKategori() {
		return kategori;
	}
	
	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	@Override
	public void cariBuku(BukuItem buku) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBuku(BukuItem buku) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
