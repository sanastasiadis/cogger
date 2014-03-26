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
        g.setColor(Color.red);
        
        int r = 200;
        int teeth = 20;
        int toothHeight = 10;
        
        setSize((int)r*2 + 50, (int)r*3 + 50);
        double x = getSize().width /2;
        double y = getSize().height /2;
        
        //Polygon p = pointy(x, y, r, teeth, toothHeight);
        Polygon p = Cogger.trapezoid(x, y, teeth, toothHeight, 0.05);
        
        g.drawPolygon(p);
    }
    
}
