package ensup.service;

import ensup.dao.DaoLogin;

public class ServiceConnection implements IServiceConnection{
    private DaoLogin dao = new DaoLogin();

    @Override
    public boolean GetConnection(String mail, String mdp) {
        String password = this.dao.getPassword(mail); // Récupération du MDP et comparaison avec le mdp saisi
        return password.equals(mdp);
    }



}
