package by.dak.furman.financial.swing.item.action;

import by.dak.furman.financial.swing.item.AINode;
import by.dak.furman.financial.swing.item.ItemNode;
import org.jdesktop.swingx.treetable.TreeTableNode;

/**
 * User: akoyro
 * Date: 4/29/13
 * Time: 12:07 AM
 */
public class DeleteItem extends AIAction<ItemNode> {
	@Override
	protected void makeAction() {
		TreeTableNode parent = getNode().getParent();

		getItemService().delete(getNode().getValue());

		RefreshHierarchy refreshHierarchy = new RefreshHierarchy();
		refreshHierarchy.setNode((AINode) getNode().getParent());
		refreshHierarchy.setPanel(getPanel());
		refreshHierarchy.action();

		getModel().removeNodeFromParent(getNode());

		if (parent.getColumnCount() > 1)
			selectColumn((AINode) parent.getChildAt(parent.getChildCount() - 2), 0);
	}

	@Override
	protected boolean validate() {
		return getNode().getValue().getId() != null;
	}
}

