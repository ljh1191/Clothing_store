package lee_pag;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.ui.RefineryUtilities;

public class Product extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JTable tbProduct;
	private JSplitPane splitPane_1;
	private JPanel panel;
	private JComboBox cbPd;
	private JTextField tfPd;
	private JButton btnNewButton;
	private JScrollPane scrollPane_1;
	private JTextArea pdTa;
	private int Wearing = 0;
	private int Sales = 0;
	static String id;
	/**
	 * Launch the application.
	 */

	ProductDBA dba = new ProductDBA();
	private JButton btnNewButton_1;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JButton btnNewButton_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product(id);
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
	public Product(String id) {
		setTitle("\uC0C1\uD488\uD604\uD669");
		setResizable(false);
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("\uC0C1\uD488\uD604\uD669", null, getSplitPane(), null);
		}
		return tabbedPane;
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setLeftComponent(getScrollPane());
			splitPane.setRightComponent(getSplitPane_1_1());
			splitPane.setDividerLocation(310);
		}
		return splitPane;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}

	private JTable getTable_1() {

		if (tbProduct == null) {
			tbProduct = new JTable();
			String[] cols = { "복종", "품번", "입고일", "판매일", "판매가격", "입고량", "판매량", "재고량" };
			ArrayList<Sales> arr = dba.ProductView();
			DefaultTableModel dt = new DefaultTableModel(cols, arr.size());
			SalesManagement sm = new SalesManagement(id);
			for (int i = 0; i < arr.size(); i++) {
				dt.setValueAt(arr.get(i).getKind(), i, 0);
				dt.setValueAt(arr.get(i).getPartnum(), i, 1);
				dt.setValueAt(arr.get(i).getW_day().replaceAll(" 00:00:00", ""), i, 2);
				dt.setValueAt(arr.get(i).getS_day().replaceAll(" 00:00:00", ""), i, 3);
				dt.setValueAt(sm.Comma(String.valueOf(arr.get(i).getSalesprice())), i, 4);
				dt.setValueAt(sm.Comma(String.valueOf(arr.get(i).getWearing_ea())), i, 5);
				dt.setValueAt(sm.Comma(String.valueOf(arr.get(i).getSales_ea())), i, 6);
				dt.setValueAt(sm.Comma(String.valueOf(arr.get(i).getStock_ea())), i, 7);
				Wearing += arr.get(i).getWearing_ea();
				Sales += arr.get(i).getSales_ea();
			}
			tbProduct.setModel(dt);
		}
		return tbProduct;
	}

	private JSplitPane getSplitPane_1_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setLeftComponent(getPanel_1_1());
			splitPane_1.setDividerLocation(300);
		}
		return splitPane_1;
	}

	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getCbPd());
			panel.add(getTfPd());
			panel.add(getBtnNewButton());
			panel.add(getScrollPane_1());
		}
		return panel;
	}

	private JComboBox getCbPd() {
		if (cbPd == null) {
			cbPd = new JComboBox();
			cbPd.setModel(new DefaultComboBoxModel(new String[] { "\uC120\uD0DD", "\uBCF5\uC885", "\uD488\uBC88" }));
			cbPd.setBounds(12, 11, 74, 21);
		}
		return cbPd;
	}

	private JTextField getTfPd() {
		if (tfPd == null) {
			tfPd = new JTextField();
			tfPd.setBounds(95, 11, 151, 21);
			tfPd.setColumns(10);
		}
		return tfPd;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String key = "";
					if (cbPd.getSelectedIndex() == 1) {
						key = "kind";
					} else if (cbPd.getSelectedIndex() == 2) {
						key = "partnum";
					} else {
						tfPd.setText("선택오류");
						return;
					}
					ArrayList<Sales> arr = dba.ProductSearch(key, tfPd.getText());
					String[] cols = { "복종", "품번", "입고일", "판매일", "판매가격", "입고량", "판매량", "재고량" };
					DefaultTableModel dt = new DefaultTableModel(cols, arr.size());
					SalesManagement sm = new SalesManagement(id);
					for (int i = 0; i < arr.size(); i++) {
						dt.setValueAt(arr.get(i).getKind(), i, 0);
						dt.setValueAt(arr.get(i).getPartnum(), i, 1);
						dt.setValueAt(arr.get(i).getW_day().replaceAll(" 00:00:00", ""), i, 2);
						dt.setValueAt(arr.get(i).getS_day().replaceAll(" 00:00:00", ""), i, 3);
						dt.setValueAt(sm.Comma(String.valueOf(arr.get(i).getSalesprice())), i, 4);
						dt.setValueAt(sm.Comma(String.valueOf(arr.get(i).getWearing_ea())), i, 5);
						dt.setValueAt(sm.Comma(String.valueOf(arr.get(i).getSales_ea())), i, 6);
						dt.setValueAt(sm.Comma(String.valueOf(arr.get(i).getStock_ea())), i, 7);
					}
					tbProduct.setModel(dt);
				}
			});
			btnNewButton.setBounds(258, 10, 85, 23);
		}
		return btnNewButton;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(12, 42, 331, 90);
			scrollPane_1.setViewportView(getPdTa());
		}
		return scrollPane_1;
	}

	private JTextArea getPdTa() {
		if (pdTa == null) {
			pdTa = new JTextArea();
			pdTa.append("상품정보분석...\n");
			pdTa.append("상품의 총 입고량 :" + Wearing + "개 \n");
			pdTa.append("상품의 총 판매량 :" + Sales + "개 \n");
			pdTa.append("상품의 총 재고량 :" + (Wearing - Sales) + "개 \n");

		}
		return pdTa;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Menu");
			btnNewButton_1.setBounds(190, 10, 97, 23);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Menu mn = new Menu(id);
					System.out.println(id);
					mn.setVisible(true);
					setVisible(false);
				}
			});
		}
		return btnNewButton_1;
	}

	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getBtnNewButton_1());
			panel_1.add(getLblNewLabel());
			panel_1.add(getBtnNewButton_2());
		}
		return panel_1;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Char", SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 15));
			lblNewLabel.setBounds(0, 43, 299, 23);
		}
		return lblNewLabel;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("BarChart");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BarChart bc = new BarChart("BarChart", "Analysis");
					bc.setSize(560, 367);
					RefineryUtilities.centerFrameOnScreen(bc);// 화면가운데표시
					bc.setVisible(true);
				}
			});
			btnNewButton_2.setBounds(106, 91, 97, 23);
		}
		return btnNewButton_2;
	}
}
