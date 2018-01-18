package id.ac.booklist.service;

import java.util.ArrayList;

import id.ac.booklist.datamodel.BukuItem;

public interface BookColectionService {
	void addBukuItem (BukuItem item) throws BookException;
	void updateBukuItem (BukuItem item) throws BookException;
	void removeBukuItem (BukuItem item) throws BookException;
	ArrayList<BukuItem> getAllBukuItem() throws BookException;
	ArrayList<BukuItem> getBukuItem(String judul) throws BookException;
	ArrayList<BukuItem> getBukuItemByKategori(String kategori) throws BookException;
	
	
//	void addDVDItem(DVDItem item) throws DVDException;
//	void updateDVDItem(DVDItem item) throws DVDException;
//	void removeDVDItem(DVDItem item) throws DVDException;
//	ArrayList<DVDItem> getAllDVDItem() throws DVDException;
//	DVDItem getDVDItem(String title) throws DVDException;
//	ArrayList<DVDItem> getDVDItemByGenre(String genre) throws DVDException;

}
