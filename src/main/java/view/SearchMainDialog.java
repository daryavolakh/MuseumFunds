package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.*;

public class SearchMainDialog {

	public JFrame frame = new JFrame();
	public Controller controller = new Controller();
	public List<Student> students = new ArrayList<Student>();
	public TableComponent table = new TableComponent(controller,students);

	public SearchMainDialog(Controller controller, List<Student> students) {
		this.controller = controller;
		this.students = students;		
		
		frame.setTitle("Search");
		frame.setSize(700, 800);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(40, 90, 600, 800);
		mainPanel.add(table);

		frame.add(mainPanel);	
	}
	
	public void update()
	{
		table.update(students);
	}
	
	public void show() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
