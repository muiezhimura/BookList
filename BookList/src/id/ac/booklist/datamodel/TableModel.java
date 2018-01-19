package id.ac.booklist.datamodel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	
	ArrayList<BukuItem> bukuitem;
	String [] header = {"ISBN","JUDUL","TAHUN","KATEGORI"};
	
	

	public TableModel(ArrayList<BukuItem> buuitem) {
		super();
		this.bukuitem = buuitem;
	}
	
	public String getColumnName(int col) {
		return header[col];
	}
	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return bukuitem.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		BukuItem entity = null;
		entity= bukuitem.get(rowIndex);
		 
		switch (columnIndex) {
		 
		case 0:
		return entity.getId_buku();
		case 1:
		return entity.getJudul();
		case 2:
		return entity.getTahun();
		case 3:
		return entity.getKategori();
		 
		default :
		
		return "";
		}
	}

}
