package Students_manage_System;

import java.awt.Font;

import javax.swing.JComboBox;

@SuppressWarnings("hiding")
public class ComboBoxes<Object> extends JComboBox<Object> {

	/**
	 * ���Ի�
	 */
	private static final long serialVersionUID = 1L;

	public ComboBoxes() {
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		this.setFont(new Font("����", Font.PLAIN, 14));
	}
}
