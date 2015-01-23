package freezer.model;

//password is incorrect when signing in
@SuppressWarnings("serial")
class IncorrectPasswordException extends Exception {
	IncorrectPasswordException() {
		super("incorrect password!");
	}
}
