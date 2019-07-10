/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import parts.BarrierImport;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class BarrierTableCellRendere implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable taImports, Object o, boolean isSelected, boolean hasFocus, int row, int column)
    {
        JLabel label = new JLabel();
        BarrierImport imported = (BarrierImport)o;
        switch(taImports.getModel().getColumnName(column))
        {
            case "objid": 
        }
        return null;
    }
    
}
