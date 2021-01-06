package ensup.service;

public interface IServiceConnection {
    // Checker ID MDP, Mot de passe oublié
    int GetConnection(String mail, String mdp);
    void UpdatePassword(String mail, String mdp);
}
