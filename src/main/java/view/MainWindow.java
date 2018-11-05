package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.Controller;

public class MainWindow {
	public JFrame frame = new JFrame();
	public Controller controller;
	public TableComponent table;
	public TableComponent tableMovement;
	public JPanel mainPanel;
	private boolean isMainTable = true;
	private int invNumberForMovement;
	private JMenuBar menuBar;
	private JMenu menuAdd;
	private JMenu menuEdit;
	private JMenu menuDelete;
	private JMenu menuShow;

	public MainWindow(Controller controller) {
		this.controller = controller;
		
		mainPanel = new JPanel();
		table = new TableComponent(controller);
		table.updateTableExhibitions();

		frame.setTitle("Lab 2");
		frame.setSize(700, 570);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);
		
		menuBar = new JMenuBar();
		menuAdd = new JMenu("Add");
		menuEdit = new JMenu("Edit");
		menuDelete = new JMenu("Delete");
		menuShow = new JMenu("Show");		

		JMenuItem  buttAdd = new JMenuItem ("add exhibit");
		JMenuItem  buttAddKit = new JMenuItem ("add kit");
		JMenuItem  buttEdit = new JMenuItem ("edit exhibit/movement");
		JMenuItem  buttEditKit = new JMenuItem ("edit kit");
		JMenuItem  buttDelete = new JMenuItem ("delete exhibit");
		JMenuItem  buttonMovements = new JMenuItem ("show movements");
		JMenuItem  buttShowCard = new JMenuItem("show exhibit card");
		JMenuItem  buttShowOneKit = new JMenuItem("show kit");
		JMenuItem  buttShowKits = new JMenuItem("show kits");
		JMenuItem  buttShowPlace = new JMenuItem("show place by date");
		
		JMenuItem  buttAddMovement = new JMenuItem ("add movement");
		JMenuItem  buttDeleteMovement = new JMenuItem ("delete movement");
		JButton  buttBack = new JButton ("back");
		
		menuAdd.add(buttAdd);
		menuAdd.add(buttAddMovement);
		menuAdd.add(buttAddKit);
		
		menuEdit.add(buttEdit);
		menuEdit.add(buttEditKit);
		
		menuDelete.add(buttDelete);
		menuDelete.add(buttDeleteMovement);
		
		menuShow.add(buttonMovements);
		menuShow.add(buttShowOneKit);
		menuShow.add(buttShowKits);
		menuShow.add(buttShowCard);
		menuShow.add(buttShowPlace);		
		
		buttBack.setBounds(480, 10, 80, 20);

		mainPanel.setBounds(40, 30, 600, 2000);
		mainPanel.add(table);
		
		frame.add(buttBack);
		frame.add(mainPanel);
		
		menuBar.add(menuAdd);
		menuBar.add(menuEdit);
		menuBar.add(menuDelete);
		menuBar.add(menuShow);
		frame.setJMenuBar(menuBar);

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
				int[] selectedRow = table.getTable().getSelectedRows();
				selectedRow[0] = table.getTable().convertRowIndexToModel(selectedRow[0]);
				table.getModel().getValueAt(selectedRow[0], 0); 
				edit(selectedRow[0]);
			}
		});
		
		buttEditKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int[] selectedRow = table.getTable().getSelectedRows();
				selectedRow[0] = table.getTable().convertRowIndexToModel(selectedRow[0]);
				table.getModel().getValueAt(selectedRow[0], 0); 
				editKit(selectedRow[0]);
			}
		});

		buttonMovements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showMovements();
				isMainTable = false;
			}
		});

		buttBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				update();
				isMainTable = true;
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
		
		buttAddKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addKit();
			}
		});
		
		buttShowOneKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showOneKit();
			}
		});
		
		buttShowKits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				updateKits();
			}
		});
		
		buttShowCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showCard();
			}
		});
		
		buttShowPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showPlace();
			}
		});		
	}

	public void add() {
		AddExhibitDialog dialog = new AddExhibitDialog(MainWindow.this, controller);
		dialog.show();
		dialog.setInfo();
	}
	
	public void addKit() {
		AddKitDialog dialog = new AddKitDialog(MainWindow.this, controller);
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
		if (isMainTable) {
			AddExhibitDialog dialog = new AddExhibitDialog(MainWindow.this, controller);
			dialog.show();
			dialog.setInfoForEdit(number);
		} else {
			AddMovementDialog dialog = new AddMovementDialog(MainWindow.this, controller);
			dialog.show();
			dialog.setInfoForEdit(number, invNumberForMovement);
		}
	}

	public void showMovements() {
		DialogUsual dialog = new DialogUsual(MainWindow.this, controller);
		dialog.show();
		dialog.getInfo();
	}
	
	public void showCard() {
		DialogUsual dialog = new DialogUsual(MainWindow.this, controller);
		dialog.show();
		dialog.getExhibitCard();
	}
	
	public void showOneKit() {
		DialogUsual dialog = new DialogUsual(MainWindow.this, controller);
		dialog.show();
		dialog.getKit();
	}
	
	public void editKit(int number) {
		AddKitDialog dialog = new AddKitDialog(MainWindow.this, controller);
		dialog.show();
		dialog.setInfoForEdit(number);
		//дописать вызов и так далее
	}
	
	public void update() {
		table.updateTableExhibitions();
		isMainTable = true;
	}

	public void updateMovement(int invNumber) {
		invNumberForMovement = invNumber;
		table.updateTableMovement(invNumber);
	}
	
	public void updateCard(int invNumber) {
		table.updateTableCard(invNumber);
	}
	
	public void updateKit(String name) {
		table.updateTableKit(name);
	}
	
	public void updateKits() {
		table.updateKits();
	}
	
	public void showPlace() {
		DialogUsual dialog = new DialogUsual(MainWindow.this, controller);
		dialog.show();
		dialog.searchPlace();
	}
	
	public void updateTablePlace(int invNumber, String org) {
		table.updateTablePlace(invNumber, org);
	}

	public void show() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
