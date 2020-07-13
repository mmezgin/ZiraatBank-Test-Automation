package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import screenplay.view.BasePage;

import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class BaseElements implements Question<Boolean>{
    @Override
    public Boolean answeredBy(Actor actor) {
        return the(BasePage.BTN_BIREYSEL).answeredBy(actor).isCurrentlyVisible();
    }
    public static BaseElements isDisplayed(){
        return new BaseElements();
    }
}
