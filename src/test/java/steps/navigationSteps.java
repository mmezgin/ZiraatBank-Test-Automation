package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import questions.InstallmentAmount;
import screenplay.view.BasePage;
import screenplay.view.KrediHesaplamaPage;
import screenplay.view.KredilerPage;
import screenplay.view.TuketiciKredisiPage;
import tasks.TutarVade;

import java.util.function.Predicate;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class navigationSteps {

    @Managed
    WebDriver driver;
    Actor mert =new Actor("mert");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Anasayfaya gidilir")
    public void Anasayfaya_gidilir(){

        theActorCalled("mert").can(BrowseTheWeb.with(driver));
        theActorInTheSpotlight().attemptsTo(Open.url(BasePage.baseUrl));
    }

    @And("Bireysel kredilere tıklanır")
    public void bireysel_kredilere_tiklanir() {
        theActorInTheSpotlight().attemptsTo(
               MoveMouse.to(BasePage.BTN_BIREYSEL),
               Click.on(BasePage.BTN_KREDILER)
       );
    }

    @And("Tüketici kredisi seçilir")
    public void tuketici_kredisi_secilir() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(KredilerPage.BTN_TUKETICI_KREDISI)
        );
    }

    @And("Hesaplama aracına gidilir")
    public void hesaplama_aracina_gidilir() {
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(TuketiciKredisiPage.BTN_HESAPLAMA_ARACI),
                Click.on(TuketiciKredisiPage.BTN_HESAPLAMA_ARACI)
        );
    }

    @When("Tüketici {word} kredisi hesaplanır {string},{string}")
    public void tuketici_kredisi_hesaplanir(String actorName,String tutar, String vade) {
        theActorInTheSpotlight().attemptsTo(
                TutarVade.tutarGir(tutar,vade),
                Click.on(KrediHesaplamaPage.BTN_HESAPLA)
        );
    }

    @Then("Tüketici kredisi kontrol edilir")
    public void tuketici_kredisi_kontrol_edilir() {
        theActorInTheSpotlight().should(
                seeThat(
                        InstallmentAmount.getValue(), Predicate.isEqual("4.806,58 TL")
                )
        );
    }
    @Then("Konut kredisine gidilir")
    public void konut_kredisine_gidilir() {
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(KrediHesaplamaPage.SELECT_KREDI_TURLERI),
                Click.on(KrediHesaplamaPage.SELECT_KREDI_TURLERI),
                Click.on(KrediHesaplamaPage.SELECT_KONUT_KREDISI)
        );
    }

    @When("Konut kredisi hesaplanır  {string},{string}")
    public void konut_kredisi_hesaplanir(String tutar, String vade) {

        theActorInTheSpotlight().attemptsTo(
                TutarVade.tutarGir(tutar,vade),
                Click.on(KrediHesaplamaPage.BTN_HESAPLA)
        );
    }

    @Then("Konut kredisi kontrol edilir")
    public void konut_kredisi_kontrol_edilir() {
        theActorInTheSpotlight().should(
                seeThat(
                        InstallmentAmount.getValue(), Predicate.isEqual("10.350,08 TL")
                )
        );
    }

    @Then("Tasit kredisine gidilir")
    public void tasit_kredisine_gidilir() {
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(KrediHesaplamaPage.SELECT_KREDI_TURLERI),
                Click.on(KrediHesaplamaPage.SELECT_KREDI_TURLERI),
                Click.on(KrediHesaplamaPage.SELECT_TASIT_KREDISI)
                );
    }

    @When("Taşıt kredisi hesaplanır {string},{string}")
    public void tasit_kredisi_hesaplanir(String tutar, String vade) {
        theActorInTheSpotlight().attemptsTo(
                TutarVade.tutarGir(tutar,vade),
                Click.on(KrediHesaplamaPage.BTN_HESAPLA)
        );
    }

    @Then("Taşıt kredisi kontrol edilir")
    public void tasit_kredisi_kontrol_edilir() {
        theActorInTheSpotlight().should(
                seeThat(
                        InstallmentAmount.getValue(), Predicate.isEqual("11.863,86 TL")
                )
        );
    }
}
