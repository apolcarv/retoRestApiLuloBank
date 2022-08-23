package questions.update;

import helpers.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CorruptAPIUpdateQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        actor.should(seeThatResponse(Constants.STATUS, response -> response.statusCode(Constants.RESPONSE_CODE_NOT_FOUND)));
        return true;
    }

    public static CorruptAPIUpdateQuestion validAPICorrupt() {
        return new CorruptAPIUpdateQuestion();
    }
}
