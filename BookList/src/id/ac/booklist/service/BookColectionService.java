package id.ac.booklist.service;

import java.util.ArrayList;

import id.ac.booklist.datamodel.BukuItem;
import id.ac.booklist.datamodel.Kategori;

public interface BookColectionService {
	void addBukuItem (BukuItem item) throws BookException;
	void updateBukuItem (BukuItem item) throws BookException;
	void removeBukuItem (BukuItem item) throws BookException;
	ArrayList<BukuItem> getAllBukuItem() throws BookException;
	ArrayList<BukuItem> getBukuItem(String judul) throws BookException;
	ArrayList<BukuItem> getBukuItemByKategori(Kategori kategori) throws BookException;
	ArrayList<BukuItem> getSortBukuByJudul() throws BookException;
	ArrayList<BukuItem> getBukuByTahun(int tahun) throws BookException;
}
