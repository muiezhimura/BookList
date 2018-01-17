package id.ac.booklist.service;

import id.ac.booklist.datamodel.BukuItem;

public interface Action {
	void cariBuku(BukuItem buku);
	void editBuku(BukuItem buku);
}
