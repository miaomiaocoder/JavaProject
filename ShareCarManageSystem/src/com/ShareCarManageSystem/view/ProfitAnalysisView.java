package com.ShareCarManageSystem.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import com.ShareCarManageSystem.util.Database;

public class ProfitAnalysisView extends javax.swing.JFrame {

	 private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JLabel jl_expend;
	    private javax.swing.JLabel jl_income;
	    private javax.swing.JLabel jl_profit;
	    private javax.swing.JTable jt_table; 
	    
    public ProfitAnalysisView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    //数据标题
    private String headTitle[] = new String[]{"编号", "时间", "类型", "车辆ID", "费用"};
    private DefaultTableModel dtm = null;
    
    public Object[][] makeTable() {
        List<String[]> list = Database.profitAnalysis();
        Object[][] data = new Object[list.size()][5];
        float sum1=0;
        float sum2=0;
        for (int i = 0; i < list.size()-1; i++) {
            data[i][0] = i+1;
            data[i][1] = list.get(i)[0];
            data[i][2] = list.get(i)[1];
            data[i][3] = list.get(i)[2];
            data[i][4] = list.get(i)[3];
        }
        jl_income.setText(list.get(list.size()-1)[0]);
        jl_expend.setText(list.get(list.size()-1)[1]);
        jl_profit.setText(Float.toString(Float.parseFloat(list.get(list.size()-1)[0])-Float.parseFloat(list.get(list.size()-1)[1])));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jl_expend = new javax.swing.JLabel();
        jl_income = new javax.swing.JLabel();
        jl_profit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("利润分析");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("车辆信息"));

        dtm=new DefaultTableModel(makeTable(),headTitle);
        jt_table.setModel(dtm);
        jScrollPane1.setViewportView(jt_table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("分析结果"));

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel1.setText("利润");

        jLabel2.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel2.setText("收入");

        jLabel3.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel3.setText("支出");

        jl_expend.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jl_expend.setForeground(new java.awt.Color(255, 51, 51));
        jl_expend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jl_income.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jl_income.setForeground(new java.awt.Color(0, 153, 255));
        jl_income.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jl_profit.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        jl_profit.setForeground(new java.awt.Color(0, 204, 0));
        jl_profit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jl_income, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jl_expend, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jl_profit, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_income)
                    .addComponent(jl_expend)
                    .addComponent(jl_profit))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
}
