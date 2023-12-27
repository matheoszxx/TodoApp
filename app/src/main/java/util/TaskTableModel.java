package util;

//AQUI NESSA CLASSE "TaskTableModel" VOU IMPLEMENTAR O MODEL DO COMPONENTE jTable

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Tasks;


//O MODEL "TaskTableModel" QUE VAI INTERLIGAR COM O COMPONENTE VISUAL jTable E VAI NOS MOSTRAR AS TAREFAS NA TELA DE CADA PROJETO
//IMPLEMENTEI O CONCEITO DE HERANÇA COM A CLASSE JÁ EXISTENTE DO JAVA "AbstractTableModel"
//"AbstractTableModel" É UMA IMPLEMENTAÇÃO MODEL PARA TABLE
public class TaskTableModel extends AbstractTableModel {
    
    //ADICIONANDO AS INFORMAÇÕES DA MINHA "TaskTableModel"
    //1º
    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluida", "Editar", "Excluir"};
    //2° 
    //UMA LISTA QUE GUARDA TAREJA  = "List<Tasks>" 
    List<Tasks> tasks = new ArrayList<>();
    
    //METODO ABSTRATO QUANTIDADE DE LINHA
    @Override
    public int getRowCount() {
        return tasks.size(); 
    }
    
    //MÉTODO ABSTRATO QUANTIDADE DE COLUNA
    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        
        return columns[columnIndex];
        
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
         if (columnIndex == 3) {
             return true;
        }
         return false;
    }
    
    @Override
    //MÉTODO PARA DIZER QUAL TIPO DE CLASSE ESTÁ EM DETERMINADA COLUNA 
     public Class<?> getColumnClass(int columnIndex){
        //SE A LISTA DE TAREFA NO BANCO DE DADOS ESTIVER VAZIA...
        if(tasks.isEmpty()){
            //RETORNA O TIPO DE CLASSE "Object" (pois não tem nenhum dados lá)
            return Object.class;
        };
        
        //CHAMA O METODO "getValueAt" E PEGAMOS O TIPO DE CLASSE DA LINHA E COLUNA ESPECIFICA
        return this.getValueAt(0, columnIndex).getClass();
         
     }
     
    
    //METODO ABSTRATO PARA RETORNAR UM VALOR COM BASE NA LINHA E COLUNA 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex) {
            case 0:
                
                return tasks.get(rowIndex).getName();
            
            case 1:
                
                return tasks.get(rowIndex).getDescription();
                
            case 2:
                
                SimpleDateFormat dateFormat  = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
                
            case 3:
                
                return tasks.get(rowIndex).getStatus();
                
            case 4: 
                
                return " ";
                
            case 5: 
                
                return " ";
                
            default:
                
                return "Dados não encontrado.";
                
        }
    }
    
    @Override
    //ESSE METODO SERVE PARA PREENCHER A CAIXA DE CHECK DA COLUNA STATUS (SE FOI CONCLUIDA OU NÃO)
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        //UTILIZOU UM "Cast" NESSA LINHA DE CÓDIGO DO TIPO "Object" PARA "boolean"
        tasks.get(rowIndex).setStatus((boolean) aValue);
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
    
    
    
    
}
