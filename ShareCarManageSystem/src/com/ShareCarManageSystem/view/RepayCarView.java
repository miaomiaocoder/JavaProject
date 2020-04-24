package com.ShareCarManageSystem.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.ShareCarManageSystem.model.RepayCar;
import com.ShareCarManageSystem.util.Database;

public class RepayCarView extends javax.swing.JFrame {

	private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_add;
    private javax.swing.JButton jbtn_delete;
    private javax.swing.JButton jbtn_modify;
    private javax.swing.JButton jbtn_refresh;
    private javax.swing.JTable jt_table;
    private javax.swing.JTextField jtf_carId;
    private javax.swing.JTextField jtf_id;
    private javax.swing.JTextField jtf_status;
    private javax.swing.JTextField jtf_time;
    private javax.swing.JTextField jtf_username;   
    
    public RepayCarView() {
        initComponents();
        //居中显示
        this.setLocationRelativeTo(null);
    }

    //数据标题
    private String headTitle[] = new String[]{"还车编号", "还车时间", "还车用户", "车辆ID", "还车状态"};
    private DefaultTableModel dtm = null;

    public Object[][] makeTable() {
        List<RepayCar> list = Database.queryRepayCarInfo();
        Object[][] data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getRepayDate();
            data[i][2] = list.get(i).getName();
            data[i][3] = list.get(i).getCarId();
            data[i][4] = list.get(i).getStatus();
        }
        return data;
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_table = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jtf_id = new javax.swing.JTextField();
        jtf_time = new javax.swing.JTextField();
        jtf_username = new javax.swing.JTextField();
        jtf_carId = new javax.swing.JTextField();
        jtf_status = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtn_add = new javax.swing.JButton();
        jbtn_modify = new javax.swing.JButton();
        jbtn_delete = new javax.swing.JButton();
        jbtn_refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("还车信息管理");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("车辆信息"));

        dtm=new DefaultTableModel(makeTable(),headTitle);
        jt_table.setModel(dtm);
        jt_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("信息操作"));

        jtf_id.setEditable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("还车编号");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("还车时间");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("还车用户");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("车辆ID");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("还车状态");

        jbtn_add.setText("添加");
        jbtn_add.setToolTipText("");
        jbtn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_addActionPerformed(evt);
            }
        });

        jbtn_modify.setText("修改");
        jbtn_modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_modifyActionPerformed(evt);
            }
        });

        jbtn_delete.setText("删除");
        jbtn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_deleteActionPerformed(evt);
            }
        });

        jbtn_refresh.setText("刷新");
        jbtn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbtn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addComponent(jtf_status)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_carId)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_username)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_time, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_id))
                    .addComponent(jbtn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_carId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_modify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_refresh))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jt_tableMouseClicked(java.awt.event.MouseEvent evt) {                                      
        //选择车辆
        int index = jt_table.getSelectedRow();
        if (index != -1) {
            jtf_id.setText(jt_table.getValueAt(index, 0).toString());
            jtf_time.setText(jt_table.getValueAt(index, 1).toString());
            jtf_username.setText(jt_table.getValueAt(index, 2).toString());
            jtf_carId.setText(jt_table.getValueAt(index, 3).toString());
            jtf_status.setText(jt_table.getValueAt(index, 4).toString());
        }
    }                                     

    private void jbtn_addActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // 添加车辆
        RepayCar car = new RepayCar(0, jtf_time.getText(), jtf_username.getText(), Integer.parseInt(jtf_carId.getText()),jtf_status.getText());
        boolean result = Database.addRepayCarInfo(car);
        if (result) {
            JOptionPane.showMessageDialog(null, "添加还车成功!", "提示", JOptionPane.PLAIN_MESSAGE);
            //刷新列表
            jbtn_refresh.doClick();
            //清空
            jtf_id.setText("");
            jtf_time.setText("");
            jtf_username.setText("");
            jtf_carId.setText("");
            jtf_status.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "添加还车失败!", "提示", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jbtn_modifyActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //修改车辆
        RepayCar car = new RepayCar(Integer.parseInt(jtf_id.getText()), jtf_time.getText(), jtf_username.getText(), Integer.parseInt(jtf_carId.getText()),jtf_status.getText());
        boolean result = Database.modifyRepayCarInfo(car);
        if (result) {
            JOptionPane.showMessageDialog(null, "修改还车成功!", "提示", JOptionPane.PLAIN_MESSAGE);
            //刷新列表
            jbtn_refresh.doClick();
        } else {
            JOptionPane.showMessageDialog(null, "修改还车失败!", "提示", JOptionPane.ERROR_MESSAGE);
        }
    }                                           

    private void jbtn_deleteActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //删除车辆
        boolean result = Database.deleteRepayCarInfo(Integer.parseInt(jtf_id.getText()));
        if (result) {
            JOptionPane.showMessageDialog(null, "删除还车成功!", "提示", JOptionPane.PLAIN_MESSAGE);
            //刷新列表
            jbtn_refresh.doClick();
            //清空
            jtf_id.setText("");
            jtf_time.setText("");
            jtf_username.setText("");
            jtf_carId.setText("");
            jtf_status.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "删除还车失败!", "提示", JOptionPane.ERROR_MESSAGE);
        }
    }                                           

    private void jbtn_refreshActionPerformed(java.awt.event.ActionEvent evt) {                                             
        //刷新数据
        dtm = new DefaultTableModel(makeTable(), headTitle);
        jt_table.removeAll();
        jt_table.setModel(dtm);
    }   
}
