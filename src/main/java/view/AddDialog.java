package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import controller.Controller;
import model.Exhibit;

public class AddDialog {

	public JDialog dialog = new JDialog();
	public JButton buttonAdd = new JButton("OK");
	public JTextField input1 = new JTextField("Инв.номер: ");
	public JTextField input2 = new JTextField("Имя: ");
	public JTextField input3 = new JTextField("Дата создания: ");
	public JTextField input4 = new JTextField("Имя автора: ");
	public JTextField input5 = new JTextField("Фамилия автора: ");
	private MainWindow mainWindow;
	public Controller controller;

	public AddDialog(MainWindow mainWindow, Controller controller) {
	
		this.mainWindow = mainWindow;
		this.controller = controller;
		dialog.setTitle("Information");
		dialog.setSize(310, 450);
		dialog.setLayout(null);
		dialog.setLocationByPlatform(true);

		input1.setBounds(20, 20, 250, 30);
		input2.setBounds(20, 60, 250, 30);
		input3.setBounds(20, 100, 250, 30);
		input4.setBounds(20, 140, 250, 30);
	//	input5.setBounds(20, 180, 250, 30);
		buttonAdd.setBounds(100, 300, 100, 30);

		dialog.add(input1);
		dialog.add(input2);
		dialog.add(input3);
		dialog.add(input4);
		//dialog.add(input5);
		dialog.add(buttonAdd);
	}

	public void setInfo() {
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				Exhibit exhibit = new Exhibit();

				exhibit.invNumber = Integer.parseInt(input1.getText());
				exhibit.name = input2.getText();
				exhibit.dateOfCreation = input3.getText();
				exhibit.author = input4.getText();			

				controller.addExhibit(exhibit);

				mainWindow.update();

				dialog.setVisible(false);
			}
		});
	}

	public void show() {
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
