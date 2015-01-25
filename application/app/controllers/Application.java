package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;

import java.lang.*;

public class Application extends Controller {
    
    @Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(index.render(
            "Freezer - Find your Dream Date",
            User.find.byId(request().username()) //access the currently logged in user with request.username()
            ));
    } 
    
    public static Result signin() {
    	return ok(signInScreen.render());
    }
    
    public static Result timeandplace() {
    	return ok(timeplace.render());
    }
    
    public static Result signUp(){
    	return ok(registerScreen.render(form(Login.class));
    }
    
    public static Result selectDate() {
    	return ok(select.render());
    }
    
    public static Result payit(){
    	return ok(payScreen.render());
    }
    
    //do maybe logout
    public static Result endit() {
    	return ok(endScreen.render());
    }
    
    public static Result persData() {
    	return ok(personal.render());
    }
    
    public static Result authenticate() { //need to render function in signin.scala.html and add it to routes
        Form<Login> loginForm = form(Login.class).bindFormRequest();
        if(loginForm.hasErrors()) { //if validation fails
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            //if validation was successful (user logged in successful) --> put emailaddress into session
            session("email", loginForm.get().email);
            return redirect(routes.Application.index());
        }
    }

    
    
    
    //if user is already a member of freezer
    public static class Login {
        public String email;
        public String password;
        
        //validate form for authenticate() --> is username and pw correct
        public String validate() {
            if(User.authenticate(email, password) == null) {
                return "invalid user or password";
            }
            return null;
        }
    }
    
    //if user is new - sign up
    public static class Register {
        public String email;
        public String confirmEmail;
        public String username;
    	public String password;
    	public String confirmPassword;
    	public Integer age;
    	public String gender;
    	public String country;
    	
    	public String validate() {
    	    if(!email.equals(confirmEmail)) {
    	        return "email-addresses don't match!!";
    	    }
    	    if(!password.equals(confirmPassword)) {
    	        return "your passwords don't match!!";
    	    }
    	    
    	    return null;
        }
    }
}