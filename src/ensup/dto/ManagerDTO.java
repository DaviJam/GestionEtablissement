package ensup.dto;

import ensup.business.Role;

public class ManagerDTO extends PersonDTO {
    /**
     * Instantiates a new Manager.
     *
     * @param lastname     the lastname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param id          the id
     * @param firstname   the firstname
     * @param password    the password
     */
    public ManagerDTO(String lastname, String mailAddress, String address, String phoneNumber, int id, String firstname, Role role, String password) {
        super(lastname, mailAddress, address, phoneNumber, id, firstname, role, password);
    }

    public ManagerDTO(String lastname, String mailAddress, String address, String phoneNumber, String firstname, Role role, String password) {
        super(lastname, mailAddress, address, phoneNumber, firstname, role, password);
    }

    public ManagerDTO(String lastname, String mailAddress, String address, String phoneNumber, int id, String firstname, String password) {
        super(lastname, mailAddress, address, phoneNumber, id, firstname, Role.MANAGER, password);
    }

    public ManagerDTO(String lastname, String mailAddress, String address, String phoneNumber, String firstname, String password) {
        super(lastname, mailAddress, address, phoneNumber, firstname, Role.MANAGER, password);
    }
    /**
     * Instantiates a new ManagerDTO.
     *
     * @param lastname     the lastname
     * @param mailAddress the mail address
     * @param id          the id
     * @param firstname   the firstname
     * @param password    the password
     */
    public ManagerDTO(String lastname, String mailAddress, int id, String firstname, String password) {
        super(lastname, mailAddress, id, firstname, password);
    }

    public ManagerDTO() {

    }

    @Override
    public String toString() {
        String res = super.toString();
        res = res.replace("Person", "ManagerDTO");

        return res;
    }
}
