package medical.solucoes.view;

import javax.swing.JOptionPane;
import medical.solucoes.dao.EspecialidadeDao;
import medical.solucoes.model.Especialidade;
import medical.tabelas.TableModelEspecialidades;

public class IfrCadastroEspecialidades extends javax.swing.JInternalFrame {

    private Especialidade especialidade = null;
    private final EspecialidadeDao especialidadeDao = new EspecialidadeDao();
    private TableModelEspecialidades table = null;

    public IfrCadastroEspecialidades() {
        initComponents();
        this.carregarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        btnSalvarUsuario = new javax.swing.JButton();
        btnSalvarUsuario1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoc = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cadastro de Especialidades");
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("DESCRIÇÃO");

        btnSalvarUsuario.setText("SALVAR");
        btnSalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuarioActionPerformed(evt);
            }
        });

        btnSalvarUsuario1.setText("NOVO");
        btnSalvarUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuario1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSalvarUsuario1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvarUsuario))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvarUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(172, 172, 172))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        tblDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDoc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuarioActionPerformed
        this.salvar();
    }//GEN-LAST:event_btnSalvarUsuarioActionPerformed

    private void btnSalvarUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuario1ActionPerformed
        this.limparFormulario();
    }//GEN-LAST:event_btnSalvarUsuario1ActionPerformed

    private void tblDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocMouseClicked
        if (evt.getClickCount() == 2) {
            this.especialidade = (Especialidade) table.getValueAt(tblDoc.getSelectedRow(), -1);
            this.carregarFormulario();
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tblDocMouseClicked

    private void limparFormulario() {
        this.carregarTabela();
        tfDescricao.setText("");
        this.especialidade = null;
    }

    private void carregarFormulario() {
        tfDescricao.setText(this.especialidade.getDescricao());
    }

    private boolean validarFormulario() {
        if (tfDescricao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Descrição não informada", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void salvar() {
        if (!this.validarFormulario()) {
            return;
        }

        boolean isNovoCadastro = false;
        if (this.especialidade == null) {
            this.especialidade = new Especialidade();
            isNovoCadastro = true;
        }

        this.especialidade.setDescricao(tfDescricao.getText());
        if (isNovoCadastro) {
            if (this.especialidadeDao.salvar(this.especialidade)) {
                JOptionPane.showMessageDialog(null,
                        "Registro inserido com sucesso", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                this.limparFormulario();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Erro ao salvar especialidade", "Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (this.especialidadeDao.atualizar(this.especialidade)) {
                JOptionPane.showMessageDialog(null,
                        "Registro atualizado com sucesso", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                this.limparFormulario();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Erro ao atualizar especialidade", "Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void carregarTabela() {
        table = new TableModelEspecialidades(this.especialidadeDao.listar());
        tblDoc.setModel(table);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvarUsuario;
    private javax.swing.JButton btnSalvarUsuario1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDoc;
    private javax.swing.JTextField tfDescricao;
    // End of variables declaration//GEN-END:variables
}
