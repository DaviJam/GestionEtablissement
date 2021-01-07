package ensup.service;

public interface IServiceConnection {
    // Checker ID MDP, Mot de passe oublié
    boolean GetConnection(String mail, String mdp);
}
