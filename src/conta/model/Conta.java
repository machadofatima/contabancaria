package conta.model;

import conta.util.Cores;

public abstract class Conta {

    private String titular;
    private int numero_conta;
    private int agencia;
    private int tipo;
    private float saldo;

    // Método Construtor: inicializa o objeto com valores iniciais
    // Para gerar um método construtor: Clicar com botão direito > Generate > Constructor
    // Depois de criado, o construtor pega os valores que você passa ao criar o objeto e os
    // guarda nos atributos correspondentes, para que possam ser usados pelo resto da classe.

    public Conta(String titular, int numero_conta, int agencia, int tipo, float saldo) {
        this.titular = titular;
        this.numero_conta = numero_conta;
        this.agencia = agencia;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public int getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(int numero_conta) {
        this.numero_conta = numero_conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean sacar(float valor) {
        if (this.getSaldo() < valor) {
            System.out.println("\nSaldo insuficiente!");
            return false;
        }

        this.setSaldo(this.getSaldo() - valor);
        return true;

    }

    public void depositar(float valor) {
        this.setSaldo(this.getSaldo() + valor);

    }

    public void visualizar() {
        String tipo = "";

        switch(this.tipo) {

            case 1:
                tipo = "Conta Corrente";
                break;

            case 2:
                tipo = "Conta Poupança";
                break;
        }

        System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT);
        System.out.println("***********************************************");
        System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT);
        System.out.println("Dados da Conta ");
        System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT);
        System.out.println("***********************************************");
        System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT);
        System.out.println("Número da Conta: " + this.numero_conta);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Tipo da Conta: " + tipo);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);
        System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT);
        System.out.println("***********************************************");
        System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT);

    }


}

