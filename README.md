# Conta Bancária

Este é um projeto em Java que simula as operações básicas de uma conta bancária, incluindo funcionalidades como criação de contas, depósito, saque, transferência e consulta de saldo. 

O projeto foi desenvolvido durante o Bootcamp da Genereation Brasil, uma imersão de mais de 400h com o objetivo de praticar conceitos de POO (Programação Orientada a Objetos).

## Funcionalidades

- Criar contas bancárias (poupança ou corrente).
- Realizar depósitos e saques.
- Efetuar transferências entre contas.
- Consultar saldo.
- Listar todas as contas cadastradas.

## Estrutura do Projeto

O projeto está organizado nas seguintes classes principais:

- **Conta**: Classe base para as contas bancárias, com métodos e atributos genéricos.
- **ContaCorrente** e **ContaPoupanca**: Subclasses que herdam de `Conta`, representando tipos específicos de contas.
- **Cliente**: Representa o titular da conta.
- **ContaController**: Gerencia as operações entre as contas e os clientes.
- **Aplicacao**: Contém o método `main`, que executa o programa.

## Tecnologias Utilizadas

- Linguagem: Java 11+
- Paradigma: Programação Orientada a Objetos (POO)
- IDE: IntelliJ IDEA / Eclipse / VS Code (ou qualquer outra de sua preferência)

## Como Executar o Projeto

1. **Clone o Repositório:**
   ```bash
   git clone https://github.com/machadofatima/contabancaria.git
   ```

2. **Abra o Projeto em sua IDE favorita.**

3. **Compile e Execute:**
   Certifique-se de que sua IDE está configurada para compilar e executar projetos em Java.

4. **Interaja com o Programa:**
   O programa é executado via terminal, onde você pode realizar operações como criar contas, fazer depósitos, saques e transferências.

## Como Contribuir

1. Faça um fork deste repositório.
2. Crie um branch para sua feature ou correção:
   ```bash
   git checkout -b minha-feature
   ```
3. Commit suas alterações:
   ```bash
   git commit -m "Adiciona nova funcionalidade"
   ```
4. Envie para o branch principal:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request no GitHub.

## Licença

Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

Feito com ❤️ por [machadofatima](https://github.com/machadofatima).
