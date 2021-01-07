package ensup.service;

public interface IServiceConnection
{
    // Checker ID MDP, Mot de passe oublié
    int checkConnection(String mail, String mdp);
}
