/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.dao;

import conexao.ConexaoBD;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import medical.solucoes.model.Doctor;
import medical.solucoes.model.Especialidade;
import medical.solucoes.model.Usuario;

/**
 *
 * @author loren
 */
public class DoctorDao {

     public boolean salvar(Doctor d){
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO doctors (nome,crm,ativo,especialidades_id) VALUES "
                    + "('" + d.getNome().toUpperCase() + "','" +
                    d.getCrm() + "'," + d.isAtivo() + ",'" + d.getEspecializacao().getId()+
                    "');";
            System.out.print(sql);
            st.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
      public static boolean atualizar(Doctor doc){
        try {
            

            String sql = "UPDATE especialidades SET "
                    + "nome = '" + doc.getNome().toUpperCase() + "' "
                    + "WHERE id = " + doc.getId();

            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Doctor> listar(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        try{
            

            String sql = "SELECT * FROM doctors ORDER BY id ASC";
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            System.out.print(sql);
            ResultSet retorno = st.executeQuery(sql);
            
            EspecialidadeDao especialidadeDao = new EspecialidadeDao();
            Doctor docObj = null;
            while (retorno.next()) {
                System.out.print(retorno);
                docObj = new Doctor(retorno.getString("Nome"), retorno.getString("crm"), especialidadeDao.buscar(retorno.getInt("especialidades_id"))); 
               
                doctors.add(docObj);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        return doctors;
    }
    public void popularTabela(JTable tabela, String criterio) {

        //LISTA DOS DADOS DECLARADA
        Object[][] dadosTabela = null;

        //CABECALHO DA TABELA
        Object[] cabecalho = new Object[3];
        /*cabecalho[0] = "Id";*/
        cabecalho[0] = "Nome";
        cabecalho[1] = "CRM";
        cabecalho[2] = "Especializacao";

        //INSERCAO DOS DADOS NA LISTA
        try {

            int linha = 0;

            List<Doctor> lista = new DoctorDao().listar();

            //CRIA MATRIZ DE ACORDO COM O NUMERO DE REGISTROS
             
            dadosTabela = new Object[lista.size()][4];

            for (Doctor doc : lista) {

                /*dadosTabela[linha][0] = user.getCodUsuario();*/
                dadosTabela[linha][0] = doc.getNome();
                dadosTabela[linha][1] = doc.getCrm();
                dadosTabela[linha][2] = doc.getEspecializacao().getDescricao();

                linha++;
            }

        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override

            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                //return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite selecao de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }

}
