package screenplay.view;

import net.serenitybdd.screenplay.targets.Target;

public class BasePage {

    public static final String baseUrl="https://www.ziraatbank.com.tr/tr";

    public final static Target BTN_BIREYSEL =
            Target.the("btn_bireysel").locatedBy("//div[@class='header-right']//a[@href='/tr/bireysel']");

    public final static Target BTN_KREDILER =
            Target.the("btn_krediler").locatedBy("//div[@class='header-right']//a[@href='/tr/bireysel/krediler']");
}

