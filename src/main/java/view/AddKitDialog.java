package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.Controller;
import model.Kit;

public class AddKitDialog {

	public JDialog dialog = new JDialog();
	public JButton buttonAdd = new JButton("OK");
	public JTextField input1 = new JTextField();
	public JTextField input2 = new JTextField();

	private JLabel label1 = new JLabel("Комплект: ");
	private JLabel label2 = new JLabel("Описание: ");
	private MainWindow mainWindow;
	public Controller controller;

	public AddKitDialog(MainWindow mainWindow, Controller controller) {

		this.mainWindow = mainWindow;
		this.controller = controller;
		dialog.setTitle("Add kit");
		dialog.setSize(410, 450);
		dialog.setLayout(null);
		dialog.setLocationByPlatform(true);

		input1.setBounds(120, 20, 250, 30);
		input2.setBounds(120, 60, 250, 30);
		label1.setBounds(10,20,90,30);
		label2.setBounds(10,60,110,30);
		buttonAdd.setBounds(100, 300, 100, 30);

		dialog.add(input1);
		dialog.add(input2);
		dialog.add(label1);
		dialog.add(label2);
		dialog.add(buttonAdd);
	}

	public void setInfo() {
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				Kit newKit = new Kit();

				newKit.setKit(input1.getText());
				newKit.setDescription(input2.getText());

				controller.addKit(newKit);

				mainWindow.update();

				dialog.setVisible(false);
			}
		});
	}
	
	public void setInfoForEdit(final int number) {
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Kit kit = controller.getKit(number);
				Kit newKit = new Kit();

				newKit.setKit(input1.getText());
				newKit.setDescription(input2.getText());
				
				controller.editKit(kit, newKit);

				mainWindow.updateKits();

				dialog.setVisible(false);
			}
		});
	}
	

	public void show() {
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
