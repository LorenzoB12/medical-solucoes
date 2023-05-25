/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.dao;

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
    
    
    public Paciente consultarId(Long idPaciente){
        
        Paciente retornoPaciente = null;
        
        List<Paciente> listaPacientes = Paciente.pacientesEstaticos;
        
        for(Paciente p: listaPacientes){
            if(p.getId() == idPaciente){
                retornoPaciente = p;
            }
        }
        
        return retornoPaciente;
        
    }
    
    public Long consultarProximoId(){
        
        Long proximoId = null;
        
        List<Paciente> listaPacientes = Paciente.pacientesEstaticos;
        
        proximoId = listaPacientes.get(listaPacientes.size() - 1).getId();
        
        return (proximoId + 1);
        
    }
    
    public String inativarPaciente(Long idPaciente){
        
        List<Paciente> listaPacientes = Paciente.pacientesEstaticos;
        
        String erro = "Nenhum paciente encontrado!";
        
        for(Paciente p: listaPacientes){
            if(p.getId() == idPaciente){
                p.setIndAtivo(Boolean.FALSE);
                erro = null;
            }
        }
        
        return erro;
        
    }
    
    public String ativarPaciente(Long idPaciente){
        
        List<Paciente> listaPacientes = Paciente.pacientesEstaticos;
        
        String erro = "Nenhum paciente encontrado!";
        
        for(Paciente p: listaPacientes){
            if(p.getId() == idPaciente){
                p.setIndAtivo(Boolean.TRUE);
                erro = null;
            }
        }
        
        return erro;
        
    }
    
    public void atualizarPaciente(Long idPaciente, String nome, String dataNascimento, String cpf, String telefone, String genero){
        
        Paciente paciente;
        
        List<Paciente> listaPacientes = Paciente.pacientesEstaticos;
        
        for(Paciente p: listaPacientes){
            if(p.getId() == idPaciente){
                p.setNome(nome);
                p.setDataNascimento(dataNascimento);
                p.setCpf(cpf);
                p.setTelefone(telefone);
                p.setGenero(genero);
            }
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
            lista.addAll(0, Paciente.pacientesEstaticos);

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
    
}
