/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.tabelas;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import medical.solucoes.model.Consulta;
import medical.solucoes.model.Doctor;
import medical.solucoes.model.Paciente;
import medical.solucoes.model.Usuario;

/**
 *
 * @author loren
 */
public class TableModelConsultas extends AbstractTableModel {
    
    private ArrayList<Consulta> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Data e Horário", "Horário", "Paciente", "Doutor"};
    
    public static final int COL_ID = 0;
    public static final int COL_DTHCONSULTA = 1;
    public static final int COL_HORACONSULTA = 2;
    public static final int COL_PACIENTE = 3;
    public static final int COL_DOUTOR = 4;
    
    public TableModelConsultas(ArrayList<Consulta> dados) {
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
            Consulta consulta = (Consulta) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ID:
                    retorno = consulta.getId();
                    break;
                
                case COL_DTHCONSULTA:
                    String data = consulta.getDthConsulta().split(" ")[0];
                    String dia = data.split("-")[2];
                    String mes = data.split("-")[1];
                    String ano = data.split("-")[0];
                    String dataF = dia + "/" + mes + "/" + ano;
                    
                    retorno = dataF;
                    break;
                    
                case COL_HORACONSULTA:
                    String hora = consulta.getDthConsulta().split(" ")[1].split(":")[0];
                    String min = consulta.getDthConsulta().split(" ")[1].split(":")[1];
                    retorno = hora + ":" + min;
                    break;
                
                case COL_PACIENTE:
                    retorno = consulta.getPaciente().getNome();
                    break;
                
                case COL_DOUTOR:
                    retorno = consulta.getDoctor().getNome();
                    break;
                
                default:
                    retorno = consulta;
                    break;
            }
            
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = this.dados.get(rowIndex);
        switch (columnIndex) {
            case COL_ID:
                consulta.setId(Long.parseLong(aValue.toString()));
                break;
            
            case COL_DTHCONSULTA:
                consulta.setDthConsulta(aValue.toString());
                break;
            
            case COL_PACIENTE:
                Paciente paciente = new Paciente();
                consulta.setPaciente(paciente);
                break;
            
            case COL_DOUTOR:
                Doctor doctor = new Doctor("1", "2", "3");
                consulta.setDoctor(doctor);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }*/
    
    @Override
    public void addTableModelListener(TableModelListener l) {
        return;
    }
    
    @Override
    public void removeTableModelListener(TableModelListener l) {
        return;
    }
    
}
