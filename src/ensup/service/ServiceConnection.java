package ensup.service;

import ensup.dao.DaoLogin;

public class ServiceConnection implements IServiceConnection{
    private DaoLogin dao = new DaoLogin();

    @Override
    public boolean checkConnection(String mail, String mdp) {
        int password = this.dao.checkPassword(mail, mdp); // Récupération du MDP et comparaison avec le mdp saisi

        if(password == 1){
            return true;
        } else if (password == -1)
        {
            // TODO Log
            return false;
        }
        else{
            return false;
        }
    }
}
