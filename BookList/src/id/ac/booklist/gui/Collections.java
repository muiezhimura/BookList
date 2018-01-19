package id.ac.booklist.gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import id.ac.booklist.datamodel.BukuItem;
import id.ac.booklist.datamodel.Kategori;
import id.ac.booklist.datamodel.TableModel;
import id.ac.booklist.datamodel.TeksBook;
import id.ac.booklist.service.ActionImpement;
import id.ac.booklist.service.BookException;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTable;

public class Collections extends JFrame{
	private JTextField kodeField;
	private JTextField judulField;
	private JTextField tahunField;
	private JButton btnDisplayAll;
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
	private JTextArea textPesan;
	private JTextArea textDisplay;
	ArrayList<BukuItem> items = new ArrayList<>();
	final ActionImpement as;
	private JTable table;
	private TableModel tb;

	
	public Collections() {
		as = ActionImpement.getInstance();
		CreateUI();
		try {
			items = as.getAllBukuItem();
			 tb = new TableModel(items);
			
		} catch (BookException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		displayBookList();
		
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
		
		btnDisplayAll = new JButton("Tampilkan Semua Koleksi");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnDisplayAll.setBounds(10, 11, 189, 30);
		contentPane.add(btnDisplayAll);
		
		btnSortByTitle = new JButton("Sort by Judul");
		btnSortByTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				btnSortByJudulAct(event);
			}
		});
		btnSortByTitle.setBounds(224, 11, 123, 30);
		contentPane.add(btnSortByTitle);
		
		btnSortByYear = new JButton("Sort by Tahun");
		btnSortByYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSortByYearAct(e);
			}
		});
		btnSortByYear.setBounds(357, 11, 133, 30);
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 764, 2);
		contentPane.add(separator);
		
		kodeField = new JTextField();
		kodeField.setBounds(10, 96, 243, 30);
		kodeField.setColumns(10);
		contentPane.add(kodeField);
		
		judulField = new JTextField();
		judulField.setBounds(10, 162, 243, 30);
		judulField.setColumns(10);
		contentPane.add(judulField);
		
		tahunField = new JTextField();
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
		
		textPesan = new JTextArea();
		textPesan.setLineWrap(true);
		textPesan.setForeground(Color.WHITE);
		textPesan.setFont(new Font("Arial", Font.PLAIN, 14));
		textPesan.setBackground(Color.GRAY);
		textPesan.setBounds(10, 322, 243, 85);
		getContentPane().add(textPesan);
		
		textDisplay = new JTextArea();
		textDisplay.setBounds(275, 65, 499, 385);
		getContentPane().add(textDisplay);
		
		table = new JTable();
		table.setBounds(265, 53, 499, 385);
		getContentPane().add(table);
		
		setTitle("Book Collections");
		setVisible(true);
	}
	
	//Sort By Judul
	private void btnSortByJudulAct(ActionEvent event) {
		try {
			items = as.getSortBukuByJudul();
			displayBookList();
		} catch (BookException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	//Display All Book
	private void btnDisplayAllAct(ActionEvent event) {
		try {
			items = as.getAllBukuItem();
		} catch (BookException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		displayBookList();
	}
	
	//Sort By Year
	private void btnSortByYearAct(ActionEvent event) {
//		try {
//			//items = as.getSortBukuByTahun();
//			displayBookList();
//		} catch (BookException e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
	}
	
	//add book implementation here
	private void btnSimpanAction(ActionEvent event) {

		if (
				!(kodeField.getText().equals("")) &&
				!(judulField.getText().equals("")) &&
				!(tahunField.getText().equals(""))
				) {
			BukuItem itemb = new BukuItem(kodeField.getText(), 
											judulField.getText(), 
											(Kategori)categoriBox.getSelectedItem(), 
											Integer.parseInt(tahunField.getText()));		
		
			try {
				as.addBukuItem(itemb);
				items = as.getAllBukuItem();
				displayBookList();
			} catch (BookException e) {
				System.out.println(e);
			}
		} else {
			textPesan.setText("Terjadi kelahan --- ISBN, Judul, dan Tahun harus diisi!!!");
		}
		kodeField.setText("");
		judulField.setText("");
		tahunField.setText("");
	}
	
	//get book by implementation here
	private void btnSearchAction(ActionEvent event) {
		try {
			items = as.getBukuItem(SearchField.getText());
			displayBookList();
		} catch (BookException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	//displaying Book List
	private void displayBookList() {
		table.setModel(tb);
		
		textDisplay.setText(items.toString());
		
	}
	
	
	public static void main(String[] args) {
		Collections application = new Collections();
		application.setDefaultCloseOperation(EXIT_ON_CLOSE);
					
	}
}
