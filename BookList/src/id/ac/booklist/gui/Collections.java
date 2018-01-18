package id.ac.booklist.gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import id.ac.booklist.datamodel.BukuItem;
import id.ac.booklist.datamodel.Kategori;
import id.ac.booklist.datamodel.TeksBook;
import id.ac.booklist.service.ActionImpement;
import id.ac.booklist.service.BookException;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Collections extends JFrame{
	private JTextField judulField;
	private JTextField pengarangField;
	private JTextField tahunField;
	private JButton btnAdd;
	private JButton btnSortByTitle;
	private JButton btnSortByYear;
	private JTextField SearchField;
	private JButton btnSearch;
	private JComboBox<Kategori> categoriBox;
	private JLabel lblJudul;
	private JLabel lblPengarang;
	private JLabel lblKategori;
	private JLabel lblTahunTerbit;
	private JButton btnSimpan;
	private JList BookList;
	List<BukuItem> items = new ArrayList<>();
	
	public Collections() {
		final ActionImpement as;
		as = ActionImpement.getInstance();
		
		BukuItem bukuitem = new TeksBook("01","Pemrograman",Kategori.INFORMATICS,2018);
		TeksBook bi=(TeksBook)bukuitem;
		bi.setKategori(Kategori.SCIENS);
		bi.setPenerbit("Airlangga");
		bi.setPengarang("Izzuddin");
		
		try {
			as.addBukuItem(bukuitem);
		} catch (BookException e) {
			System.out.println(e);
		}
		
		BukuItem bukuitem2 = new TeksBook("01","Aljabar",Kategori.SCIENS,2018);
		TeksBook bi2=(TeksBook)bukuitem;
		bi2.setKategori(Kategori.SCIENS);
		bi2.setPenerbit("Airlangga");
		bi2.setPengarang("Izzuddin");
		
		
		try {
			as.addBukuItem(bukuitem);
		} catch (BookException e) {
			System.out.println(e);
		}
		
		items.add(bukuitem);
		items.add(bukuitem2);
		System.out.println(items);
		
		CreateUI();
	}
	
	private void CreateUI() {
		// get content pane for attaching GUI components
        Container contentPane = getContentPane();
 
        // enable explicit positioning of GUI components
        contentPane.setLayout(null);
        contentPane.setBackground(Color.GRAY);
		setBackground(Color.GRAY);
		setBounds(new Rectangle(300, 200, 0, 0));		
		setMaximumSize(new Dimension(1400, 800));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 500));
		
		btnAdd = new JButton("Tambah Koleksi");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				judulField.setEnabled(true);
				pengarangField.setEnabled(true);
				tahunField.setEnabled(true);
			}
		});
		btnAdd.setBounds(133, 11, 120, 30);
		contentPane.add(btnAdd);
		
		btnSortByTitle = new JButton("Sort by Judul");
		btnSortByTitle.setBounds(263, 11, 108, 30);
		contentPane.add(btnSortByTitle);
		
		btnSortByYear = new JButton("Sort by Tahun");
		btnSortByYear.setBounds(381, 11, 109, 30);
		contentPane.add(btnSortByYear);
		
		SearchField = new JTextField();
		SearchField.setBackground(Color.WHITE);
		SearchField.setBounds(500, 11, 189, 30);
		SearchField.setColumns(10);
		contentPane.add(SearchField);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				btnSearchAction(event);
			}
		});
		btnSearch.setBounds(685, 11, 89, 30);
		contentPane.add(btnSearch);
		
		BookList = new JList();
		BookList.setBounds(263, 52, 511, 398);
		contentPane.add(BookList);

		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 764, 2);
		contentPane.add(separator);
		
		judulField = new JTextField();
		judulField.setEnabled(false);
		judulField.setBounds(10, 96, 243, 30);
		judulField.setColumns(10);
		contentPane.add(judulField);
		
		pengarangField = new JTextField();
		pengarangField.setEnabled(false);
		pengarangField.setBounds(10, 162, 243, 30);
		pengarangField.setColumns(10);
		contentPane.add(pengarangField);
		
		tahunField = new JTextField();
		tahunField.setEnabled(false);
		tahunField.setBounds(10, 281, 243, 30);
		contentPane.add(tahunField);
		tahunField.setColumns(10);
		
		categoriBox = new JComboBox(Kategori.values());
		categoriBox.setBounds(10, 224, 243, 30);
		contentPane.add(categoriBox);
		
		lblJudul = new JLabel("ISBN");
		lblJudul.setBounds(10, 72, 46, 14);
		contentPane.add(lblJudul);
		
		lblPengarang = new JLabel("JUDUL");
		lblPengarang.setBounds(10, 137, 81, 14);
		contentPane.add(lblPengarang);
		
		lblKategori = new JLabel("KATEGORI");
		lblKategori.setBounds(10, 203, 81, 14);
		contentPane.add(lblKategori);
		
		lblTahunTerbit = new JLabel("TAHUN ");
		lblTahunTerbit.setBounds(10, 265, 81, 14);
		contentPane.add(lblTahunTerbit);
		
		btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				btnSimpanAction(event);
			}
		});
		btnSimpan.setBounds(144, 414, 109, 36);
		contentPane.add(btnSimpan);
		
		setTitle("Book Collections");
		setVisible(true);
	}
	
	//add book implementation here
	private void btnSimpanAction(ActionEvent event) {
		
		judulField.setEnabled(false);
		pengarangField.setEnabled(false);
		tahunField.setEnabled(false);
	}
	
	//get book by implementation here
	private void btnSearchAction(ActionEvent event) {
		
	}
	
	private void displayBookList() {
		
	}
	
	public static void main(String[] args) {
		Collections application = new Collections();
		application.setDefaultCloseOperation(EXIT_ON_CLOSE);
					
	}
}


