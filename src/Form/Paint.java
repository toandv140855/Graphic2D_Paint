/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * Main form program
 *
 * @author hailiang194
 */
public class Paint extends javax.swing.JFrame {

	private DrawPanel graphic;
	private javax.swing.JButton btnBrush;
	private javax.swing.JButton btnLine;
	private javax.swing.JButton btnEllipse;
	private javax.swing.JButton btnRectangle;
	private javax.swing.JButton btnStoke;
	private javax.swing.JButton btnFill;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenu mFile;
	private javax.swing.JMenuItem miOpen;
	private javax.swing.JMenuItem miNew;
	private javax.swing.JMenuItem miSave;
	private javax.swing.JMenu mEdit;
	private javax.swing.JMenuItem miUndo;
	private javax.swing.JMenuItem miRedo;

	private final java.util.ArrayList<javax.swing.JButton> drawFunctionbuttons;

	private javax.swing.JButton setupDrawButton(javax.swing.ImageIcon icon, String toolTipHelp, java.awt.event.ActionListener clickedButton) {
		javax.swing.JButton button = new javax.swing.JButton(icon);
		button.setPreferredSize(Default.DISPLAY.BUTTON_SIZE);
		button.setToolTipText(toolTipHelp);
		button.setBackground(Default.COLOR.DRAW_BUTTON_BACKGROUND);
		button.addActionListener(clickedButton);

		this.drawFunctionbuttons.add(button);

		return button;
	}

	private javax.swing.JButton setupConfigButton(String toolTipHelp, java.awt.event.ActionListener clickedButton) {
		javax.swing.JButton button = new javax.swing.JButton();
		button.setPreferredSize(Default.DISPLAY.BUTTON_SIZE);
		button.setToolTipText(toolTipHelp);
		button.setBackground(Default.COLOR.DRAW_BUTTON_BACKGROUND);
		button.addActionListener(clickedButton);

		return button;
	}

	private void setUnselectDrawButton() {
		for (javax.swing.JButton drawFunctionbutton : drawFunctionbuttons) {
			drawFunctionbutton.setBackground(Default.COLOR.DRAW_BUTTON_BACKGROUND);
		}
	}

	private javax.swing.JPanel getDrawFunctionContainer(javax.swing.JButton button) {
		javax.swing.JPanel panel = new javax.swing.JPanel();
		panel.setBackground(Default.COLOR.PAINT_CONTROL_PANEL);

		panel.add(button);

		return panel;
	}

	private void initComponent() {

		this.menuBar = new javax.swing.JMenuBar();

		//File Menu Config
		this.mFile = new javax.swing.JMenu("File");
		this.menuBar.add(mFile);

		this.miOpen = new javax.swing.JMenuItem("Open");
		this.miOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
		this.miOpen.addActionListener((java.awt.event.ActionEvent e) -> {
			miOpenClicked(e);
		});
		this.mFile.add(miOpen);

		this.miNew = new javax.swing.JMenuItem("New");
		this.miNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
		this.miNew.addActionListener((java.awt.event.ActionEvent e) -> {
			miNewClicked(e);
		});
		this.mFile.add(miNew);

		this.miSave = new javax.swing.JMenuItem("Save");
		this.miSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
		this.miSave.addActionListener((java.awt.event.ActionEvent e) -> {
			miSaveClicked(e);
		});
		this.mFile.add(miSave);

		//Edit Menu config
		this.mEdit = new javax.swing.JMenu("Edit");
		this.menuBar.add(mEdit);

		this.miUndo = new javax.swing.JMenuItem("Undo");
		this.miUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
		this.miUndo.addActionListener((java.awt.event.ActionEvent e) -> {
			miUndoClicked(e);
		});
		this.mEdit.add(miUndo);

		this.miRedo = new javax.swing.JMenuItem("Redo");
		this.miRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
		this.miRedo.addActionListener((java.awt.event.ActionEvent e) -> {
			miRedoClicked(e);
		});
		this.mEdit.add(miRedo);

		//Componenet config
		javax.swing.JPanel pButton = new javax.swing.JPanel();
		pButton.setBackground(Default.COLOR.PAINT_CONTROL_PANEL);
		this.graphic = new DrawPanel();
		javax.swing.Box box = javax.swing.Box.createHorizontalBox();

		this.btnBrush = this.setupDrawButton(Default.ICON.BRUSH, "Brush Mode", (java.awt.event.ActionEvent e) -> {
			btnBrushClicked(e);
		});
		javax.swing.JPanel pBrushPlace = this.getDrawFunctionContainer(this.btnBrush);

		this.btnLine = this.setupDrawButton(Default.ICON.LINE, "Line Mode", (java.awt.event.ActionEvent e) -> {
			btnLineClicked(e);
		});
		javax.swing.JPanel pLinePlace = this.getDrawFunctionContainer(this.btnLine);

		this.btnEllipse = this.setupDrawButton(Default.ICON.ELLIPSE, "Ellipse Mode", (java.awt.event.ActionEvent e) -> {
			btnEllipseClicked(e);
		});
		javax.swing.JPanel pEllipsePlace = this.getDrawFunctionContainer(this.btnEllipse);

		this.btnRectangle = this.setupDrawButton(Default.ICON.RECTANGLE, "Rectangle Mode", (java.awt.event.ActionEvent e) -> {
			btnRetangleClicked(e);
		});
		javax.swing.JPanel pRectanglePlace = this.getDrawFunctionContainer(this.btnRectangle);

		this.btnFill = this.setupConfigButton("Choose fill color. If close without choosing, no fill color.", (java.awt.event.ActionEvent e) -> {
			btnFillClicked(e);
		});
		this.btnFill.setBackground(DrawConfig.getInstance().getFillColor());
		this.btnFill.setBorder(new javax.swing.border.LineBorder(java.awt.Color.WHITE, Default.DISPLAY.STOKE_BORDER_BUTTON_THICKNESS));
		javax.swing.JPanel pFillPlace = this.getDrawFunctionContainer(this.btnFill);

		this.btnStoke = this.setupConfigButton("Choose stoke color. If close without choosing, no stoke color.", (java.awt.event.ActionEvent e) -> {
			btnStokeClicked(e);
		});
		this.btnStoke.setBorder(new javax.swing.border.LineBorder(DrawConfig.getInstance().getStoke(), Default.DISPLAY.STOKE_BORDER_BUTTON_THICKNESS));
		this.btnStoke.setBackground(java.awt.Color.WHITE);

		javax.swing.JPanel pStokePlace = this.getDrawFunctionContainer(this.btnStoke);
		pStokePlace.setBorder(new javax.swing.border.LineBorder(java.awt.Color.WHITE));

		box.add(pBrushPlace);
		box.add(pLinePlace);
		box.add(pEllipsePlace);
		box.add(pRectanglePlace);
		box.add(pFillPlace);
		box.add(pStokePlace);

		this.setJMenuBar(menuBar);
		pButton.add(box);
		this.add(pButton, java.awt.BorderLayout.SOUTH);
		this.add(this.graphic, java.awt.BorderLayout.CENTER);
	}

	public Paint() {
		this.drawFunctionbuttons = new java.util.ArrayList<>();
		this.initComponent();
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				if (graphic.isEmpty()) {
					System.exit(0);
				}

				int exitOption = javax.swing.JOptionPane.showConfirmDialog(null, "Do you want to save this painting?", "EXIT", javax.swing.JOptionPane.YES_NO_OPTION);

				if (exitOption == javax.swing.JOptionPane.YES_OPTION) {
					javax.swing.JFileChooser save = new javax.swing.JFileChooser();

					if (save.showSaveDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION) {
						Function.ImageSaver imgSaver = new Function.ImageSaver(graphic.capture(), save.getSelectedFile());
						try {
							imgSaver.save();
						} catch (java.io.IOException ex) {
							javax.swing.JOptionPane.showConfirmDialog(null, "ERROR: " + ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
						}
					} else {
						javax.swing.JOptionPane.showConfirmDialog(null, "Error to save file", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
					}
				}

				System.exit(0);

			}

		});
		this.btnBrushClicked(null);
	}

	private void btnBrushClicked(java.awt.event.ActionEvent e) {
		DrawConfig.getInstance().setDrawShape(new Form.ShapeDrawer.Brush(Default.BRUSH.BRUSH_STOKE_WIDTH, Default.BRUSH.BRUSH_STOKE_HEIGHT));
		this.setUnselectDrawButton();
		this.btnBrush.setBackground(Default.COLOR.SELECTION_DRAW_BUTTON_BACKGROUND);
	}

	private void btnLineClicked(java.awt.event.ActionEvent e) {
		DrawConfig.getInstance().setDrawShape(new Form.ShapeDrawer.Line());
		this.setUnselectDrawButton();
		this.btnLine.setBackground(Default.COLOR.SELECTION_DRAW_BUTTON_BACKGROUND);
	}

	private void btnEllipseClicked(java.awt.event.ActionEvent e) {
		DrawConfig.getInstance().setDrawShape(new Form.ShapeDrawer.Ellipse());
		this.setUnselectDrawButton();
		this.btnEllipse.setBackground(Default.COLOR.SELECTION_DRAW_BUTTON_BACKGROUND);
	}

	private void btnRetangleClicked(java.awt.event.ActionEvent e) {
		DrawConfig.getInstance().setDrawShape(new Form.ShapeDrawer.Rectangle());
		this.setUnselectDrawButton();
		this.btnRectangle.setBackground(Default.COLOR.SELECTION_DRAW_BUTTON_BACKGROUND);
	}

	private void btnFillClicked(java.awt.event.ActionEvent e) {
		java.awt.Color chosen = javax.swing.JColorChooser.showDialog(null, "Choose fill color", DrawConfig.getInstance().getFillColor());
		DrawConfig.getInstance().setFillColor(chosen);
		if (chosen != null) {
			this.btnFill.setBackground(chosen);
			this.btnFill.setText("");
		} else {
			this.btnFill.setBackground(java.awt.Color.WHITE);
			this.btnFill.setText("NO");
		}
	}

	private void btnStokeClicked(java.awt.event.ActionEvent e) {
		java.awt.Color chosen = javax.swing.JColorChooser.showDialog(null, "Choose fill color", DrawConfig.getInstance().getStoke());
		if (chosen != null) {
			DrawConfig.getInstance().setStoke(chosen);
			this.btnStoke.setBorder(new javax.swing.border.LineBorder(chosen, Default.DISPLAY.STOKE_BORDER_BUTTON_THICKNESS));
		}
	}

	private void miNewClicked(java.awt.event.ActionEvent e) {
		if (!this.graphic.isEmpty()
			&& javax.swing.JOptionPane.showConfirmDialog(null, "Do you want to save this draw?", "Exit", javax.swing.JOptionPane.INFORMATION_MESSAGE) == javax.swing.JOptionPane.OK_OPTION) {
			javax.swing.JFileChooser save = new javax.swing.JFileChooser();

			if (save.showSaveDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION) {
				Function.ImageSaver imgSaver = new Function.ImageSaver(this.graphic.capture(), save.getSelectedFile());
				try {
					imgSaver.save();
				} catch (java.io.IOException ex) {
					javax.swing.JOptionPane.showConfirmDialog(null, "ERROR: " + ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			} else {
				javax.swing.JOptionPane.showConfirmDialog(null, "Error to save file", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		}
		this.setTitle(Default.TITLE);
		this.graphic.clean();
	}

	private void miSaveClicked(java.awt.event.ActionEvent e) {
		javax.swing.JFileChooser save = new javax.swing.JFileChooser();

		if (save.showSaveDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION) {
			Function.ImageSaver imgSaver = new Function.ImageSaver(this.graphic.capture(), save.getSelectedFile());
			try {
				imgSaver.save();
			} catch (java.io.IOException ex) {
				javax.swing.JOptionPane.showConfirmDialog(null, "ERROR: " + ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		} else {
			javax.swing.JOptionPane.showConfirmDialog(null, "Error to save file", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}

	private void miUndoClicked(ActionEvent e) {
		this.graphic.undo();
	}

	private void miRedoClicked(ActionEvent e) {
		this.graphic.redo();
	}

	private void miOpenClicked(ActionEvent e) {
		javax.swing.JFileChooser open = new javax.swing.JFileChooser();

		if (open.showOpenDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION) {
			try {
				java.awt.image.BufferedImage buffer = javax.imageio.ImageIO.read(open.getSelectedFile());
				this.graphic.open(buffer);
				this.setTitle(open.getSelectedFile().getAbsolutePath() + " - " + Default.TITLE);
			} catch (IOException ex) {
				javax.swing.JOptionPane.showConfirmDialog(null, "ERROR: " + ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		} else {
			javax.swing.JOptionPane.showConfirmDialog(null, "Error to open file.", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}
}
