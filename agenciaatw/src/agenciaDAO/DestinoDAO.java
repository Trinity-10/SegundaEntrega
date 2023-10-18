package agenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Cliente;
import com.agencia.model.Destino;

public class DestinoDAO {

	private static String sql;

	private final Connection connection;

	public DestinoDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createDestino(Destino destino) {
		sql = "INSERT INTO Destino (localDestino, horarioDestino, IdCompra) VALUES (?, ?, ?) ";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
		stmt.setString(1,  destino.getLocalDestino());
		stmt.setString(2, destino.getHorarioDestino());
		stmt.setInt(3, destino.getIdDestino());
		stmt.executeUpdate();

	
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		
	}
	}
		//READ
		public void readAllDestinos() {
			sql = "SELECT * FROM destino as d " + "INNER JOIN cliente as c " + " ON d.idCliente = c.idCliente";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			
			while (r.next()) {
				//Destino
				Destino destino = new Destino();
				destino.setIdDestino(r.getInt("idDestino"));
				destino.setLocalDestino(r.getString("localDestino"));
				destino.setHorarioDestino(r.getString("horarioDestino"));
				
				//cliente do destino
				Cliente cliente = new Cliente();
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setEnderecoCliente(r.getString("enderecoCliente"));
				cliente.setTelefoneCliente(r.getString("telefoneCliente"));
				cliente.setEmailCliente(r.getString("emailCliente"));

				System.out.println("ID do Destino:" + destino.getIdDestino() + "\nLocal do Destino: " + destino.getLocalDestino() + "\nNome ID do Cliente: " + cliente.getIdCliente() + "\nNome Cliente: " + cliente.getNomeCliente());
			
			}		
		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível acessar as informações. Mensagem: " + e.getMessage());

		}
	
		}
	



	//UPDATE
	public void updateDestino(Destino destino) {
		sql = "UPDATE destino SET localDestino = ?, horarioDestino = ?, idCompra = ? WHERE idDestino = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destino.getLocalDestino());
			stmt.setString(2, destino.getHorarioDestino());
	//		stmt.setInt(3, destino.getCompra().getIdCompra());
			stmt.setInt(4, destino.getIdDestino());


			stmt.executeUpdate();
			System.out.println("Destino atualizado com sucesso.\n " + "Local: "
					+ destino.getLocalDestino() + " \nHorario: " + destino.getHorarioDestino());

		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível atualizar o destino." + e.getMessage());
		}
	
	}
	
	//DELETE
		public void deleteDestino(int id) {
			sql = "DELETE FROM destino WHERE idDestino = ?";
			try (PreparedStatement stmt = connection.prepareStatement(sql)){
				stmt.setInt(1,  id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}

		public void readAllClients(int i) {
			// TODO Auto-generated method stub
			
		}
		
	}

	

