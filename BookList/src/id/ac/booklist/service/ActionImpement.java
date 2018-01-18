package id.ac.booklist.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import id.ac.booklist.datamodel.BukuItem;
import id.ac.booklist.datamodel.Kategori;
import id.ac.booklist.datamodel.TeksBook;

public class ActionImpement implements BookColectionService, Serializable{
	private ArrayList<BukuItem> bukuitems;
	private ArrayList<Object> objectitems;
	private final static ActionImpement instance = new ActionImpement();
	
	public static ActionImpement getInstance() {
		return instance;
	}

	public ActionImpement() {
		bukuitems = new ArrayList<>();
		try {
			bukuitems = BacaFile();	
		} catch (Exception e) {
			//throw new BookException(" File tidak ditemukan");	
		}	
	}

	@Override
	public void addBukuItem(BukuItem item) throws BookException  {
		ArrayList<BukuItem> AlBi = new ArrayList<>();
		try {
			AlBi = BacaFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean found = AlBi.contains(item);
		if(!found) {
			AlBi.add(item);
		} else {
			throw new BookException(item.getJudul() + " sudah terdaftar");
		}	
		TulisFile(AlBi);
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
	public ArrayList<BukuItem> getBukuItemByKategori(Kategori kategori) throws BookException{
		
		int a=0;		
		ArrayList<BukuItem> resultitems = new ArrayList();
		
		for (BukuItem item: bukuitems) {
			if (item.getKategori()==kategori) {
				resultitems.add(item);
				a++;
			}
		}
		
		if (a>0) {
			return resultitems;
		} else {
			
			throw new BookException(" Tidak ditemukan buku dengan kategori "+ kategori);
		}		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BukuItem> getSortBukuByJudul() throws BookException {
		/*
		 * Labmda Expression ArrayList.sort
		 */
		bukuitems.sort(Comparator.comparing(BukuItem::getJudul));
		return bukuitems;
	}

	@Override
	public ArrayList<BukuItem> getBukuByTahun(int tahun) throws BookException {
		int a=0;		
		ArrayList<BukuItem> resultitems = new ArrayList();
		
		for (BukuItem item: bukuitems) {
			if (item.getTahun()==tahun) {
				resultitems.add(item);
				a++;
			}
		}
		
		if (a>0) {
			return resultitems;
		} else {
			
			throw new BookException(" Tidak ditemukan buku dengan tahun "+ tahun);
		}	
	}

	@Override
	public void TulisFile(ArrayList<BukuItem> items) throws BookException {
		FileOutputStream fos = null;
        ObjectOutputStream oos = null;
 
        try {
            // for writing or saving binary data
            fos = new FileOutputStream("ArrayListOfCustomer.ser");
 
            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);
 
            // writing or saving ArrayList values to stream
            oos.writeObject(items);
            oos.flush();
            oos.close();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
		
	}

	@Override
	public ArrayList<BukuItem> BacaFile() throws FileNotFoundException {
		
		ArrayList<BukuItem> arraylist=null;
		FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        // creating List reference to hold AL values after de-serialization 
        
        File file = new File("ArrayListOfCustomer.ser");     
        try {
        		if (file.exists()) { 
	            fis = new FileInputStream(file);
	            ois = new ObjectInputStream(fis);
	            arraylist = (ArrayList<BukuItem>) ois.readObject(); 
	        } else {
	        	    FileOutputStream fos = new FileOutputStream("ArrayListOfCustomer.ser");
	        	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.flush();
	            oos.close();
	        }
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
 
        
        return arraylist;
	}
	

}
