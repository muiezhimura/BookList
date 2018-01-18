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
		
		BukuItem bukuitem = new TeksBook("01","Pemrograman",2018);
		TeksBook bi=(TeksBook)bukuitem;
		bi.setKategori(Kategori.SCIENS);
		bi.setPenerbit("Airlangga");
		bi.setPengarang("Izzuddin");
		
		
		try {
			as.addBukuItem(bukuitem);
		} catch (BookException e) {
			System.out.println(e);
		}
		
		
		
		BukuItem bukuitem2 = new TeksBook("01","Java",2018);
		TeksBook bi2=(TeksBook)bukuitem;
		bi.setKategori(Kategori.SCIENS);
		bi.setPenerbit("Airlangga");
		bi.setPengarang("Izzuddin");
		
		
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
			System.out.println("Hasil Pendarian \n"+ as.getBukuItem("J").toString());
		} catch (BookException e) {
			System.out.println(e);
		}
		
		
	}

	



	

	

}
