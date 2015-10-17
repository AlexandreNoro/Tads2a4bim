package br.univel.cadastro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClienteDaoH2 implements ClienteDao {

	private static Connection con;

	private static ClienteDaoH2 instanciar;
	
	private ClienteDaoH2(){
		
	}
	
	public static ClienteDaoH2 getNovaInstancia(){
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

	@Override
	public void inserir(Cliente c) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO CLIENTE(ID,NOME,ENDERECO,TELEFONE,CIDADE,UF) VALUES (?, ?, ?, ?, ?, ?)");

		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getEndereço());
		ps.setString(4, c.getTelefone());
		ps.setString(5, c.getCidade());
		ps.setString(6, c.getUf());

		int res = ps.executeUpdate();

		ps.close();

		System.out.println(res + "Registro inserido.");

	}

	@Override
	public void atualizar(Cliente c) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("UPDATE CLIENTE SET NOME = ?,ENDERECO = ?,TELEFONE = ?,UF = ? WHERE ID =" + c.getId());

		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome() + "");
		ps.setString(3, c.getEndereço() + "");
		ps.setString(4, c.getTelefone() + "");
		ps.setString(5, c.getCidade() + "");
		ps.setString(6, c.getUf() + "");

		int res = ps.executeUpdate();

		ps.close();

		System.out.println(res + "Registro alterado.");

	}

	@Override
	public void excluir(Cliente c) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("DELETE FROM CLIENTE WHERE ID =" + c.getId());


		int res = ps.executeUpdate();

		ps.close();

		System.out.println(res + "Registro deletado.");
	}

	@Override
	public Cliente buscar(int d) throws SQLException {
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM CLIENTE");
		while (result.next()) {
			// pega coluna pelo id
			int id = result.getInt(1);
			// pega coluna pela String
			String nome = result.getString("nome");
			System.out.println(id + "" + nome);

		}
		return null;

	}

	@Override
	public Cliente buscarPorExemplo(Cliente c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
