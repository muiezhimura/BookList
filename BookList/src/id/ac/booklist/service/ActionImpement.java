package id.ac.booklist.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import id.ac.booklist.datamodel.BukuItem;

public class ActionImpement implements BookColectionService {
	private ArrayList<BukuItem> bukuitems;
	private final static ActionImpement instance = new ActionImpement();
	
	/// input data
	
	
	public static ActionImpement getInstance() {
		return instance;
	}

	public ActionImpement() {
		bukuitems = new ArrayList<>();
	}

	@Override
	public void addBukuItem(BukuItem item) throws BookException {
		boolean found = bukuitems.contains(item);
		if(!found) {
			bukuitems.add(item);
		} else {
			throw new BookException(item.getJudul() + " sudah terdaftar");
		}	
	}

	@Override
	public void updateBukuItem(BukuItem item) throws BookException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBukuItem(BukuItem item) throws BookException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BukuItem> getAllBukuItem() throws BookException {
		return bukuitems;
	}

	@Override
	public ArrayList<BukuItem> getBukuItem(String judul) throws BookException {
		int a=0;		
		ArrayList<BukuItem> resultitems = new ArrayList();
		
		for (BukuItem item: bukuitems) {			
			Pattern pattern = Pattern.compile(judul);
			Matcher matcher = pattern.matcher(item.getJudul());
			
			if (matcher.find()) {
				resultitems.add(item);
				a++;
			}
		}
		
		if (a>0) {
			return resultitems;
		} else {
			throw new BookException(" Tidak ditemukan buku dengan judul "+ judul);
		}		
	}

	@Override
	public ArrayList<BukuItem> getBukuItemByKategori(String kategori) throws BookException{
		// TODO Auto-generated method stub
		return null;
	}

}
