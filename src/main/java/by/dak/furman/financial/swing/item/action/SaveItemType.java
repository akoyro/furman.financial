package by.dak.furman.financial.swing.item.action;

import by.dak.furman.financial.ItemType;
import by.dak.furman.financial.swing.item.ItemTypeNode;
import org.apache.commons.lang3.StringUtils;

/**
 * User: akoyro
 * Date: 4/27/13
 * Time: 1:43 PM
 */
public class SaveItemType extends AIAction<ItemTypeNode>
{
    private ItemType itemType;

    @Override
    protected void before()
    {
        itemType = getNode().getItemType();
    }

    @Override
    protected void makeAction()
    {
        if (itemType.getId() == null)
            getItemTypeService().add(itemType);
        else
            getItemTypeService().save(itemType);
    }

    @Override
    protected boolean validate()
    {
        return StringUtils.trimToNull(itemType.getName()) != null
                && getItemTypeService().getBy(itemType.getCategory(), itemType.getName()) == null;
    }
}
