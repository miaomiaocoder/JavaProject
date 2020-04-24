package com.ShareCarManageSystem.view;

import javax.swing.JOptionPane;

import com.ShareCarManageSystem.util.Database;

public class LoginView extends javax.swing.JFrame {

	private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtn_login;
    private javax.swing.JPasswordField jtf_password;
    private javax.swing.JTextField jtf_username;
    
    public LoginView() {
        initComponents();
        //������ʾ
        this.setLocationRelativeTo(null);
        //��ʼ�����ݿ�
        new Database();
        //�ж����ݿ��Ƿ����ӳɹ�
        if(Database.getCon() == null){
            JOptionPane.showMessageDialog(null, "���ݿ�����ʧ��!", "��ʾ", JOptionPane.ERROR_MESSAGE); 
            System.exit(0);
        }
    }
                       
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_username = new javax.swing.JTextField();
        jbtn_login = new javax.swing.JButton();
        jtf_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("��������ϵͳ - ����Ա��¼");

        jLabel1.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        jLabel1.setText("��  �룺");

        jLabel2.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        jLabel2.setText("��¼����");

        jtf_username.setFont(new java.awt.Font("����", 0, 18)); // NOI18N

        jbtn_login.setFont(new java.awt.Font("����", 0, 18)); // NOI18N
        jbtn_login.setText("��¼");
        jbtn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_loginActionPerformed(evt);
            }
        });

        jtf_password.setFont(new java.awt.Font("����", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_username, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(jtf_password))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addComponent(jbtn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jbtn_login)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>                        

    private void jbtn_loginActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //����Ա��¼
        boolean result=Database.adminLogin(jtf_username.getText().trim(), jtf_password.getText().trim());
        if(result){
            //��¼�ɹ�
            new MainView().setVisible(true);
            this.setVisible(false);
        }else{
            //��¼ʧ��
            JOptionPane.showMessageDialog(null, "��¼����������������µ�¼!", "��ʾ", JOptionPane.ERROR_MESSAGE); 
        }
    }                                          

    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }
                   
    
                 
}

