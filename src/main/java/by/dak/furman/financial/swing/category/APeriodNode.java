package by.dak.furman.financial.swing.category;

import by.dak.common.lang.StringValueAnnotationProcessor;
import by.dak.furman.financial.Period;

/**
 * User: akoyro
 * Date: 4/22/13
 * Time: 12:36 PM
 */
public abstract class APeriodNode extends ACNode<Period> {
	public APeriodNode() {
		setAllowsChildren(true);
	}

	public String getName() {
		return StringValueAnnotationProcessor.getProcessor().convert(getValue());
	}

	@Override
	public Period getPeriod() {
		return getValue();
	}

	@Override
	public void setPeriod(Period period) {
		super.setValue(period);    //To change body of overridden methods use File | Settings | File Templates.
	}
}

