package id.ac.booklist.datamodel;

import java.util.List;


public class Buku{
	protected String id_buku;
	protected String judul;
	protected int tahun;
	public Buku(String id_buku, String judul, int tahun) {
		super();
		this.id_buku = id_buku;
		this.judul = judul;
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
	
	public String toString() {
		return "BukuItem [ ID=" +id_buku+" judul="+judul+" tahun="+tahun +" ]\n";
	}
	
}
