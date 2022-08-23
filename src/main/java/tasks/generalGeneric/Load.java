package tasks.generalGeneric;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import utils.data.DataFaker;

public class Load implements Task {
    public Load(){}

    @Override
    public <T extends Actor> void performAs(T actor) {
        DataFaker.setData();
    }
    public static Load testData() {
        return Tasks.instrumented(Load.class);
    }


}
