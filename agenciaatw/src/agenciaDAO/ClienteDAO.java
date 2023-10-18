package agenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Cliente;

public class ClienteDAO { // CRIACAO DOS METODOS DE ACESSO AO BANCO DE DADOS DAO = data acess objet

	private static String sql;

	private final Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE(PRIMEIRO METODO do CRUD CREATE read update delete)
	public void createCliente(Cliente cliente) {
		sql = "INSERT INTO cliente (nomeCliente, cpfCliente, enderecoCliente, telefoneCliente, emailCliente) VALUES (?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getEnderecoCliente());
			stmt.setString(4, cliente.getTelefoneCliente());
			stmt.setString(5, cliente.getEmailCliente()); // envia pro banco as strings que precisamos pra compor o
															// objeto

			stmt.executeUpdate();
			System.out.println("Cliente criado com sucesso.\n " + cliente.getNomeCliente() + "Nome: "
					+ cliente.getNomeCliente() + " \nCPF: " + cliente.getCpfCliente());
		} catch (SQLException e) {
			System.out.println("[LOG] Nao foi possível criar o cliente. Mensagem: " + e.getMessage());
		}

	}

// método READ
	public void readAllClients() {
		sql = "SELECT * FROM cliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Cliente cliente = new Cliente(); // cria objeto cliente
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setEnderecoCliente(r.getString("enderecoCliente"));
				cliente.setTelefoneCliente(r.getString("telefoneCliente"));
				cliente.setEmailCliente(r.getString("emailCliente"));

				System.out.printf(
						"ID: %d\n Nome: %s\n CPF: %s\n Endereco: %s\n Telefone: %s\n Email: %s\n, cliente.get,IdCliente()",
						cliente.getNomeCliente(), cliente.getCpfCliente(), cliente.getEnderecoCliente(),
						cliente.getTelefoneCliente(), cliente.getEmailCliente());

			}
			if (!r.next()) {
				System.out.println("Não há dados");
			}

		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível acessar as informações. Mensagem: " + e.getMessage());

		}
	}

	// UPDATE
	public void updateCliente(Cliente cliente) {
		sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente ?, enderecoCliente = ?, telefoneCliente = ?, emailCliente = ?, WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getEnderecoCliente());
			stmt.setString(3, cliente.getTelefoneCliente());
			stmt.setString(3, cliente.getEmailCliente());
			stmt.setInt(5, cliente.getIdCliente());

			stmt.executeUpdate();
			System.out.println("Cliente atualizado com sucesso.\n " + cliente.getNomeCliente() + "Nome: "
					+ cliente.getNomeCliente() + " \nCPF: " + cliente.getCpfCliente());

		} catch (SQLException e) {
			System.out.println("[LOG] Não foi possível atualizar o cliente." + e.getMessage());
		}
	}

	// DELETE
	public void deleteCliente(int id) {
		sql = "DELETE FROM cliente WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println("Cliente deletado com sucesso.");
		} catch (Exception e) {
			System.out.println("Não foi possível deletar o cliente" + "Mensagem: " + e.getMessage());
		}

	}

	public void ReadAllClients(int i) {
		// TODO Auto-generated method stub
		
	}
}
