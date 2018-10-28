package view;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Exhibit;
import model.Movement;

@SuppressWarnings("serial")
public class TableComponent extends JPanel {
	public Controller controller;
	public JPanel panelTable = new JPanel();
	public JPanel panelButtons = new JPanel();
	public Vector<String> columns = new Vector<String>();
	public DefaultTableModel model = new DefaultTableModel(columns, 0);
	public JTable table = new JTable();

	public TableComponent(Controller controller) {
		this.controller = controller;
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
		panelTable.add(scrollPane);
		add(panelTable);
	}

	
	public void updateTableExhibitions() {	
		setModelForExhibits();
		clearTable();
		List<Exhibit> exhibits = controller.getExhibits();
		System.out.println("exhibits COUNT: " + exhibits.size());
		for (int index = 0; index < exhibits.size(); index++) {
			Vector<Serializable> row = new Vector<Serializable>();

			row.add((exhibits.get(index)).invNumber);
			row.add((exhibits.get(index)).name);
			row.add((exhibits.get(index)).dateOfCreation);
			row.add((exhibits.get(index)).author);
			
			System.out.println("-> " + (exhibits.get(index)).invNumber);
			model.addRow(row);			
		}
		System.out.println("ROW COUNT: " + model.getRowCount());
		
	}

	public void clearTable() {
		for (int index = model.getRowCount() - 1; index >= 0; index--) {
			model.removeRow(index);
		}
	}
	
	public void updateTableMovement(int invNumber) {	
		setModelForMovement();
		clearTable();
		List<Movement> movements = controller.getMovements(invNumber);
		System.out.println("exhibits COUNT: " + movements.size());
		for (int index = 0; index < movements.size(); index++) {
			Vector<String> row = new Vector<String>();

			row.add((movements.get(index)).dateOfTransfer);
			row.add((movements.get(index)).dateOfReturn);
			row.add((movements.get(index)).organization);
			
			model.addRow(row);			
		}
	}
	
	public void updateTableCard(int invNumber) {
		setModelForCard();
		Exhibit exhibit = controller.getExhibitByInvNumber(invNumber);
		
		Vector<Serializable> row = new Vector<Serializable>();

		row.add(exhibit.getInvNumber());
		row.add(exhibit.getName());
		row.add(exhibit.getDateOfCreation());
		row.add(exhibit.getAuthor());
		row.add(exhibit.getKit());	
		row.add(exhibit.getResponsible());	
		
		model.addRow(row);
	}
	
	public void updateTableKit(String name) {
		setModelForKit();
		List<Exhibit> list = controller.getExhibitsFromOneKit(name);
		
		for (int index = 0; index < list.size(); index++) {
			Vector<String> row = new Vector<String>();

			row.add((list.get(index)).getKit());
			row.add((list.get(index)).getName());
			row.add((list.get(index)).getDateOfCreation());
			row.add((list.get(index)).getAuthor());
			
			model.addRow(row);			
		}
	}
	
	public void setModelForMovement() {
		Vector<String> columns = new Vector<String>();
		model = new DefaultTableModel(columns, 0);		
		
		columns.add("Дата получения");
		columns.add("Дата возврата");
		columns.add("Организация");
		table.setModel(model);
	}
	
	
	public void setModelForExhibits() {
		Vector<String> columns = new Vector<String>();
		model = new DefaultTableModel(columns, 0);		
		
		columns.add("Инв.номер");
		columns.add("Экспонат");
		columns.add("Дата создания");
		columns.add("Автор");
		
		table.setModel(model);
	}
	
	public void setModelForCard() {
		Vector<String> columns = new Vector<String>();
		model = new DefaultTableModel(columns, 0);		
		
		columns.add("Инв.номер");
		columns.add("Экспонат");
		columns.add("Дата создания");
		columns.add("Автор");
		columns.add("Комплект");
		columns.add("Ответственное лицо");
		
		table.setModel(model);
	}
	
	public void setModelForKit() {
		Vector<String> columns = new Vector<String>();
		model = new DefaultTableModel(columns, 0);		
		
		columns.add("Комплект");
		columns.add("Экспонат");
		columns.add("Дата создания");
		columns.add("Автор");
//		columns.add("Ответственное лицо");
		
		table.setModel(model);
	}
	
	public JTable getTable() {
		return table;
	}
	
	public DefaultTableModel getModel() {
		return model;
	}
}
