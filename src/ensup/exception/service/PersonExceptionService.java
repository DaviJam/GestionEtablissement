package ensup.exception.service;

public class PersonExceptionService extends Exception{
    public PersonExceptionService(){
        super();
    }

    public PersonExceptionService(String s){
        super(s);
    }
}
