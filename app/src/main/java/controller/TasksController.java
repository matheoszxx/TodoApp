package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Tasks;
import util.ConnectionFactory;

/**
 *
 * @author matheus.silva
 */
public class TasksController {
    
    //Método para salvar algo nas tarefas
    public void save(Tasks tasks){
        String sql = "INSERT INTO tasks (idProject, "
                + " name, "
                + " description, "
                + " status, "
                + " notes, "
                + " deadline, "
                + " createdDate, "
                + " updateDate ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //Setando os valores para cada "?" da string
            statement.setInt(1, tasks.getIdProject());
            statement.setString(2, tasks.getName());
            statement.setString(3, tasks.getDescription());
            statement.setBoolean(4, tasks.getStatus());
            statement.setString(5, tasks.getNotes());
            statement.setDate(6, new java.sql.Date(tasks.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(tasks.getCreatedDate().getTime()));
            statement.setDate(8, new java.sql.Date(tasks.getUpdateDate().getTime()));
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
}
