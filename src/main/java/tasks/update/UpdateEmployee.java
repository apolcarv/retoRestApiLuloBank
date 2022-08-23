package tasks.update;

import interactions.delete.GetDeleteEmployee;
import interactions.delete.GetDeleteEmployeeCorrupt;
import interactions.update.GetCorruptAPIUpdateEmployee;
import interactions.update.GetUpdateEmployee;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class UpdateEmployee {

    public Performable updateEmployee (String resources){
        return Task.where("{0} call the deleteEmployee service", GetUpdateEmployee.service(resources));
    }
    public Performable updateEmployeeEndpointCorrupt (String resources){
        return Task.where("{0} call the deleteEmployeeEndpointCorrupt service", GetCorruptAPIUpdateEmployee.service(resources));
    }
}
