package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.Controller;

public class DialogUsual {

	public JDialog dialog = new JDialog();
	public JButton buttonAdd = new JButton("OK");
	public JTextField input1 = new JTextField("Инв.номер: ");
	public JTextField input2 = new JTextField("Дата: ");
	private MainWindow mainWindow;
	private Controller controller;

	public DialogUsual(MainWindow mainWindow, Controller controller) {
	
		this.mainWindow = mainWindow;
		this.controller = controller;
		
		dialog.setSize(310, 250);
		dialog.setLayout(null);
		dialog.setLocationByPlatform(true);

		input1.setBounds(20, 20, 250, 30);
		input2.setBounds(20, 60, 250, 30);
		buttonAdd.setBounds(100, 150, 100, 30);

		dialog.add(input1);
		dialog.add(buttonAdd);
	}

	public void getInfo() {
		dialog.setTitle("Просмотр движения экспоната");
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				int invNumber = Integer.parseInt(input1.getText());	

				mainWindow.updateMovement(invNumber);

				dialog.setVisible(false);
			}
		});
	}

	public void eraseExhibit() {
		dialog.setTitle("Удаление экспоната");
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				
				int invNumber = Integer.parseInt(input1.getText());	
				controller.deleteExhibit(invNumber);

				mainWindow.update();

				dialog.setVisible(false);
			}
		});
	}
	
	public void getExhibitCard() {
		dialog.setTitle("Просмотр карточки экспоната");
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				int invNumber = Integer.parseInt(input1.getText());	

				mainWindow.updateCard(invNumber);

				dialog.setVisible(false);
			}
		});
	}
	
	public void getKit() {
		dialog.setTitle("Просмотр комплекта");
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				input1.setText("Имя комплекта");
				String name = input1.getText();	

				mainWindow.updateKit(name);

				dialog.setVisible(false);
			}
		});
	}
	
	public void show() {
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
