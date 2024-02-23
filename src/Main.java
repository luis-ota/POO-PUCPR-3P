import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner objScan = new Scanner(System.in);
        System.out.print("Digite seu nome: ");

        String nome;
        nome = objScan.next();

        System.out.println("Oi " + nome + ", tudo bem?");
        objScan.close();

    }
}