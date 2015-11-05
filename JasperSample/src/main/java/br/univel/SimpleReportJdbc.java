package br.univel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class SimpleReportJdbc {

	private String arq = "C:\\Users\\Alexandre H. Noro\\JaspersoftWorkspace\\MyReports\\simplesjdbc.jasper";
	private Connection con;

	public SimpleReportJdbc() throws SQLException {

		JasperPrint jasperPrint = null;
		getConnection();
		try {
			jasperPrint = JasperFillManager.fillReport(arq, null,
					getConnection());
			JasperViewer jasperViewer = new JasperViewer(jasperPrint);
			jasperViewer.setVisible(true);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {

		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Aguarde.....Abrindo Relatório!!!");
		
		String url = "jdbc:mysql://192.168.101.10/employees";
		String user = "jasper";
		String password = "jasper";
		
		return con = DriverManager.getConnection(url, user, password);
		
		
	}

	public static void main(String[] args) throws SQLException {
		new SimpleReportJdbc();
	}
}