package greeter;

import javax.enterprise.context.SessionScoped;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Arrays;


@SessionScoped
public class Greeter implements Serializable {

    private String greeting;

    public void greet(PrintStream to, String name) {
        greeting = name;
        to.println(createGreeting(greeting));
    }

    public String createGreeting(String name) {
        greeting = name;
        return "Hello " + greeting + "!";
    }

    public void showParam(Class<?> clazz) {
        System.out.println(Arrays.toString(clazz.getDeclaredFields()));
    }
}
