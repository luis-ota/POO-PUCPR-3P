import java.util.ArrayList;
import java.util.Scanner;

public class Conta {

    private static int proximoNumeroConta = 1;
    private static Scanner scanner = new Scanner(System.in);

    public String nome;
    public String sobrenome;
    private  int numeroConta;
    private double saldo;

    public Conta(String nome, String sobrenome, double saldoInicial) {
        numeroConta = proximoNumeroConta ;
        proximoNumeroConta++;

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.saldo = saldoInicial;
    }

    public Conta(String nome, String sobrenome) {
        numeroConta = proximoNumeroConta ;
        proximoNumeroConta++;

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.saldo = 0;
    }

    public static Conta CriarConta() {
        System.out.println("Bem vindo ao banco VictorLuisRafaelGustavo, Qual o seu nome?");
        String nome = scanner.next();
        System.out.println("Qual o seu sobrenome?");
        String sobrenome = scanner.next();

        System.out.println("Qual o saldo da sua conta?");
        double saldo = scanner.nextDouble();

        Conta conta;

        if (saldo == 0) {
            conta = new Conta(nome, sobrenome);
        } else {
            conta = new Conta(nome, sobrenome, saldo);
        }

        System.out.println("Informações da conta: " + "\nTitular: " + conta.nome + "\nNumero:  " + conta.getNumeroConta() + "\nSaldo:  " + conta.getSaldo());
        return conta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double deposito) {
        this.saldo += deposito;
    }
    public boolean sacar(double saque) {
        boolean podeSacar = saldo >= saque;
        if (podeSacar) {
            saldo -= saque;
        }
        return  podeSacar;
    }
}
