/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form.ShapeDrawer;

/**
 * Draw rectangle
 * @author hailiang194
 */
public class Rectangle implements Form.IShapeDrawer<java.awt.geom.Rectangle2D.Double> {

	@Override
	public java.awt.geom.Rectangle2D.Double draw(int startX, int startY, int endX, int endY) {
		java.awt.geom.Point2D point = new java.awt.geom.Point2D.Double(Math.min(startX, endX), Math.min(startY, endY));
		
		int width = Math.abs(startX - endX);
		int height = Math.abs(startY - endY);

		return new java.awt.geom.Rectangle2D.Double(point.getX(), point.getY(), width, height);
	}

}
