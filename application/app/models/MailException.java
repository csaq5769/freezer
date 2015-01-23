package freezer.model;

//if email-address isn't a correct one - wrong signature
@SuppressWarnings("serial")
class MailException extends Exception {
	MailException() {
		super("this is not an correct e-mail address! Verify your address.");
	}
}
