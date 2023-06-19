package medical.tabelas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import medical.solucoes.model.Paciente;

/**
 *
 * @author Carlos
 */
public class TableModelPacientes extends AbstractTableModel {

    private ArrayList<Paciente> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Nome", "CPF", "Data Nascimento", "Telefone", "Gênero", "Ativo"};

    public static final int COL_ID = 0;
    public static final int COL_NOME = 1;
    public static final int COL_CPF = 2;
    public static final int COL_DATA_NASCIMENTO = 3;
    public static final int COL_TELEFONE = 4;
    public static final int COL_GENERO = 5;
    public static final int COL_ATIVO = 6;

    public TableModelPacientes(ArrayList<Paciente> dados) {
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
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            
            Paciente paciente = (Paciente) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ID:
                    retorno = paciente.getId();
                    break;

                case COL_NOME:
                    retorno = paciente.getNome();
                    break;

                case COL_CPF:
                    retorno = paciente.getCpf();
                    break;
                    
                case COL_DATA_NASCIMENTO:
                    retorno = format.format(format1.parse(paciente.getDataNascimento()));
                    break;

                case COL_TELEFONE:
                    retorno = paciente.getTelefone();
                    break;

                case COL_GENERO:
                    retorno = paciente.getGenero();
                    break;

                case COL_ATIVO:
                    retorno = paciente.getIndAtivo().booleanValue() ? "Ativo" : "Inativo";
                    break;

                default:
                    retorno = paciente;
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
        Paciente paciente = this.dados.get(rowIndex);
        switch (columnIndex) {
            case COL_ID:
                paciente.setId(Long.parseLong(aValue.toString()));
                break;

            case COL_NOME:
                paciente.setNome(aValue.toString());
                break;

            case COL_CPF:
                paciente.setCpf(aValue.toString());
                break;
                
            case COL_DATA_NASCIMENTO:
                paciente.setDataNascimento(aValue.toString());
                break;

            case COL_TELEFONE:
                paciente.setTelefone(aValue.toString());
                break;

            case COL_GENERO:
                paciente.setCpf(aValue.toString());
                break;

            case COL_ATIVO:
                paciente.setIndAtivo(Boolean.parseBoolean(aValue.toString()));
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
