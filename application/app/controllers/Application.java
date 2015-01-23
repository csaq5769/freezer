package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Freezer - Find your Dream Date"));
    }
    
    public static Result signin() {
    	return ok(signInScreen.render());
    }
    
    public static Result timeandplace() {
    	return ok(timeplace.render());
    }
    
    public static Result signUp(){
    	return ok(registerScreen.render());
    }
    
    public static Result selectDate() {
    	return ok(select.render());
    }
    
    public static Result payit(){
    	return ok(payScreen.render());
    }
    
    public static Result endit() {
    	return ok(endScreen.render());
    }
    
    public static Result persData() {
    	return ok(personal.render());
    }
}

