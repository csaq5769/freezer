package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.Model;


@Entity
public class Interests extends Model {	
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    
    //List<Users> users = new ArrayList<>();
  
    public Interests(String name) {
        super();
        this.name = name;
    }
    
    
    public static Model.Finder<Integer, Interests> find = new Model.Finder(Integer.class, Interests.class);


    public void initInterests() {
        new Interests("sport").save();
        new Interests("baby cats").save();
        new Interests("rock/metal").save();
        new Interests("actionmovies").save();
        new Interests("nature").save();
        new Interests("computergames").save();
    }
    
    public boolean getSameInterests(List<Interests> interestsOfPerson1, List<Interests> interestsOfPerson2) {
        int countMatch = 0;
        for(Interests interest : interestsOfPerson1) {
            if(interestsOfPerson2.contains(interest)) {
                countMatch++;
            }
        }
        
        if(countMatch != 0) {
            return true;
        } else return false;
    }

}