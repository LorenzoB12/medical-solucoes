package medical.solucoes;

import at.favre.lib.crypto.bcrypt.BCrypt;
import conexao.ConexaoBD;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import medical.solucoes.view.Login;

public class MedicalSolucoesUnivates {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");

            if (ConexaoBD.getInstance().getConnection() != null) {
                new Login().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de Dados!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
