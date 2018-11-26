package lee_pag;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PieChart_Age extends ApplicationFrame {
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JButton btnNewButton;

	public PieChart_Age(String title, String id) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(createDemoPanel());
		setJMenuBar(getMenuBar_1());
	}

	private static PieDataset createDataset() {
		CustomerDBA dba = new CustomerDBA();
		DefaultPieDataset dataset = new DefaultPieDataset();
		ArrayList<Customer_s> arr = dba.CustomerAgeAnalysis();
		for (int i = 0; i < arr.size(); i++) {
			dataset.setValue(
					String.valueOf(arr.get(i).getAge()) + "0 s : " + Math.round((arr.get(i).getRatio() * 100)) + "%",
					new Double(Math.round((arr.get(i).getRatio() * 100))));
		}
		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("AgeAnalysis", // chart title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getBtnNewButton());
		}
		return menuBar;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC885\uB8CC");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return btnNewButton;
	}
}