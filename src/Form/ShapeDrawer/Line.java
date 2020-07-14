/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form.ShapeDrawer;



/**
 *
 * @author hailiang194
 */
public class Line implements Form.IShapeDrawer<java.awt.geom.Line2D.Double>{

	@Override
	public java.awt.geom.Line2D.Double draw(int startX, int startY, int endX, int endY) {
		return new java.awt.geom.Line2D.Double(startX, startY, endX, endY);
	}
	
}
