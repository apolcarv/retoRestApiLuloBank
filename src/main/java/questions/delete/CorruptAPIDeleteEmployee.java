package questions.delete;

import helpers.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CorruptAPIDeleteEmployee implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        actor.should(seeThatResponse(Constants.STATUS, response -> response.statusCode(Constants.RESPONSE_METHOD_NOT_ALLOWEB)));
        return true;
    }

    public static CorruptAPIDeleteEmployee validAPICorrupt() {
        return new CorruptAPIDeleteEmployee();
    }
}
