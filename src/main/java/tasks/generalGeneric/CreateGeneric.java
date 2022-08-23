package tasks.generalGeneric;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import utils.templates.MergeFrom;
import java.util.Map;
import static helpers.Constants.TEMPLATES_PATH;


public class CreateGeneric implements Task {
    private final String template;
    private final String bodyName;
    private final Map<String, Object> clientData;

    public CreateGeneric(String template, String bodyName, Map<String, Object> clientData) {
        this.template = template;
        this.bodyName = bodyName;
        this.clientData = clientData;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        String templatePath = String.format(TEMPLATES_PATH, template);
        String body = MergeFrom.template(templatePath).withFieldsFrom(clientData);
        actor.remember(bodyName, body);
    }
    public static CreateGeneric messageBody(String template, String bodyName, Map<String, Object> clientData) {
        return Tasks.instrumented(CreateGeneric.class, template, bodyName, clientData);
    }
}
