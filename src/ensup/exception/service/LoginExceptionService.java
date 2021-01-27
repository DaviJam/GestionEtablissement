package ensup.exception.service;

public class LoginExceptionService extends Exception{
    public LoginExceptionService(){
        super();
    }

    public LoginExceptionService(String s){
        super(s);
    }
}
