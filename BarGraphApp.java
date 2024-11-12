
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;

/**
 *
 * @author Nate
 */
public class BarGraphApp extends JPanel {

    private BarGraph graph;
    private BarGraphModel model;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblReport;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    
    public BarGraphApp() {
    	
        this.graph = new BarGraph();
        this.model = graph.getModel();
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("TOTAL EXPENSE:");
        lblNewLabel.setBounds(26, 66, 118, 36);
        add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel(" TOTAL INCOME:");
        lblNewLabel_1.setBounds(26, 232, 118, 14);
        add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel(" TOTAL SAVED:");
        lblNewLabel_2.setBounds(26, 408, 128, 14);
        add(lblNewLabel_2);
        
        lblReport = new JLabel("2024 REPORT");
        lblReport.setBounds(154, 11, 109, 58);
        add(lblReport);
        
        lblNewLabel_3 = new JLabel("Income");
        lblNewLabel_3.setBounds(316, 22, 49, 14);
        add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Expense");
        lblNewLabel_4.setBounds(470, 22, 87, 14);
        add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Saved");
        lblNewLabel_5.setBounds(631, 22, 49, 14);
        add(lblNewLabel_5);
    }

    
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        graph.draw(g);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Bar Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 550);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(new BarGraphApp());
        frame.setVisible(true);
    }
}
