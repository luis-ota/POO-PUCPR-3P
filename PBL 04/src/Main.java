import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Conta>  contas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("1-Adicionar conta\n2-Depositar\n3-Sacar\n4-Sair");
            opcao = scanner.nextInt();

            if (opcao == 1){
                contas.add(Conta.CriarConta());
            }

            else if (opcao == 2) {

                System.out.println("Saldo atualizado: " + depositar());
            } else if (opcao == 3) {

                System.out.println("Saldo atualizado: "+ sacar());
            }

        } while (opcao != 4);
    }

    private static double depositar() {
        System.out.println("Em qual conta voce quer depositar? ");
        int numeroConta = scanner.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Qual a quantia que quer depositar? ");
            double deposito = scanner.nextDouble();
            conta.depositar(deposito);
            return conta.getSaldo();
        }
        else{
            System.out.println("Conta não encontrada");
            return -1;
        }
    }

    private static double sacar() {
        System.out.println("Qual o número da conta que quer sacar?");
        int numeroConta = scanner.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual a quantia que quer sacar? ");
            double saque = scanner.nextDouble();
            boolean sacou = conta.sacar(saque);
            if (!sacou) {
                System.out.println("Não há saldo o suficiente para sacar. ");
            }
            return conta.getSaldo();
        }
        else {
            System.out.println("Conta não encontrada");
            return -1;
        }
    }

    private static Conta encontrarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}