package conexao_jaohss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizacaoDados {
    public void atualizarDados() {
        Connection conexao = ConexaoBD.conectar();
        if(conexao != null){
            String sql = "UPDATE clubes SET nome = ?, ano_fundacao = ? WHERE id = ?";
            Scanner scn = new Scanner(System.in);
            try{
                System.out.println("Digite o ID do clube que deseja atualizar: ");
                int id = scn.nextInt();
                scn.nextLine();

                System.out.println("Digite o novo nome do clube: ");
                String nome = scn.nextLine();

                System.out.println("Digite o novo ano de fundação do clube: ");
                int ano_fundacao = scn.nextInt();

                PreparedStatement stmt =  conexao.prepareStatement(sql);
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

            }catch(SQLException e){
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
