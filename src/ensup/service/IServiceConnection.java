package ensup.service;

public interface IServiceConnection
{
    // Checker ID MDP, Mot de passe oublié
    boolean checkConnection(String mail, String mdp);
}
