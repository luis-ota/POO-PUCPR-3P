import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Conta conta = new Conta();
        int opcao;
        do {

            System.out.println("1-Adicionar conta\n2-Depositar\n3-Sacar\n4-Sair");
            opcao = ler.nextInt();

            if (opcao == 1){
                conta.CriarConta(conta.Nome, conta.NumeroConta, conta.Saldo);

            }

            else if (opcao == 2) {

                System.out.println("Saldo atualizado: " + conta.Depositar(conta.Deposito));
            } else if (opcao == 3) {

                System.out.println("Saldo atualizado: "+ conta.Sacar(conta.Saque));
            }

        } while (opcao != 4);
    }
}