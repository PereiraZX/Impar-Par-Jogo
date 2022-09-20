import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Jogo game = new Jogo();
        int jogar_de_novo = 0;
        Scanner teclado = new Scanner(System.in);

        //DO WHILE
        do {
            try {
                //ESCOLHA DO PLAYER EM SER IMPAR OU PAR
                game.playerVSCPU();

                // Quem comeca jogando
                game.comecaJogando();

                while (true) {
                    //JOGADAS
                    for (int jogada = 0; jogada < 2; jogada++) {
                        game.playerVSCPUGame(game.vezde);
                    }

                    //EXIBE RESULTADO
                    game.resultado();

                    //PROXIMO A JOGAR
                    game.comecaJogando();

                    //VERIFICA SE ALGUEM JA FEZ 3
                    if (game.p_points == 3 || game.cpu_points == 3) {
                        game.campeao();
                        break;
                    } else {
                        continue;
                    }
                }

                System.out.println("--OBRIGADO POR JOGAR!--");

            } catch (Exception e) {
                System.out.println("ERRO!");
            }
        } while (jogar_de_novo == 1);

        game.finalizacao();

}
}