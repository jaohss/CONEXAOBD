package conexao_jaohss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD{
    private static final String URL = "jdbc:mysql://localhost:3306/CONEXAOBD_JAVA";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection conectar() {
        try {
            System.out.println("Tentando carregar o driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver carregado com sucesso !");

            System.out.println("Tentando estabelecer conexão com o banco...");
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão realizada com sucesso !");
            return conexao;
            
            
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        conectar();
    }
}
