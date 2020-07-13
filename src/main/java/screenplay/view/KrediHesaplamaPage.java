package screenplay.view;

import net.serenitybdd.screenplay.targets.Target;

public class KrediHesaplamaPage {

    public final static Target taksitTutari=
              Target.the("taksitTutar").locatedBy("//div[@class='result-item']//span[contains(text(),'TL')]");

    public final static Target INPUT_TUTAR =
            Target.the("inputTutar").locatedBy("//input[@id='calc-tutar']");
    public final static Target INPUT_VADE =
            Target.the("inputVade").locatedBy("//input[@id=\'calc-vade\']");
    public final static Target BTN_HESAPLA =
            Target.the("hesaplaButton").locatedBy("//a[@class='btn btn-red calculation-btn']");
    public final static Target SELECT_KREDI_TURLERI=
            Target.the("krediTurleri").locatedBy("//a[@class='selected']");
    public final static Target SELECT_KONUT_KREDISI =
            Target.the("konutKredisi").locatedBy("//div[@class='list active']//a[3]");
    public final static Target SELECT_TASIT_KREDISI =
            Target.the("tasitKredisi").locatedBy("//div[@class='list active']//a[2]");


}
