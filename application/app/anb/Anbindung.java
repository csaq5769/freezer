package anb;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import models.Lift;
import models.Location;
import models.User;

import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import play.db.ebean.Model;

import utils.Util;

public final class Anbindung {
	public static Lift getLift(String name) {
		return new Model.Finder<String, Lift>(String.class, Lift.class).where(Expr.eq("name", name)).findUnique();
	}
	
	public static User getUser(String username) {
		return new Model.Finder<String, User>(String.class, User.class).where(Expr.eq("username", username)).findUnique();
	}
	
	public static List<User> getUsers () {
		return new Model.Finder<String, User>(String.class, User.class).all();
	
	}
	public static List<Lift> getLifts() {
		return new Model.Finder<>(String.class, Lift.class).all();
	}
	
	public static List<Lift> getLifts(String region) {
		return new Model.Finder<>(String.class, Lift.class).where(Expr.eq("village", region)).findList();
	}
	
	public static void addUser(User user) {
		user.save();
	}

	//updates the interests of each user
	public static void updateInterests() {
		List<User> users = getUsers();
		for (User u : users) {
			u.updateInterests();
		}
	}

	//reads the xls-file with office automation
	public static void readSpreadsheet() {
		try {
			File file = File.createTempFile("baum", "warum");
			FileUtils.copyURLToFile(new URL(readLift.liftFile), file);
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			for (int i = 3; i < sheet.getRows(); i++) { 
				if (sheet.getCell(8, i).getContents().equalsIgnoreCase("nein") && !sheet.getCell(2, i).getContents().equals("")) {
					int id = Integer.parseInt(sheet.getCell(1, i).getContents());
					String name = sheet.getCell(0, i).getContents();
					String region = sheet.getCell(3, i).getContents();
					int maxPersons;
					if (sheet.getCell(14, i).getContents().equals("")) {
						maxPersons = 0;
					} else {
						maxPersons = Integer.parseInt(sheet.getCell(14, i)).getValue());
					}
					
					Lift thatone = getLift(name);
					if (thatone == null) {
						Lift lift = new Lift(name, location, type, maxPersons, seatHeating, weatherProtection);
						lift.save();
					} else {
						thatone.id = id;
						thatone.name = name;
						thatone.region = region;
					}
				}
			}
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}