package screenplay.view;

import net.serenitybdd.screenplay.targets.Target;

public class KredilerPage {

    public final static Target BTN_TUKETICI_KREDISI =
            Target.the("tüketiciKredisi").locatedBy("//a[contains(@href,'/tuketici-kredisi')]");
}
