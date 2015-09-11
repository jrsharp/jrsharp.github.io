// VisualGeo.java
// Jonathan Sharp
// Lab 9
// 11-10-00

import java.applet.Applet;
import java.awt.*;
import Geometry.*; 
import java.awt.event.*;
import java.text.DecimalFormat;

public class VisualGeo extends Applet implements MouseListener {
   private final int APPLET_WIDTH = 400;
   private final int APPLET_HEIGHT = 400;
   private DecimalFormat fmt = new DecimalFormat ("0.##");
   private Geometry.Point point1 = null;
   private Geometry.Point point2 = null;
   private Geometry.Point point3 = null;
   private Geometry.Point point4 = null;
   private Geometry.Point point5 = null;
   private Geometry.Line line1 = null;
   private Geometry.Line line2 = null;
   private int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5; 
   private int i = 0;

   public void init() {
      setBackground (Color.white);
      setSize (APPLET_WIDTH, APPLET_HEIGHT);
      addMouseListener(this);
   }

   public void paint(Graphics page) {
      if (point1 != null) {
         x1 = (int) Math.round(point1.getX());
         y1 = (int) Math.round(point1.getY());
         page.setColor(Color.blue);
	 page.drawRect((x1-1),(y1-1),3,3);
         if (point2 != null) {
            x2 = (int) Math.round(point2.getX());
            y2 = (int) Math.round(point2.getY());
	    page.drawRect((x2-1),(y2-1),3,3);
            mydrawLine1(line1);
	    page.drawLine(x1,y1,x2,y2);
	    page.drawString(line1.toString(),10,370);
            if (point3 != null) {
               x3 = (int) Math.round(point3.getX());
               y3 = (int) Math.round(point3.getY());
	       page.setColor(Color.green);
	       page.drawRect((x3-1),(y3-1),3,3);
               if (point4 != null) {
                  x4 = (int) Math.round(point4.getX());
                  y4 = (int) Math.round(point4.getY());
                  page.drawRect((x4-1),(y4-1),3,3);
                  mydrawLine2(line2);
	          page.drawLine(x3,y3,x4,y4);
	          page.drawString(line2.toString(),10,390);
	          point5 = line1.intersect(line2);
		  x5 = (int) point5.getX();
		  y5 = (int) point5.getY();
		  page.setColor(Color.red);
		  page.drawRect((x5-1),(y5-1),3,3);
		  page.drawString(point5.toString(),x5,(y5+15));
               }
            }
         }
      }
   }
   public void mouseClicked(MouseEvent event) {}
   public void mousePressed(MouseEvent event) {}
   public void mouseEntered(MouseEvent event) {}
   public void mouseExited(MouseEvent event) {}
   public void mouseReleased(MouseEvent event) {
      switch (i) {
         case 0:
	    point1 = new Geometry.Point(event.getX(),event.getY());
	    point2 = null;
	    point3 = null;
	    point4 = null;
	    break;
	 case 1:
	    point2 = new Geometry.Point(event.getX(),event.getY());
	    line1 = new Geometry.Line(point1,point2);
	    break;
	 case 2:
	    point3 = new Geometry.Point(event.getX(),event.getY());
	    break;
	 case 3:
	    point4 = new Geometry.Point(event.getX(),event.getY());
	    line2 = new Geometry.Line(point3,point4);
	    i = -1;
	    break;
      }
      i++;
      repaint();
   }
   public void mydrawLine1(Line line) {
      double m = line.getm();
      double b = line.getb();
      int bb = (int) line.getb();
      int mm = (int) line.getm();
      if ( m == Double.POSITIVE_INFINITY ) {
         x1 = (int) line.getx();
	 y1 = 0;
	 x2 = x1;
	 y2 = APPLET_HEIGHT;
      } else if ( m < -1 || m > 1 ) {
         y1 = 0;
	 x1 = (int) ((y1 - b) / m);
	 y2 = APPLET_HEIGHT;
	 x2 = (int) ((y2 - b) / m);
      } else {
         x1 = 0;
	 y1 = (int) b;
	 x2 = APPLET_WIDTH;
	 y2 = (int) (m*x2 + b);
      }
   }
   public void mydrawLine2(Line line) {
      double m = line.getm();
      double b = line.getb();
      int bb = (int) line.getb();
      int mm = (int) line.getm();
      if ( m == Double.POSITIVE_INFINITY ) {
         x3 = (int) line.getx();
	 y3 = 0;
	 x4 = x3;
	 y4 = APPLET_HEIGHT;
      } else if ( m < -1 || m > 1 ) {
         y3 = 0;
	 x3 = (int) ((y3 - b) / m);
	 y4 = APPLET_HEIGHT;
	 x4 = (int) ((y4 - b) / m);
      } else {
         x3 = 0;
	 y3 = (int) b;
	 x4 = APPLET_WIDTH;
	 y4 = (int) (m*x4 + b);
      }
   }

}

