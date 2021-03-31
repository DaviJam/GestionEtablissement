package eu.ensup.gestionetablissement.service;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoTest {

    @Test
    public void mockitoTest()
    {
        List mockedList = mock(List.class);
        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();
        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void mockitoTest2()
    {
        LinkedList theMockedList = mock(LinkedList.class);

        when(theMockedList.get(0)).thenReturn("toto");
        when(theMockedList.contains("")).thenReturn(false);

        assertEquals( "toto", theMockedList.get(0));
        assertEquals( false, theMockedList.contains(""));

        verify(theMockedList).contains("");
        verify(theMockedList).get(0);
    }

}
