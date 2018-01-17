import java.util.ArrayList;
import java.util.List;

import id.ac.booklist.datamodel.BukuItem;
import id.ac.booklist.datamodel.Majalah;
import id.ac.booklist.datamodel.Kategori;
import id.ac.booklist.datamodel.TeksBook;
import id.ac.booklist.service.Action;

public class BukuTest implements Action {
	
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
		
		
		
//		System.out.println(checkObject(items));
		System.out.println(items.toString());
		
		
	}

	@Override
	public void cariBuku(BukuItem buku) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBuku(BukuItem buku) {
		// TODO Auto-generated method stub
		
	}
	
	public static String checkObject(List<BukuItem> items2) {
		
		if (items2 instanceof TeksBook) {
			return "Buku Cetak";
		} else {
			return "Majalah";
		}
		
	}
	

}
