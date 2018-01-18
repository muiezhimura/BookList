package id.ac.booklist.datamodel;

import java.io.Serializable;
import java.util.List;

import id.ac.booklist.service.Action;

public class BukuItem implements Serializable {
	protected String id_buku;
	protected String judul;
	protected int tahun;
	protected Kategori kategori;
	public BukuItem(String id_buku, String judul,Kategori kategori, int tahun) {
		super();
		this.id_buku = id_buku;
		this.judul = judul;
		this.kategori = kategori;
		this.tahun = tahun;
	}
	public String getId_buku() {
		return id_buku;
	}
	public void setId_buku(String id_buku) {
		this.id_buku = id_buku;
	}
	public String getJudul() {
		return judul;
	}
	public void setJudul(String judul) {
		this.judul = judul;
	}
	public int getTahun() {
		return tahun;
	}
	public void setTahun(int tahun) {
		this.tahun = tahun;
	}
	public Kategori getKategori() {
		return kategori;
	}
	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}
	@Override
	public String toString() {
		return "BukuItem [id_buku=" + id_buku + ", judul=" + judul + ", tahun=" + tahun + ", kategori=" + kategori
				+ "]";
	}
	
	
	
	
}
