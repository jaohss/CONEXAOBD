import java.util.Scanner;
import conexao_jaohss.AtualizacaoDados;
import conexao_jaohss.ConsultaDados;
import conexao_jaohss.InserirDados;
import conexao_jaohss.RemoverDados;

public class Main {
    public static void main(String[] args)  {
//Instanciando objetos
        Scanner scn = new Scanner(System.in);
        InserirDados id = new InserirDados();
        RemoverDados rd = new RemoverDados();
        ConsultaDados cd = new ConsultaDados();
        AtualizacaoDados ad = new AtualizacaoDados();

        //Definindo a variável de opção
        int opcao = -1;

        do {//Estrutura de repetição para executar o programa pelo menos uma vez
            System.out.println("=====MENU PRINCIPAL=====");
            System.out.println("1 - Inserir clube");
            System.out.println("2 - Atualizar clube");
            System.out.println("3 - Deletar clube");
            System.out.println("4 - Ler registros dos clubes ");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scn.nextInt();
            scn.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    id.inserirDados();//chama o método de inserção de dados
                    break;
                case 2:
                    ad.atualizarDados();//chama o método de atualização de dados
                    break;
                case 3:
                    rd.removerDados();//chama o método de remoção de dados
                    break;
                case 4:
                    cd.consultaDados();//chama o método de consulta de dados
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0 && opcao <= 1 && opcao >=4 );

        scn.close();
    }
}
