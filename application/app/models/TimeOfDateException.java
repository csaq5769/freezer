package freezer.model;

@SuppressWarnings("serial")
//if person already has a date at a time he/she wants to take another one
class TimeOfDateException extends Exception {
	TimeOfDateException() {
		super("you already have a date at this time! Look for another day to meet with this person :)");
	}
}
