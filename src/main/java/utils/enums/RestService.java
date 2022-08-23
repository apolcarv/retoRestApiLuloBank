package utils.enums;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public enum RestService {

    EMPLOYEES("employees"),
    CREATE("create"),
    EMPLOYEE("employee/"),
    DELETE("delete/"),
    UPDATE("update/");

    private String uri;
    RestService(String uri) {
        this.uri = uri;
    }
    public String getUri(){return uri;}
}
