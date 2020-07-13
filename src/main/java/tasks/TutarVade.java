package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.view.KrediHesaplamaPage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TutarVade implements Task {

    public static String tutar;
    public static String vade;

    public TutarVade (String tutar,String vade){
        TutarVade.vade =vade;
        TutarVade.tutar =tutar;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
                Click.on(KrediHesaplamaPage.INPUT_TUTAR),
                Enter.theValue(tutar).into(KrediHesaplamaPage.INPUT_TUTAR),
                Click.on(KrediHesaplamaPage.INPUT_VADE),
                Enter.theValue(vade).into(KrediHesaplamaPage.INPUT_VADE)
        );
    }
    public static TutarVade tutarGir(String tutar, String vade){
        return instrumented(TutarVade.class,tutar,vade);
    }
}
