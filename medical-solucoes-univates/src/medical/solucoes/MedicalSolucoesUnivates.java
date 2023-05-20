package medical.solucoes;

import javax.swing.UIManager;
import medical.solucoes.view.Login;

public class MedicalSolucoesUnivates {

    public static void main(String[] args) {
          try {
        UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");
    } catch (Exception ex) {
       
    }
        new Login().setVisible(true);
    }
    
}
