package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner ler = new Scanner (System.in);
		
		int opcao;
		
		while(true) {
			
			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT);
			System.out.println("***********************************************");
			System.out.println("                                               ");
			System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT);
			System.out.println("                 FATIBANK                      ");
			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT);
			System.out.println("                                               ");
			System.out.println("***********************************************");
			System.out.println(Cores.TEXT_WHITE_BOLD);
			System.out.println("                                               ");
			System.out.println("    1 - Criar Conta                            ");		
			System.out.println("    2 - Listar Todas as Contas  	           ");
			System.out.println("    3 - Buscar Conta por Numero                ");		
			System.out.println("    4 - Atualizar Dados da Conta               ");		
			System.out.println("    5 - Apagar Conta                           ");		
			System.out.println("    6 - Sacar                                  ");		
			System.out.println("    7 - Depositar                              ");		
			System.out.println("    8 - Transferir Valores entre Contas        ");		
			System.out.println("    9 - Sair      	                           ");		
			System.out.println("                                               ");
			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT);
			System.out.println("***********************************************");
			System.out.println(Cores.TEXT_WHITE_BOLD);
			System.out.println("                                               ");
			System.out.println("    Entre com a opção desejada:                ");
		
			opcao = ler.nextInt();
			
			if(opcao == 9) {
				System.out.println("\nFATIBANK - TRANSFORMANDO O FUTURO DO SEU DINHEIRO");
				sobre();
				ler.close();
				System.exit(0);
			}
			
			switch(opcao) {
			
			case 1:
				System.out.println("Criar Conta");
				break;
				
			case 2:
				System.out.println("Listar Todas as Contas");
				break;

			case 3:
				System.out.println("Buscar Conta por Numero");
				break;

			case 4:
				System.out.println("Atualizar Dados da Conta");
				break;

			case 5:
				System.out.println("Apagar Conta");
				break;
				
			case 6:
				System.out.println("Sacar");
				break;
				
			case 7:
				System.out.println("Depositar");
				break;
				
			case 8:
				System.out.println("Transferir Valores entre Contas");
				break;
				
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
				
			}
			
		}
		
	}

	public static void sobre() {
		System.out.println("***********************************************");
		System.out.println("Projeto Desenvolvido por: Fátima Machado :) ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("https://github.com/machadofatima/contabancaria.git");
		System.out.println("***********************************************");

	}

}
