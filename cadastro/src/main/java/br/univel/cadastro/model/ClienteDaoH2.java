package br.univel.cadastro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoH2 implements ClienteDao {

	private static Connection con;

	private static ClienteDaoH2 instanciar;

	private ClienteDaoH2() {

	}

	public static ClienteDaoH2 getNovaInstancia() {
		if (instanciar == null)
			return instanciar = new ClienteDaoH2();
		return instanciar;
	}

	private void abrirConexao() throws SQLException {

		String url = "jdbc:h2:~/Alexandre";
		String user = "sa";
		String password = "sa";
		con = DriverManager.getConnection(url, user, password);

	}

	private void fecharConexao() throws SQLException {

		con.close();

	}

	public void inserir(Cliente c) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO CLIENTE(ID,NOME,ENDERECO,TELEFONE,CIDADE,UF) VALUES (?, ?, ?, ?, ?, ?)");

		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getEndereço());
		ps.setString(4, c.getTelefone());
		ps.setString(5, c.getCidade());
		ps.setObject(6, c.getUf().getNome());

		int res = ps.executeUpdate();

		ps.close();

		System.out.println(res + "Registro inserido.");

	}

	public void atualizar(Cliente c) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("UPDATE CLIENTE SET NOME = ?,ENDERECO = ?,TELEFONE = ?,UF = ? WHERE ID ="
						+ c.getId());

		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome() + "");
		ps.setString(3, c.getEndereço() + "");
		ps.setString(4, c.getTelefone() + "");
		ps.setString(5, c.getCidade() + "");
		ps.setObject(6, c.getUf() + "");

		int res = ps.executeUpdate();

		ps.close();

		System.out.println(res + "Registro alterado.");

	}

	public void excluir(Cliente c) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("DELETE FROM CLIENTE WHERE ID =" + c.getId());

		int res = ps.executeUpdate();

		ps.close();

		System.out.println(res + "Registro deletado.");
	}

	public Cliente buscar(int id){
		Statement st = null;
		ResultSet rs = null;
		Cliente c = null;
		Uf uf = Uf.PR;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT NOME,ENDERECO,TELEFONE,CIDADE,UF  FROM CLIENTE WHERE ID="
					+ id);
			rs.next();
			c = new Cliente(id, rs.getString("NOME"), rs.getString("ENDERECO"),
					rs.getString("TELEFONE"), rs.getString("CIDADE"),
					uf.validar(rs.getObject("UF")));
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao buscar o Cliente desejado!\n"
					+ e.getMessage());
		}
		return c;

	}

	public Cliente buscarPorExemplo(Cliente c) {
		// Não aprendido em sala ainda
		return null;
	}

	public List<Cliente> listar() {
		Statement st = null;
		ResultSet rs = null;
		Uf uf = Uf.PR;
		List<Cliente> lc = new ArrayList<Cliente>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID,NOME,ENDERECO,TELEFONE,CIDADE,UF  FROM CLIENTE");
			while (rs.next()) {
				lc.add(new Cliente(rs.getInt("ID"), rs.getString("NOME"), rs
						.getString("ENDERECO"), rs.getString("TELEFONE"), rs
						.getString("CIDADE"), uf.validar(rs.getObject("UF"))));
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao listar Clientes!!\n" + e.getMessage());
		}
		return lc;
	}

	public int PegaId() {
		Statement st = null;
		ResultSet rs = null;
		int id = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID FROM CLIENTE");
			while (rs.next()) {
				id = rs.getInt("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
