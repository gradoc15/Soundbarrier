/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import gui.BarrierTableVisibleColumns;
import parts.BarrierImport;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class BarrierTableModel extends AbstractTableModel
{

    private static ArrayList<String> COLUMNAMES = new ArrayList<>();
    
    private ArrayList<BarrierImport> imports = new ArrayList<>();
    
    public void setColumnNames()
    {
        BarrierTableVisibleColumns dialog = new BarrierTableVisibleColumns(null, true);
        dialog.setVisible(true);
        if(dialog.isOk())
        {
            System.out.println("Columnames gesetzt");
        }
    }
    
    public void add(BarrierImport imp)
    {
        imports.add(imp);
        this.fireTableDataChanged();
    }
    
    public void addColumnName(String name)
    {
        COLUMNAMES.add(name);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount()
    {
        return imports.size();
    }

    @Override
    public int getColumnCount()
    {
        return COLUMNAMES.size();
    }

    @Override
    public Object getValueAt(int rowindex, int columnindex)
    {
        BarrierImport imported = imports.get(rowindex);
        return imported;
    }
    
    public String getColumnName(int column)
    {
        return COLUMNAMES.get(column);
    }
    
}
