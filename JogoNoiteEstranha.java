
import java.util.Scanner;

public class JogoNoiteEstranha {

    public String nome;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JogoNoiteEstranha jogo = new JogoNoiteEstranha();

        while (true) {
            System.out.print("""
                                                                                                                                
                               _____      _                     _                      _                              _         
                              |     |   _| |___ ___ ___ ___ ___| |_ ___ ___    ___ ___| |_ ___ ___    _____ _ _ ___ _| |___ ___ 
                              |  |  |  | . | -_|_ -| . | -_|  _|  _| .'|  _|  | -_|   |  _|  _| -_|  |     | | |   | . | . |_ -|
                              |_____|  |___|___|___|  _|___|_| |_| |__,|_|    |___|_|_|_| |_| |___|  |_|_|_|___|_|_|___|___|___|
                                                   |_|                                                                          
                              """);
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Iniciar o jogo");
            System.out.println("2. Instruções");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            String escolha = input.nextLine();

            switch (escolha) {
                case "1":
                    jogo.iniciarJogo();
                    
                    break;
                case "2":
                    System.out.println("\n=== INSTRUÇÕES ===");
                    System.out.println("Responda corretamente às perguntas em cada fase para avançar na história.");
                    System.out.println("Se errar, o jogo termina. Boa sorte!");
                    break;
                case "3":
                    System.out.println("Saindo do jogo. Até a próxima!");
                    input.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void iniciarJogo() {
        Scanner input = new Scanner(System.in);
        long inicio = System.nanoTime();
        System.out.println("Digite seu nome:");
        nome = input .nextLine();

        iniciarHistoria();

        if (faseParedes() && perguntas2() && fasePortas() && perguntas3() && faseRelogio() && perguntas4()) {
            fimJogo();
        }
        long fim = System.nanoTime();
        long duracao = fim - inicio;
        long segundosTotais = duracao / 1_000_000_000;
        long minutos = segundosTotais / 60;
        long segundosRestantes = segundosTotais % 60;
        
         if (minutos <= 0 && segundosRestantes <30) {
            System.out.println("Seu tempo: " + minutos + ":" + segundosRestantes + " segundos" );
            System.out.println("Você não conseguiu ficou preso para sempre!");
            input
 .nextLine();
           } else if (minutos >= 1 && minutos <= 2){
            System.out.println("Você demorou " + minutos + " minuto e " + segundosRestantes + " e segundos.");
            System.out.println("Você foi rápido e continua jovem!");  
            input
 .nextLine();
           } else if (minutos >= 2 && minutos <= 5) {
            System.out.println("Você demorou " + minutos + " minuto e " + segundosRestantes + " e segundos.");
            System.out.println("Você demorou um pouco e está adulto!");
            input
 .nextLine();
           } else {
            System.out.println("Você demorou " + minutos + " minuto e " + segundosRestantes + " e segundos.");
            System.out.println("Você demorou muito e ficou muito velho!");
            input
 .nextLine();

         }

        input .close();
    }

    public void iniciarHistoria() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEm uma noite chuvosa, " + nome + " estava prestes a pegar no sono...");
        System.out.println("Ao adormecer, " + nome + " se vê suspenso no ar, confuso.");
        System.out.println("Uma voz misteriosa ecoa: 'Para sair deste lugar, você precisa deter as paredes.'");
        System.out.println("pressione qualquer enter para continuar..."); 
        input.nextLine();
    }

    public boolean faseParedes() {
        System.out.println("Respondas as perguntas para achar a porta certa:");
        System.out.println("\n=== FASE DAS PAREDES ===");
        return perguntaMultipla(
            "Qual das alternativas representa uma função em Java?",
            new String[]{
                "a) int numero = 5;",
                "b) System.out.println();",
                "c) public void minhaFuncao() {}",
                "d) Scanner sc = new Scanner(System.in);"
            },
            'c'
        );
    }
    ////perguntas2
    public boolean perguntas2() {
            return perguntaMultipla(
            "Qual é o tipo de dado primitivo para representar números inteiros em Java?",
            new String[]{
                "a) int",  
                "b) float",  
                "c) char",
                "d) double",
            },
            'a'
        );
    }
    

    public boolean fasePortas() {
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Muito bem, você parou as paredes!");
        System.out.println("pressione qualquer enter para continuar..."); 
        input.nextLine();
        System.out.println("Uma das paredes se desfaz lentamente, revelando um corredor com várias portas.");
        System.out.println("A mesma voz ressoa novamente, firme e enigmática:"
                + " \n Para continuar, você deve escolher a porta certa. Se errar, ficará preso aqui para sempre. ");
        System.out.println("pressione qualquer enter para continuar..."); 
        input.nextLine();
        System.out.println("Respondas as perguntas para achar a porta certa: ");
        System.out.println("pressione enter para continuar..."); 
        input.nextLine();
        System.out.println("Começando segunda rodada de perguntas");
        System.out.println("\n=== FASE DAS PORTAS ===");
        return perguntaMultipla(
            "Qual palavra-chave usamos para declarar uma função que retorna um valor inteiro?",
            new String[]{
                "a) void",
                "b) return",
                "c) int",
                "d) function"
            },
            'c'
        );
    }
    
    public boolean perguntas3() {
            return perguntaMultipla(
            "O que significa FOR em um laço de repetição?",
            new String[]{
               " a) Definir um tipo de variável",  
                "b) Declarar uma classe",  
                "c) Repetir um bloco de código várias vezes ", 
                "d) Atribuir valores a variáveis",  
            },
            'c'
        );
    }
    

    public boolean faseRelogio() {
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Muito bem, você achou a porta correta!");
        System.out.println("pressione enter para continuar..."); 
        input.nextLine();
        System.out.println("Ao atravessar a porta, você se depara com um imenso relógio suspenso no ar, seus ponteiros girando em um ritmo acelerado.");
        System.out.println("A voz retorna, agora com um tom mais grave e urgente:");
        System.out.println("Para escapar, você precisa parar o relógio. Mas cuidado... a cada segundo que passa, você envelhece");
        System.out.println("pressione qualquer enter para continuar..."); 
        input.nextLine();
        System.out.println("Respondas as perguntas para parar o relógio!"); 
        System.out.println("\n=== FASE DO RELÓGIO ===");
        return perguntaMultipla(
            "O que o comando 'return' faz dentro de uma função?",
            new String[]{
                "a) Encerra o programa",
                "b) Retorna um valor e encerra a execução da função",
                "c) Cria uma nova variável",
                "d) Inicia um loop"
            },
            'b'
        );
    }
    
    public boolean perguntas4() {
            return perguntaMultipla(
            "Qual é a estrutura de repetição que verifica a condição após a execução do bloco de código?",
            new String[]{
               "a) while",  
                "b) do-while"  ,
                "c) FOR"  ,
                "d) switch" , 
            },
            'b'
        );
    }
    

    public boolean perguntaMultipla(String pergunta, String[] opcoes, char respostaCorreta) {
        Scanner input = new Scanner(System.in);
        System.out.println(pergunta);
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }

        System.out.print("Digite a letra da resposta correta: ");
        char resposta = input .next().toLowerCase().charAt(0);

        switch (resposta) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
                if (resposta == respostaCorreta) {
                    System.out.println("Muito bem! Resposta correta.");
                    return true;
                } else {
                    System.out.println("Resposta incorreta. Você falhou!");
                    return false;
                    
                    }
            default:
                System.out.println("Opção inválida.");
                return false;
        }
    }

    public void fimJogo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Muito bem, você achou conseguiu, parar o relógio.");
        System.out.println("pressione enter para continuar..."); 
        input.nextLine();
        System.out.println("De repente, " + nome + " desperta em seu quarto, ofegante e exausto. ");
        System.out.println("Olha ao redor, confuso — tudo parece normal, mas a sensação permanece.");
        System.out.println("Ele se pergunta, com o coração acelerado. Foi apenas um sonho... ou algo mais");
        input.nextLine();
        System.out.print("""
                                                                                                                                
                               _____      _                     _                      _                              _         
                              |     |   _| |___ ___ ___ ___ ___| |_ ___ ___    ___ ___| |_ ___ ___    _____ _ _ ___ _| |___ ___ 
                              |  |  |  | . | -_|_ -| . | -_|  _|  _| .'|  _|  | -_|   |  _|  _| -_|  |     | | |   | . | . |_ -|
                              |_____|  |___|___|___|  _|___|_| |_| |__,|_|    |___|_|_|_| |_| |___|  |_|_|_|___|_|_|___|___|___|
                                                   |_|                                                                          
                              """);
        input.nextLine();                      
    }
}
