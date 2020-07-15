/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

/**
 * Get shape interface
 * @author hailiang194
 * @param <Shape> shape
 */
public interface IShapeDrawer<Shape> {
	/**
	 * get drawn shape
	 * @param startX x position of start point
	 * @param startY y position of start point
	 * @param endX x position of end point
	 * @param endY y position of end point
	 * @return shape
	 */
	public Shape draw(int startX, int startY, int endX, int endY);
}
