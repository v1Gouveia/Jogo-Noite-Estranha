
import java.util.Scanner;

public class JogoNoiteEstranha {

    public String nome;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoNoiteEstranha jogo = new JogoNoiteEstranha();

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Iniciar o jogo");
            System.out.println("2. Instruções");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    long inicio = System.nanoTime();
                    jogo.iniciarJogo();
                    long fim = System.nanoTime();

                    long duracao = fim - inicio;
                    long segundosTotais = duracao / 1_000_000_000;
                    long minutos = segundosTotais / 60;
                    long segundosRestantes = segundosTotais % 60;

                    if (minutos <= 0) {
                        System.out.println("");
                    } else if (minutos >= 1 && minutos <= 2) {
                        System.out.println("Você demorou " + minutos + " minuto e " + segundosRestantes + " e segundos.");
                        System.out.println("Você foi rápido e continua jovem!");
                    } else if (minutos >= 2 && minutos <= 5) {
                        System.out.println("Você demorou " + minutos + " minuto e " + segundosRestantes + " e segundos.");
                        System.out.println("Você demorou um pouco e está adulto!");
                    } else {
                        System.out.println("Você demorou " + minutos + " minuto e " + segundosRestantes + " e segundos.");
                        System.out.println("Você demorou muito e ficou muito velho!");
                    }
                    break;
                case "2":
                    System.out.println("\n=== INSTRUÇÕES ===");
                    System.out.println("Responda corretamente às perguntas em cada fase para avançar na história.");
                    System.out.println("Se errar, o jogo termina. Boa sorte!");
                    break;
                case "3":
                    System.out.println("Saindo do jogo. Até a próxima!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite seu nome:");
        nome = scanner.nextLine();

        iniciarHistoria();

        if (faseParedes() && fasePortas() && faseRelogio()) {
            fimJogo();
        }

        scanner.close();
    }
