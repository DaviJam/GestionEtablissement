package ensup.service;

public interface IServiceConnection {
    // Checker ID MDP, Mot de passe oublié
    boolean getConnection(String mail, String mdp);
}
