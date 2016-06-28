package edu.wsu.dase;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JCheckBox;
import javax.swing.JList;

import org.protege.editor.owl.OWLEditorKit;
import edu.wsu.dase.OWLCellRenderer;

public class CustomCheckBoxCellRenderer extends OWLCellRenderer {

	public CustomCheckBoxCellRenderer(OWLEditorKit editorKit) {
		super(editorKit);
	}

	public Component getCheckBoxCellRendererComponent(JCheckBox checkBox, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		componentBeingRendered = checkBox;
		Rectangle cellBounds = new Rectangle();
		// We need to prevent infinite recursion here!
		if (!gettingCellBounds) {
			gettingCellBounds = true;
			cellBounds = checkBox.getBounds();
			gettingCellBounds = false;
		}
		minTextHeight = 12;
		if (checkBox.getParent() != null) {
			preferredWidth = checkBox.getParent().getWidth();
		}
		// preferredWidth = -1;
		// textPane.setBorder(BorderFactory.createEmptyBorder(1, 2, 1, 2 +
		// rightMargin));
		setupLinkedObjectComponent(checkBox, cellBounds);
		Component c = prepareRenderer(value, isSelected, cellHasFocus);
		reset();
		return c;
	}

}
