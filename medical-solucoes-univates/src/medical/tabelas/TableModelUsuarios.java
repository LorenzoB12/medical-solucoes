package medical.tabelas;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import medical.solucoes.model.Usuario;

/**
 *
 * @author Carlos
 */
public class TableModelUsuarios extends AbstractTableModel {
    
    private ArrayList<Usuario> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Nome", "Login", "Ativo"};
    
    public static final int COL_ID = 0;
    public static final int COL_NOME = 1;
    public static final int COL_LOGIN = 2;
    public static final int COL_ATIVO = 3;
    
    public TableModelUsuarios(ArrayList<Usuario> dados) {
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
            Usuario usuario = (Usuario) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ID:
                    retorno = usuario.getId();
                    break;
                
                case COL_NOME:
                    retorno = usuario.getNome();
                    break;
                
                case COL_LOGIN:
                    retorno = usuario.getLogin();
                    break;
                
                case COL_ATIVO:
                    retorno = usuario.isAtivo() ? "Ativo" : "Inativo";
                    break;
                
                default:
                    retorno = usuario;
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
        Usuario usuario = this.dados.get(rowIndex);
        switch (columnIndex) {
            case COL_ID:
                usuario.setId(Long.parseLong(aValue.toString()));
                break;
            
            case COL_NOME:
                usuario.setNome(aValue.toString());
                break;
            
            case COL_LOGIN:
                usuario.setLogin((aValue.toString()));
                break;
            
            case COL_ATIVO:
                usuario.setAtivo(Boolean.parseBoolean(aValue.toString()));
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
