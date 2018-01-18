package id.ac.booklist.test;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import id.ac.booklist.datamodel.BukuItem;
import id.ac.booklist.datamodel.Majalah;
import id.ac.booklist.datamodel.Kategori;
import id.ac.booklist.datamodel.TeksBook;
import id.ac.booklist.service.Action;
import id.ac.booklist.service.ActionImpement;
import id.ac.booklist.service.BookException;

public class BukuTest {
	
	public static void main(String[] args)  {
		final ActionImpement as;
		as = ActionImpement.getInstance();
		
		ArrayList<BukuItem> items = new ArrayList<>();
		
		BukuItem bukuitem = new BukuItem("01","Pemrograman",Kategori.INFORMATICS,2017);
		
		try {
			as.addBukuItem(bukuitem);
		} catch (BookException e) {
			System.out.println(e);
		}
		
		BukuItem bukuitem2 = new BukuItem("01","Java",Kategori.INFORMATICS,2018);
		
		try {
			as.addBukuItem(bukuitem2);
		} catch (BookException e) {
			System.out.println(e);
		}
		
		
		
		
		
		
//		try {
//			System.out.println(as.getAllBukuItem().toString());
//		} catch (BookException e) {
//			System.out.println(e);
//		}
		
		
		
		try {
			System.out.println("Hasil Pendarian \n"+ as.getBukuItem("Jb").toString());
		} catch (BookException e) {
			System.out.println(e);
		}
		
		//urutkan berdasarkan judul
		try {
			System.out.println("Hasil Urut \n"+ as.getSortBukuByJudul().toString());
		} catch (BookException e) {
			System.out.println(e);
		}
		
		// cari kategori
		try {
			System.out.println("Hasil kategori \n"+ as.getBukuItemByKategori(Kategori.INFORMATICS).toString());
		} catch (BookException e) {
			System.out.println(e);
		}
		
		// cari kategori
				try {
					System.out.println("Hasil Tahun \n"+ as.getBukuByTahun(2017).toString());
				} catch (BookException e) {
					System.out.println(e);
				}
		
	}

	



	

	

}
