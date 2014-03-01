

public class SoldOutState implements State {
    GumballMachine gumballMachine;
 
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin(int coin) {
		System.out.println("You can't insert a quarter, the machine is sold out");
	}
 
	public void ejectCoin() {
		System.out.println("You can't eject, you haven't inserted a quarter yet");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
		gumballMachine.releaseChange();
	}
 
	public void dispense() {
		System.out.println("No gumball dispensed");
	}
 
	public String toString() {
		return "sold out";
	}
	
	public void takeGumball() {
	    if(gumballMachine.getNumOfGumballInSlot() > 0) {
            System.out.println(gumballMachine.getNumOfGumballInSlot()+ " Gumball taken from slot.");
            gumballMachine.setNumOfGumballInSlot(0);
            gumballMachine.setState(gumballMachine.getNoCoinState());
        } else {
            System.out.println("No Gumball in slot.");
        }
	}
}
