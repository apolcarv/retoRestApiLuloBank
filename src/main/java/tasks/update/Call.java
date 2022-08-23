package tasks.update;

import tasks.delete.DeleteEmployee;

public class Call {
    private Call(){}
    public static UpdateEmployee service(){
        return new UpdateEmployee();
    }


}
