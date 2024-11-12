package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        ContaController contas = new ContaController();

        int opcao, numero_conta, agencia, tipo, aniversario, numeroDestino;
        String titular;
        float saldo, limite, valor;

        System.out.println("\nCriar Contas\n");

        ContaCorrente cc1 = new ContaCorrente("Cleo Xavier Clain de Abreu Machado da Silva", contas.gerarNumero_conta(), 001, 1,13000f,1200f);
        contas.cadastrar(cc1);

        ContaCorrente cc2 = new ContaCorrente("Betina Xavier Clain de Abreu Machado Polaroid da Silva", contas.gerarNumero_conta(), 001, 1,13000f,1200f);
        contas.cadastrar(cc2);

        ContaPoupanca cp1 = new ContaPoupanca("Angélica Melody Xavier Clain de Abreu Machado da Silva ", contas.gerarNumero_conta(), 003, 2,12000f,13);
        contas.cadastrar(cp1);

        ContaPoupanca cp2 = new ContaPoupanca("Marcelino Xavier Clain de Abreu Machado da Silva", contas.gerarNumero_conta(), 003, 2,12000f,12);
        contas.cadastrar(cp2);

        contas.listarTodas();

        while (true) {

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

            try {
                ler.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite apenas valores inteiros!");
                ler.nextLine();
                opcao = 0;
            }


            if (opcao == 9) {
                System.out.println("\nFATIBANK - TRANSFORMANDO O FUTURO DO SEU DINHEIRO");
                sobre();
                ler.close();
                System.exit(0);
            }


            switch (opcao) {

                case 1:
                    System.out.println("Criar conta");
                    System.out.println("Digite o número da agência: ");
                    agencia = ler.nextInt();
                    System.out.println("Digite o nome do titular: ");
                    ler.skip("\\R?");
                    titular = ler.nextLine();

                    do {
                        System.out.println("Digite o tipo de conta (1 - Conta Corrente | 2 - Conta Poupança): ");
                        tipo = ler.nextInt();
                    } while (tipo < 1 || tipo > 2);

                    System.out.println("Digite o saldo da conta (R$): ");
                    saldo = ler.nextFloat();

                    switch (tipo) {
                        case 1 -> {
                            System.out.println("Digite o limite de crédito (R$): ");
                            limite = ler.nextFloat();

                            contas.cadastrar(new ContaCorrente(titular, contas.gerarNumero_conta(), agencia, tipo, saldo, limite));
                        }

                        case 2 -> {
                            System.out.println("Digite o dia do aniversário da conta: ");
                            aniversario = ler.nextInt();

                            contas.cadastrar(new ContaPoupanca(titular, contas.gerarNumero_conta(), agencia, tipo, saldo, aniversario));
                        }


                    }

                    keyPress();
                    break;

           case 2:
               System.out.println("Listar Todas as Contas");
               contas.listarTodas();
               keyPress();
               break;


            case 3:
                System.out.println("Consultar Dados da Conta por Numero\n\n");

                System.out.println("Digite o Número da Conta: \n\n");
                numero_conta = ler.nextInt();

                contas.procurarPorNumero_Conta(numero_conta);

                keyPress();
                break;

            case 4:
                System.out.println("\n\nAtualizar Dados da Conta");

                System.out.println("\nDigite o Número da Conta: \n\n");
                numero_conta = ler.nextInt();

                var buscaConta = contas.buscarNaCollection(numero_conta);

                if (buscaConta != null) {

                    tipo = buscaConta.getTipo();

                    System.out.println("Digite o Número da Agência: ");
                    agencia = ler.nextInt();

                    System.out.println("Digite o Nome do Titular: ");
                    ler.skip("\\R?");
                    titular = ler.nextLine();

                    System.out.println("Digite o Saldo da Conta (R$): ");
                    saldo = ler.nextFloat();

                    switch (tipo) {
                        case 1 -> {
                            System.out.println("Digite o Limite de Crédito (R$): ");
                            limite = ler.nextFloat();

                            contas.atualizar(new ContaCorrente(titular, numero_conta, agencia, tipo, saldo, limite));

                        }

                        case 2 -> {
                            System.out.println("Digite o dia do Aniversário da conta: ");
                            aniversario = ler.nextInt();

                            contas.atualizar(new ContaPoupanca(titular, numero_conta, agencia, tipo, saldo, aniversario));

                        }
                        default -> {
                            System.out.println("Tipo de conta inválida!");

                        }

                    }
                }else {
                    System.out.println("A conta não foi encontrada!");

                }

                keyPress();
                break;

            case 5:
                System.out.println("Apagar Conta");

                System.out.println("Digite o Número da Conta: ");
                numero_conta = ler.nextInt();

                contas.deletar(numero_conta);

                keyPress();
                break;

            case 6:
                System.out.println("Sacar");

                System.out.println("Digite o Número da Conta: ");
                numero_conta = ler.nextInt();

                do {
                    System.out.println("Digite o Valor do Saque (R$): ");
                    valor = ler.nextFloat();

                }while(valor <= 0);

                contas.sacar(numero_conta, valor);

                keyPress();
                break;

            case 7:
                System.out.println("Depositar");
                System.out.println("Digite o Número da Conta: ");
                numero_conta = ler.nextInt();

                do {
                    System.out.println("Digite o Valor do Depósito (R$): ");
                    valor = ler.nextFloat();

                }while(valor <= 0);

                contas.depositar(numero_conta, valor);

                keyPress();
                break;

            case 8:
                System.out.println("Transferir Valores entre Contas");

                System.out.println("Digite o Número da Conta de Origem : ");
                numero_conta = ler.nextInt();
                System.out.println("Digite o Número da Conta de Destino : ");
                numeroDestino = ler.nextInt();

                do {
                    System.out.println("Digite o Valor da Transferência (R$): ");
                    valor = ler.nextFloat();

                }while(valor <= 0);

                contas.transferir(numero_conta, numeroDestino, valor);

                keyPress();
                break;

            default:
                System.out.println("\nOpção Inválida!\n");
                keyPress();
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

    public static void keyPress() {

        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
            System.in.read();

        } catch (IOException e) {

            System.out.println("Você pressionou uma tecla diferente de Enter!");
        }

    }

}
