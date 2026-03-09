package aha.common.ui.swing.desktop;

import java.awt.Frame;

import javax.swing.Action;
import javax.swing.JFrame;

public abstract class Application {
	private final JFrame frame;
	
	

	protected Application(String title) {
		this.frame = new JFrame(title);
	}
	
	protected Application addMenuAction(String path, Action action) {
		var components = path.split(".");
		
		
		
		return this;
	}
}
