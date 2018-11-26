package lee_pag;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.jfree.ui.RefineryUtilities;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JTable CuMainView;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane_2;
	private JSplitPane splitPane_3;
	private JPanel panel_3;
	private JLabel label_4;
	private JTextField tfCuName;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField tfCuBirth;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField tfCuAddr;
	private JLabel label_9;
	private JTextField tfCuPhone;
	private JButton btnCuInsert;
	private JButton BtnCuReset;
	private JButton btnCuUpdate;
	private JButton btnCuDelete;

	private JLabel lblPassword;
	private JLabel lblId;
	private JTextField tfCuId;
	private JPasswordField tfCuPwd;
	private JSplitPane splitPane_4;
	private JScrollPane scrollPane_3;
	private JTable tbCuSignUpView;
	private JPanel panel_1;
	private JComboBox cbCu;
	private JTextField tfCuSearch;
	private JButton btnSearch;
	private boolean flag;
	/**
	 * Launch the application.
	 */
	CustomerDBA dba = new CustomerDBA();
	ArrayList<Customer_s> arr = null;
	ButtonGroup btngr = new ButtonGroup();
	private static String id = null;
	private JRadioButton rdCuMen;
	private JRadioButton rdCuWomen;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane_1;
	private JTextArea CustTa;
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnAddr;
	private JLabel lacheck;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param id
	 */
	public Customer(String id) {
		setResizable(false);
		setTitle("\uACE0\uAC1D\uD604\uD669");
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("\uACE0\uAC1D\uD604\uD669", null, getSplitPane(), null);
			tabbedPane.addTab("\uACE0\uAC1D\uC815\uBCF4\uB4F1\uB85D", null, getScrollPane_2(), null);
		}
		return tabbedPane;
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setRightComponent(getScrollPane());
			splitPane.setLeftComponent(getSplitPane_1());
			splitPane.setDividerLocation(205);
		}
		return splitPane;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getCuMainView());
		}
		return scrollPane;
	}

	private JTable getCuMainView() {
		if (CuMainView == null) {
			CuMainView = new JTable();
			arr = dba.CustomerView();
			String[] cols = { "NAME", "BIRTH", "GENDER", "ADDR", "PHONE", "Id" };
			DefaultTableModel dt = new DefaultTableModel(cols, arr.size());
			// DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			// center.setHorizontalAlignment(SwingConstants.CENTER);
			// TableColumnModel tc = CuMainView.getColumnModel();
			for (int i = 0; i < arr.size(); i++) {
				dt.setValueAt(arr.get(i).getName(), i, 0);
				dt.setValueAt(arr.get(i).getBirth().replaceAll(" 00:00:00", ""), i, 1);
				dt.setValueAt(arr.get(i).getGender(), i, 2);
				dt.setValueAt(arr.get(i).getAddr(), i, 3);
				dt.setValueAt(arr.get(i).getPhone(), i, 4);
				dt.setValueAt(arr.get(i).getId(), i, 5);
				// tc.getColumn(i).setCellRenderer(center);
			}
			CuMainView.setModel(dt);
		}
		return CuMainView;
	}

	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setLeftComponent(getScrollPane_1_1());
			splitPane_1.setRightComponent(getPanel_2());
			splitPane_1.setDividerLocation(300);
		}
		return splitPane_1;
	}

	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getSplitPane_3());
		}
		return scrollPane_2;
	}

	private JSplitPane getSplitPane_3() {
		if (splitPane_3 == null) {
			splitPane_3 = new JSplitPane();
			splitPane_3.setRightComponent(getPanel_3());
			splitPane_3.setLeftComponent(getSplitPane_4());
			splitPane_3.setDividerLocation(270);
		}
		return splitPane_3;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.add(getLabel_4());
			panel_3.add(getTfCuName());
			panel_3.add(getLabel_5());
			panel_3.add(getLabel_6());
			panel_3.add(getTfCuBirth());
			panel_3.add(getLabel_7());
			panel_3.add(getLabel_8());
			panel_3.add(getTfCuAddr());
			panel_3.add(getLabel_9());
			panel_3.add(getTfCuPhone());
			panel_3.add(getBtnCuInsert());
			panel_3.add(getBtnCuReset());
			panel_3.add(getBtnCuUpdate());
			panel_3.add(getBtnCuDelete());
			panel_3.add(getLblPassword());
			panel_3.add(getLblId());
			panel_3.add(getTfCuId());
			panel_3.add(getTfCuPwd());
			panel_3.add(getRdCuMen());
			panel_3.add(getRdCuWomen());
			panel_3.add(getLacheck());
		}
		return panel_3;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uACE0\uAC1D\uC815\uBCF4\uB4F1\uB85D", SwingConstants.CENTER);
			label_4.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 20));
			label_4.setBounds(0, 10, 365, 27);
		}
		return label_4;
	}

	private JTextField getTfCuName() {
		if (tfCuName == null) {
			tfCuName = new JTextField();
			tfCuName.setColumns(10);
			tfCuName.setBounds(148, 154, 141, 21);
		}
		return tfCuName;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uC774\uB984");
			label_5.setBounds(67, 157, 69, 15);
		}
		return label_5;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
			label_6.setBounds(67, 199, 69, 15);
		}
		return label_6;
	}

	private JTextField getTfCuBirth() {
		if (tfCuBirth == null) {
			tfCuBirth = new JTextField();
			tfCuBirth.setColumns(10);
			tfCuBirth.setBounds(148, 196, 141, 21);
		}
		return tfCuBirth;
	}

	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("\uC131\uBCC4");
			label_7.setBounds(67, 237, 69, 15);
		}
		return label_7;
	}

	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("\uC8FC\uC18C");
			label_8.setBounds(67, 271, 69, 15);
		}
		return label_8;
	}

	private JTextField getTfCuAddr() {
		if (tfCuAddr == null) {
			tfCuAddr = new JTextField();
			tfCuAddr.setColumns(10);
			tfCuAddr.setBounds(148, 268, 141, 21);
		}
		return tfCuAddr;
	}

	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_9.setBounds(67, 305, 69, 15);
		}
		return label_9;
	}

	private JTextField getTfCuPhone() {
		if (tfCuPhone == null) {
			tfCuPhone = new JTextField();
			tfCuPhone.setColumns(10);
			tfCuPhone.setBounds(148, 302, 141, 21);
		}
		return tfCuPhone;
	}

	private JButton getBtnCuInsert() {
		if (btnCuInsert == null) {
			btnCuInsert = new JButton("\uCD94\uAC00");
			btnCuInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (flag == false) {
						Customer_s c = new Customer_s();
						c.setId(tfCuId.getText());
						c.setPwd(tfCuPwd.getPassword());
						c.setName(tfCuName.getText());
						c.setBirth(tfCuBirth.getText());
						String gender = "";
						int cnt = 0;
						if (rdCuMen.isSelected()) {
							gender = "남";
							cnt++;
							c.setGender("남");
						}
						if (rdCuWomen.isSelected()) {
							gender = "여";
							cnt++;
							c.setGender("여");
						}
						if (cnt == 2) {
							JOptionPane.showMessageDialog(null, "성별은 하나만 선택가능 합니다.");
							return;
						}
						c.setGender(gender);
						c.setAddr(tfCuAddr.getText());
						c.setPhone(tfCuPhone.getText().replaceAll("-", ""));
						dba.CustomerInsert(c);

						CustTableView();
					} else {
						JOptionPane.showMessageDialog(null, "다른 아이디를 사용해주세요.");
					}
				}
			});
			btnCuInsert.setBounds(67, 385, 69, 23);
		}
		return btnCuInsert;
	}

	private JButton getBtnCuReset() {
		if (BtnCuReset == null) {
			BtnCuReset = new JButton("reset");
			BtnCuReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfCuId.setEnabled(true);
					tfCuId.setText("");
					tfCuPwd.setText("");
					tfCuName.setText("");
					tfCuBirth.setText("");
					tfCuAddr.setText("");
					tfCuPhone.setText("");
					btnCuDelete.setEnabled(false);
					btnCuUpdate.setEnabled(false);
				}
			});
			BtnCuReset.setBounds(205, 333, 84, 23);
		}
		return BtnCuReset;
	}

	private JButton getBtnCuUpdate() {
		if (btnCuUpdate == null) {
			btnCuUpdate = new JButton("\uC218\uC815");
			btnCuUpdate.setEnabled(false);
			btnCuUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Customer_s ct = new Customer_s();
					ct.setId(tfCuId.getText());
					ct.setPwd(tfCuPwd.getPassword());
					ct.setName(tfCuName.getText());
					ct.setBirth(tfCuBirth.getText());
					dba.CustomerUpdate(ct, id);
					CustTableView();
				}
			});
			btnCuUpdate.setBounds(148, 385, 72, 23);
		}
		return btnCuUpdate;
	}

	private JButton getBtnCuDelete() {
		if (btnCuDelete == null) {
			btnCuDelete = new JButton("\uC0AD\uC81C");
			btnCuDelete.setEnabled(false);
			btnCuDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "삭제할까요?", "confirm",
							JOptionPane.YES_NO_CANCEL_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						String user = tfCuId.getText();
						dba.CustomerDelete(user);
						tbCuSignUpView.getMouseListeners();
						getTable_1_1();
						CustTableView();
					}
				}
			});
			btnCuDelete.setBounds(232, 385, 69, 23);
		}
		return btnCuDelete;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("PASSWORD");
			lblPassword.setBounds(67, 119, 69, 15);
		}
		return lblPassword;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setBounds(67, 82, 69, 15);
		}
		return lblId;
	}

	private JTextField getTfCuId() {
		if (tfCuId == null) {
			tfCuId = new JTextField();
			tfCuId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					flag = dba.check(tfCuId.getText());
					if (flag == true) {
						lacheck.setText("사용불가능");
					} else {
						lacheck.setText("사용가능");
					}
				}
			});
			tfCuId.setColumns(10);
			tfCuId.setBounds(148, 79, 141, 21);
		}
		return tfCuId;
	}

	private JPasswordField getTfCuPwd() {
		if (tfCuPwd == null) {
			tfCuPwd = new JPasswordField();
			tfCuPwd.setBounds(148, 116, 141, 21);
		}
		return tfCuPwd;
	}

	private JSplitPane getSplitPane_4() {
		if (splitPane_4 == null) {
			splitPane_4 = new JSplitPane();
			splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_4.setLeftComponent(getScrollPane_3());
			splitPane_4.setRightComponent(getPanel_1());
			splitPane_4.setDividerLocation(350);
		}
		return splitPane_4;
	}

	private JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setViewportView(getTable_1_1());
		}
		return scrollPane_3;
	}

	private JTable getTable_1_1() {
		if (tbCuSignUpView == null) {
			tbCuSignUpView = new JTable();
			arr = dba.CustomerView();
			String[] cols = { "Id", "Name", "Phone" };
			DefaultTableModel dt = new DefaultTableModel(cols, arr.size());
			for (int i = 0; i < arr.size(); i++) {

				dt.setValueAt(arr.get(i).getId(), i, 0);
				dt.setValueAt(arr.get(i).getName(), i, 1);
				String phone = arr.get(i).getPhone();
				dt.setValueAt(phone.substring(0, 3) + "-" + phone.substring(3, 7) + "-" + phone.substring(7, 11), i, 2);
			}
			tbCuSignUpView.setModel(dt);
			tbCuSignUpView.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// btnUpdate.setEnabled(true);
					// btnDelete.setEnabled(true);
					int i = tbCuSignUpView.getSelectedRow();
					tfCuId.setText(arr.get(i).getId());
					tfCuPwd.setText("*");
					tfCuName.setText(arr.get(i).getName());
					tfCuBirth.setText(arr.get(i).getBirth().replaceAll(" 00:00:00", ""));
					if (arr.get(i).getGender().equals("남")) {
						rdCuMen.setSelected(true);
					}
					if (arr.get(i).getGender().equals("여")) {
						rdCuWomen.setSelected(true);
					}
					tfCuAddr.setText(arr.get(i).getAddr());
					String phone = arr.get(i).getPhone();
					tfCuPhone.setText(
							phone.substring(0, 3) + "-" + phone.substring(3, 7) + "-" + phone.substring(7, 11));
					String id = arr.get(i).getId();
					tfCuId.setEnabled(false);
					btnCuUpdate.setEnabled(true);
					btnCuDelete.setEnabled(true);
				}
			});
		}
		return tbCuSignUpView;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getCbCu());
			panel_1.add(getTfCuSearch());
			panel_1.add(getBtnSearch());
			panel_1.add(getBtnNewButton_2());
		}
		return panel_1;
	}

	private JComboBox getCbCu() {
		if (cbCu == null) {
			cbCu = new JComboBox();
			cbCu.setModel(new DefaultComboBoxModel(new String[] { "\uC120\uD0DD", "id", "name" }));
			cbCu.setBounds(22, 24, 66, 21);
		}
		return cbCu;
	}

	private JTextField getTfCuSearch() {
		if (tfCuSearch == null) {
			tfCuSearch = new JTextField();
			tfCuSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnSearch.doClick();
				}
			});
			tfCuSearch.setBounds(22, 55, 155, 21);
			tfCuSearch.setColumns(10);
		}
		return tfCuSearch;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("\uAC80\uC0C9");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = "";
					if (cbCu.getSelectedIndex() == 1) {
						key = "id";
					} else if (cbCu.getSelectedIndex() == 2) {
						key = "name";
					} else {
						tfCuSearch.setText("선택오류");
						return;
					}
					ArrayList<Customer_s> arr = dba.CustomerSearch(key, tfCuSearch.getText());
					String[] cols = { "CustId", "Id", "Name" };
					DefaultTableModel dt = new DefaultTableModel(cols, arr.size());
					for (int i = 0; i < arr.size(); i++) {
						dt.setValueAt(arr.get(i).getCustid(), i, 0);
						dt.setValueAt(arr.get(i).getId(), i, 1);
						dt.setValueAt(arr.get(i).getName(), i, 2);
					}
					tbCuSignUpView.setModel(dt);
					tfCuSearch.setText("");
				}
			});
			btnSearch.setBounds(189, 54, 66, 23);
		}
		return btnSearch;
	}

	private JRadioButton getRdCuMen() {
		if (rdCuMen == null) {
			rdCuMen = new JRadioButton("\uB0A8");
			rdCuMen.setBounds(148, 233, 61, 23);
			btngr.add(getRdCuMen());
		}
		return rdCuMen;
	}

	private JRadioButton getRdCuWomen() {
		if (rdCuWomen == null) {
			rdCuWomen = new JRadioButton("\uC5EC");
			rdCuWomen.setBounds(228, 233, 61, 23);
			btngr.add(getRdCuWomen());
		}
		return rdCuWomen;
	}

	public void CustTableView() {
		arr = dba.CustomerView();
		String[] cols = { "Id", "Name", "phone" };
		DefaultTableModel dt = new DefaultTableModel(cols, arr.size());
		for (int i = 0; i < arr.size(); i++) {
			dt.setValueAt(arr.get(i).getId(), i, 0);
			dt.setValueAt(arr.get(i).getName(), i, 1);
			dt.setValueAt(arr.get(i).getPhone(), i, 2);
		}
		tbCuSignUpView.setModel(dt);
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC804\uCCB4\uBCF4\uAE30");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CustTableView();
				}
			});
			btnNewButton_2.setBounds(158, 23, 97, 23);
		}
		return btnNewButton_2;
	}

	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getCustTa());
		}
		return scrollPane_1;
	}

	private JTextArea getCustTa() {
		if (CustTa == null) {
			CustTa = new JTextArea();
			int Total = 0;
			CustTa.append("매장 고객정보 분석...\n");
			// CustTa.append("현재 매장 총 고객수는 :"+arr.get(i).getGender());

			ArrayList<Customer_s> arr_g = dba.CustomerGenderAnalysis();
			for (int i = 0; i < arr_g.size(); i++) {
				Total += arr_g.get(i).getCount();
				CustTa.append(arr_g.get(i).getGender() + " : " + arr_g.get(i).getCount() + "명, 비율 : "
						+ Math.round(arr_g.get(i).getRatio() * 100) + "% \n");
			}
			ArrayList<Customer_s> arr_ag = dba.CustomerAgeAnalysis();
			for (int i = 0; i < arr_ag.size(); i++) {
				CustTa.append(arr_ag.get(i).getAge() + "0대 연령층 : " + arr_ag.get(i).getCount() + "명, 비율 : "
						+ Math.round(arr_ag.get(i).getRatio() * 100) + "% \n");
			}
			ArrayList<Customer_s> arr_ad = dba.CustomerAddrAnalysis();
			for (int i = 0; i < arr_ad.size(); i++) {
				CustTa.append(arr_ad.get(i).getAddr() + "의 거주자 : " + arr_ad.get(i).getCount() + "명, 비율 : "
						+ Math.round(arr_ad.get(i).getRatio() * 100) + "% \n");
			}
			CustTa.append("현재 매장 총 고객수는 :" + Total + "명 입니다.");
		}
		return CustTa;
	}

	private JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getBtnNewButton());
			panel.add(getLblNewLabel());
			panel.add(getBtnNewButton_3());
			panel.add(getBtnNewButton_4());
			panel.add(getBtnAddr());
		}
		return panel;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Menu");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Menu mn = new Menu(id);
					mn.setVisible(true);
					setVisible(false);
				}
			});
			btnNewButton.setBounds(248, 10, 65, 23);
		}
		return btnNewButton;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Chart", SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 15));
			lblNewLabel.setBounds(0, 43, 325, 23);
		}
		return lblNewLabel;
	}

	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("Gender");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PieChart_Gender pc = new PieChart_Gender("Gender");
					pc.setSize(560, 367);
					RefineryUtilities.centerFrameOnScreen(pc);// 화면가운데표시
					pc.setVisible(true);
				}
			});
			btnNewButton_3.setBounds(117, 76, 97, 23);
		}
		return btnNewButton_3;
	}

	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("Age");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PieChart_Age pc = new PieChart_Age("Age", id);
					pc.setSize(560, 367);
					RefineryUtilities.centerFrameOnScreen(pc);// 화면가운데표시
					pc.setVisible(true);
				}
			});
			btnNewButton_4.setBounds(117, 109, 97, 23);
		}
		return btnNewButton_4;
	}

	private JButton getBtnAddr() {
		if (btnAddr == null) {
			btnAddr = new JButton("Addr");
			btnAddr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PieChart_Addr pc = new PieChart_Addr("Addr", id);
					pc.setSize(560, 367);
					RefineryUtilities.centerFrameOnScreen(pc);// 화면가운데표시
					pc.setVisible(true);
				}
			});
			btnAddr.setBounds(117, 142, 97, 23);
		}
		return btnAddr;
	}

	private JLabel getLacheck() {
		if (lacheck == null) {
			lacheck = new JLabel("");
			lacheck.setBounds(292, 82, 69, 15);
		}
		return lacheck;
	}
}
