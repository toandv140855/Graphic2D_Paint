/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;




/**
 *
 * @author hailiang194
 */
public class ImageSaver {
	private java.awt.image.BufferedImage buffer;
	private java.io.File file;

	public ImageSaver(java.awt.image.BufferedImage buffer, java.io.File file) {
		this.buffer = buffer;
		this.file = file;
	}
	
	public void save() throws java.io.IOException
	{
		String formatFile = this.file.getAbsolutePath().substring(this.file.getAbsolutePath().lastIndexOf('.') + 1);
		
		javax.imageio.ImageIO.write(buffer, formatFile, file);
	}
	
}
