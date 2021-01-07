package ensup.service;	

import ensup.business.School;

public interface IServiceSchool extends IService<School>
{
    /**
     * @param surname name of the school
     * @param email
     * @param address
     * @param phone
     * @param director
     * @return type of the result
     */
    int create(String surname, String email, String address, String phone, int director);
    
    /**
     * @param surname
     * @param email
     * @param address
     * @param phone
     * @param director
     * @return type of the result
     */
    int update(String surname, String email, String address, String phone, int director);
    
    /**
     * Get the index of the school by this name
     * 
     * @param surname name of the school
     * @return index of the School
     */
    public int getIndex( String surname );
}
