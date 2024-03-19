import java.util.Scanner;

public class AppBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Classe para dados pessoais e operações bancárias
        class ContaBancaria {
            private String nome;
            private String sobrenome;
            private String cpf;
            private Double saldo;

            public ContaBancaria(String nome, String sobrenome, String cpf) {
                this.nome = nome;
                this.sobrenome = sobrenome;
                this.cpf = cpf;
                this.saldo = 0.0;
            }

            public void consultarSaldo() {
                System.out.println("Saldo atual: R$" + saldo);
            }
            public void depositar(double valor){
                saldo += valor;
                System.out.println("Deposito realizado com sucesso!");
            }

            public void sacar(double valor) {
                if (valor <= saldo) {
                    saldo -= valor;
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente");
                }
            }
        }
        //Criação da conta bancaria
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);

        //Exibição do menu
        int opcao;
        do {
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Encerrar");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.println("Digite o valor do depósito: R$");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 3:
                    System.out.println("Digite o valor do saque: R$");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;

                default:
                    System.out.println("Opção invalida. Tente novamnte.");

            }
        } while (opcao != 0);
        scanner.close();
    }
}