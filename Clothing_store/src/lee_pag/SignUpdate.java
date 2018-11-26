package lee_pag;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SignUpdate extends JFrame {
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfowner;
	private JTextField tfStorenum;
	private JTextField tfAddr;
	private JTextField tfTell;
	private static String id;
	/**
	 * 
	 * Launch the application.
	 * 
	 */

	SignUpdateDBA dba = new SignUpdateDBA();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpdate frame = new SignUpdate(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame.
	 * 
	 */

	public SignUpdate(String id) {
		setTitle("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 10, 379, 40);
		panel.add(lblNewLabel);
		tfName = new JTextField();
		tfName.setBounds(177, 126, 156, 21);
		panel.add(tfName);
		tfName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uB9E4\uC7A5\uBA85");
		lblNewLabel_1.setBounds(60, 126, 78, 21);
		panel.add(lblNewLabel_1);

		JLabel label = new JLabel("\uB300\uD45C\uC790");
		label.setBounds(60, 168, 78, 21);
		panel.add(label);
		tfowner = new JTextField();
		tfowner.setColumns(10);
		tfowner.setBounds(177, 168, 156, 21);
		panel.add(tfowner);

		JLabel label_1 = new JLabel("\uC0AC\uC5C5\uC790\uBC88\uD638");
		label_1.setBounds(60, 211, 100, 21);
		panel.add(label_1);
		tfStorenum = new JTextField();
		tfStorenum.setColumns(10);
		tfStorenum.setBounds(177, 211, 156, 21);
		panel.add(tfStorenum);

		JLabel label_2 = new JLabel("\uC8FC\uC18C");
		label_2.setBounds(60, 254, 78, 21);
		panel.add(label_2);
		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		tfAddr.setBounds(177, 254, 156, 21);
		panel.add(tfAddr);

		JLabel label_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_3.setBounds(60, 293, 78, 21);
		panel.add(label_3);
		tfTell = new JTextField();
		tfTell.setColumns(10);
		tfTell.setBounds(177, 293, 156, 21);
		panel.add(tfTell);

		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "수정할까요?", "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Store s = new Store();
					s.setName(tfName.getText());
					s.setOwner(tfowner.getText());
					s.setStorenum(tfStorenum.getText().replaceAll("-", ""));
					s.setAddr(tfAddr.getText());
					s.setTell(tfTell.getText().replaceAll("-", ""));
					dba.SignUpdate(s, id);
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
				}
			}
		});

		btnNewButton.setBounds(51, 348, 78, 29);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC0AD\uC81C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "삭제할까요?", "confirm", JOptionPane.YES_NO_CANCEL_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					dba.SignDelete(id);
					setVisible(false);
					LogIn lg = new LogIn();
					lg.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(161, 348, 78, 29);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uCDE8\uC18C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu mn = new Menu(id);
				mn.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(268, 348, 78, 29);
		panel.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("\uC815\uBCF4\uBCF4\uAE30");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Store> arr = dba.StignView(id);
				for (Store s : arr) {
					tfName.setText(s.getName());
					tfowner.setText(s.getOwner());
					tfStorenum.setText(s.getStorenum().substring(0, 3) + "-" + s.getStorenum().substring(3, 5) + "-"
							+ s.getStorenum().substring(5, 9) + "-" + s.getStorenum().substring(9, 10));
					tfAddr.setText(s.getAddr());
					tfTell.setText(s.getTell().substring(0, 3) + "-" + s.getTell().substring(3, 7) + "-"
							+ s.getTell().substring(7, 11));
				}
			}
		});

		btnNewButton_3.setBounds(239, 78, 94, 21);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Menu");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu mn = new Menu(id);
				mn.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(60, 78, 95, 21);
		panel.add(btnNewButton_4);

	}

}