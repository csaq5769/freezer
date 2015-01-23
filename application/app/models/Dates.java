package models;

import java.util.*;
import javax.persistence.*;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Dates extends Model {
    @Id
    @GeneratedValue
    public Long dateId;
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date timeOfDate; //take class Date of java.util
	public String placeOfDate; //change to lift if possible
	
	@ManyToOne (cascade = CascadeType.REMOVE)
	public List<User> usersToDate = new ArrayList<User>();
	
	public Dates(Date timeOfDate, String placeOfDate, User potentialDates) {
        this.timeOfDate = timeOfDate;
        this.placeOfDate = placeOfDate;
        this.usersToDate.add(potentialDates);
	}

	public static Model.Finder<Long, Dates> find = new Model.Finder(Long.class, Dates.class);

    public static Dates newDate(Date timeOfDate, String placeOfDate, String potentialDate) {
        Dates dates = new Dates(timeOfDate, placeOfDate, User.find.ref(potentialDate));
        //@ManyToOne
        dates.save();
        
        return dates;
    }

    //find particular user in list of potential dates
    public static List<Dates> findDate(String potentialDate) {
        return find.where().eq("usersToDate.email", potentialDate).findList();
    }
}