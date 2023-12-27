/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Tasks;

/**
 *
 * @author matheus.silva
 */
//MÉTODO PARA REDENRIZAÇÃO DA CELULA PRAZO
public class DeadlineColumnCellRederer extends DefaultTableCellRenderer{
    
    @Override
    //METODO PARA DEVOLVER UM COMPONENTE QUE VAI SER MOSTRADO NA CELULA
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column){
        //CRIANDO UMA jLabel (QUE É DATA NO NOSSO GRID)
        //ISSO RETORNA O COMPONENTE QUE VAI SER RENDERIZADO NA TELA (VAI REDENRIZAR UMA LABEL)
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        //ALINHAR O TEXTO "DATA" NO CENTRO DA TABELA
        label.setHorizontalAlignment(CENTER);
        
        //CHAMEI O MÉTODO PARA NA OUTRA LINHA CONSEGUIR PEGAR A TAREFA
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        //PEGANDO A TAREFA DE ACORDO COM A LINHA A SER RENDERIZADA
        Tasks task = taskModel.getTasks().get(row);
        
        //SE A TAREFA ESTIVER DEPOIS DE AGORA "new Date()" PINTE DE VERDE
        if(task.getDeadline().after(new Date())){
            label.setBackground(Color.GREEN);
            
        }else{
            label.setBackground(Color.RED);
        }
        return label;
    }
    
    
}
