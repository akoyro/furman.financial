package by.dak.furman.financial.swing.category.action;

import by.dak.common.persistence.SearchFilter;
import by.dak.furman.financial.Period;
import by.dak.furman.financial.PeriodType;
import by.dak.furman.financial.swing.ARefreshAction;
import by.dak.furman.financial.swing.category.CategoriesPanel;
import by.dak.furman.financial.swing.category.RootNode;
import by.dak.furman.financial.swing.category.YearNode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * User: akoyro
 * Date: 4/25/13
 * Time: 1:03 PM
 */
public class RefreshRootNode extends ARefreshAction<CategoriesPanel, RootNode, Period, YearNode>
{
    @Override
    public List<Period> getValues()
    {
        ArrayList<Period> periods = new ArrayList<Period>();
        periods.add(createYearPeriod(new Date()));
        return periods;
    }

    @Override
    public YearNode createChildNode()
    {
        YearNode yearNode = new YearNode();
        SearchFilter searchFilter = getItemService().getSearchFilter(getNode().getCategory(), null, getNode().getPeriod());
        yearNode.setAmount(getItemService().getSumBy(searchFilter));
        return yearNode;
    }

    @Override
    public void refreshChildNode(YearNode childNode)
    {
        RefreshYearNode refreshYearNode = new RefreshYearNode();
        refreshYearNode.setPanel(getPanel());
        refreshYearNode.setNode(childNode);
        refreshYearNode.action();
    }


    private Period createYearPeriod(Date date)
    {
        Period period = new Period();
        period.setPeriodType(PeriodType.YEAR);
        period.setCurrent(true);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Period.resetTime(calendar);

        calendar.set(Calendar.DAY_OF_YEAR, 1);
        period.setStartDate(calendar.getTime());

        calendar.add(Calendar.YEAR, 1);
        period.setEndDate(calendar.getTime());
        return period;
    }


}