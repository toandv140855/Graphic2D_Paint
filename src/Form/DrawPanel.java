/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.image.BufferedImage;

/**
 *
 * @author hailiang194
 */
public class DrawPanel extends javax.swing.JPanel {

	private java.awt.image.BufferedImage openedImg;
	private java.util.ArrayList<DrawShape> shapes;
	private java.util.Stack<DrawShape> shapesStack;
	private java.awt.Point start;
	private java.awt.Point end;

	public DrawPanel() {
		
		this.openedImg = null;
		javax.swing.border.Border border = javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK);
		this.setBackground(Default.COLOR.PAINT_BACKGROUND);
		this.setBorder(border);
		
		this.shapes = new java.util.ArrayList<>();
		this.shapesStack = new java.util.Stack<>();
		

		this.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {

				Form.IShapeDrawer shapeDrawer = Default.config.getDrawShape();

				if (shapeDrawer instanceof Form.ShapeDrawer.Brush) {
					return;
				}

				start = new java.awt.Point(e.getX(), e.getY());
				end = start;
				repaint();
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
		
				//This function user to draw shapes that is not brush

				Form.IShapeDrawer shapeDrawer = Default.config.getDrawShape();

				if (shapeDrawer instanceof Form.ShapeDrawer.Brush) {
					return;
				}
				
				
				java.awt.Shape shape = (java.awt.Shape) shapeDrawer.draw(start.x, start.y, end.x, end.y);
				java.awt.Color stoke = Default.config.getStoke();
				java.awt.Color fill = Default.config.getFillColor();

				shapes.add(new Form.DrawShape(shape, fill, stoke));
				start = null;
				end = null;

				repaint();
			}

		});

		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {


				Form.IShapeDrawer shapeDrawer = Default.config.getDrawShape();

				if (shapeDrawer instanceof Form.ShapeDrawer.Brush) {
					int x = e.getX();
					int y = e.getY();
					
					java.awt.Shape shape = (java.awt.Shape)shapeDrawer.draw(x, y, x, y);
					java.awt.Color stoke = Default.config.getStoke();
					java.awt.Color fill = Default.config.getStoke();
					
					shapes.add(new DrawShape(shape, fill, stoke));
				}
				
				end = new java.awt.Point(e.getX(), e.getY());
				repaint();
			}

		});
	}

	@Override
	public void paint(java.awt.Graphics g) {
		
		super.paint(g);
		
		java.awt.Graphics2D graphic = (java.awt.Graphics2D) g;

		if(this.openedImg != null)
		{
			graphic.drawImage(this.openedImg, 0, 0, null);
		}
		
		graphic.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
			java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

		graphic.setStroke(new java.awt.BasicStroke(4));
		
		for (DrawShape shape : shapes) {
			if(shape.getShape() != null)
			{
				graphic.setPaint(shape.getStoke());
				graphic.draw(shape.getShape());
			}
			if(shape.getFill() != null)
			{
				graphic.setPaint(shape.getFill());
				graphic.fill(shape.getShape());
			}
		}

		//draw temporary shape when user is drawing
		if (start != null && end != null) {
			Form.IShapeDrawer shapeDrawer = Default.config.getDrawShape();

			if (shapeDrawer instanceof Form.ShapeDrawer.Brush) {
				return;
			}

			graphic.setComposite(java.awt.AlphaComposite.getInstance(
				java.awt.AlphaComposite.SRC_OVER, 0.40f));

			// Make guide shape gray for professional look
			graphic.setPaint(Default.COLOR.DRAWING_STOKE);

			java.awt.Shape shape = (java.awt.Shape) shapeDrawer.draw(start.x, start.y, end.x, end.y);
			graphic.draw(shape);
		}
	}

	public void clean() {
		this.openedImg = null;
		this.shapes.clear();
		this.shapesStack.clear();
		this.repaint();
	}
	
	public void undo()
	{
		if(this.shapes.isEmpty())
			return;
		
		Form.DrawShape shape = this.shapes.remove(this.shapes.size() - 1);
		this.shapesStack.push(shape);
		this.repaint();
	}
	
	public void redo()
	{
		if(this.shapesStack.empty())
			return;
		
		Form.DrawShape shape = this.shapesStack.pop();
		this.shapes.add(shape);
		this.repaint();
	}
	
	public java.awt.image.BufferedImage capture()
	{
		java.awt.image.BufferedImage buffered = new java.awt.image.BufferedImage(this.getWidth(), this.getHeight(), java.awt.image.BufferedImage.TYPE_INT_RGB);
		java.awt.Graphics graphic = buffered.getGraphics();
		this.paint(graphic);
		
		return buffered;
	}

	public void open(BufferedImage buffer) {
		this.shapes.clear();
		this.shapesStack.clear();
		this.openedImg = buffer;
		this.repaint();
	}
	
	public boolean isEmpty()
	{
		return this.shapes.isEmpty();
	}

}
