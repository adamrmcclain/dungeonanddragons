package com.mcclain.service;

import com.mcclain.config.SecretSantaConfig;
import com.mcclain.model.Person;
import junit.framework.TestCase;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SecretSantaServiceTest extends TestCase {

    SecretSantaService secretSantaService;

    @Mock
    SecretSantaConfig secretSantaConfig;

    public void setUp() throws Exception {
        super.setUp();
        initMocks(this);

        when(secretSantaConfig.getFilePath()).thenReturn("something");

        secretSantaService = new SecretSantaService(secretSantaConfig);
    }

    public void testGetSecretSantaList() throws Exception {

    }

    public void testPopulateReceiver() throws Exception {

    }

    public void testGenerateReceiver() throws Exception {

    }

    public void testFilterReceiver() throws Exception {

    }

    public void testEvaluateExclusion() throws Exception {

    }

    public void testGetObjectValue() throws Exception {
        Person person = new Person("Joe", "Doe", "joe.doe");
        String firstName = secretSantaService.getObjectValue(person, "firstName");
        String lastName = secretSantaService.getObjectValue(person, "lastName");
        String facebookId = secretSantaService.getObjectValue(person, "facebookId");

        assertEquals("Joe", firstName);
        assertEquals("Doe", lastName);
        assertEquals("joe.doe", facebookId);
    }
}