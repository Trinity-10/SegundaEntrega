package agenciaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Cliente;
import com.agencia.model.Compra;
import com.agencia.model.Destino;

public class CompraDAO {
	
	
	private static String sql;

	private final Connection connection;

	
	public CompraDAO(Connection connection) {
		this.connection = connection;
	} 
	
	 //CREATE
		public void createCompra(Compra compra) {
			sql = "INSERT INTO Compra (valor, descricao, idDestino, idCliente) VALUES (?, ?, ?, ?) ";
			try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setDouble(1,  compra.getValorCompra());
			stmt.setString(2, compra.getDescricaoCompra());
			stmt.setInt(3, compra.getIdCompra());
			stmt.setInt(4, compra.getCliente().getIdCliente());
			stmt.executeUpdate();
	
	
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
			}
			}
		
		//READ
				public void readAllCompra() {
					sql = "SELECT * FROM compra as d " + "INNER JOIN cliente as c " + " ON d.idCliente = c.idCliente";
				
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					ResultSet r = stmt.executeQuery();
					
					while (r.next()) {
						//criar objeto compra
						
						Compra compra = new Compra();
						compra.setIdCompra(r.getInt("idCompra"));
						compra.setValorCompra(r.getDouble("valorCompra"));
						compra.setDescricaoCompra(r.getString("descricaoCompra"));
					
						
						Cliente cliente = new Cliente();
						cliente.setIdCliente(r.getInt("idCliente"));
						cliente.setNomeCliente(r.getString("nomeCliente"));
						cliente.setCpfCliente(r.getString("cpfCliente"));
						cliente.setEnderecoCliente(r.getString("enderecoCliente"));
						cliente.setTelefoneCliente(r.getString("telefoneCliente"));
						cliente.setEmailCliente(r.getString("emailCliente"));

						System.out.println("ID do Compra:" + compra.getIdCompra() + "\nLocal do Compra: " + compra.getValorCompra() + "\nNome ID do Cliente: " + cliente.getIdCliente() + "\nNome Cliente: " + cliente.getNomeCliente());
					
					}		
				} catch (SQLException e) {
					System.out.println("[LOG] Não foi possível acessar as informações. Mensagem: " + e.getMessage());

				}
			
				}
			



			//UPDATE
			public void updateCompra(Compra compra) {
				sql = "UPDATE compra SET idCompra = ?, valorCompra = ?, descricaoCompra = ? WHERE idCompra = ?";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					stmt.setInt(1, compra.getIdCompra());
					stmt.setDouble(2, compra.getValorCompra());
					stmt.setString(3, compra.getDescricaoCompra());


					stmt.executeUpdate();
					System.out.println("Compra atualizada com sucesso.\n " + "Valor: "
							+ compra.getValorCompra() + " \nDescricao: " + compra.getDescricaoCompra());

				} catch (SQLException e) {
					System.out.println("[LOG] Não foi possível atualizar a compra." + e.getMessage());
				}
			
			}
			
			//DELETE
				public void deleteCompra(int id) {
					sql = "DELETE FROM compra WHERE idCompra = ?";
					try (PreparedStatement stmt = connection.prepareStatement(sql)){
						stmt.setInt(1,  id);
						stmt.executeUpdate();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					
				}
				
			}

			

