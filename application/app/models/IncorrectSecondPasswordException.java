package freezer.model;

//second password is incorrect when signing up
@SuppressWarnings("serial")
class IncorrectSecondPasswordException extends Exception{
	IncorrectSecondPasswordException() {
		super("passwords do not match! type it in again to be sure it is the password you wanted to use!");
	}
}
