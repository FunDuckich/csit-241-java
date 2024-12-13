package org.knit.lab9;

public class Task17 {
    public void execute() throws IllegalAccessException {
        User user = new User(null, "LongUsernameHere", 3);
        try {
            Validator.validate(user);
        }
        catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
