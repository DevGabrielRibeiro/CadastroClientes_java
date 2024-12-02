package br.com.cadastro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		
		while (opcao !=5) {
			System.out.println("1. Adicionar Cliente");
			System.out.println("2. Listar Clientes");
			System.out.println("3. Remover CLiente");
			System.out.println("4. Adicionar veiculo a Cliente");
			System.out.println("5. Sair");
			System.out.println("Escolha uma opcao: ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch(opcao) {
			case 1:
				adicionarCliente(scanner);
				break;
			case 2:
				listarClientes();
				break;
			case 3:
				removerCliente(scanner);
				break;
			case 4:
				adicionarVeiculoACliente(scanner);
				break;
			case 5:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opcao invalida");				
			}																																
		}																								
		scanner.close();
	}
	
		
	private static void adicionarCliente(Scanner scanner) {
			System.out.print("Nome: ");
			String nome = scanner.nextLine();
			System.out.print("Email: ");
			String email = scanner.nextLine();
			System.out.print("Telefone: ");
			String telefone = scanner.nextLine();
			
			Cliente cliente = new Cliente(nome, email, telefone);
			clientes.add(cliente);
			System.out.println("Cliente adicionado com sucesso!");
		}
		
		private static void listarClientes() {
			if(clientes.isEmpty()) {
				System.out.println("Nenhum cliente cadastrado.");
			} else {
				for (Cliente clientes : clientes) {
					System.out.println(clientes);
				}
			}
		}
		
		private static void removerCliente(Scanner scanner) {
			System.out.print("Digite o nome do cliente a ser removido: ");
			String nome = scanner.nextLine();
			
			Cliente clienteARemover = null;
			for (Cliente cliente : clientes) {
				if (cliente.getNome().equalsIgnoreCase(nome)) {
					clienteARemover = cliente;
					break;
				}
			}
			
			if (clienteARemover != null) {
				clientes.remove(clienteARemover);
				System.out.println("Cliente removido com sucesso!");
			} else {
				System.out.println("Cliente nao encontrado.");
			}
		}
		
		private static void adicionarVeiculoACliente(Scanner scanner) {
			System.out.print("Digite o nome do cliente: ");
			String nomeCliente = scanner.nextLine();
			
			Cliente cliente = null;
			for(Cliente c : clientes){
				if(c.getNome().equalsIgnoreCase(nomeCliente)) {
					cliente = c;
					break;
				}
			}
			
				if(cliente != null) {
				System.out.print("Marca do veiculo: ");
				String marca = scanner.nextLine();
				System.out.print("Modelo do veiculo: ");
				String modelo = scanner.nextLine();
				System.out.print("Placa do veiculo: ");
				String placa = scanner.nextLine();
				
				Veiculo veiculo = new Veiculo(marca, modelo, placa);
				cliente.adicionarVeiculo(veiculo);
				System.out.println("Veiculo adicionado com sucesso!");
				} else {
					System.out.println("Cliente nao encontrado.");
				}
		}
}

