package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.Model;

@Entity
public class Lift extends Model {
    @Id
    private Integer id;
    private String name;
    private String region;
 
    private List<Integer> amountSeats = new ArrayList<>();
    private List<Integer> noOneSeats = new ArrayList<>();

    public Lift(String name, String region, Integer numOfSeats) {
        this.name = name;
        this.region = region;
        this.amountSeats.add(numOfSeats);
    }
    
 
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
 
 	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	public static Finder<Integer, Lift> find = new Finder<Integer, Lift>(
	    Integer.class, Lift.class
	);
	
	public List<Integer> eliminateOneSeats(List<Integer> amountSeats) {
	   for(Integer num : amountSeats) {
	       if(num == 1) {
	           amountSeats.remove(num);
	       }
	   } 
	   
	   noOneSeats = amountSeats;
	   
	   return noOneSeats;
	}

}