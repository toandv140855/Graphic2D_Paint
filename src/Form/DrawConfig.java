/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Color;

/**
 * Draw configure
 * @author toandvhe140855
 */
public class DrawConfig {

	private static DrawConfig instance = new DrawConfig(Default.COLOR.STOKE, Default.COLOR.FILL, Default.SHAPE);
	
	private java.awt.Color stoke;
	private java.awt.Color fillColor;
	private IShapeDrawer drawShape;

	public static DrawConfig getInstance()
	{
		return instance;
	}
	
	private DrawConfig(Color stoke, Color fillColor, IShapeDrawer drawShape) {
		this.stoke = stoke;
		this.fillColor = fillColor;
		this.drawShape = drawShape;
	}

	public Color getStoke() {
		return stoke;
	}

	public void setStoke(Color stoke) {
		this.stoke = stoke;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public IShapeDrawer getDrawShape() {
		return drawShape;
	}

	public void setDrawShape(IShapeDrawer drawShape) {
		this.drawShape = drawShape;
	}
	
	
}
