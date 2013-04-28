package by.dak.furman.financial.converter;

import by.dak.common.lang.ToStringConverter;
import by.dak.furman.financial.Category;

/**
 * User: akoyro
 * Date: 4/23/13
 * Time: 11:25 AM
 */
public class Category2StringConverter implements ToStringConverter<Category>
{
    @Override
    public String convert(Category entity)
    {
        if (entity.getId() == null)
            return "new category ...";
        return entity.getName();
    }
}
