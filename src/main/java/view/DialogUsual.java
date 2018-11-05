package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controller;

public class DialogUsual {

	public JDialog dialog = new JDialog();
	public JButton buttonAdd = new JButton("OK");
	public JTextField input1 = new JTextField();
	private JLabel label1 = new JLabel("Инв.номер: ");
	public JTextField input2 = new JTextField();
	private JLabel label2 = new JLabel("до: ");
	private MainWindow mainWindow;
	private Controller controller;

	public DialogUsual(MainWindow mainWindow, Controller controller) {

		this.mainWindow = mainWindow;
		this.controller = controller;

		dialog.setSize(310, 250);
		dialog.setLayout(null);
		dialog.setLocationByPlatform(true);

		input1.setBounds(90, 20, 150, 30);
		label1.setBounds(20, 20, 70, 30);
		input2.setBounds(90, 60, 150, 30);
		label2.setBounds(20, 60, 70, 30);

		buttonAdd.setBounds(100, 150, 100, 30);

		dialog.add(input1);
		dialog.add(label1);
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
		label1.setText("Комплект:");
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				label1.setText("Имя комплекта:");
				String kit = input1.getText();

				mainWindow.updateKit(kit);

				dialog.setVisible(false);
			}
		});
	}

	public void searchPlace() {
		dialog.setTitle("Поиск в заданном интервале ");
		label1.setText("Инв.номер:");
		label2.setText("от:");

		final JTextField input3 = new JTextField();
		JLabel label3 = new JLabel("до:");

		input3.setBounds(90, 100, 150, 30);
		label3.setBounds(20, 100, 70, 30);

		dialog.add(input2);
		dialog.add(label2);
		dialog.add(input3);
		dialog.add(label3);
		buttonAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				int invNumber = Integer.parseInt(input1.getText());
				String dateBegin = input2.getText();
				String dateEnd = input3.getText();

				mainWindow.table.updateTablePlace(invNumber, controller.searchPlace(invNumber, dateBegin, dateEnd));
				dialog.setVisible(false);
			}
		});
	}

	public void show() {
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
