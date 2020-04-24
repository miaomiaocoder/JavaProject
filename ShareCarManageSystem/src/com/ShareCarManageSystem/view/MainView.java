package com.ShareCarManageSystem.view;

import java.beans.PropertyVetoException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainView extends javax.swing.JFrame {

	private javax.swing.JLabel jLabel2;
	private javax.swing.JButton jbtn_carInfo;
	private javax.swing.JButton jbtn_fixCar;
	private javax.swing.JButton jbtn_profitAnalysis;
	private javax.swing.JButton jbtn_rentCar;
	private javax.swing.JButton jbtn_repayCar;

	public MainView() {
		initComponents();
		// 居中显示
		this.setLocationRelativeTo(null);
	}

	private void initComponents() {

		jLabel2 = new javax.swing.JLabel();
		jbtn_carInfo = new javax.swing.JButton();
		jbtn_rentCar = new javax.swing.JButton();
		jbtn_profitAnalysis = new javax.swing.JButton();
		jbtn_repayCar = new javax.swing.JButton();
		jbtn_fixCar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("车辆管理系统");

		jLabel2.setFont(new java.awt.Font("宋体", 0, 60)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("车  辆  管  理  系  统");

		jbtn_carInfo.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
		jbtn_carInfo.setText("车辆信息管理");
		jbtn_carInfo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn_carInfoActionPerformed(evt);
			}
		});

		jbtn_rentCar.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
		jbtn_rentCar.setText("租车信息管理");
		jbtn_rentCar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn_rentCarActionPerformed(evt);
			}
		});

		jbtn_profitAnalysis.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
		jbtn_profitAnalysis.setText("利润分析");
		jbtn_profitAnalysis.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn_profitAnalysisActionPerformed(evt);
			}
		});

		jbtn_repayCar.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
		jbtn_repayCar.setText("还车信息管理");
		jbtn_repayCar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn_repayCarActionPerformed(evt);
			}
		});

		jbtn_fixCar.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
		jbtn_fixCar.setText("修车信息管理");
		jbtn_fixCar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbtn_fixCarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jbtn_profitAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 632,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jbtn_carInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 307,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(jbtn_rentCar, javax.swing.GroupLayout.PREFERRED_SIZE, 307,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(jbtn_repayCar, javax.swing.GroupLayout.PREFERRED_SIZE, 307,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(jbtn_fixCar,
												javax.swing.GroupLayout.PREFERRED_SIZE, 307,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(181, 181, 181)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel2).addGap(39, 39, 39)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jbtn_carInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jbtn_rentCar, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jbtn_repayCar, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jbtn_fixCar, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(jbtn_profitAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE,
								120, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(86, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jbtn_carInfoActionPerformed(java.awt.event.ActionEvent evt) {
		new CarInfoView().setVisible(true);
	}

	private void jbtn_rentCarActionPerformed(java.awt.event.ActionEvent evt) {
		new RentCarView().setVisible(true);
	}

	private void jbtn_profitAnalysisActionPerformed(java.awt.event.ActionEvent evt) {
		new ProfitAnalysisView().setVisible(true);
	}

	private void jbtn_repayCarActionPerformed(java.awt.event.ActionEvent evt) {
		new RepayCarView().setVisible(true);
	}

	private void jbtn_fixCarActionPerformed(java.awt.event.ActionEvent evt) {
		new FixCarView().setVisible(true);
	}
}

