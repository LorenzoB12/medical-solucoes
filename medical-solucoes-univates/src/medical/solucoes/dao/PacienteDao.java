/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.dao;

import conexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import medical.solucoes.model.Usuario;
import medical.solucoes.model.Paciente;

/**
 *
 * @author loren
 */
public class PacienteDao {
    
    
    public boolean salvar(Paciente p) {
        System.out.println(p.getDataNascimento());
        
        try {
            String sql = "INSERT INTO PACIENTES (nome, data_nascimento, cpf, telefone, genero, ativo) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            pstm.setString(1, p.getNome());
            
            Integer dia = Integer.parseInt(p.getDataNascimento().split("/")[0]);
            Integer mes = Integer.parseInt(p.getDataNascimento().split("/")[1]);
            Integer ano = Integer.parseInt(p.getDataNascimento().split("/")[2]);
            LocalDate localDate = LocalDate.of(ano, mes, dia);
            Date sqlDate = Date.valueOf(localDate);
            
            pstm.setDate(2, sqlDate);
            pstm.setString(3, p.getCpf());
            pstm.setString(4, p.getTelefone());
            pstm.setString(5, p.getGenero());
            pstm.setBoolean(6, p.getIndAtivo());
            
            pstm.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public Paciente consultarId(Long idPaciente){
        Paciente paciente = new Paciente();
        try{
            String sql = "SELECT * FROM PACIENTES WHERE ID = " + idPaciente;
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                paciente.setId(rs.getLong(1));
                paciente.setNome(rs.getString(2));
                
                Date dataNascimentoSql = rs.getDate(3);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataNascimentoFormatada = dateFormat.format(dataNascimentoSql);
                paciente.setDataNascimento(dataNascimentoFormatada);
                
                paciente.setCpf(rs.getString(4));
                paciente.setTelefone(rs.getString(5));
                paciente.setGenero(rs.getString(6));
            }
            
        } catch (Exception e){
            System.out.println(e);
        }
        
        return paciente;
    }
    
    public Long consultarProximoId(){
        
        return null;
        
    }
    
    public String inativarPaciente(Long idPaciente){
        
        return null;
        
    }
    
    public String ativarPaciente(Long idPaciente){
        
        return null;
        
    }
    
    public boolean atualizarPaciente(Paciente paciente){
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE PACIENTES SET NOME = ?, DATA_NASCIMENTO = ?, CPF = ?, TELEFONE = ?, GENERO = ?, ATIVO = ? WHERE ID = ?";
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
        
            pstm.setString(1, paciente.getNome());
            
            Integer dia = Integer.parseInt(paciente.getDataNascimento().split("/")[0]);
            Integer mes = Integer.parseInt(paciente.getDataNascimento().split("/")[1]);
            Integer ano = Integer.parseInt(paciente.getDataNascimento().split("/")[2]);
            LocalDate localDate = LocalDate.of(ano, mes, dia);
            Date sqlDate = Date.valueOf(localDate);
            pstm.setDate(2, sqlDate);
            
            pstm.setString(3, paciente.getCpf());
            pstm.setString(4, paciente.getTelefone());
            pstm.setString(5, paciente.getGenero());
            pstm.setBoolean(6, paciente.getIndAtivo());
            pstm.setLong(7, paciente.getId());
            
            pstm.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    
    public void popularTabela(JTable tabela, String criterio) {

        //LISTA DOS DADOS DECLARADA
        Object[][] dadosTabela = null;

        //CABECALHO DA TABELA
        Object[] cabecalho = new Object[7];
        /*cabecalho[0] = "Id";*/
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "CPF";
        cabecalho[3] = "Data de Nascimento";
        cabecalho[4] = "Telefone";
        cabecalho[5] = "Gênero";
        cabecalho[6] = "Ind Ativo";

        //INSERCAO DOS DADOS NA LISTA
        try {

            int linha = 0;

            List<Paciente> lista = new ArrayList<>();

            //CRIA MATRIZ DE ACORDO COM O NUMERO DE REGISTROS
            dadosTabela = new Object[lista.size()][7];

            for (Paciente p : lista) {

                /*dadosTabela[linha][0] = user.getCodUsuario();*/
                dadosTabela[linha][0] = p.getId();
                dadosTabela[linha][1] = p.getNome();
                dadosTabela[linha][2] = p.getCpf();
                dadosTabela[linha][3] = p.getDataNascimento();
                dadosTabela[linha][4] = p.getTelefone();
                dadosTabela[linha][5] = p.getGenero();
                if(p.getIndAtivo()){
                    dadosTabela[linha][6] = "ATIVO";
                } else{
                    dadosTabela[linha][6] = "INATIVO";
                }

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

    public ArrayList<Paciente> listar() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM pacientes ORDER BY id ASC";
            ResultSet retorno = st.executeQuery(sql);

            Paciente pacienteObj = null;
            while (retorno.next()) {
                pacienteObj = new Paciente();
                pacienteObj.setId(retorno.getLong("id"));
                pacienteObj.setNome(retorno.getString("nome"));
                pacienteObj.setDataNascimento(retorno.getString("data_nascimento"));
                pacienteObj.setCpf(retorno.getString("cpf"));
                pacienteObj.setTelefone(retorno.getString("telefone"));
                pacienteObj.setGenero(retorno.getString("genero"));
                pacienteObj.setIndAtivo(retorno.getBoolean("ativo"));
               
                pacientes.add(pacienteObj);
            }

            return pacientes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }
    
}
