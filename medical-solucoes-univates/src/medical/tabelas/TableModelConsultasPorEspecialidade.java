/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.tabelas;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import medical.solucoes.beans.BeanConsultasEspecialidades;
import medical.solucoes.model.Consulta;

/**
 *
 * @author loren
 */
public class TableModelConsultasPorEspecialidade extends AbstractTableModel {
    
    private ArrayList<BeanConsultasEspecialidades> dados = new ArrayList<>();
    private final String[] colunas = {"Especialidade", "Número de Consultas"};
    
    public static final int COL_ESPECIALIDADE = 0;
    public static final int COL_NUMERO_CONSULTAS = 1;
    
    public TableModelConsultasPorEspecialidade(ArrayList<BeanConsultasEspecialidades> dados) {
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
            BeanConsultasEspecialidades bean = (BeanConsultasEspecialidades) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ESPECIALIDADE:
                    retorno = bean.getEspecialidadeDescricao();
                    break;
                
                case COL_NUMERO_CONSULTAS:
                    retorno = bean.getNumeroConsultas();
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
    public void addTableModelListener(TableModelListener l) {
        return;
    }
    
    @Override
    public void removeTableModelListener(TableModelListener l) {
        return;
    }
    
}
