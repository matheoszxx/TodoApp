package util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Tasks;

// Esta classe, "TaskTableModel", implementa o modelo para o componente visual jTable.
// Ela herda de AbstractTableModel, uma implementação padrão de modelo para tabelas em Java.
public class TaskTableModel extends AbstractTableModel {
    
    // Definição das colunas da tabela
    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa Concluida", "Editar", "Excluir"};
    
    // Lista que armazena as tarefas a serem exibidas na tabela 
    List<Tasks> tasks = new ArrayList<>();
    
    // Método abstrato que retorna o número de linhas na tabela
    @Override
    public int getRowCount() {
        return tasks.size(); 
    }
    
    // Método abstrato que retorna o número de colunas na tabela
    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    // Método para obter o nome da coluna com base no índice da coluna
    @Override
    public String getColumnName(int columnIndex){
        
        return columns[columnIndex];
    }
    
    // Método que define se uma célula é editável ou não (no caso, a coluna "Tarefa Concluída")
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
         if (columnIndex == 3) {
             return true;
        }
         return false;
    }
    
    // Método para obter a classe da coluna, útil para determinar o tipo de dado na célula
    @Override
     public Class<?> getColumnClass(int columnIndex){
        if(tasks.isEmpty()){
            return Object.class;
        };
        //CHAMA O METODO "getValueAt" E PEGAMOS O TIPO DE CLASSE DA LINHA E COLUNA ESPECIFICA
        return this.getValueAt(0, columnIndex).getClass();
         
     }
     
    
    // Método abstrato para obter o valor em uma determinada célula 
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
    // Método para definir o valor em uma determinada célula (usado para preencher a caixa de seleção na coluna "Tarefa Concluída")
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        tasks.get(rowIndex).setStatus((boolean) aValue);
    }
    
    // Métodos de acesso aos atributos da classe
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
