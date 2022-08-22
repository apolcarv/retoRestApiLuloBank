package tasks.employees;

public class Call {
    private Call(){}
    public static ConsultEmployees service(){
        return new ConsultEmployees();
    }
}
