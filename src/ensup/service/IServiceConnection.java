package ensup.service;

import ensup.business.Person;

public interface IServiceConnection
{
    // Checker ID MDP, Mot de passe oublié
    Person checkConnection(String mail, String mdp);
}
