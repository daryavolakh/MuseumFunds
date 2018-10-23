package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

public class MainWindow {
	public JFrame frame = new JFrame();
	public Controller controller;
	public TableComponent table;
	public TableComponent tableMovement;
	public JPanel mainPanel = new JPanel();
	private JButton buttonMovements;

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
		buttonMovements = new JButton("show movements");
		JButton buttBack = new JButton("back");
		JButton buttAddMovement = new JButton("add movement");	
		JButton buttDeleteMovement = new JButton("delete movement");	

		buttAdd.setBounds(125, 50, 70, 20);
		buttEdit.setBounds(200, 50, 80, 20);
		buttDelete.setBounds(285, 50, 80, 20);
		buttonMovements.setBounds(370,50,150,20);
		buttBack.setBounds(125, 75, 80, 20);
		buttAddMovement.setBounds(210, 75, 150, 20);
		buttDeleteMovement.setBounds(365, 75, 150, 20);

		mainPanel.setBounds(40, 90, 600, 800);
		mainPanel.add(table);		

		frame.add(buttAdd);
		frame.add(buttEdit);
		frame.add(buttDelete);
		frame.add(buttonMovements);
		frame.add(buttBack);
		frame.add(buttAddMovement);
		frame.add(buttDeleteMovement);
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
				//сперва выбрать строку!
				int[] selectedRow = table.getTable().getSelectedRows();  
				selectedRow[0] = table.getTable().convertRowIndexToModel(selectedRow[0]);
				//Object value = table.getModel().getValueAt(selectedRow[0], 1);
				table.getModel().getValueAt(selectedRow[0], 0);   //чекни!
				edit(selectedRow[0]);
			}
		});
		
		buttonMovements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showMovements();
			}
		});
		
		buttBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				update();
			}
		});
		
		buttAddMovement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addMovement();				
			}
		});
		
		buttDeleteMovement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				deleteMovement();				
			}
		});
		
		
	}

	public void add() {
		AddExhibitDialog dialog = new AddExhibitDialog(MainWindow.this, controller);
		dialog.show();
		dialog.setInfo();
	}
	
	public void addMovement() {
		AddMovementDialog dialog = new AddMovementDialog(MainWindow.this, controller);
		dialog.show();
		dialog.setInfo();
	}
	
	public void deleteMovement() {
		AddMovementDialog dialog = new AddMovementDialog(MainWindow.this, controller);
		dialog.show();
		dialog.setInfoForDelete();
	}

	public void delete() {
		DialogUsual dialog = new DialogUsual(MainWindow.this, controller);
		dialog.show();
		dialog.eraseExhibit();
	}

	public void edit(int number) {
		AddExhibitDialog dialog = new AddExhibitDialog(MainWindow.this, controller);
		dialog.show();
		dialog.setInfoForEdit(number);
	}
	
	public void showMovements() {
		DialogUsual dialog = new DialogUsual(MainWindow.this, controller);
		dialog.show();
		dialog.getInfo();
	}


	public void update() {	
		table.updateTableExhibitions();
		System.out.println("UPDATE");
	}
	
	public void updateMovement(int invNumber) {	
		table.updateTableMovement(invNumber);
		System.out.println("UPDATE");
	}

	public void show() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
