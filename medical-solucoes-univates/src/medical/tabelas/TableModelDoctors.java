package medical.tabelas;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import medical.solucoes.dao.EspecialidadeDao;
import medical.solucoes.model.Doctor;
import medical.solucoes.model.Especialidade;
import medical.solucoes.model.Usuario;

/**
 *
 * @author Carlos
 */
public class TableModelDoctors extends AbstractTableModel {
    
    private ArrayList<Doctor> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Nome","CRM","Especialidade"};
    
    public static final int COL_ID = 0;
    public static final int COL_NOME = 1;
    public static final int COL_CRM = 2;
    public static final int COL_ESPECIALDADE = 3;
    
    public TableModelDoctors(ArrayList<Doctor> dados) {
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
            Doctor doctor = (Doctor) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ID:
                    retorno = doctor.getId();
                    break;
                
                case COL_NOME:
                    retorno = doctor.getNome();
                    break;
                case COL_CRM:
                    retorno = doctor.getNome();
                    break;
                case COL_ESPECIALDADE:
                    retorno = doctor.getNome();
                    break;        
                
                default:
                    retorno = doctor;
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
        Doctor doctor = this.dados.get(rowIndex);
        switch (columnIndex) {
            case COL_ID:
                doctor.setId(Integer.parseInt(aValue.toString()));
                break;
            
           case COL_NOME:
                doctor.setNome(aValue.toString());
                break;
           case COL_CRM:
                doctor.setCrm(aValue.toString());
                break;
           case COL_ESPECIALDADE:
                doctor.setEspecializacao(new EspecialidadeDao().buscar(Integer.parseInt(aValue.toString())));
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
