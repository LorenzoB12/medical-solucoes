package medical.tabelas;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import medical.solucoes.beans.BeanRelatorioConsultasMedicos;

/**
 *
 * @author Carlos
 */
public class TableModelRelatorioConsultasPorMedicos extends AbstractTableModel {

    private ArrayList<BeanRelatorioConsultasMedicos> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Paciente", "CPF", "Doutor", "Data Consulta", "Especialidade"};

    public static final int COL_ID = 0;
    public static final int COL_PACIENTE = 1;
    public static final int COL_CPF = 2;
    public static final int COL_DOUTOR = 3;
    public static final int COL_DATA_CONSULTA = 4;
    public static final int COL_ESPECIALIDADE = 5;

    public TableModelRelatorioConsultasPorMedicos(ArrayList<BeanRelatorioConsultasMedicos> dados) {
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
            BeanRelatorioConsultasMedicos bean = (BeanRelatorioConsultasMedicos) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ID:
                    retorno = bean.getId();
                    break;

                case COL_PACIENTE:
                    retorno = bean.getNomePaciente();
                    break;

                case COL_CPF:
                    retorno = bean.getCpf();
                    break;

                case COL_DOUTOR:
                    retorno = bean.getNomeDoutor();
                    break;

                case COL_DATA_CONSULTA:
                    retorno = bean.getDataConsulta();
                    break;

                case COL_ESPECIALIDADE:
                    retorno = bean.getEspecialidade();
                    break;

                default:
                    retorno = bean;
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
        BeanRelatorioConsultasMedicos bean = this.dados.get(rowIndex);
        switch (columnIndex) {
            case COL_PACIENTE:
                bean.setNomePaciente(aValue.toString());
                break;

            case COL_DOUTOR:
                bean.setNomeDoutor(aValue.toString());
                break;

            case COL_DATA_CONSULTA:
                bean.setDataConsulta(aValue.toString());
                break;

            case COL_CPF:
                bean.setCpf(aValue.toString());
                break;

            case COL_ID:
                bean.setId(Integer.parseInt(aValue.toString()));
                break;

            case COL_ESPECIALIDADE:
                bean.setEspecialidade(aValue.toString());
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
