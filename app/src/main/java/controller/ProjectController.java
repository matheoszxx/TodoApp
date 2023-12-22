package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
