package br.univel.cadastro.model;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {

	public void inserir(Cliente c) throws SQLException;

	public void atualizar(Cliente c) throws SQLException;

	public void excluir(Cliente c) throws SQLException;

	public Cliente buscar(int id);

	public Cliente buscarPorExemplo(Cliente c);

	public List<Cliente> listar();
}
