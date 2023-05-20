/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import medical.solucoes.model.Usuario;

/**
 *
 * @author loren
 */
public class UsuarioDao {

    public void popularTabela(JTable tabela, String criterio) {

        //LISTA DOS DADOS DECLARADA
        Object[][] dadosTabela = null;

        //CABECALHO DA TABELA
        Object[] cabecalho = new Object[4];
        /*cabecalho[0] = "Id";*/
        cabecalho[0] = "Nome";
        cabecalho[1] = "Email";
        cabecalho[2] = "Login";
        cabecalho[3] = "Senha";

        //INSERCAO DOS DADOS NA LISTA
        try {

            int linha = 0;

            List<Usuario> lista = new ArrayList<>();
            lista.addAll(0, Usuario.usuariosEstaticos);
            lista.add(Usuario.user1);
            lista.add(Usuario.user2);
            lista.add(Usuario.user3);

            //CRIA MATRIZ DE ACORDO COM O NUMERO DE REGISTROS
            dadosTabela = new Object[lista.size()][4];

            for (Usuario user : lista) {

                /*dadosTabela[linha][0] = user.getCodUsuario();*/
                dadosTabela[linha][0] = user.getNome();
                dadosTabela[linha][1] = user.getEmail();
                dadosTabela[linha][2] = user.getLogin();
                dadosTabela[linha][3] = user.getSenha();

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
