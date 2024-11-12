package conta.repository;

import conta.model.Conta;

public interface ContaRepository {

    // Métodos CRUD da conta (Create, Read, Update e Delete)
    public void procurarPorNumero_Conta(int numero_conta);
    public void listarTodas();
    public void cadastrar(Conta conta);
    public void atualizar(Conta conta);
    public void deletar(int numero_conta);

    // Métodos Bancários
    public void sacar(int numero_conta, float valor);
    public void depositar(int numero_conta, float valor);
    public void transferir(int numeroOrigem, int numeroDestino, float valor);


}
