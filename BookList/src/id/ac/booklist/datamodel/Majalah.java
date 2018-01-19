package id.ac.booklist.datamodel;

import java.util.List;


public class Majalah extends BukuItem {	
	private String id_buku;
	private String judul;
	private int tahun;
	private Kategori kategori;
	
	private int tanggal;
	private int bulan;
	
	public Majalah (String id_buku, String judul,Kategori kategori , int tahun) {
		super(id_buku, judul, kategori, tahun);	
	}

	public int getTahun() {
		return tahun;
	}

	public void setTahun(int tahun) {
		this.tahun = tahun;
	}

	public int getTanggal() {
		return tanggal;
	}

	public void setTanggal(int tanggal) {
		this.tanggal = tanggal;
	}

}
