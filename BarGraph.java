
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author Nate
 */
public class BarGraph {

    protected BarGraphModel model;
    
    protected static final Font BAR_TITLE_FONT = new Font("Calibri", Font.PLAIN, 11);
    
    public BarGraph() {
        this.model = new BarGraphModel();
        
        //TODO: Remove this code below. Only test code
        model.setLocation(200, 75);
        model.setSize(525, 400);
        
        BarGraphModel.BarItem item = new BarGraphModel.BarItem("January");
        item.percentage = 60;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("February");
        item.percentage = 50;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("March");
        item.percentage = 65;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("April");
        item.percentage = 70;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("June");
        item.percentage = 70;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("July");
        item.percentage = 70;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("August");
        item.percentage = 70;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("September");
        item.percentage = 70;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("October");
        item.percentage = 70;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("November");
        item.percentage = 70;
        model.addItem(item);
        
        item = new BarGraphModel.BarItem("December");
        item.percentage = 70;
        model.addItem(item);
        
     
    }
    
    public BarGraphModel getModel() {
        return model;
    }

    public void setModel(BarGraphModel model) {
        this.model = model;
    }
    
    public void draw(Graphics g){
        drawItems(g);
        drawBoarder(g);
        
        
    }
    
    private void drawItems(Graphics g){
        int i = 0;
        g.setFont(BAR_TITLE_FONT);
        FontMetrics fm = g.getFontMetrics(BAR_TITLE_FONT);
        
        for (BarGraphModel.BarItem item : model.items){
            
            int percentHeight = ((int)((double)item.percentage/100 * model.getSize().height));
            
            int x = model.getX() + i * model.getHorizontalGap();
            int y = model.getY() + model.getSize().height - percentHeight;
            int w = item.width;
            int h = percentHeight;
            g.setColor(item.background==null ? new Color(255, 0, 0) : item.background);
            g.fillRect(x, y, w, h);
          
            i++;
            //Draw the title
            int sw = fm.stringWidth(item.title);
            if (sw < item.width){
                x = x + ((item.width - sw)/2);
            } else {
                x = x - ((sw - item.width)/2);
            }
            
            y = model.getY() + model.getSize().height + BAR_TITLE_FONT.getSize();
            g.drawString(item.title, x, y);
        }
    }
    
    private void drawBoarder(Graphics g){
        g.setColor(Color.black);
        g.drawRoundRect(model.getX(), model.getY(), model.getSize().width, model.getSize().height, 5, 5);
        
    }
    
}
