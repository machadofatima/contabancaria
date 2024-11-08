package conta.model;

public class ContaCorrente extends Conta {

    private float limite;

    public ContaCorrente(String titular, int numero_conta, int agencia, int tipo, float saldo, float limite) {
        super(titular, numero_conta, agencia, tipo, saldo);
        this.limite = limite;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override // sobrescreve (redefine) o método sacar
    public boolean sacar(float valor){
        if(this.getSaldo() + this.getLimite() < valor){ // se o saldo - o limite for < que o valor não efetua o saque
            System.out.println("\nSaldo insuficiente!");
            return false;
        }

        this.setSaldo(this.getSaldo() - valor); // atualiza o saldo com o valor do saldo - o valor do saque
        return true;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Limite disponível: " + this.limite);
    }


}
