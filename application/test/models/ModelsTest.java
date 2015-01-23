package models;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication; //provides start method to easily start fake application
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {
    @Before
    public void setUp()  {
        start(fakeApplication(inMemoryDatabase())); //automatically cleans up after each test run
    }
    
    @Test
    public void userCheck() {
        //take constructor email, username, password
        new User("smartguy@gmail.com", "SmartGuy1234", "pw5678").save();
        User smartGuy = User.find.where().eq("email", "smartguy@gmail.com").findUnique();
        assertNotNull(smartGuy);
        assertEquals("SmartGuy1234", smartGuy.username);
    }
    
    @Test
    public void authenticateUserTest() { //bad draft - should hash password
        new User("smartguy@gmail.com", "SmartGuy1234", "pw5678").save();
        
        assertNotNull(User.authenticate("smartguy@gmail.com", "pw5678");
        assertNull(User.authenticate("smartguy@gmail.com", "evenworsepw");
        assertNull(User.authenticate("batman@gmail.com", "pw5678");
    }
    
    @Test
    public void getDateTest() {
        new User("smartguy@gmail.com", "SmartGuy1234", "pw5678").save();
        new User("princess09@gmail.com", "Princess09", "secretpw").save();
        
        Dates.newDate("2015-01-26 10:00:00", "Aualm", "smartguy@gmail.com");
        Dates.newDate("2015-01-26 10:00:00", "Aualm", "princess09@gmail.com");
        
        List<Dates> result = Dates.findDate("princess09@gmail.com");
        assertEquals(1, result.size());
        assertEquals("26-01-2015", result.get(0).timeOfDate);
    }
}