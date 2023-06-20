/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package medical.solucoes.view;

import javax.swing.JInternalFrame;

/**
 *
 * @author loren
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
         
        setTitle("Medical Soluções");
    }

    private void abrirInternalFrame(JInternalFrame internalFrame) {
        jDesktopPane1.add(internalFrame);
        internalFrame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnRegister = new javax.swing.JMenu();
        mniUsers = new javax.swing.JMenuItem();
        mniDoctors = new javax.swing.JMenuItem();
        mniPacients = new javax.swing.JMenuItem();
        mniUsers1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mniAppointment1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniAppointment2 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mniAppointment3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        mnRegister.setText("Cadastro");

        mniUsers.setText("Usuarios");
        mniUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUsersActionPerformed(evt);
            }
        });
        mnRegister.add(mniUsers);

        mniDoctors.setText("Medicos");
        mniDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoctorsActionPerformed(evt);
            }
        });
        mnRegister.add(mniDoctors);

        mniPacients.setText("Pacientes");
        mniPacients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPacientsActionPerformed(evt);
            }
        });
        mnRegister.add(mniPacients);

        mniUsers1.setText("Especialidades");
        mniUsers1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUsers1ActionPerformed(evt);
            }
        });
        mnRegister.add(mniUsers1);

        jMenuBar1.add(mnRegister);

        jMenu4.setText("Operacional");

        mniAppointment1.setText("Consultas");
        mniAppointment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAppointment1ActionPerformed(evt);
            }
        });
        jMenu4.add(mniAppointment1);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Relatorios");

        mniAppointment2.setText("Consultas Por Paciente");
        mniAppointment2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAppointment2ActionPerformed(evt);
            }
        });
        jMenu2.add(mniAppointment2);

        jMenuItem2.setText("Consultas Por Médico");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        mniAppointment3.setText("Estatísticas");
        mniAppointment3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAppointment3ActionPerformed(evt);
            }
        });
        jMenu2.add(mniAppointment3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mniUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUsersActionPerformed
        abrirInternalFrame(new IfrCadastroUsers());
    }//GEN-LAST:event_mniUsersActionPerformed

    private void mniDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoctorsActionPerformed
        abrirInternalFrame(new IfrCadastroDoctors());
    }//GEN-LAST:event_mniDoctorsActionPerformed

    private void mniAppointment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAppointment1ActionPerformed
        abrirInternalFrame(new IfrOperacionalConsultas(this.jDesktopPane1));
    }//GEN-LAST:event_mniAppointment1ActionPerformed

    private void mniUsers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUsers1ActionPerformed
        abrirInternalFrame(new IfrCadastroEspecialidades());
    }//GEN-LAST:event_mniUsers1ActionPerformed

    private void mniPacientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPacientsActionPerformed
        abrirInternalFrame(new IfrCadastroPacientes());
    }//GEN-LAST:event_mniPacientsActionPerformed

    private void mniAppointment2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAppointment2ActionPerformed
        abrirInternalFrame(new IfrConsultasPorPacientes());
    }//GEN-LAST:event_mniAppointment2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        abrirInternalFrame(new IfrConsultasPorMedicos());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mniAppointment3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAppointment3ActionPerformed
        abrirInternalFrame(new IfrRelatorioEstatisticas());
    }//GEN-LAST:event_mniAppointment3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu mnRegister;
    private javax.swing.JMenuItem mniAppointment1;
    private javax.swing.JMenuItem mniAppointment2;
    private javax.swing.JMenuItem mniAppointment3;
    private javax.swing.JMenuItem mniDoctors;
    private javax.swing.JMenuItem mniPacients;
    private javax.swing.JMenuItem mniUsers;
    private javax.swing.JMenuItem mniUsers1;
    // End of variables declaration//GEN-END:variables
}
