package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;

public class Secured extends Security.Authentictor {
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }
    
    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.Application.signin());
    }

}