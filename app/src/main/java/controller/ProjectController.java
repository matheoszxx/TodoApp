package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author matheus.silva
 */
public class ProjectController {
    
    public void update(Project project){
        
        String sql = "UPDATE projects SET "
                + "id = ?, "
                + "name = ?, "
                + "description = ?, "
                + "createDate = ?, "
                + "updateDate = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, project.getId());
            statement.setString(2, project.getName());
            statement.setString(3, project.getDescription());
            statement.setDate(4, new Date(project.getCreatedDate().getTime()));
            statement.setDate(5, new Date(project.getUpdateDate().getTime()));
            statement.setInt(6, project.getId());
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o projeto." + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void save(Project project){
        
        String sql = "INSERT INTO projects (name, "
                + "description, "
                + "createDate, "
                + "updateDate ) VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //Vamos setar os valores para cada "?" na query do banco de dados
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedDate().getTime()));
            statement.setDate(4, new Date(project.getUpdateDate().getTime()));
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o projeto." + ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    
    }
    
    public void removeById(int id){
        
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        //Faz um tratamento de exeção 
        try {
            //Estabelece a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores
            statement.setInt(1, id);
            statement.execute();
            
            
        } catch (SQLException ex) {
             throw new RuntimeException("Erro ao deletar o projeto." + ex.getMessage(), ex);
             
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    //Método para buscar todos os projetos, sem filtro nenhum dentro do parametro do metodo
    public List<Project> getAll(){
        
        String sql = "SELECT * FROM projects";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        //Como na query SQL vou utilizar o SELECT, utilizaremos o ResultSet (para pegarmos o resultado do banco de dados)
        ResultSet resultSet = null;
        
        //Criação da lista de projetos
        List<Project> projects = new ArrayList<Project>();
        
        try {
            //Inicia a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Prepara a query do banco de dados (String sql)
            statement = connection.prepareStatement(sql);
            
            //Executa a query
            resultSet = statement.executeQuery();
            
            //Estrutura de repetição para percorrer os resultados do resultSet 
            while(resultSet.next()){
                
                //Criação de um novo projeto
                Project project = new Project();
                
                //Setando todos os campos com base nas informações gerada pelo resultSet
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedDate(resultSet.getDate("createDate"));
                project.setUpdateDate(resultSet.getDate("updateDate"));
                
                //Adicionando o objeto "project" dentro da List<Project> projects
                projects.add(project);
            }
        } catch (SQLException ex) {
            
            throw new RuntimeException("Erro ao buscar o projeto." + ex.getMessage(), ex);
            
        }finally{
            
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
    
        return projects;
    }
}
