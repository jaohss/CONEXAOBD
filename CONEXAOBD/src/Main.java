import java.util.Scanner;
import conexao_jaohss.AtualizacaoDados;
import conexao_jaohss.ConsultaDados;
import conexao_jaohss.InserirDados;
import conexao_jaohss.RemoverDados;

public class Main {
    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        InserirDados id = new InserirDados();
        RemoverDados rd = new RemoverDados();
        ConsultaDados cd = new ConsultaDados();
        AtualizacaoDados ad = new AtualizacaoDados();
        
        int opcao = -1;

        do {
            System.out.println("=====MENU PRINCIPAL=====");
            System.out.println("1 - Inserir clube");
            System.out.println("2 - Atualizar clube");
            System.out.println("3 - Deletar clube");
            System.out.println("4 - Ler registros dos clubes ");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!scn.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scn.next(); // descarta a entrada incorreta
                System.out.print("Escolha uma opção: ");
            }

            opcao = scn.nextInt();
            scn.nextLine(); // limpa o buffer
            
            switch (opcao) {
                case 1:
                    id.inserirDados();
                    break;
                case 2:
                    ad.atualizarDados();
                    break;
                case 3:
                    rd.removerDados();
                    break;
                case 4:
                    cd.consultaDados();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        scn.close();
    }
}
