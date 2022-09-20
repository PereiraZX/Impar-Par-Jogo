import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

public class Jogo {

    int soma;
    int vezde;

    int num_player;
    int num_cpu;
    int cpu_type;
    int player_type;
    int p_points;
    int cpu_points;

    Scanner teclado = new Scanner(System.in);
    public Object Mode;

    public void playerVSCPU() throws InterruptedException {

        System.out.println("**PLAYER vs CPU**");
        System.out.println("-IMPAR OU PAR?-");
        System.out.println("-(1)-IMPAR-");
        System.out.println("-(2)-PAR-");
        System.out.println("---------------");
        System.out.print("Escolha uma opcao: ");
        player_type = teclado.nextInt();

        switch (player_type) {
            case 1:
                System.out.println("Player: IMPAR");
                System.out.println("CPU: PAR\n");
                cpu_type = 2; // player ficou com o tipo 2 que é impar
                break;

            case 2:
                System.out.println("Player: PAR");
                System.out.println("CPU: IMPAR\n");
                cpu_type = 1; // player ficou com o tipo 1 que é par
                break;
            default:
                System.out.println("OPCAO INEXISTENTE! :( \n"); 
                Thread.sleep(2000); //delay de 2s
                playerVSCPU();
        }

        Thread.sleep(2000); //delay de 2s
    }

    //RANDOM NUMERO MAQUINA
    public int randomNumberCPU() {
        Random rand = new Random();
        num_cpu = rand.nextInt(5);
        return num_cpu;
    }

    //PLAYER VS MAQUINA
    public int playerVSCPUGame(int vxd) throws InterruptedException {

        // Vez de: MAQUINA
        if (vxd == 0) {
            System.out.println("Vez de: CPU");
            randomNumberCPU();
             Thread.sleep(2000); //delay de 2s
            vezde = 1; // o prox a jogar atumaticamente tem q ser o player

        } else if (vxd == 1) {
            System.out.println("Vez de: Player");
            System.out.print("Digite um numero entre 0 e 5: ");
            num_player = teclado.nextInt();

            if(num_player < 0 || num_player > 5){
                System.out.println("Erro! Apenas entre 0 e 5.");
                Thread.sleep(2000); //delay de 2s
                playerVSCPUGame(vezde);
            }

            vezde = 0;
        }

        //SOMA O RESULTADO
        soma = num_player + num_cpu;
        return soma;
    }

        //CALCULO E MENSAGEM DE QUEM GANHOU PONTO
    public void resultado() throws InterruptedException{
        Thread.sleep(1000); //delay de 1s
        System.out.println("RESULTADO: " + num_player + " + " + num_cpu + " = " + soma);
        Thread.sleep(1000); //delay de 1s
        // Verifica se deu impar ou par
        if (soma % 2 == 0 && player_type == 2) {
            System.out.println("DEU PAR! MAIS UM PONTO PARA VOCE.\n");
            p_points++;
        } else if (soma % 2 == 0 && cpu_type == 2) {
            System.out.println("DEU PAR! PONTO PARA O ADVERSARIO.\n");
            cpu_points++;
        } else if (soma % 2 != 0 && player_type == 1) {
            System.out.println("DEU IMPAR! MAIS UM PONTO PARA VOCE.\n");
            p_points++;
        } else if (soma % 2 != 0 && cpu_type == 1) {
            System.out.println("DEU IMPAR! PONTO PARA O ADVERSARIO.\n");
            cpu_points++;
        }

        //TABELA DE PONTOS
        System.out.println("---PONTOS---");
        System.out.println("Player: " + p_points);
        System.out.println("CPU: " + cpu_points + "\n");
    }

    //CAMPEAO > EXIBE CAMPEAO
    public void campeao() throws InterruptedException{

        System.out.println("FIM DE JOGO!!!");
        if (p_points == 3) {
            System.out.println("VENCEDOR(A): Player\n");
        } else if (cpu_points == 3) {
            System.out.println("VENCEDOR: CPU\n");
        }
         Thread.sleep(2000); //delay de 2s
    }

    //FINAL
    public void finalizacao() {
    }

    public int comecaJogando() {
        Random rand = new Random();
        vezde = rand.nextInt(2);
        return vezde;
    }
}