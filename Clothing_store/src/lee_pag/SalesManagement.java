package lee_pag;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesManagement extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable smTableView;
	private JScrollPane scrollPane_1;
	private static String id;

	/**
	 * Launch the application.
	 */

	SalesManagementDBA dba = new SalesManagementDBA();
	ArrayList<Sales> arr = null;
	private JLabel tlTotalSales;
	private JLabel tlTotalCost;
	private JLabel tlTotalMargin;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JButton Day;
	private JButton Week;
	private JButton Month;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesManagement frame = new SalesManagement(id);
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
	public SalesManagement(String id) {
		setResizable(false);
		setTitle("\uB9E4\uCD9C\uD604\uD669");
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getSplitPane());
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setLeftComponent(getSplitPane_1());
			splitPane.setRightComponent(getScrollPane_1());
			splitPane.setDividerLocation(300);
		}
		return splitPane;
	}

	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setLeftComponent(getPanel());
			splitPane_1.setRightComponent(getScrollPane());
			splitPane_1.setDividerLocation(350);
		}
		return splitPane_1;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLblNewLabel());
			panel.add(getTlTotalSales());
			panel.add(getTlTotalCost());
			panel.add(getTlTotalMargin());
			panel.add(getLabel_3());
			panel.add(getLabel_4());
			panel.add(getLabel_5());
			panel.add(getDay());
			panel.add(getWeek());
			panel.add(getMonth());
			panel.add(getBtnNewButton());
		}
		return panel;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uB9E4\uCD9C\uC561");
			label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
			label.setBounds(73, 97, 57, 15);
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC6D0\uAC00");
			label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
			label_1.setBounds(73, 137, 57, 15);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uD310\uB9E4\uC774\uC775");
			label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
			label_2.setBounds(73, 177, 57, 15);
		}
		return label_2;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uB9E4\uCD9C\uD604\uD669", SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 20, 325, 35);
		}
		return lblNewLabel;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uBCF5\uC885\uBCC4 \uC18C\uACC4",
					TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scrollPane.setViewportView(getSmTableView());
		}
		return scrollPane;
	}

	private JTable getSmTableView() {
		if (smTableView == null) {
			smTableView = new JTable();
//			ArrayList<Sales> arr = dba.SalesViewDay();
			String[] cols = { "º¹Á¾", "¿ø°¡", "ÆÇ¸Å°¡°Ý", "¸ÅÃâ" };
			DefaultTableModel dt = new DefaultTableModel(cols, 0);
//			int sum = 0;
//			int cost = 0;
//			for (int i = 0; i < arr.size(); i++) {
//				dt.setValueAt(arr.get(i).getKind(), i, 0);
//				dt.setValueAt(Comma(String.valueOf(arr.get(i).getCost())), i, 1);
//				dt.setValueAt(Comma(String.valueOf(arr.get(i).getSalesprice())), i, 2);
//				dt.setValueAt(Comma(String.valueOf(arr.get(i).getSales_m())), i, 3);
//				sum += arr.get(i).getSales_m();
//				cost += arr.get(i).getCost();
//			}
//			tlTotalSales.setText(Comma(String.valueOf(sum)));
//			tlTotalCost.setText(Comma(String.valueOf(cost)));
//			tlTotalMargin.setText(Comma(String.valueOf(sum - cost)));
			smTableView.setModel(dt);
		}
		return smTableView;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			LineChart chart = new LineChart();
			scrollPane_1.setViewportView(chart);
		}
		return scrollPane_1;
	}

	private JLabel getTlTotalSales() {
		if (tlTotalSales == null) {
			tlTotalSales = new JLabel("", SwingConstants.RIGHT);
			tlTotalSales.setBounds(166, 98, 57, 15);
		}
		return tlTotalSales;
	}

	private JLabel getTlTotalCost() {
		if (tlTotalCost == null) {
			tlTotalCost = new JLabel("", SwingConstants.RIGHT);
			tlTotalCost.setBounds(166, 138, 57, 15);
		}
		return tlTotalCost;
	}

	private JLabel getTlTotalMargin() {
		if (tlTotalMargin == null) {
			tlTotalMargin = new JLabel("", SwingConstants.RIGHT);
			tlTotalMargin.setBounds(166, 178, 57, 15);
		}
		return tlTotalMargin;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC6D0");
			label_3.setBounds(250, 98, 57, 15);
		}
		return label_3;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("\uC6D0");
			label_4.setBounds(250, 138, 57, 15);
		}
		return label_4;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("\uC6D0");
			label_5.setBounds(250, 178, 57, 15);
		}
		return label_5;
	}

	private JButton getDay() {
		if (Day == null) {
			Day = new JButton("\uC77C\uAC04");
			Day.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					arr = dba.SalesViewDay();
					SalesView();
				}
			});
			Day.setBounds(25, 244, 97, 23);
		}
		return Day;
	}

	private JButton getWeek() {
		if (Week == null) {
			Week = new JButton("\uC8FC\uAC04");
			Week.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					arr = dba.SalesViewWeek();
					SalesView();
				}
			});
			Week.setBounds(134, 244, 97, 23);
		}
		return Week;
	}

	private JButton getMonth() {
		if (Month == null) {
			Month = new JButton("\uC6D4\uAC04");
			Month.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					arr = dba.SalesViewMonth();
					SalesView();
				}
			});
			Month.setBounds(243, 244, 97, 23);
		}
		return Month;
	}

	public static String Comma(String i) {
		int Values = Integer.parseInt(i);
		DecimalFormat Comma = new DecimalFormat("#,###");
		String Result = Comma.format(Values);
		return Result;
	}

	public void SalesView() {
		String[] cols = { "º¹Á¾", "¿ø°¡", "ÆÇ¸Å°¡°Ý", "¸ÅÃâ" };
		DefaultTableModel dt = new DefaultTableModel(cols, arr.size());
		int sum = 0;
		int cost = 0;
		for (int i = 0; i < arr.size(); i++) {
			dt.setValueAt(arr.get(i).getKind(), i, 0);
			dt.setValueAt(Comma(String.valueOf(arr.get(i).getCost())), i, 1);
			dt.setValueAt(Comma(String.valueOf(arr.get(i).getSalesprice())), i, 2);
			dt.setValueAt(Comma(String.valueOf(arr.get(i).getSales_m())), i, 3);
			sum += arr.get(i).getSales_m();
			cost += arr.get(i).getCost();
		}
		tlTotalSales.setText(Comma(String.valueOf(sum)));
		tlTotalCost.setText(Comma(String.valueOf(cost)));
		tlTotalMargin.setText(Comma(String.valueOf(sum - cost)));
		smTableView.setModel(dt);
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
			btnNewButton.setBounds(12, 10, 65, 23);
		}
		return btnNewButton;
	}
}
