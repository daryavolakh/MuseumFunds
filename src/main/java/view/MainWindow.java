package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.Controller;

public class MainWindow {
	public JFrame frame = new JFrame();
	public Controller controller;
	public TableComponent table = new TableComponent(controller);
	public JPanel mainPanel = new JPanel();

	public MainWindow(Controller controller) {
		this.controller = controller;
		
		frame.setTitle("Lab 2");
		frame.setSize(700, 670);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);

		JButton buttAdd = new JButton("add");
		JButton buttSearch = new JButton("search");
		JButton buttDelete = new JButton("delete");
		
		Font font = new Font("Verdana", Font.PLAIN, 11);		

		buttAdd.setBounds(125, 50, 70, 20);
		buttSearch.setBounds(200, 50, 80, 20);
		buttDelete.setBounds(285, 50, 80, 20);

		mainPanel.setBounds(40, 90, 600, 800);
		mainPanel.add(table);		

		frame.add(buttAdd);
		frame.add(buttSearch);
		frame.add(buttDelete);
		frame.add(mainPanel);

		buttAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				add();
			}
		});

		buttDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				delete();
			}
		});

		buttSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				search();
			}
		});
	}

	public void add() {
		AddDialog dialog = new AddDialog(MainWindow.this, controller);
		dialog.show();
		dialog.setInfo();
	}

	public void delete() {
		Selected selected = new Selected(MainWindow.this, controller, true);
		selected.searchStud();
		selected.show();
	}

	public void search() {
		Selected selected = new Selected(MainWindow.this, controller, false);
		selected.searchStud();
		selected.show();
	}


	public void update() {		
		mainPanel.removeAll();
		TableComponent table = new TableComponent(controller);
		
		mainPanel.add(table);	
		//table.update(controller.getStudents());
	}

	public void show() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
