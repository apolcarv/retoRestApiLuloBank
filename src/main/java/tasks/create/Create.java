package tasks.create;

import interactions.create.PostCreate;
import interactions.create.PostCreateCorrupt;
import interactions.employees.GetConsultEmployeeCorrupt;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Create {
    public Performable createEmployee (String resource, String bodyName){
        return Task.where("{0} call the createEmployee service", PostCreate.service(resource,bodyName));
    }
    public Performable createEmployeeEndpointCorrupt (String resource, String bodyName){
        return Task.where("{0} call the createEmployeeEndpointCorrupt service", PostCreateCorrupt.service(resource,bodyName));
    }
}
