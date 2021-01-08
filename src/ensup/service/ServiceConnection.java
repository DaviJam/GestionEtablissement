package ensup.service;

import ensup.dao.DaoLogin;
import ensup.dao.DaoPerson;

/**
 * The type Service connection.
 */
public class ServiceConnection implements IServiceConnection{
    private DaoLogin dao = new DaoLogin();
    private DaoPerson daopers = new DaoPerson();

    @Override
    public int checkConnection(String mail, String mdp) {
        int index = this.dao.checkPassword(mail, mdp); // Récupération du MDP et comparaison avec le mdp saisi
        return index;
    }
}
