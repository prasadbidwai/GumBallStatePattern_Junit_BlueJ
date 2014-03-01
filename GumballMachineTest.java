

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GumballMachineTest
{
    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void normal_scenario()
    {
        GumballMachine gumballM1 = new GumballMachine(1);
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        gumballM1.takeGumballFromSlot();
        gumballM1.turnCrank();
    }

    @Test
    public void given_scenario1st()
    {
        GumballMachine gumballM1 = new GumballMachine(1);
        gumballM1.insertNickel();
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        gumballM1.takeGumballFromSlot();
    }

    @Test
    public void given_scenario2nd()
    {
        GumballMachine gumballM1 = new GumballMachine(2);
        gumballM1.insertDime();
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        gumballM1.takeGumballFromSlot();
    }

    @Test
    public void given_scenario3rd()
    {
        GumballMachine gumballM1 = new GumballMachine(1);
        gumballM1.insertDime();
        gumballM1.insertNickel();
        gumballM1.insertNickel();
        gumballM1.turnCrank();
    }

    @Test
    public void releasing_change()
    {
        GumballMachine gumballM1 = new GumballMachine(1);
        gumballM1.insertQuarter();
        gumballM1.insertNickel();
        gumballM1.insertDime();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        gumballM1.takeGumballFromSlot();
    }

    @Test
    public void nogumballs_left_test()
    {
        GumballMachine gumballM1 = new GumballMachine(1);
        gumballM1.insertQuarter();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        gumballM1.takeGumballFromSlot();
        gumballM1.insertQuarter();
    }
}






