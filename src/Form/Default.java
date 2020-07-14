/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;


/**
 *
 * @author hailiang194
 */
public class Default {
	public static final class COLOR
	{
		public static final java.awt.Color STOKE = java.awt.Color.BLACK;
		public static final java.awt.Color FILL = java.awt.Color.BLACK;
		public static final java.awt.Color DRAWING_STOKE = java.awt.Color.LIGHT_GRAY;
		public static final java.awt.Color PAINT_BACKGROUND = java.awt.Color.WHITE;
	}
	
	public static final class BRUSH
	{
		public static final int BRUSH_STOKE_HEIGHT = 5;
		public static final int BRUSH_STOKE_WIDTH = BRUSH_STOKE_HEIGHT;
	}
	
	public static final class ICON
	{
		public static final javax.swing.ImageIcon BRUSH = new javax.swing.ImageIcon("icon\\brush.png");
		public static final javax.swing.ImageIcon LINE = new javax.swing.ImageIcon("icon\\line.png");
		public static final javax.swing.ImageIcon ELLIPSE = new javax.swing.ImageIcon("icon\\ellipse.png");
		public static final javax.swing.ImageIcon RECTANGLE = new javax.swing.ImageIcon("icon\\rectangle.png");
	}
	
	public static final class DISPLAY
	{
		public static final int STOKE_BORDER_BUTTON_THICKNESS = 5;
	}
	
	public static final Form.IShapeDrawer SHAPE = new Form.ShapeDrawer.Brush(BRUSH.BRUSH_STOKE_WIDTH, BRUSH.BRUSH_STOKE_HEIGHT);
	
	public static final String TITLE = "Paint";
	
	public static Form.DrawConfig config = new DrawConfig(COLOR.STOKE, COLOR.FILL, SHAPE);
}
