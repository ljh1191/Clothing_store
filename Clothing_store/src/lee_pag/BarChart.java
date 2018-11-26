package lee_pag;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BarChart extends ApplicationFrame {
	BarChartDBA dba = new BarChartDBA();
	private JMenuBar menuBar;
	private JButton btnNewButton;

	public BarChart(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, "Category", "Score", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		setJMenuBar(getMenuBar_1());

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}

	private CategoryDataset createDataset() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<Sales> arr = dba.BarChartDBA();
		for (int i = 0; i < arr.size(); i++) {
			dataset.addValue(arr.get(i).getWearing_ea(), "wearing", arr.get(i).getKind()); // (입고량,컬럼명,복종)
			dataset.addValue(arr.get(i).getSales_ea(), "sales", arr.get(i).getKind());
			dataset.addValue(arr.get(i).getStock_ea(), "stock", arr.get(i).getKind());
		}
		return dataset;
	}

	public static void main(String[] args) {
		BarChart chart = new BarChart("Car Usage Statistics", "Which car do you like?");
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
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