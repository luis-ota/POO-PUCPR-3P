import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] configs = GetConfigs();
        int maxQtdJogador = configs[0];
        int maxQtdNivel = configs[1];
        ArrayList<String> Jogadores = new ArrayList<>(maxQtdJogador);
        int[][] QuantMoedas = new int[maxQtdJogador][maxQtdNivel];
        int[][] Pontuacoes = new int[maxQtdJogador][maxQtdNivel];
        for (int jogador = 0; jogador < maxQtdJogador; jogador++) {
            System.out.println();
            System.out.printf("==== Adicionando Jogador %s ===%n", jogador);
            Object[] novoJogador = NovoJogador();
            Jogadores.add(novoJogador[0].toString());
            QuantMoedas[jogador][0] = (int) novoJogador[1];
            Pontuacoes[jogador][0] = (int) novoJogador[2];
            for (int i = 1; i < maxQtdNivel; i++) {
                QuantMoedas[jogador][i] = 0;
                Pontuacoes[jogador][i] = 0;
            }
        }
        int jogador = 0;
        int nivel = 0;
        while (true){
            Object[] resposta = Menu(Jogadores, jogador, nivel, Pontuacoes);
            String indice = resposta[0].toString();
            switch (indice) {
                case "0" -> System.exit(0);
                case "1" -> jogador = op1(Jogadores);
                case "2" -> nivel = op2(maxQtdNivel);
                case "3" -> op3(Jogadores, jogador, Pontuacoes);
                case "4" -> Pontuacoes[jogador][nivel] = op4(Jogadores, jogador,
                        Pontuacoes, nivel);
                case "5" -> op5(Jogadores, QuantMoedas, nivel, maxQtdJogador);
                case "6" -> op6(Jogadores, Pontuacoes, maxQtdJogador, maxQtdNivel);
                case "7" -> {
                    System.out.println();
                    System.out.println("=== Novo Jogador ===");
                    Object[] novoJogador = NovoJogador();
                    maxQtdJogador += 1;
                    Jogadores.add((String) novoJogador[0]);
                    int[][] NovoQuantMoedas = new int[maxQtdJogador][maxQtdNivel];
                    int[][] NovoPontuacoes = new int[maxQtdJogador][maxQtdNivel];
                    for (int jog = 0; jog < maxQtdJogador - 1; jog++) {
                        for (int nvl = 0; nvl < maxQtdNivel; nvl++) {
                            NovoQuantMoedas[jog][nvl] = QuantMoedas[jog][nvl];
                            NovoPontuacoes[jog][nvl] = Pontuacoes[jog][nvl];
                        }
                    }
                    NovoQuantMoedas[maxQtdJogador - 1][0] = (int) novoJogador[1];
                    NovoPontuacoes[maxQtdJogador - 1][0] = (int) novoJogador[2];
                    for (int i = 1; i < maxQtdNivel; i++) {
                        NovoQuantMoedas[maxQtdJogador - 1][i] = 0;
                        NovoPontuacoes[maxQtdJogador - 1][i] = 0;
                    }
                    QuantMoedas = NovoQuantMoedas;
                    Pontuacoes = NovoPontuacoes;
                }
                default -> {
                    System.out.println();
                    System.out.println("*** Digite um indice valido ***");
                }
            }
        }
    }
    static int[] GetConfigs()
    {
        int maxQtdJogador = InputInt("Informe a quantidade de jogadores: ");
        int t = InputInt("Informe a quantidade de níveis: ");
        System.out.println();
        return new int[]{maxQtdJogador, t};
    }
    static Object[] NovoJogador() {
        String Nome = InputString("Qual o nome do jogador?: ");
        int QuantMoedas = InputInt("Qual a quantidades de moedas?: ");
        int Pontuacao = InputInt(String.format("Qual a pontuação do %s?: ", Nome));
        return new Object[]{Nome, QuantMoedas, Pontuacao};
    }
    static String InputString(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    static int InputInt(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    static Object[] Menu(ArrayList<String> Jogadores,int jogador, int nivel, int[]
            [] Pontuacoes) {
        System.out.println();
        System.out.printf("==* Jogador %s *========* Nivel %s - Pontuação %s *==%n", Jogadores.get(jogador), nivel, Pontuacoes[jogador][nivel]);
        System.out.println();
        System.out.println("1 - Selecionar outro jogador");
        System.out.println("2 - Selecionar outro nivel");
        System.out.println("3 - Mostrar pontuação total do jogador atual");
        System.out.println("4 - Atualizar pontuação do jogador atual");
        System.out.println("5 - Mostrar total de moedas dos jogadores nesse nivel");
        System.out.println("6 - Mostrar jogador com pontuação mais alta");
        System.out.println("7 - Adicionar outro jogador");
        System.out.println();
        return new Object[]{InputString("Digite o indice desejado ou (0) para sair:"), jogador};
        }
        static int op1(ArrayList<String> Jogadores) {
            System.out.println();
            System.out.print("=== Selecione o jogador desejado ===");
            System.out.println();
            for (int jogador = 0; jogador < Jogadores.size(); jogador++) {
                System.out.printf("%s - %s%n", jogador, Jogadores.get(jogador));
            }
            System.out.println();
            return InputInt("Digite o indice desejado: ");
        }
        static int op2(int maxNiveis) {
            System.out.println();
            System.out.print("=== Selecione o nivel desejado ===");
            System.out.println();
            for (int nivel = 0; nivel < maxNiveis; nivel++) {
                System.out.printf("%s - %s%n", nivel, nivel);
            }
            return InputInt("Digite o indice desejado: ");
        }
        static void op3(ArrayList<String> Jogadores, int jogador, int[][] Pontuacoes) {
            System.out.println();
            int pontuacaoTotal = 0;
            for (int nivel = 0; nivel < Pontuacoes[jogador].length; nivel++) {
                System.out.printf("A pontuação do jogador %s no nivel %s foi: %s",
                        Jogadores.get(jogador), nivel, Pontuacoes[jogador][nivel]);
                pontuacaoTotal+=Pontuacoes[jogador][nivel];
                System.out.println();
            }
            System.out.printf("Somando todos os niveis a pontuação total é de: %s",
                    pontuacaoTotal);
            System.out.println();
        }
        static int op4(ArrayList<String> Jogadores, int jogador, int[][] Pontuacoes, int
        nivel) {
            System.out.println();
            System.out.printf("A pontuação do jogador %s no nivel %s é de: %s",
                    Jogadores.get(jogador), nivel, Pontuacoes[jogador][nivel]);
            System.out.println();
            return InputInt("Para qual valor você deseja atualizar a pontuação: ");
        }
        static void op5(ArrayList<String> Jogadores, int[][] Moedas, int nivel, int MaxJogadores) {
            System.out.println();
            System.out.println("=== Total de moedas de cada jogador nesse nivel ===");
            System.out.println();
            for (int jogador = 0; jogador < MaxJogadores; jogador++) {
                System.out.printf(" O jogador %s no nivel %s tem %s moedas", Jogadores.get(jogador), nivel, Moedas[jogador][nivel]);
                System.out.println();
            }

        }
        static void op6(ArrayList<String> Jogadores, int[][] Pontuacao, int MaxJogadores,
        int MaxNiveis) {
            System.out.println();
            System.out.println("=== Jogador com pontuação mais alta ===");
            System.out.println();
            int maiorPontuacao = 0;
            int jogadorMaiorPont = 0;
            for (int jogador = 0; jogador < MaxJogadores; jogador++) {
                int pontuacaoJogador = 0;
                for (int nivel = 0; nivel < MaxNiveis; nivel++) {
                    pontuacaoJogador += Pontuacao[jogador][nivel];
                }
                if(pontuacaoJogador>maiorPontuacao){
                    maiorPontuacao = pontuacaoJogador;
                    jogadorMaiorPont = jogador;
                }
            }
            System.out.printf("A maior pontuação somando todos os nivel é do jogador %s com %s pontos!", Jogadores.get(jogadorMaiorPont), maiorPontuacao);
            System.out.println();
        }
    }
