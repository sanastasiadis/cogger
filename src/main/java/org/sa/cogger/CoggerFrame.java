/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sa.cogger;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * 
 * 
 * @author stavros
 */
public class CoggerFrame extends Frame {
    
    CoggerFrame() {
        super("Cogger");
        setSize(400,300);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        setSize(500, 500);
        double x = 250;
        double y = 250;
        
        g.setColor(Color.red);
        
        //always declare the number of cogs
        int cogs = 15;
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        //declare the size of the cogwheel that you need, and the height of the cog will be computed
        double r = 100;
        Polygon p1 = Cogger.trapezoid(x, y, r, cogs, 0.03);
        g.drawPolygon(p1);
        //g.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        //declare the height of the cog that you need, and the size of the cogwheel will be computed
        double cogHeight = 10;
        Polygon p2 = Cogger.trapezoid(x, y, cogs, cogHeight, 0.03);
        g.drawPolygon(p2);
        //g.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints);
    }
    
}
