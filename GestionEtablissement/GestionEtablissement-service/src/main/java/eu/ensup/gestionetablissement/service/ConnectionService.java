package eu.ensup.gestionetablissement.service;

import eu.ensup.gestionetablissement.dao.LoginDao;
import eu.ensup.gestionetablissement.dao.ExceptionDao;

import static eu.ensup.gestionetablissement.service.IService.serviceLogger;

/**
 * The type Service connection.
 */
public class ConnectionService implements IConnectionService {
    private LoginDao dao = new LoginDao();
    // nom de la classe
    String className = getClass().getName();
    
    @Override
    public int checkConnection(String mail, String mdp) throws ExceptionService {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        int index;
        try {
            index = this.dao.checkPassword(mail, mdp); // Récupération du MDP et comparaison avec le mdp saisi
            serviceLogger.logServiceInfo(className, methodName,"Le mot de passe utilisateur "+mail+" est correct.");
        } catch (ExceptionDao e){
            serviceLogger.logServiceError(className, methodName,"Le mot de passe utilisateur est incorrect.");
            throw new ExceptionService(e.getMessage());
        } finally {

        }
        return index;
    }
}
