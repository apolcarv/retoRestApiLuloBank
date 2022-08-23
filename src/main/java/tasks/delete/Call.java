package tasks.delete;

public class Call {
    private Call(){}
    public static DeleteEmployee service(){
        return new DeleteEmployee();
    }

}
