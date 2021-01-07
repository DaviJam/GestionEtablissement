package ensup.service;	

import ensup.business.School;

public interface IServiceSchool extends IService<School>
{
    int create(String surname, String email, String address, String phone, int director);
    int update(String surname, String email, String address, String phone, int director);
    public int getIndex( String surname );
}
