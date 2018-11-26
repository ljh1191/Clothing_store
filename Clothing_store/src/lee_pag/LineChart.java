package lee_pag;

import org.jfree.chart.ChartPanel;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends JPanel {
	SalesManagementDBA dba = new SalesManagementDBA();

	public LineChart() {
		// super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart("Month Sales", "Month", "Product_Sales_Ea", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		add(chartPanel);
		setVisible(true);
	}

	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<Sales> arr = dba.SalesViewMonth_g();
		for (int i = 0; i < arr.size(); i++) {
			dataset.addValue(arr.get(i).getSales_ea(), "sales", arr.get(i).getMonth());
		}
		return dataset;
	}
}
