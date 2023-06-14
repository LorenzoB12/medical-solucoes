package medical.tabelas;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import medical.solucoes.model.Especialidade;
import medical.solucoes.model.Usuario;

/**
 *
 * @author Carlos
 */
public class TableModelEspecialidades extends AbstractTableModel {
    
    private ArrayList<Especialidade> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Descrição"};
    
    public static final int COL_ID = 0;
    public static final int COL_DESCRICAO = 1;
    
    public TableModelEspecialidades(ArrayList<Especialidade> dados) {
        this.dados = dados;
    }
    
    @Override
    public int getRowCount() {
        return this.dados.size();
    }
    
    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Especialidade especialidade = (Especialidade) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ID:
                    retorno = especialidade.getId();
                    break;
                
                case COL_DESCRICAO:
                    retorno = especialidade.getDescricao();
                    break;
                
                default:
                    retorno = especialidade;
                    break;
            }
            
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Especialidade especialidade = this.dados.get(rowIndex);
        switch (columnIndex) {
            case COL_ID:
                especialidade.setId(Integer.parseInt(aValue.toString()));
                break;
            
            case COL_DESCRICAO:
                especialidade.setDescricao(aValue.toString());
                break;
            
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public void addTableModelListener(TableModelListener l) {
        return;
    }
    
    @Override
    public void removeTableModelListener(TableModelListener l) {
        return;
    }
    
}
