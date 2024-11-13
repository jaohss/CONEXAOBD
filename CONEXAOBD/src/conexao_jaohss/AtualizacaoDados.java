package conexao_jaohss;

//importando package SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizacaoDados {
    public void atualizarDados() {//Método para atualizar os dados
        Connection conexao = ConexaoBD.conectar();
        if(conexao != null){
            String sql = "UPDATE clubes SET nome = ?, ano_fundacao = ? WHERE id = ?";
            Scanner scn = new Scanner(System.in);
            try{
                System.out.println("Digite o ID do clube que deseja atualizar: ");
                int id = scn.nextInt();//recebe qual id do clube que deseja atualizar
                scn.nextLine();

                System.out.println("Digite o novo nome do clube: ");
                String nome = scn.nextLine();//recebe o nome novo clube

                System.out.println("Digite o novo ano de fundação do clube: ");
                int ano_fundacao = scn.nextInt();//recebe o novo ano de função do clube

                PreparedStatement stmt =  conexao.prepareStatement(sql);//definindo a ordem das variaveis de acordo com a string sql
                stmt.setString(1, nome);
                stmt.setInt(2, ano_fundacao);
                stmt.setInt(3, id);

                int rowsUpdated = stmt.executeUpdate();

                if(rowsUpdated > 0){
                    System.out.println("Registro atualizado com sucesso !");
                }
                else{
                    System.out.println("Nenhum registro encontrado com ID especificado");
                }

            }catch(SQLException e){//Erro se houver falha ao atualizar os dados
                System.err.println("Erro ao atualizar dados dados: " + e.getMessage());
            } finally{
                try{
                    if (conexao !=null) conexao.close();
                } catch(SQLException e){
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
                scn.close();
            }
        }
    }
    
}
