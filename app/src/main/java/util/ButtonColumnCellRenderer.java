package util;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author matheus.silva
 */
public class ButtonColumnCellRenderer extends DefaultTableCellRenderer{
    
    private String buttonType;

    //MÉTODO CONSTRUTOR QUE FOI CHAMADO NA "MainScreen"
    public ButtonColumnCellRenderer(String buttonType) {
        this.buttonType = buttonType;
    }
    
    //MÉTODO QUE É UMA IMPLEMENTAÇÃO PERSONALIZADA DA RENDERIZAÇÃO DE CELULAS
    //É CHAMADO PELO "JTable" PARA RENDERIZAR UMA CÉLULA ESPECIFICA NA TABELA
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column){
        
        //ESSE MÉTODO É PARA OBTER O COMPONENTE DE CELULA PADRÃO (NO CASO A "JLabel"
        //"super..." ISSO É FEITO PARA APAROVEITAR A FUNCIONALIDADE PADRÃO DE RENDERIZAÇÃO E EM SEGUIDA PERSONALIZAR A PARTIR DAI 
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //CENTRALIZA A LABEL
        label.setHorizontalAlignment(CENTER);
        
        label.setIcon(new ImageIcon(getClass().getResource("/" + buttonType + ".png")));
        
        return label;
    }
    
}
