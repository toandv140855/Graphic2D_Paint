/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form.ShapeDrawer;


/**
 * Draw dot by brush
 * @author hailiang194
 */
public class Brush implements Form.IShapeDrawer<java.awt.geom.Ellipse2D.Double>{

	private int stokeWidth;
	private int stokeHeight;

	public Brush(int stokeWidth, int stokeHeight) {
		this.stokeWidth = stokeWidth;
		this.stokeHeight = stokeHeight;
	}

	public int getStokeWidth() {
		return stokeWidth;
	}

	public void setStokeWidth(int stokeWidth) {
		this.stokeWidth = stokeWidth;
	}

	public int getStokeHeight() {
		return stokeHeight;
	}

	public void setStokeHeight(int stokeHeight) {
		this.stokeHeight = stokeHeight;
	}
	
	
	
	@Override
	public java.awt.geom.Ellipse2D.Double draw(int startX, int startY, int endX, int endY) {
		//because now startX == endX, startY == endY
		return new java.awt.geom.Ellipse2D.Double(startX, startY, this.stokeWidth, this.stokeHeight);
	}
	
}
