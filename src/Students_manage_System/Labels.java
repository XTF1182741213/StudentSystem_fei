package Students_manage_System;

import java.awt.Font;

import javax.swing.JLabel;

public class Labels extends JLabel {
	/**
	 * 个性化
	 */
	private static final long serialVersionUID = 1L;

	public Labels() {
		super();
		init();
	}

	public Labels(String s) {
		super(s);
		init();
	}
	
	private void init() {
		this.setFont(new Font("楷体", Font.PLAIN, 16));
	}
}
