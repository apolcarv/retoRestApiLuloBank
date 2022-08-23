package questions.create;

import helpers.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CreateStatusQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        actor.should(seeThatResponse(Constants.STATUS, response -> response.statusCode(Constants.RESPONSE_CODE_OK)));
        return true;
    }
    public static CreateStatusQuestion confirmStatusOK(){
        return new CreateStatusQuestion();
    }
}
