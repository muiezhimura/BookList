package id.ac.booklist.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	public static void main(String[] args) throws BookException  {
		final ActionImpement as;
		ArrayList<BukuItem> arraylist = null ;
		as = ActionImpement.getInstance();
		
		ArrayList<BukuItem> items = new ArrayList<>();
		
		BukuItem bukuitem = new BukuItem("09","Pengabdian Masyarakat",Kategori.SOCIAL,2010);
		
		try {
			as.addBukuItem(bukuitem);
		} catch (BookException e) {
			System.out.println(e);
		}
//		
//		BukuItem bukuitem2 = new BukuItem("01","Java",Kategori.INFORMATICS,2018);
//		
//		try {
//			as.addBukuItem(bukuitem2);
//		} catch (BookException e) {
//			System.out.println(e);
//		}
//		
//		
//		as.TulisFile(as.getAllBukuItem());
		
		
        for(BukuItem tmp: as.BacaFile()){
            System.out.println("Baca File "+tmp.toString());
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
		
		// cari tahun
				try {
					System.out.println("Hasil Tahun \n"+ as.getBukuByTahun(2017).toString());
				} catch (BookException e) {
					System.out.println(e);
				}
		
	}

	



	

	

}
