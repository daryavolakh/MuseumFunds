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
	public TableComponent table;
	public TableComponent tableMovement;
	public JPanel mainPanel = new JPanel();

	public MainWindow(Controller controller) {
		this.controller = controller;
		table = new TableComponent(controller);
		table.updateTableExhibitions();
		
		frame.setTitle("Lab 2");
		frame.setSize(700, 670);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);

		JButton buttAdd = new JButton("add");
		JButton buttEdit = new JButton("edit");
		JButton buttDelete = new JButton("delete");
		
		Font font = new Font("Verdana", Font.PLAIN, 11);		

		buttAdd.setBounds(125, 50, 70, 20);
		buttEdit.setBounds(200, 50, 80, 20);
		buttDelete.setBounds(285, 50, 80, 20);

		mainPanel.setBounds(40, 90, 600, 800);
		mainPanel.add(table);		

		frame.add(buttAdd);
		frame.add(buttEdit);
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

		buttEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				edit();
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
		//selected.editStud();
		selected.show();
	}

	public void edit() {
		Selected selected = new Selected(MainWindow.this, controller, false);
		//selected.editStud();
		selected.show();
	}


	public void update() {	
		table.updateTableExhibitions();
		System.out.println("UPDATE");
	}

	public void show() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
