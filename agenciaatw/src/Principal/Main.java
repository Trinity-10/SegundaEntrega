package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.agencia.model.Cliente;
import com.agencia.model.Compra;
import com.agencia.model.Destino;

import agenciaDAO.ClienteDAO;
import agenciaDAO.CompraDAO;
import agenciaDAO.DestinoDAO;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection connection = Conexao.createConnection();
		ClienteDAO clienteDAO = new ClienteDAO(connection);
		DestinoDAO destinoDAO = new DestinoDAO(connection);
		CompraDAO compraDAO = new CompraDAO(connection);
	
	//	Connection connection = null;
		
int option = 0;
try {

    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenciaatw", "root",
            "root");

		while (true) {
			System.out.println("\nSistema de Gestão de agencia de viagens");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Ler Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("5. Criar Destino");
            System.out.println("6. Ler Destino");
            System.out.println("7. Atualizar Destino");
            System.out.println("8. Deletar Destino");
            System.out.println("9. Criar Compra");
            System.out.println("10. Ler Compra");
            System.out.println("11. Atualizar Compra");
            System.out.println("12. Deletar Compra");
            System.out.println("13. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();

            switch (opcao) {
            
            //Criar Cliente
            
                case 1: 
                	Cliente cliente = new Cliente();
                	System.out.println("Nome do cliente:");
                	scanner.nextLine();
                	cliente.setNomeCliente(scanner.nextLine());
                	System.out.println("Cpf do cliente:");
                	cliente.setCpfCliente(scanner.nextLine());
                	System.out.println("Endereço do cliente:");
                	cliente.setEnderecoCliente(scanner.nextLine());
                	System.out.println("Telefone do cliente:");
                	cliente.setTelefoneCliente(scanner.nextLine());
                	System.out.println("Email  do cliente:");
                	cliente.setEmailCliente(scanner.nextLine());
                	clienteDAO.createCliente(cliente);
                	
                	
                	break;
                	
                //ler cliente	
                case 2:
                	clienteDAO.ReadAllClients(2);
                	break;
                	
                	//atualizar cadastro cliente
                case 3:
                	Cliente Atualizado = new Cliente();
                	System.out.println("Nome do cliente:");
                	scanner.nextLine();
                	Atualizado.setNomeCliente(scanner.nextLine());
                	System.out.println("Cpf do cliente:");
                	Atualizado.setCpfCliente(scanner.nextLine());
                	System.out.println("Endereço do cliente:");
                	Atualizado.setEnderecoCliente(scanner.nextLine());
                	System.out.println("Telefone do cliente:");
                	Atualizado.setTelefoneCliente(scanner.nextLine());
                	System.out.println("Email  do cliente:");
                	Atualizado.setEmailCliente(scanner.nextLine());
                	Atualizado.updateCliente(Atualizado);
                	
                	break;
                	
                case 4:
                	System.out.println("Digite o ID do Cliente a ser DELETADO: ");
                    int idCliente = scanner.nextInt();
                    clienteDAO.deleteCliente(idCliente);
                    break;
                    
                 //Criar Destino   
                    
                case 5:
                	
                	Destino createDestino = new Destino();
                    System.out.println("Digite o local de destino:");
                    createDestino.setLocalDestino(scanner.next());
                    System.out.println("Digite o horário do destino:");
                    createDestino.setHorarioDestino(scanner.next());
                    destinoDAO.createDestino(createDestino);

                    break;
                    
                    //Ler destino
                    
                case 6:
                	destinoDAO.readAllClients(2);
                	break;
        
                	//Atualizar Destino
                case 7:
                	Destino destinoAtualizado = new Destino();
                	System.out.println("Digite o iD do destino a ser atualizado:)");
                	destinoAtualizado.setIdDestino(scanner.nextInt());
                	scanner.nextLine();
                	System.out.println("Digite o local a ser atualizado:");
                	destinoAtualizado.setLocalDestino(scanner.next());
                	scanner.nextLine();
                	System.out.println("Digite o novo horário:");
                	destinoDAO.updateDestino(destinoAtualizado);
                	break;
                	
                	//Deletar destino
                case 8:
                    System.out.println("Digite o ID do Destino a ser Deletado: ");
                    int nomeDestino = scanner.nextInt();
                    destinoDAO.deleteDestino(nomeDestino);
                    break;
                    
                    //Criar Compra
                    
                case 9:
                	Compra createCompra = new Compra();
                    System.out.println("Digite a nova compra:");
                    createCompra.setIdCompra(scanner.nextInt());
                    System.out.println("Digite o valor da nova compra:");
        			createCompra.setValorCompra(scanner.nextDouble());
        			System.out.println("Digite a descricao da nova compra:");
        			createCompra.setDescricaoCompra(scanner.next());
        			System.out.println("Digite o id destino:");
        			createCompra.setIdCompra(scanner.nextInt());
        			System.out.println("Digite o id cliente:");
        			createCompra.setCliente(scanner.nextInt());
        			compraDAO.createCompra(createCompra);
        			break;
        			
        			//Ler Compra
        			
                case 10:
                	compraDAO.readAllCompra();
                	break;
                	
                	
                	//Atualizar Compra
                case 11:
                	Compra compraAtualizada = new Compra();
                	System.out.println("Digite o iD da compra a ser atualizada:)");
                	compraAtualizada.setIdCompra(scanner.nextInt());
                	scanner.nextLine();
                	System.out.println("Digite o novo valor da compra:");
                	compraAtualizada.setValorCompra(scanner.nextDouble());
                	scanner.nextLine();
                	System.out.println("Digite a nova descricao"); 
                	compraAtualizada.setDescricaoCompra(scanner.next());
                	compraDAO.updateCompra(compraAtualizada);
                	break;
                	
                	//Deletar Compra
                	
                case 12:
                	System.out.println("Digite o ID do Compra a ser Deletado: ");
                    int nomeCompra = scanner.nextInt();
                    compraDAO.deleteCompra(nomeCompra);
                    break;
                   
                
                case 13:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
            
           


		}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

	
	
	