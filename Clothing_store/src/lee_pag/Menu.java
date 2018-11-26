package lee_pag;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton btnNewButton_1;
	private String id;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_2;
	private JButton btnLogout;

	/**
	 * Create the frame.
	 */
	public Menu(String id) {
		setResizable(false);
		setTitle("\uBA54\uB274");
		this.id = id;
//		SalesManagement sm = new SalesManagement(id);
//		Product pd = new Product(id);
//		Customer ct = new Customer(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 244);
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
			panel.add(getBtnNewButton());
			panel.add(getButton());
			panel.add(getButton_1());
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getBtnNewButton_2());
			panel.add(getBtnLogout());
		}
		return panel;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uB9E4\uCD9C\uD604\uD669");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SalesManagement sm = new SalesManagement(id);
					sm.setVisible(true);
					setVisible(false);
				}
			});
			btnNewButton.setBounds(33, 114, 96, 57);
		}
		return btnNewButton;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("\uACE0\uAC1D\uD604\uD669");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Customer ct = new Customer(id);
					ct.setVisible(true);
					setVisible(false);
				}
			});
			button.setBounds(141, 114, 96, 57);
		}
		return button;
	}

	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("\uC0C1\uD488\uD604\uD669");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Product pd = new Product(id);
					pd.setVisible(true);
					setVisible(false);
				}
			});
			button_1.setBounds(249, 114, 96, 57);
		}
		return button_1;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(id);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 15));
			lblNewLabel.setBounds(33, 19, 96, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
			lblNewLabel_1.setBounds(141, 21, 234, 15);
		}
		return lblNewLabel_1;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignUpdate su = new SignUpdate(id);
					su.setVisible(true);
					setVisible(false);
				}
			});
			btnNewButton_2.setBounds(233, 46, 112, 23);
		}
		return btnNewButton_2;
	}

	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("LogOut");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LogIn li = new LogIn();
					setVisible(false);
					li.setVisible(true);
				}
			});
			btnLogout.setBounds(248, 79, 97, 23);
		}
		return btnLogout;
	}
}
