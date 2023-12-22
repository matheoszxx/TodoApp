package util;

import java.sql.DriverManager; //Classe DriverManager
import java.sql.Connection;   //Classe Connection
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver"; //colocamos a dependencia do JDBC dentro do build.gradle
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = ""; 
    
    //Método de conexão
    //Static pq ele diz que posso chamar esse método sem criar uma instancia (objeto) dessa classe
    //então não precisamos criar um objeto da classe ConnectionFactory pra poder executar esse método
    public static Connection getConnection(){
        try {
            //Carrega o Driver
            Class.forName(DRIVER);
            //Faz a conexão com o banco de dados
            //DriverManager é uma classe que esá dentro do conjunto de dependencias que baixamos e colocamos no build.gradle
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp", "root", "");
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao com o banco de dados", ex); 
        }          
    }
    
    public static void closeConnection(Connection connection){ 
        try {
            if (connection != null){ //Se essa conexão existir. FAÇA
                connection.close(); //feche a conexão
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
    
    //Podemos ter varios metodos com o mesmo nome, porem tem que ter parametros diferentes.
    public static void closeConnection(Connection connection, PreparedStatement statement){ 
        try {
            if (connection != null){ //Se essa conexão existir. FAÇA
                connection.close(); //feche a conexão
            }
            
            if (statement != null){
                statement.close();
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
    
    //Podemos ter varios metodos com o mesmo nome, porem tem que ter parametros diferentes.
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){ 
        try {
            if (connection != null){ //Se essa conexão existir. FAÇA
                connection.close(); //feche a conexão
            }
            
            if (statement != null){
                statement.close();
            }
            
            if(resultSet != null){
                resultSet.close();
            }
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
    
    
}