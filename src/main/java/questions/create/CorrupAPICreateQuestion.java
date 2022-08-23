package questions.create;

import helpers.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CorrupAPICreateQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        String message = Constants.MESSAGE_CORRUPT;
        actor.should(seeThatResponse(Constants.STATUS, response -> response.statusCode(Constants.RESPONSE_METHOP_NOT_ALLOWEB)));
        /** actor.should(seeThatResponse(Constants.MESSAGE,
         response -> response.body(Constants.MESSAGE, hasItems(message))));*/

        return true;
    }

    public static CorrupAPICreateQuestion validAPICorrupt() {
        return new CorrupAPICreateQuestion();
    }
}
