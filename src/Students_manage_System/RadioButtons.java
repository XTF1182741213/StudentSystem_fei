package Students_manage_System;

import java.awt.Font;

import javax.swing.JRadioButton;

public class RadioButtons extends JRadioButton {
	/**
	 * ���Ի�
	 */
	private static final long serialVersionUID = 1L;

	public RadioButtons() {
		// TODO Auto-generated constructor stub
		super();
		init();
	}

	public RadioButtons(String s) {
		// TODO Auto-generated constructor stub
		super(s);
		init();
	}

	public RadioButtons(String s, boolean b) {
		// TODO Auto-generated constructor stub
		super(s, b);
		init();
	}

	private void init() {
		this.setFont(new Font("����", Font.PLAIN, 16));
	}

}
