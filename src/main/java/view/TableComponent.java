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
import model.Student;

public class TableComponent extends JPanel {
	public Controller controller = new Controller();
	public JPanel panelTable = new JPanel();
	public JPanel panelButtons = new JPanel();
	public Vector<String> columns = new Vector<String>();
	public DefaultTableModel model = new DefaultTableModel(columns, 0);
	public JTable table = new JTable();
	public List<Student> students = new ArrayList<Student>();

	public TableComponent(Controller controller, List<Student> students) {
		this.controller = controller;
		this.students = students;
		panelTable.setPreferredSize(new Dimension(500, 650));

		columns.add("ФИО студента");
		columns.add("Адрес");
		columns.add("Кол-во членов семьи");
		columns.add("Размер жилой S");
		columns.add("Жилая S на чел.");

		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 70, 10, 1);

		panelTable.add(scrollPane);

		add(panelTable);

		
	}

	public void addRow(Student student) {
		Vector row = new Vector();

		row.add(student.surname + " " + student.name);
		row.add(student.town + " " + student.street + " " + student.house);
		row.add(student.familyMembers);
		row.add(student.area);
		row.add(student.areaPerPerson);

		model.addRow(row);
	}

	public void addToTable(int from, int to) {
		if (to == 1) {
			Student student = new Student();
			student = students.get(0);
			addRow(student);
		}

		else {
			for (int index = from; index < to; index++) {
				Student student = new Student();
				student = students.get(index);
				addRow(student);
			}
		}
	}

	
	public void clearTable() {
		for (int index = model.getRowCount() - 1; index >= 0; index--) {
			model.removeRow(index);
		}
	}

	public void update(List<Student> students) {
		this.students = students;
		clearTable();
		if (students.size() == 1) {
			addToTable(0, students.size());
			
			//добавить обновление мб
		}
	}
}
