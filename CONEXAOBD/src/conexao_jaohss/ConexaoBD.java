package conexao_jaohss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD{
    private static final String URL = "jdbc:mysql://localhost:3306/CONEXAOBD_JAVA";//definindo o caminho/URL do banco de dados
    private static final String USUARIO = "root"; //definindo o nome do usuário do banco de dados no wampserver
    private static final String SENHA = ""; //definindo a senha do wampserver

    //Método para fazer a conexão com o banco de dados
    public static Connection conectar() {
        try {
            //Carregando o driver
            System.out.println("Tentando carregar o driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver carregado com sucesso !");

            System.out.println("Tentando estabelecer conexão com o banco...");
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão realizada com sucesso !");
            return conexao;
            
            
        } catch (ClassNotFoundException e) {//mensagem de erro caso o driver não seja encontrado
            System.err.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {//mensagem de erro caso haja falha ao conectar com banco de dados
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        //Execução da conexão com o banco de dados
        conectar();
    }
}
