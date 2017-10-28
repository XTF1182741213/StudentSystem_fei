package Students_manage_System;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class Tables extends JTable {
	/**
	 * 个性化
	 */
	private static final long serialVersionUID = 1L;

	public Tables(TableModel dm) {
		super(dm);
		init();
	}

	private void init() {
		this.setFont(new Font("楷体", Font.PLAIN, 16));
	}
}
