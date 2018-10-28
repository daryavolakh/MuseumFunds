package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import controller.Controller;
import model.Movement;

public class AddMovementDialog {

	public JDialog dialog = new JDialog();
	public JButton buttonAdd = new JButton("OK");
	public JTextField input1 = new JTextField("Инв.номер: ");
	public JTextField input2 = new JTextField("Дата получения: ");
	public JTextField input3 = new JTextField("Дата возврата: ");
	public JTextField input4 = new JTextField("Организация: ");
	private MainWindow mainWindow;
	public Controller controller;

	public AddMovementDialog(MainWindow mainWindow, Controller controller) {

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
		buttonAdd.setBounds(100, 300, 100, 30);

		dialog.add(input1);
		dialog.add(input2);
		dialog.add(input3);
		dialog.add(input4);
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

				System.out.println("NEW " + newMovement.getInvNumber() + " " + newMovement.getDateOfTransfer());
				System.out.println("OLD " + movement.getInvNumber() + " " + movement.getDateOfTransfer());

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
