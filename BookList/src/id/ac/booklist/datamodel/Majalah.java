package id.ac.booklist.datamodel;

import id.ac.booklist.service.Action;

public class Majalah extends BukuItem implements Action{	
	private String id_buku;
	private String judul;
	private int tahun;
	
	private int tanggal;
	private int bulan;
	
	public Majalah (String id_buku, String judul, int tahun) {
		super(id_buku, judul, tahun);	
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

	@Override
	public void cariBuku(BukuItem buku) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBuku(BukuItem buku) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
