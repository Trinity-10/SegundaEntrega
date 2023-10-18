package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	


		private static final String URL = "jdbc:mysql://localhost:3306/AgenciaATW";
		private static final String USER = "root";
		private static final String PASSWORD = "root";
		
		public static Connection createConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println( "Driver encontrado!" );

			} catch (ClassNotFoundException e) {
				System.out.printf( "Driver nao encontrado! Mensagem: " );
			}

			try {
				Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Conectado com sucesso!");

				return connection;
			} catch (SQLException e) {
				System.out.printf( " Nao foi possivel conectar ao banco! Mensagem: " );
				return null;
			}

		}
}