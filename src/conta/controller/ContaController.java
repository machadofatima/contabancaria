package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<Conta>();
    int numero_conta = 0;


    @Override
    public void listarTodas() {
        for (var conta : listaContas) {
            conta.visualizar();
        }

    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("\nConta número: " + conta.getNumero_conta() + " foi criada com sucesso!");

    }

    @Override
    public void atualizar(Conta conta) {
        var buscarConta = buscarNaCollection(conta.getNumero_conta());

        if (buscarConta != null) {
            listaContas.set(listaContas.indexOf(buscarConta), conta);
            System.out.println("\nConta número: " + conta.getNumero_conta() + " foi atualizada com sucesso!");
        }else
            System.out.println("\nConta número: " + conta.getNumero_conta() + " não foi encontrada!");


    }

    @Override
    public void deletar(int numero_conta) {
        var conta = buscarNaCollection(numero_conta);

        if (conta != null) {
            if (listaContas.remove(conta) == true)
                System.out.println("\nA conta numero: " + numero_conta + " foi deletada com sucesso!");
        }else
            System.out.println("\nA conta numero: " + numero_conta + " não foi encontrada!");

    }

    @Override
    public void sacar(int numero_conta, float valor) {
        var conta = buscarNaCollection(numero_conta);
        if (conta != null) {

            if (conta.sacar(valor) == true)
                System.out.println("\nO Saque na Conta Número: " + numero_conta + " foi efetuado com sucesso!");
        } else
            System.out.println("\nConta Número: " + numero_conta + " não foi encontrada!");


    }

    @Override
    public void depositar(int numero_conta, float valor) {
        var conta = buscarNaCollection(numero_conta);

        if(conta != null) {
            conta.depositar(valor);
            System.out.println("\nO Depósito na Conta Número: " + numero_conta + " foi efetuado com sucesso!");

        } else
            System.out.println("\nConta Número: " + numero_conta + " não foi encontrada ou a Conta destino não é uma Conta Corrente!");

    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        var contaOrigem = buscarNaCollection(numeroOrigem);
        var contaDestino = buscarNaCollection(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.sacar(valor) == true) {
                contaDestino.depositar(valor);
                System.out.println("\nA Transferência foi efetuada com sucesso!");
            }
        }else
            System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas!");



    }

    public int gerarNumero_conta() {
        return ++ numero_conta;
    }

    public Conta buscarNaCollection(int numero_conta) {
        for (var conta : listaContas) {
            if (conta.getNumero_conta() == numero_conta) {
                return conta;
            }
        }
         return null;
    }

    @Override
    public void procurarPorNumero_Conta(int numero_conta) {
        Conta conta = buscarNaCollection(numero_conta);

        if(conta != null)
            conta.visualizar();
        else
            System.out.println("\nA conta número: " + numero_conta + " não foi encontrada");
    }

}
