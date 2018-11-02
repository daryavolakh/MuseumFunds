package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.Controller;
import model.Exhibit;

public class AddExhibitDialog {

	public JDialog dialog = new JDialog();
	public JButton buttonAdd = new JButton("OK");
	public JTextField input1 = new JTextField();
	public JTextField input2 = new JTextField();
	public JTextField input3 = new JTextField();
	public JTextField input4 = new JTextField();
	public JTextField input5 = new JTextField();
	public JTextField input6 = new JTextField();
	private JLabel label1 = new JLabel("Инв.номер: ");
	private JLabel label2 = new JLabel("Имя: ");
	private JLabel label3 = new JLabel("Дата создания: ");
	private JLabel label4 = new JLabel("Автор: ");
	private JLabel label5 = new JLabel("Комплект: ");
	private JLabel label6 = new JLabel("Ответственный: ");
	private MainWindow mainWindow;
	public Controller controller;

	public AddExhibitDialog(MainWindow mainWindow, Controller controller) {
	
		this.mainWindow = mainWindow;
		this.controller = controller;
		dialog.setTitle("Information");
		dialog.setSize(410, 450);
		dialog.setLayout(null);
		dialog.setLocationByPlatform(true);

		input1.setBounds(120, 20, 250, 30);
		input2.setBounds(120, 60, 250, 30);
		input3.setBounds(120, 100, 250, 30);
		input4.setBounds(120, 140, 250, 30);
		input5.setBounds(120,180,250,30);
		input6.setBounds(120,220,250,30);
		label1.setBounds(10,20,90,30);
		label2.setBounds(10,60,110,30);
		label3.setBounds(10,100,110,30);
		label4.setBounds(10,140,110,30);
		label5.setBounds(10,180,110,30);
		label6.setBounds(10,220,110,30);
		buttonAdd.setBounds(100, 300, 100, 30);

		dialog.add(input1);
		dialog.add(input2);
		dialog.add(input3);
		dialog.add(input4);
		dialog.add(input5);
		dialog.add(input6);
		dialog.add(label1);
		dialog.add(label2);
		dialog.add(label3);
		dialog.add(label4);
		dialog.add(label5);
		dialog.add(label6);
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
				exhibit.kit = input5.getText();
				exhibit.responsible = input6.getText();

				controller.addExhibit(exhibit);

				mainWindow.update();

				dialog.setVisible(false);
			}
		});
	}
	
	public void setInfoForEdit(final int number) {
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Exhibit exhibit = controller.getExhibit(number);
				Exhibit newExhibit = new Exhibit();

				newExhibit.setInvNumber(Integer.parseInt(input1.getText()));
				newExhibit.setName(input2.getText());
				newExhibit.setDateOfCreation(input3.getText());
				newExhibit.setAuthor(input4.getText());	
				newExhibit.setKit(input5.getText());
				newExhibit.setResponsible(input6.getText());

				controller.editExhibit(exhibit, newExhibit);

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
