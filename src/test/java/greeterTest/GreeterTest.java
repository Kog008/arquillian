package greeterTest;

import greeter.Greeter;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class GreeterTest {

    @Deployment
    public static JavaArchive createDeployment() {
        /*
                Möchte man den Archivnamen mit angeben, so sollte man die Dateiendung mit angeben,
                um eine Warnung zu vermeiden. Diese Endung sollte entsprechend mit dem Ausgabevormat übereinstimmen.
         */
        JavaArchive archive = ShrinkWrap
                .create(JavaArchive.class, "arquillian-exercise.jar")
                .addClass(Greeter.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        System.out.println("Archivinhalt \n" + archive.toString(true));

        return archive;
    }

    @Inject
    private Greeter greeter;

    @Test
    public void should_create_greeting() {

        System.out.println("Test: should_create_greeting()");
        greeter.greet(System.out, greeter.createGreeting("Earthling"));

        Assert.assertEquals("Hello Earthling!", greeter.createGreeting("Earthling"));
        Assert.assertNotNull(greeter);
    }

    @Test
    public void check_class() {
        System.out.println("Test: check_class()");
        Assert.assertNotNull(greeter);
        greeter.showParam(greeter.getClass());
    }
}
