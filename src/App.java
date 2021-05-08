import java.util.Scanner;

public class App {
    private static int jog;
    private static int[][] casa = new int [3][3];
    private static int linha, coluna, win;
    private static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        jogo();
    }

    public static void desenha(int x, int y){
        if(casa[x][y] == 1){
            //Espaço marcado pelo jogador 1 aparece o "X"
            System.out.print("X");
        } else if(casa[x][y] == 2){
            //Espaço marcado pelo jogador 2 aparece o "Y"
            System.out.print("Y");
        } else{
            //Espaço não marcado
            System.out.print(" ");
        }
    }

    public static void jogo(){
        //Mostrar os números das colunas do tabuleiro
        System.out.print("\n  1    2    3\n");
        //Mostrar os números da primeira linha
        System.out.print("1");
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
        System.out.print("\n -----------\n2");
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
        System.out.print("\n -----------\n3");
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
}
