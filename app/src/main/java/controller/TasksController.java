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
    
    //Método para fazer mudanças da tarefa
    public void update(Tasks tasks){
        String sql = "UPDATE tasks SET "
                + "idProject = ?, "
                + "name = ?, "
                + "description = ?, "
                + "status = ?, "
                + "notes = ?, "
                + "deadline = ?, "
                + "createdDate = ?, "
                + "updateDate = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Inicia a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores do statement
            statement.setInt(1, tasks.getIdProject());
            statement.setString(2, tasks.getName());
            statement.setString(3, tasks.getDescription());
            statement.setBoolean(4, tasks.getStatus());
            statement.setString(5, tasks.getNotes());
            statement.setDate(6, new java.sql.Date(tasks.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(tasks.getCreatedDate().getTime()));
            statement.setDate(8, new java.sql.Date(tasks.getUpdateDate().getTime()));
            statement.setInt(9, tasks.getId());
            
            //Executando a query
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    //Método para buscar o ID da tarefa e fazer o DELETE pelo ID
    public void  removeById(int tasksId){
        String sql = "DELETE FROM tasks WHERE id = ?"; //"?" é meu parametro 1
        
        Connection connection  = null;
        PreparedStatement statement = null; 
        
        try {
            //Estabelecendo uma conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            statement =  connection.prepareStatement(sql);
            statement.setInt(1, tasksId);
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa." + ex.getMessage(), ex);
        } finally {
            //aqui utilizamos o método com dois parametros (connection e statement) para fechar a conexão dos dois
            //pois temos outro método com o mesmo nome (closeConnection) que tem um parametro 
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
}
