package questions.create;

import helpers.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import utils.data.DataFaker;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasItems;


public class CreateRegisterQuestion implements Question {

    @Override
    public Object answeredBy(Actor actor) {
      actor.should(seeThatResponse(Constants.KEY_STATUS,
                response -> response.body(Constants.KEY_STATUS, hasItems(Constants.SUCCESS))));
        actor.should(seeThatResponse(Constants.KEY_MESSAGE,
                response -> response.body(Constants.KEY_MESSAGE, hasItems(Constants.REGYSTER_MESSAGE))));
        actor.should(seeThatResponse(Constants.NAME,
                response -> response.body("data.name", hasItems(DataFaker.generarNombre().get(0)))));
        actor.should(seeThatResponse(Constants.SALARY,
                response -> response.body("data.salary", hasItems(DataFaker.generarSalario().get(0)))));
        actor.should(seeThatResponse(Constants.AGE,
                response -> response.body("data.age", hasItems(DataFaker.generarEdad().get(0)))));
        return true;
    }
    public static CreateRegisterQuestion registerSucces(){
        return new CreateRegisterQuestion();
    }


}
