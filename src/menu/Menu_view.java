package menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Menu_view extends Frame implements ActionListener,WindowListener{
    
	private MenuBar mb;
	private Menu graph;
	private MenuItem graph1,graph2;
	private Panel cardPanel,card1,card2;
	
	
	public Menu_view() {
		addWindowListener(this);
		setTitle("Menu");
		//メニューの作成
		mb = new MenuBar();
		graph = mb.add(new Menu("Graph"));
		graph1 = graph.add(new MenuItem("Graph1"));
		graph2 = graph.add(new MenuItem("Graph2"));
		setMenuBar(mb);
		//カードパネルの利用
		cardPanel = new Panel();
		cardPanel.setLayout(new CardLayout());
		card1 = new Panel();
		card2 = new Panel();
		//card１にグラフの設定
		DefaultCategoryDataset data1 = new DefaultCategoryDataset();
		data1.addValue(200, "China", "2005");
		data1.addValue(400, "China", "2006");
		data1.addValue(320, "China", "2007");

		JFreeChart chart1 = 
	    ChartFactory.createLineChart("Import Volume",
	                                   "Year",
	                                   "Ton",
	                                   data1,
	                                   PlotOrientation.VERTICAL,
	                                   true,
	                                   false,
	                                   false);

	    ChartPanel cpanel = new ChartPanel(chart1);
	    card1.add(cpanel, BorderLayout.CENTER);
        //card2にグラフの設定
        DefaultCategoryDataset data2 = new DefaultCategoryDataset();
        data2.addValue(300, "USA", "2005");
        data2.addValue(500, "USA", "2006");
        data2.addValue(120, "USA", "2007");


		JFreeChart chart2 = 
	    ChartFactory.createLineChart("Import Volume",
	                                   "Year",
	                                   "Ton",
	                                   data2,
	                                   PlotOrientation.VERTICAL,
	                                   true,
	                                   false,
	                                   false);

	    ChartPanel cpane2 = new ChartPanel(chart2);
	    card2.add(cpane2, BorderLayout.CENTER);
	    //カードを実装
	    cardPanel.add(card1, "Card1");
	    add(cardPanel);
	    cardPanel.add(card2,"Card2");
	    add(cardPanel);
		//Listenerの設定
		graph1.addActionListener(this);
		graph2.addActionListener(this);
		
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CardLayout cardlayout = (CardLayout)(cardPanel.getLayout());
	    if(e.getSource() == graph1) {
	    	setBackground(Color.red);
	    	cardlayout.show(cardPanel, "Card1");
	    }
	    if(e.getSource() == graph2) {
	    	setBackground(Color.blue);
	    	cardlayout.show(cardPanel, "Card2");
	    }
	}
    
	
	
}
