/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Color;
import java.awt.Shape;

/**
 * Drawn shape object
 * @author hailiang194
 */
public class DrawShape {
	private java.awt.Shape shape;
	private java.awt.Color fill;
	private java.awt.Color stoke;

	public DrawShape(Shape shape, Color fill, Color stoke) {
		this.shape = shape;
		this.fill = fill;
		this.stoke = stoke;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

	public Color getStoke() {
		return stoke;
	}

	public void setStoke(Color stoke) {
		this.stoke = stoke;
	}
	
	
}
