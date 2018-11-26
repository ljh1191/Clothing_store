package lee_pag;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField tfId;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JLabel lblNewLabel_1;
	private JButton btnlogin;
	private JButton btnreset;
	private JButton btnsignup;
	private JButton btncancle;
	private JPasswordField tfPwd;
	/**
	 * Launch the application.
	 */
	SignUp su = new SignUp();
	LoginDBA dba = new LoginDBA();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("\uB85C\uADF8\uC778");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 234);
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
			panel.add(getTfId());
			panel.add(getLblNewLabel());
			panel.add(getLblPassword());
			panel.add(getLblNewLabel_1());
			panel.add(getBtnlogin());
			panel.add(getBtnreset());
			panel.add(getBtnsignup());
			panel.add(getBtncancle());
			panel.add(getTfPwd());
		}
		return panel;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(140, 69, 169, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(44, 72, 84, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("PASSWORD");
			lblPassword.setBounds(44, 103, 84, 15);
		}
		return lblPassword;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("LogIn");
			lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 15));
			lblNewLabel_1.setBounds(12, 10, 329, 21);
		}
		return lblNewLabel_1;
	}

	private JButton getBtnlogin() {
		if (btnlogin == null) {
			btnlogin = new JButton("\uB85C\uADF8\uC778");
			btnlogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText();
					String pw = String.valueOf(tfPwd.getPassword());
					if (dba.LogIn(id, pw) == 3) {
						Menu mn = new Menu(id);
						mn.setVisible(true);
						setVisible(false);
					} else if (dba.LogIn(id, pw) != 1) {
						JOptionPane.showMessageDialog(null, "아이디가 틀렸습니다.", "아이디 오류", 1);
					} else if (dba.LogIn(id, pw) != 2) {
						JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "비밀번호 오류", 2);
					}
				}
			});
			btnlogin.setBounds(31, 143, 84, 23);
		}
		return btnlogin;
	}

	private JButton getBtnreset() {
		if (btnreset == null) {
			btnreset = new JButton("\uB9AC\uC14B");
			btnreset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfId.setText("");
					tfPwd.setText("");
				}
			});
			btnreset.setBounds(127, 143, 84, 23);
		}
		return btnreset;
	}

	private JButton getBtnsignup() {
		if (btnsignup == null) {
			btnsignup = new JButton("\uD68C\uC6D0\uAC00\uC785");
			btnsignup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					su.setVisible(true);
				}
			});
			btnsignup.setBounds(218, 36, 91, 23);
		}
		return btnsignup;
	}

	private JButton getBtncancle() {
		if (btncancle == null) {
			btncancle = new JButton("\uCDE8\uC18C");
			btncancle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0); // 해당창만 닫기.
				}
			});
			btncancle.setBounds(225, 143, 84, 23);
		}
		return btncancle;
	}

	private JPasswordField getTfPwd() {
		if (tfPwd == null) {
			tfPwd = new JPasswordField();
			tfPwd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnlogin.doClick();
				}
			});
			tfPwd.setBounds(140, 100, 169, 21);
		}
		return tfPwd;
	}
}
