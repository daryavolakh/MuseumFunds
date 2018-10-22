package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class TableComponent extends JPanel {
	public Controller controller;
	public JPanel panelTable = new JPanel();
	public JPanel panelButtons = new JPanel();
	public Vector<String> columns = new Vector<String>();
	public DefaultTableModel model = new DefaultTableModel(columns, 0);
	public JTable table = new JTable();
	public List exhibits;
	// public List<Student> students = new ArrayList<Student>();

	public TableComponent(Controller controller) {// , List<Student> students) {
		this.controller = controller;
		exhibits = controller.getExhibits();
		panelTable.setPreferredSize(new Dimension(500, 650));

		columns.add("Инв.номер");
		columns.add("Экспонат");
		columns.add("Дата создания");
		columns.add("Автор");

		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 70, 10, 1);

		panelTable.add(scrollPane);

		add(panelTable);
	}

	public void update() {
		clearTable();

		for (int index = 0; index < (controller.getExhibits()).size(); index++) {

			Vector row = new Vector();

			row.add((controller.getExhibit(index)).invNumber);
			row.add((controller.getExhibit(index)).name);
			row.add((controller.getExhibit(index)).dateOfCreation);
			row.add((controller.getExhibit(index)).author.getName()
					+ (controller.getExhibit(index)).author.getSurname());

			model.addRow(row);
		}

	}

	public void clearTable() {
		for (int index = model.getRowCount() - 1; index >= 0; index--) {
			model.removeRow(index);
		}
	}
}
