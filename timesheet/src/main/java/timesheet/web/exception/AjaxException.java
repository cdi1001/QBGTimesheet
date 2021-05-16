package timesheet.web.exception;


public class AjaxException extends RuntimeException {

    private int status;
    private String exception;

    public AjaxException(int status, String exception) {
        this.status = status;
        this.exception = exception;
    }

    @Override
    public String getMessage() {
        return status + " " + exception;
    }
}
