package Students_manage_System;

import java.awt.Font;

import javax.swing.JTextField;

public class TextField extends JTextField {
	/**
	 * 个性化
	 */
	private static final long serialVersionUID = 1L;

	public TextField() {
		// TODO Auto-generated constructor stub
		super();
		init();
	}

	public TextField(String s) {
		// TODO Auto-generated constructor stub
		super(s);
		init();
	}

	private void init() {
		this.setFont(new Font("楷体", Font.PLAIN, 14));
	}

}
