import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import id.ac.booklist.datamodel.BukuItem;
import id.ac.booklist.datamodel.Majalah;
import id.ac.booklist.datamodel.Kategori;
import id.ac.booklist.datamodel.TeksBook;
import id.ac.booklist.service.Action;

public class BukuTest {
	
	public static void main(String[] args) {
		List<BukuItem> items = new ArrayList<>();
		
		BukuItem bukuitem = new TeksBook("01","Pemrograman",2018);
		TeksBook bi=(TeksBook)bukuitem;
		bi.setKategori(Kategori.SCIENS);
		bi.setPenerbit("Airlangga");
		bi.setPengarang("Izzuddin");
		
		items.add(bukuitem);
		

		BukuItem bukuitem2 = new Majalah("02", "TEMPO", 2017);
		Majalah bi2=(Majalah)bukuitem2;
		
		
		items.add(bukuitem2);
		
		BukuItem bukuitem3 = new TeksBook("03","Java",2010);
		items.add(bukuitem3);
		
		System.out.println(items.toString());
		
		
		for (BukuItem item: items) {
			
			Pattern pattern = Pattern.compile("a");
	        Matcher matcher = pattern.matcher(item.getJudul());
			
			if (matcher.find()) {
				System.out.println("KETEMU");
			} else {
				System.out.println("Tidak ketemu");
			}
		}
		
		
	}

	



	

	

}
