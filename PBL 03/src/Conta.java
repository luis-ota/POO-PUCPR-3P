import java.util.ArrayList;
import java.util.Scanner;

public class Conta {

    ArrayList<Conta> contas = new ArrayList<>();
    private static int proximoNumeroConta = 1;

    Scanner ler = new Scanner(System.in);
    String Nome;
    int NumeroConta;
    double Saldo;

    double Saque;

    double Deposito;



    public Conta CriarConta(String Nome, int NumeroConta, double Saldo){
        System.out.println("Bem vindo ao banco VictorLuisRafaelGustavo, Qual o seu nome?");
        Scanner ler = new Scanner(System.in);
        Conta conta = new Conta();
        conta.NumeroConta = proximoNumeroConta++;
        conta.Nome = ler.next();



        System.out.println("Qual o saldo da sua conta?");
        conta.Saldo = ler.nextDouble();

        System.out.println("Informações da conta: " + "\nTitular: " + conta.Nome + "\nNumero:  " + conta.NumeroConta + "\nSaldo:  " + conta.Saldo);
        contas.add(conta);
        return conta;
    }

    public double Depositar(double Deposito){
        System.out.println("Em qual conta voce quer depositar? ");
        int numeroConta = ler.nextInt();
        Conta conta = encontrarConta(this.contas,numeroConta);
        if (conta != null){
            System.out.println("Qual a quantia que quer depositar? ");
            Deposito = ler.nextDouble();
            conta.Saldo += Deposito;
            return conta.Saldo;
        }
        else{
            System.out.println("Conta não encontrada");
            return -1;
        }
    }
    public double Sacar(double Saque){
        System.out.println("Qual o número da conta que quer sacar?");
        int numeroConta = ler.nextInt();
        Conta conta = encontrarConta(this.contas, numeroConta);
        if (conta != null){
            System.out.println("Qual a quantia que quer sacar? ");
            Saque = ler.nextDouble();
            conta.Saldo -= Saque;
            return conta.Saldo;
        }
        else {
            System.out.println("Conta não encontrada");
            return -1;
        }
    }

    private static Conta encontrarConta(ArrayList<Conta> contas, int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
    public int getNumeroConta(){
        return this.NumeroConta;
    }

}
