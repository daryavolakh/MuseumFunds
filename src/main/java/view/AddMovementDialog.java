package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.Controller;
import model.Movement;

public class AddMovementDialog {

	public JDialog dialog = new JDialog();
	public JButton buttonAdd = new JButton("OK");
	public JTextField input1 = new JTextField();
	public JTextField input2 = new JTextField();
	public JTextField input3 = new JTextField();
	public JTextField input4 = new JTextField();

	private JLabel label1 = new JLabel("Инв.номер: ");
	private JLabel label2 = new JLabel("Дата получения: ");
	private JLabel label3 = new JLabel("Дата возврата: ");
	private JLabel label4 = new JLabel("Организация: ");
	private MainWindow mainWindow;
	public Controller controller;

	public AddMovementDialog(MainWindow mainWindow, Controller controller) {

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
		label1.setBounds(10,20,90,30);
		label2.setBounds(10,60,110,30);
		label3.setBounds(10,100,110,30);
		label4.setBounds(10,140,110,30);
		buttonAdd.setBounds(100, 300, 100, 30);

		dialog.add(input1);
		dialog.add(input2);
		dialog.add(input3);
		dialog.add(input4);
		dialog.add(label1);
		dialog.add(label2);
		dialog.add(label3);
		dialog.add(label4);
		dialog.add(buttonAdd);
	}

	public void setInfo() {
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				Movement movement = new Movement();

				movement.invNumber = Integer.parseInt(input1.getText());
				movement.dateOfTransfer = input2.getText();
				movement.dateOfReturn = input3.getText();
				movement.organization = input4.getText();

				controller.addMovement(movement);

				mainWindow.update();

				dialog.setVisible(false);
			}
		});
	}

	public void setInfoForDelete() {
		dialog.remove(input4);
		dialog.remove(label4);
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				Movement movement = new Movement();

				movement.invNumber = Integer.parseInt(input1.getText());
				movement.dateOfTransfer = input2.getText();
				movement.dateOfReturn = input3.getText();

				controller.deleteMovement(movement);

				mainWindow.update();

				dialog.setVisible(false);
			}
		});
	}

	public void setInfoForEdit(final int number, final int invNumber) {
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Movement movement = controller.getMovement(number, invNumber);
				Movement newMovement = new Movement();

				newMovement.setInvNumber(Integer.parseInt(input1.getText()));
				newMovement.setDateOfTransfer(input2.getText());
				newMovement.setDateOfReturn(input3.getText());
				newMovement.setOrganization(input4.getText());

				controller.editMovement(movement, newMovement);

				mainWindow.updateMovement(invNumber);

				dialog.setVisible(false);
			}
		});
	}

	public void show() {
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
