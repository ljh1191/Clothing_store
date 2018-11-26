package lee_pag;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PieChart_Gender extends ApplicationFrame {
	private JMenuBar menuBar;
	private JButton btnNewButton;

	public PieChart_Gender(String title) {
		super(title);
		setContentPane(createDemoPanel());
		setJMenuBar(getMenuBar_1());
	}

	private static PieDataset createDataset() {
		CustomerDBA dba = new CustomerDBA();
		DefaultPieDataset dataset = new DefaultPieDataset();
		ArrayList<Customer_s> arr = dba.CustomerGenderAnalysis();
		for (int i = 0; i < arr.size(); i++) {
			String gender = null;
			if (arr.get(i).getGender().equals("³²")) {
				gender = "men";
			}
			if (arr.get(i).getGender().equals("¿©")) {
				gender = "women";
			}
			dataset.setValue(gender + " : " + Math.round((arr.get(i).getRatio() * 100)) + "%",
					new Double(Math.round((arr.get(i).getRatio() * 100))));
		}
		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("GenderAnalysis", // chart title
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
			menuBar.add(getButton_1());
		}
		return menuBar;
	}

	private JButton getButton_1() {
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