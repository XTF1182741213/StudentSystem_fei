package Students_manage_System;

import java.awt.Font;

import javax.swing.JComboBox;

@SuppressWarnings("hiding")
public class ComboBoxes<Object> extends JComboBox<Object> {

	/**
	 * 个性化
	 */
	private static final long serialVersionUID = 1L;

	public ComboBoxes() {
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		this.setFont(new Font("楷体", Font.PLAIN, 14));
	}
}
