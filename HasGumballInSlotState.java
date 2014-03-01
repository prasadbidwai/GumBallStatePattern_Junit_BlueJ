
/**
 * Write a description of class HasGumballInSlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HasGumballInSlotState implements State
{
    GumballMachine gumballMachine;
 
    public HasGumballInSlotState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
       
    public void insertCoin(int coin) {
        //System.out.println("Please take gumball from the slot first and then insert coin.");
        gumballMachine.getHasCoinState().insertCoin(coin);
        gumballMachine.setState(gumballMachine.getHasCoinState());

    }
 
    public void ejectCoin() {
        System.out.println("No coins to eject. Please take gumball from the slot");
    }
 
    public void turnCrank() {
        System.out.println("Please take gumball from the slot first.");
    }
 
    public void dispense() {
            System.out.println("One gumball already in slot");
    }
 
    public String toString() {
        return "Gumball in slot";
    }
    
    public void takeGumball() {
            System.out.println(gumballMachine.getNumOfGumballInSlot()+ " Gumball taken from slot.");
            gumballMachine.setNumOfGumballInSlot(0);
            gumballMachine.setState(gumballMachine.getNoCoinState());
    }
}
