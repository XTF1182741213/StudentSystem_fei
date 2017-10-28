package Students_manage_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Buttons extends JButton {

	/**
	 * 个性化
	 */
	private static final long serialVersionUID = 1L;

	public Buttons() {
		super();
		init();
	}

	public Buttons(String s) {
		super(s);
		init();
	}

	private void init() {
		this.setFont(new Font("楷体", Font.PLAIN, 16));
		this.setBorderPainted(false);
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Buttons.this.setForeground(Color.blue);
				Buttons.this.setOpaque(true);
			}

			public void mouseExited(MouseEvent e) {
				Buttons.this.setForeground(null);
				Buttons.this.setOpaque(false);
			}
		});
	}
}
