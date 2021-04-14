package br.com.SistemaLoja.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "12345678";
	private static final String URL = "jdbc:mysql://localhost:3306/sistema";
	
	
	public static Connection conectar() throws SQLException {

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

}
