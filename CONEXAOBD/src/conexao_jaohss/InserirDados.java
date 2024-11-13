package conexao_jaohss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDados {
    
        public void inserirDados(){//Método para a inserção de dados
            Connection conexao = ConexaoBD.conectar();
            if(conexao != null){
                String sql = "INSERT INTO clubes(nome, ano_fundacao) VALUES(?, ?)";

                try(PreparedStatement stmt = conexao.prepareStatement(sql)){
    
                    //Fazendo a inserção de dados
                    stmt.setString(1, "Corinthians");
                    stmt.setInt(2, 1910);
                    stmt.executeUpdate();

                    stmt.setString(1, "Palmeiras");
                    stmt.setInt(2, 1914);
                    stmt.executeUpdate();

                    stmt.setString(1, "Flamengo");
                    stmt.setInt(2, 1889);
                    stmt.executeUpdate();

                    System.out.println("Dados inseridos com sucesso !");
                    stmt.close();

                } catch (SQLException e){//Mensagem de erro se houver falhas ao inserir dados
                    System.err.println("Erro ao inserir dados: "+e.getMessage());
                }

                finally{
                    try{
                        if(conexao!=null) conexao.close();
                    }catch(SQLException e){
                        System.err.println("Erro ao fechar conexão: "+e.getMessage());
                    }
                }

            }
        
        
        
    }
    
}
