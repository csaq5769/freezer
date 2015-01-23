package freezer.model;

//password is too short (in case of signing up)
@SuppressWarnings("serial")
class TooShortPasswordException extends Exception{
	TooShortPasswordException() {
		super("password is too short thus not safety! type in a new password - use letters and digits and special characters!");
	}
}
