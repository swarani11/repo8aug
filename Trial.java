package trials;
import java.awt.Graphics;
import java.awt.Color;
import java.util.*;

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers
 
/** Custom Drawing Code Template */
// A Swing application extends javax.swing.JFrame

class CGTemplate extends JFrame {
   // Define constants
   public static final int CANVAS_WIDTH  = 1200;
   public static final int CANVAS_HEIGHT = 1200;
 
   // Declare an instance of the drawing canvas,
   // which is an inner class called DrawCanvas extending javax.swing.JPanel.
   private DrawCanvas canvas;
 
   // Constructor to set up the GUI components and event handlers
   public CGTemplate() {
      canvas = new DrawCanvas();    // Construct the drawing canvas
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
 
      // Set the Drawing JPanel as the JFrame's content-pane
      Container cp = getContentPane();
      cp.add(canvas);
      // or "setContentPane(canvas);"
 
      setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
      pack();              // Either pack() the components; or setSize()
      setTitle("......");  // "super" JFrame sets the title
      setLocationRelativeTo(null);
      setVisible(true);    // "super" JFrame show
   }
 
   /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
   private class DrawCanvas extends JPanel {
      // Override paintComponent to perform your own painting
      @Override
      public void paintComponent(Graphics g2) {
    	  
         super.paintComponent(g2);     // paint parent's background
         Graphics2D g = (Graphics2D) g2;
         g.setStroke(new BasicStroke(3));
         
         
         setBackground(Color.WHITE);  // set background color for this JPanel
 
         // Your custom painting codes. For example,
         // Drawing primitive shapes
         g.setColor(Color.BLACK);    // set the drawing color
         g.drawRect(200,200,800,800);
         int [] startPoint = {200,200};
         //drawPattern(g,500,300,500,900);
         drawTree (g, 500,300,500,900,1,3,65);
         
      }
      public void drawPattern(Graphics2D g, int startX, int startY, int endX, int endY) {
    	   
    	  // Draw a vertical line drawLine(startX,startY,endX,endY)
    	  drawRightBranch(g,startX,startY,endX,endY);
    	  
      }
   void drawRectangles(Graphics2D g, int startX, int startY, int endX, int endY) {
	   
   }
   /*
   void drawAPoint(Graphics2D g, Point2D aPoint, int radius, Color color) {
	   
   }
   */
   void drawRightBranch(Graphics2D g, int startX, int startY, int endX, int endY) {
	   
	  int heightOfVerticalLine = endY-startY;
	  
	  System.out.println(heightOfVerticalLine);
	  
	  if (heightOfVerticalLine >= 1) {
		  int radius = 20;
		  g.setColor(Color.RED); 
		  g.fillOval(startX-(radius/2), startY-(radius/2), radius,radius);
		  g.fillOval(endX-(radius/2), endY-(radius/2), radius,radius);
 	  
		  g.setColor(Color.BLACK); 
		  g.drawLine(startX, startY, endX, endY);
 	 
 	 
		  // Draw Branches, starting the first branch at midpoint of the main branch
 	  
		  startY = startY + (heightOfVerticalLine/2);
 	  
		  // length of branch 1/2 of the main branch
		  int lengthOfHyp = (endY-startY)/2;
 	  
		  // Compute length of opposite using sine
 	  
		  double opp = Math.sin(Math.toRadians(35)) * lengthOfHyp;
 	  
		  // Compute length of adjacent side using cos
 	  
		  double adj = Math.cos(Math.toRadians(65)) * lengthOfHyp;
 	  
		  // endx is startX + opp
		  endX = startX + (new Double(opp)).intValue(); 	  
 	  
		  // endy is startY - adj for the right branch
		  endY = startY -(new Double(-adj)).intValue();
 	  
		  System.out.print(startX+" "+startY+" ");
		  System.out.println(endX+" "+endY+" ");
		  g.setColor(Color.RED); 
		  g.fillOval(startX-(radius/2), startY-(radius/2), radius,radius);
		  g.fillOval(endX-(radius/2), endY-(radius/2), radius,radius);
 	  
		  g.setColor(Color.BLACK); 
		  g.drawLine(startX, startY, endX, endY);  
		  
	  }	  
   }   
   void drawTree(Graphics2D g, int startX, int startY, int endX, int endY, int direction, int shrinkFactor, int angle) {
	   
	   // Draw the trunk
	   int lineHeight = endY-startY;
		  
	   System.out.println(lineHeight);
	   
	   g.setColor(Color.BLACK); 
	   g.drawLine(startX, startY, endX, endY);
	   
	   // DrawTree with LeftBranch. Compute endX and endY
	   
	   startX = endX;
	   startY = endY;
	   
	   lineHeight = lineHeight / shrinkFactor;
	   
	  // endX = 
	   //endY = 
	   
	   // Compute length of opposite using sine
	 	  
	   double opp = Math.sin(Math.toRadians(angle)) * lineHeight;
	  
	    // Compute length of adjacent side using cos
	  
	   double adj = Math.cos(Math.toRadians(angle)) * lineHeight;
	  
	    // endx is startX + opp
	   endX = startX + (new Double(opp)).intValue(); 	  
	  
		// endy is startY - adj for the right branch
	   endY = startY -(new Double(-adj)).intValue();
	  
	   System.out.print(startX+" "+startY+" ");
	   
	   System.out.println(endX+" "+endY+" ");
	   
	   // DrawTree with RightBranch
	   
	   
   
   }
   
   
   }
}
class Crayon {

	  private Color color;
	  
	  public Crayon(int colorNumber) {
	    switch (colorNumber) {
	    case 0:
	      color = Color.black;
	      break;
	    case 1:
	      color = Color.darkGray;
	      break;
	    case 2:
	      color = Color.red;
	      break;
	    case 3:
	      color = Color.orange;
	      break;
	    case 4:
	      color = Color.pink;
	      break;
	    case 5:
	      color = Color.cyan;
	      break;
	    case 6:
	      color = Color.magenta;
	      break;
	    case 7:
	      color = Color.green;
	      break;
	    case 8:
	      color = Color.blue;
	      break;
	    case 9:
	      color = Color.yellow;
	      break;
	    case 10:
	      color = new Color(20,30,40);
	      break;
	    case 11:
	      color = new Color(30,20,40);
	      break;
	    case 12:
	      color = new Color(100, 70, 200);
	      break;
	    case 13:
	      color = new Color(14, 105, 83);
	      break;
	    case 14:
	      color = new Color(5, 30, 40);
	      break;
	    case 15:
	      color = new Color(30, 27, 105);
	      break;
	    default:
	      throw new Error("Bad color specified " + colorNumber);
	    }
}
	  public Color getColor() {
		    return color;
		  } 
}

public class Trial {

		// The entry main method
		   public static void main(String[] args) {
		      // Run the GUI codes on the Event-Dispatching thread for thread safety
		      SwingUtilities.invokeLater(new Runnable() {
		         @Override
		         public void run() {
		            new CGTemplate(); // Let the constructor do the job
		         }
		      });
		   }

}
