package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.view.KrediHesaplamaPage;

public class InstallmentAmount implements Question {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(KrediHesaplamaPage.taksitTutari).viewedBy(actor).asString();
    }

    public static Question<String> getValue(){
        return new InstallmentAmount();
    }
}
