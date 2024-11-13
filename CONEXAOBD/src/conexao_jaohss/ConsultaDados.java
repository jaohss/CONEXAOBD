package conexao_jaohss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultaDados {
    //Método para consulta de dados
    public void consultaDados() {
        Connection conexao = ConexaoBD.conectar();
        if(conexao != null){
            String sql = "SELECT * FROM clubes"; //sintaxe seletora para consulta de todos os itens do banco de dados
            try{
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                System.out.println("Registros da tabela 'clubes':");
                while(rs.next()){
                    //definição das variáveis que serão consultadas
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int ano_fundacao = rs.getInt("ano_fundacao");
                    
                    //Exibe a consulta do banco de dados
                    System.out.println("ID: "+ id + ", Nome: " + nome + ", Ano de fundacao: "+ano_fundacao);
                }
            }catch (SQLException e){
                System.err.println("Erro ao ler dados: " + e.getMessage());
            } finally{
                try{
                    if(conexao != null) conexao.close();
                }catch (SQLException e){
                    System.err.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        } 
    }
}
