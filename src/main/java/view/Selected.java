package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.Controller;

public class Selected {
	//поиск по критериям. Он не нужен! 

	public JFrame frame = new JFrame();
	public JDialog dialog = new JDialog();
	public JButton buttonSearch = new JButton("OK");
	public MainWindow mainwindow;
	public Controller controller;
	public Vector<String> items = new Vector<String>();
	public JComboBox comboBox = new JComboBox(items);
	public JTextField in1 = new JTextField();
	public JTextField in2 = new JTextField();
	public JTextField in3 = new JTextField();
	public JTextField in4 = new JTextField();
	//public List<Student> founded = new ArrayList<Student>();
	private boolean dOrS;

	public Selected(MainWindow mainwindow, Controller controller, boolean dOrS) {
		this.mainwindow = mainwindow;
		this.controller = controller;
		this.dOrS = dOrS;

		dialog.setTitle("Search");
		dialog.setSize(310, 210);
		dialog.setLayout(null);
		dialog.setLocationByPlatform(true);

		items.add("по фамилии и числу членов семьи");
	/*	items.add("по числу членов семьи и занимаемой S");
		items.add("по фамилии и занимаемой S");
		items.add("вывести всех студентов, чья S на человека меньше/больше заданного предела");*/

		comboBox.setBounds(25, 35, 245, 30);
		buttonSearch.setBounds(45, 100, 180, 30);

		dialog.add(comboBox);
		dialog.add(buttonSearch);
	}

	public void searchStud() {

	/*	buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (comboBox.getSelectedItem() == items.get(0)) {

					SearchStudentsDialog search = new SearchStudentsDialog(mainwindow,controller, dOrS);
					search.show();
					search.byNameAndNumber();
					dialog.setVisible(false);
				}

				if (comboBox.getSelectedItem() == items.get(1)) {
					SearchStudentsDialog search = new SearchStudentsDialog(mainwindow,controller, dOrS);
					search.show();
					search.delAddTextFields(); 
					search.byNumberAndArea();
					 
					dialog.setVisible(false);
				}

				if (comboBox.getSelectedItem() == items.get(2)) {
					 SearchStudentsDialog search = new SearchStudentsDialog(mainwindow,controller, dOrS);
					 search.show(); 
					 search.byNameAndArea();
					
					 dialog.setVisible(false);
				}

				if (comboBox.getSelectedItem() == items.get(3)) {
					SearchStudentsDialog search = new SearchStudentsDialog(mainwindow,controller, dOrS);
					search.show(); 
					search.delTextFields(); 
					search.byAreaPerPerson();
					
					dialog.setVisible(false);
				}
			}
		});*/
	}

	public void show() {
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
