package lee_pag;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField tfName;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JTextField tfOwner;
	private JLabel label_1;
	private JTextField tfStorenum;
	private JLabel label_2;
	private JTextField tfAddr;
	private JLabel label_3;
	private JTextField tfTell;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private boolean flag;

	/**
	 * Launch the application.
	 */
	SignUpDBA dba = new SignUpDBA();
	private JLabel lblPassword;
	private JTextField tfId;
	private JLabel lblId;
	private JPasswordField tfPwd;
	private JButton btnNewButton_1;
	private JButton btnCheck;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getTfName());
			panel.add(getLblNewLabel_1());
			panel.add(getLabel());
			panel.add(getTfOwner());
			panel.add(getLabel_1());
			panel.add(getTfStorenum());
			panel.add(getLabel_2());
			panel.add(getTfAddr());
			panel.add(getLabel_3());
			panel.add(getTfTell());
			panel.add(getBtnNewButton());
			panel.add(getButton());
			panel.add(getButton_1());
			panel.add(getLblPassword());
			panel.add(getTfId());
			panel.add(getLblId());
			panel.add(getTfPwd());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnCheck());
		}
		return panel;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785", SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 25, 340, 26);
		}
		return lblNewLabel;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(167, 144, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uB9E4\uC7A5\uBA85");
			lblNewLabel_1.setBounds(80, 147, 75, 15);
		}
		return lblNewLabel_1;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uB300\uD45C\uC790");
			label.setBounds(80, 178, 75, 15);
		}
		return label;
	}

	private JTextField getTfOwner() {
		if (tfOwner == null) {
			tfOwner = new JTextField();
			tfOwner.setColumns(10);
			tfOwner.setBounds(167, 175, 116, 21);
		}
		return tfOwner;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC0AC\uC5C5\uC790\uBC88\uD638");
			label_1.setBounds(80, 209, 75, 15);
		}
		return label_1;
	}

	private JTextField getTfStorenum() {
		if (tfStorenum == null) {
			tfStorenum = new JTextField();
			tfStorenum.setColumns(10);
			tfStorenum.setBounds(167, 206, 116, 21);
		}
		return tfStorenum;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC8FC\uC18C");
			label_2.setBounds(80, 240, 75, 15);
		}
		return label_2;
	}

	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setColumns(10);
			tfAddr.setBounds(167, 237, 116, 21);
		}
		return tfAddr;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_3.setBounds(80, 271, 75, 15);
		}
		return label_3;
	}

	private JTextField getTfTell() {
		if (tfTell == null) {
			tfTell = new JTextField();
			tfTell.setColumns(10);
			tfTell.setBounds(167, 268, 116, 21);
		}
		return tfTell;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCD08\uAE30\uD654");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfId.setText("");
					tfPwd.setText("");
					tfName.setText("");
					tfOwner.setText("");
					tfStorenum.setText("");
					tfAddr.setText("");
					tfTell.setText("");
				}
			});
			btnNewButton.setBounds(133, 320, 97, 23);
		}
		return btnNewButton;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uAC00\uC785");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						if (flag == false) {
							Store s = new Store();
							s.setName(tfName.getText());
							s.setOwner(tfOwner.getText());
							s.setStorenum(tfStorenum.getText());
	
							s.setAddr(tfAddr.getText());
							s.setTell(tfTell.getText());
							s.setId(tfId.getText());
							s.setPwd(tfPwd.getPassword());
							dba.SignUp(s);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "다른아이디를 사용해주세요.");
						}
					}
			});
			button.setBounds(24, 320, 97, 23);
		}
		return button;
	}

	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uCDE8\uC18C");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button_1.setBounds(242, 320, 97, 23);
		}
		return button_1;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("PASSWORD");
			lblPassword.setBounds(80, 116, 75, 15);
		}
		return lblPassword;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(167, 85, 116, 21);
		}
		return tfId;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setBounds(80, 88, 75, 15);
		}
		return lblId;
	}

	private JPasswordField getTfPwd() {
		if (tfPwd == null) {
			tfPwd = new JPasswordField();
			tfPwd.setBounds(167, 113, 116, 21);
		}
		return tfPwd;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("LogIn");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LogIn li = new LogIn();
					setVisible(false);
					li.setVisible(true);
				}
			});
			btnNewButton_1.setBounds(12, 10, 75, 23);
		}
		return btnNewButton_1;
	}

	private JButton getBtnCheck() {
		if (btnCheck == null) {
			btnCheck = new JButton("\uC911\uBCF5\uD655\uC778");
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					flag = dba.check(tfId.getText());
					if (flag == true) {
						JOptionPane.showMessageDialog(null, "다른 아이디를 사용해주세요.");
					} else if (tfId.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
					} else {
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
					}
				}
			});
			btnCheck.setBounds(290, 84, 91, 23);
		}
		return btnCheck;
	}
}
