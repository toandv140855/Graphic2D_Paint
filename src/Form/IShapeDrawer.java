/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

/**
 *
 * @author hailiang194
 * @param <Shape> shape
 */
public interface IShapeDrawer<Shape> {
	//get shape 
	public Shape draw(int startX, int startY, int endX, int endY);
}
