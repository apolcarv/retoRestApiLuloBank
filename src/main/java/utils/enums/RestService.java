package utils.enums;

public enum RestService {

    EMPLOYEES("employees"),
    CREATE("create"),
    EMPLOYEE("employee/1"),
    DELETE("delete/2"),
    UPDATE("update/2");

    private String uri;
    RestService(String uri) {
        this.uri = uri;
    }
    public String getUri(){return uri;}
}
