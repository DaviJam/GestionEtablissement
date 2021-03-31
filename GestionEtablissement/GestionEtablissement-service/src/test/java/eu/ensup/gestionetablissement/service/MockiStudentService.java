package eu.ensup.gestionetablissement.service;

import eu.ensup.gestionetablissement.business.Course;
import eu.ensup.gestionetablissement.dao.CourseDao;
import eu.ensup.gestionetablissement.dao.ExceptionDao;
import eu.ensup.gestionetablissement.dao.ICourseDao;
import eu.ensup.gestionetablissement.dto.CourseDTO;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// 3) Créer une classe de test
// 4) On annote la classe avec @RunWith(MockitoJUnitRunner.class)

@RunWith(MockitoJUnitRunner.class)
public class MockiStudentService {

    // 5) Ajouter une propriété de type interface dans la classe de test
    // 6) Annoter la propriété de type interface avec @Mock
    @Mock
    ICourseDao mockDao;

    // 7) Ajouter une propriété de type service dans la classe de test
    // 8) On annote la propriété service avec @InjectMocks
    @InjectMocks
    CourseService service;

    // 9) On créer une méthode de test avec l'annotations @Test (Choisir la bonne version de Junit)
    @Test
    public void testGetOneCourse() throws ExceptionDao, ExceptionService {
        // 10) Créer le stubbing pour le mock
        // On utilise le stubbing. Le stubbing est une technique permettant d’imposer un comportement à un mock. .Quand le service va appeller la méthode du dao get(1) le dao va lui retourner le nouveau course qui a pour sujet math, nombre d'heure 1 et id 1.
        when(mockDao.get(1)).thenReturn(new Course("Math", 1, 1));

        // 11) Soliciter le service
        // Je déclare une variable c de Type CourseDTO. Je lui affecte le résultat de la méthode get(1) du service
        CourseDTO c = service.get(1);

        // Je vérifie que le sujet du cours est bien "Math"
        assertEquals(c.getCourseSubject(), "Math");

        // 12) Vérifier que le mock à été utilisé
        // Je vérifie que mon avec la méthode get(1) de mon mock a bien été utilisé
        Mockito.verify(mockDao).get(1);
    }

    // 13) Exécuter le test

    @AfterEach
    public void afterEach(){mockDao = null;}

}
