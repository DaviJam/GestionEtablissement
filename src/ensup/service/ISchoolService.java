package ensup.service;	

import ensup.business.School;

/**
 * The interface Service school.
 */
public interface ISchoolService extends IService<School>
{
    /**
     * Create int.
     *
     * @param surname  name of the school
     * @param email    the email
     * @param address  the address
     * @param phone    the phone
     * @param director the director
     * @return type of the result
     */
    int create(String surname, String email, String address, String phone, int director);

    /**
     * Update int.
     *
     * @param surname  the surname
     * @param email    the email
     * @param address  the address
     * @param phone    the phone
     * @param director the director
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
