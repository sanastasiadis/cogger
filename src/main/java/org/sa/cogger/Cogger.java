/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sa.cogger;

import java.awt.Polygon;

/**
 *
 * @author stavros
 */
public class Cogger {
    
    /**
     * 
     * @param x
     * @param y
     * @param r
     * @param cogs
     * @param cogHeight
     * @return 
     */
    public static Polygon pointy(double x, double y, double r, int cogs, int cogHeight) {
        Polygon p = new Polygon();
        
        double plat = 2*Math.PI/(double)cogs;
        
        double x1 = x + r*Math.cos(0);
        double y1 = y - r*Math.sin(0);
        p.addPoint((int)x1, (int)y1);
        
        for (double theta = 0; theta <= 2*Math.PI; theta+=plat) {
            double x2 = x + r*Math.cos(theta);
            double y2 = y - r*Math.sin(theta);
            p.addPoint((int)x2, (int)y2);
            
            x2 = x + (r-cogHeight)*Math.cos(theta + plat/2);
            y2 = y - (r-cogHeight)*Math.sin(theta + plat/2);
            p.addPoint((int)x2, (int)y2);
        }
        
        return p;
    }
    
    /**
     * 2 * r * sin(f2/2) = 2 * (r-toothHeight) * sin(f4/2)
     * 2 * r * sin(f2/2) = 2*sin(f4/2)*r - 2*sin(f4/2)*toothHeight
     * 2 * sin(f4/2) * r - 2 * r * sin(f2/2) = 2 * sin(f4/2) * toothHeight
     * r * (2*sin(f4/2) - 2*sin(f2/2)) = 2 * sin(f4/2) * toothHeight
     * r = (2 * sin(f4/2) * toothHeight) / (2*sin(f4/2) - 2*sin(f2/2))
     * @param x
     * @param y
     * @param cogs
     * @param cogHeight
     * @param inclination
     * @return 
     */
    public static Polygon trapezoid(double x, double y, int cogs, double cogHeight, double inclination) {
        double plat = 2*Math.PI/(double)cogs;
        
        double f1 = plat * inclination;
        double f2 = plat/2 - 2*f1;
        double f3 = f1;
        double f4 = plat/2;
        
        double r = (2 * Math.sin(f4/2) * cogHeight) / (2*Math.sin(f4/2) - 2*Math.sin(f2/2));
        //r = r * cogs/20;
        
        return trapezoid(x, y, r, cogHeight, f1, f2, f3, f4);
    }
    
    /**
    * 2 * r * sin(f2/2) = 2 * (r-toothHeight) * sin(f4/2)
    * 2 * r * sin(f2/2) = 2*sin(f4/2)*r - 2*sin(f4/2)*toothHeight
    * 2 * sin(f4/2) * r - 2 * r * sin(f2/2) = 2 * sin(f4/2) * toothHeight
    * toothHeight = (2 * sin(f4/2) * r - 2 * r * sin(f2/2)) / 2 * sin(f4/2)
    */
    public static Polygon trapezoid(double x, double y, double r, int cogs, double inclination) {
        double plat = 2*Math.PI/(double)cogs;
        
        double f1 = plat * inclination;
        double f2 = plat/2 - 2*f1;
        double f3 = f1;
        double f4 = plat/2;
        
        double cogHeight = (2 * Math.sin(f4/2) * r - 2 * r * Math.sin(f2/2)) / (2 * Math.sin(f4/2));
        
        return trapezoid(x, y, r, cogHeight, f1, f2, f3, f4);
    }
    
    private static Polygon trapezoid(double x, double y, double r, double cogHeight, double f1, double f2, double f3, double f4) {
        Polygon p = new Polygon();
        
        double plat = f1+f2+f3+f4;
        
        for (double theta = 0; theta < 2*Math.PI; theta+=plat) {
            double x2 = x + (r-cogHeight)*Math.cos(theta);
            double y2 = y - (r-cogHeight)*Math.sin(theta);
            p.addPoint((int)x2, (int)y2);
            
            x2 = x + r*Math.cos(theta + f1);
            y2 = y - r*Math.sin(theta + f1);
            p.addPoint((int)x2, (int)y2);
            
            x2 = x + r*Math.cos(theta + f1 + f2);
            y2 = y - r*Math.sin(theta + f1 + f2);
            p.addPoint((int)x2, (int)y2);
            
            x2 = x + (r-cogHeight)*Math.cos(theta + f1 + f2 + f3);
            y2 = y - (r-cogHeight)*Math.sin(theta + f1 + f2 + f3);
            p.addPoint((int)x2, (int)y2);
        }
        
        return p;
    }
}
