package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.*;

public class SearchMainDialog {

	public JFrame frame = new JFrame();
	public Controller controller;
	//public List<Student> students;
	//public TableComponent table = new TableComponent(controller);

	public SearchMainDialog(Controller controller) {
		this.controller = controller;	
		
		frame.setTitle("Search");
		frame.setSize(700, 800);
		frame.setLayout(null);
		frame.setLocationByPlatform(true);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(40, 90, 600, 800);
	//	mainPanel.add(table);

		frame.add(mainPanel);	
	}
	
	public void update()
	{
		//table.update();
	}
	
	public void show() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
