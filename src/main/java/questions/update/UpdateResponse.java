package questions.update;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static helpers.Constants.KEY_STATUS;
import static helpers.Constants.SUCCESS;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasItems;

public class UpdateResponse implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        actor.should(seeThatResponse(KEY_STATUS,
                response -> response.body(KEY_STATUS, hasItems(SUCCESS))));
        return true;
    }
    public static UpdateResponse ConfirRegisterDeleted(){
        return new UpdateResponse();
    }
}
