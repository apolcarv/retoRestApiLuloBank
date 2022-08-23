package tasks.generalGeneric;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import utils.data.DataFaker;

import java.util.ArrayList;
import java.util.List;

public class GetResponse implements Task {

    private final String pathName;
    private final String name;

    public GetResponse(String pathName, String name) {
        this.pathName = pathName;
        this.name = name;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (SerenityRest.lastResponse().body().path(pathName) instanceof ArrayList) {
            List<String> listCode = SerenityRest.lastResponse().body().path(pathName);
            DataFaker.getData().put(name, listCode.get(0));
        } else {
            String value = SerenityRest.lastResponse().body().path(pathName);
            DataFaker.getData().put(name, value);
        }
    }
    public static Performable path(String pathName, String name) {
        return Tasks.instrumented(GetResponse.class, pathName, name);
    }
}
