import java.util.Scanner;

public class App {
    private static int jog;
    private static int[][] casa = new int [3][3];
    private static int linha, coluna, win;
    private static String jogador1, jogador2;
    private static long inicio;
    private static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        cadastro();
        setTempo(); //Começa a contar o tempo da partida
        int i = 0;
        //Percorre todo o tabuleiro, nas nove posições
        for(i = 0; i < 9; i++){
            jogo(); //Chama a rotina "jogo()", que desenha o tabuleiro
            if(i % 2 == 0){
                jogar(1);
            } else {
                jogar(2);
            }
            check(); //Chama a rotina "check()", para ver se alguém ganhou
            if(win == 1 || win == 2){
                //Sai do laço antes de completar o tabuleiro, se alguém tiver vencido
                i = 10;
            }
        }
        jogo(); //Chama a rotina "jogo()", para redesenhar o tabuleiro
        //Verificar se houve vencedor
        System.out.println();
        if(win == 1){
            //Informa o vencedor
            System.out.println("Jogador " + jogador1 + " é o ganhador!");
        } else if(win == 2){
            //Informa o vencedor
            System.out.println("Jogador " + jogador2 + " é o ganhador!");
        } else {
            //Não houve vencedor
            System.out.println("Não houve vencedor! O jogo foi empate!");
        }
        System.out.println("O tempo da partida foi: " + getTempo() + "s");
    }

    public static void desenha(int x, int y){
        if(casa[x][y] == 1){
            //Espaço marcado pelo jogador 1 aparece o "X"
            System.out.print("X");
        } else if(casa[x][y] == 2){
            //Espaço marcado pelo jogador 2 aparece o "Y"
            System.out.print("O");
        } else{
            //Espaço não marcado
            System.out.print(" ");
        }
    }

    public static void jogo(){
        //Mostrar os números das colunas do tabuleiro
        System.out.print("\n  1    2    3\n");
        //Mostrar os números da primeira linha
        System.out.print("1 ");
        //Exibir o campo que cruza a linha 1 com a coluna 1
        desenha(0, 0);
        //Divisão entre dois campos
        System.out.print("  | ");
        //Exibir o campo que cruza a linha 1 com a coluna 2
        desenha(0, 1);
        //Divisão entre dois campos
        System.out.print("  | ");
        //Exibir o campo que cruza a linha 1 com a coluna 3
        desenha(0, 2);
        //Desenha linha horizontal e mostra número da linha 2
        System.out.print("\n -------------\n2 ");
        //Exibir o campo que cruza a linha 2 com a coluna 1
        desenha(1, 0);
        //Divisão entre dois campos
        System.out.print("  | ");
        //Exibir o campo que cruza a linha 2 com a coluna 2
        desenha(1, 1);
        //Divisão entre dois campos
        System.out.print("  | ");
        //Exibir o campo que cruza a linha 2 com a coluna 2
        desenha(1, 2);
        //Desenha linha horizontal e mostra número da linha 3
        System.out.print("\n -------------\n3 ");
        //Exibir o campo que cruza a linha 3 com a coluna 1
        desenha(2, 0);
        //Divisão entre dois campos
        System.out.print("  | ");
        //Exibir o campo que cruza a linha 3 com a coluna 2
        desenha(2, 1);
        //Divisão entre dois campos
        System.out.print("  | ");
        //Exibir o campo que cruza a linha 3 com a coluna 3
        desenha(2, 2);
    }

    public static void jogar(int jogador){
        //Inicializar contador da estrutura while
        int i = 0;
        //Definindo o jogador da vez
        if(jogador == 1){
            jog = 1;
            System.out.println("\nVez do jogador: " + jogador1);
        } else{
            jog = 2;
            System.out.println("\nVez do jogador: " + jogador2);
        }
        while(i == 0){
            linha = 0; //Inicializando valor da linha
            coluna = 0; //Inicializando valor da coluna
            while(linha < 1 || linha > 3){
                System.out.print("Escolha a linha (1, 2, 3):");
                //Ler a escolha da linha
                linha = leitor.nextInt();
                //Aviso de linha inválida, no caso do jogador
                //escolher uma valor menor que 1 ou maior que 3
                if(linha < 1 || linha > 3){
                    System.out.print("Linha inválida! Escolha uma linha entre 1 e 3.");
                }
            }
            while(coluna < 1 || coluna > 3){
                System.out.print("Escolha uma coluna (1, 2, 3):");
                //Ler a escolha da coluna
                coluna = leitor.nextInt();
                //Aviso de coluna inválida, no caso do jogador
                //escolher uma valor menor que 1 ou maior que 3
                if(coluna < 1 || coluna > 3){
                    System.out.print("Coluna inválida! Escolha uma coluna entre 1 e 3.");
                }
            }
            //Ajusta os índices para começar do zero
            linha = linha - 1;
            coluna = coluna - 1;
            if(casa[linha][coluna] == 0){
                //Caso não estaja marcado,
                //marca o símbolo do jogador da vez
                casa[linha][coluna] = jog;
                i = 1;
            } else{
                //Caso o campo escolhido ja estaja marcado
                System.out.print("Posição ocupada!");
            }
        }
    }

    public static void check(){
        int i = 0;
        //verificando se houve vencedor na horizontal
        for(i = 0; i < 3; i++){
            if(casa[i][0] == casa[i][1] && casa[i][0] == casa[i][2]){
                if(casa[i][0] == 1) win = 1;
                if(casa[i][0] == 2) win = 2;
            }
        }
        //Verificando se houve vencedor na vertical
        for(i = 0; i < 3; i++){
            if(casa[0][i] == casa[1][i] && casa[0][i] == casa[2][i]){
                if(casa[0][i] == 1) win = 1;
                if(casa[0][i] == 2) win = 2;
            }
        }
        //Verificando se houve vencedor na diagonal de cima para baixo
        if(casa[0][0] == casa[1][1] && casa[0][0] == casa[2][2]){
            if(casa[0][0] == 1) win = 1;
            if(casa[0][0] == 2) win = 2;
        }
        //Verificando se houve vencedor na diagonal de baixo para cima
        if(casa[0][2] == casa[1][1] && casa[0][2] == casa[2][0]){
            if(casa[0][2] == 1) win = 1;
            if(casa[0][2] == 2) win = 2;
        }
    }

    public static void cadastro(){
        System.out.println("Digite o nome do jogador 1:");
        //Recebe o nome do jogador 1
        jogador1 = leitor.next();
        System.out.println("Digite o nome do jogador 2:");
        //Recebe o nome do jogador 1
        jogador2 = leitor.next();
    }

    public static void setTempo(){
        inicio = System.currentTimeMillis();
    }

    public static long getTempo(){
        return (System.currentTimeMillis() - inicio) / 1000;
    }
}