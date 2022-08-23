package tasks.delete;

import interactions.delete.GetDeleteEmployee;
import interactions.delete.GetDeleteEmployeeCorrupt;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class DeleteEmployee {
    public Performable deleteEmployee (String resources){
        return Task.where("{0} call the deleteEmployee service", GetDeleteEmployee.service(resources));
    }
    public Performable deleteEmployeeEndpointCorrupt (String resources){
        return Task.where("{0} call the deleteEmployeeEndpointCorrupt service", GetDeleteEmployeeCorrupt.service(resources));
    }
}