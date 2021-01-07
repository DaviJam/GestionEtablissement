package ensup.service;

import ensup.business.Person;
import ensup.dao.DaoLogin;
import ensup.dao.DaoPerson;

public class ServiceConnection implements IServiceConnection{
    private DaoLogin dao = new DaoLogin();
    private DaoPerson daopers = new DaoPerson();

    @Override
    public Person checkConnection(String mail, String mdp) {
        int index = this.dao.checkPassword(mail, mdp); // Récupération du MDP et comparaison avec le mdp saisi
        Person person = this.daopers.get(index); // On créer une personne et on le renvoit a la vue
        return person;
    }
}
