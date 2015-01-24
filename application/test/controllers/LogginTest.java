package controllers;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

import play.mvc.*;
import play.libs.*;
import play.test.*;
import static play.test.Helpers.*;

public class LoginTest extends WithApplication {
    @Before
    public void setUp() {
        //need database
    }
/*    
    @Test
    public void authenticated() {
        Result result = callAction(
            controllers.routes.ref.Application.index(),
            fakeRequest().withSession("email", "smartguy@gmail.com")
            );
            assertEquals(200, status(result));
    }
    
    @Test
    public void notAuthenticated() { //request must be blocked if user is not authenticateed
        Result result  = callAction(
            controllers.routes.ref.Application.index(),
            fakeRequest()
            );
            assertEquals(303, status(result));
            assertEquals("/signin", header("Location", result)); //need to edit view
    }
*/
}