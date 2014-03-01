

public class SoldState implements State {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
       
    public void insertCoin(int coin) {
        System.out.println("Please wait, we're already giving you a gumball");
    }
 
    public void ejectCoin() {
        System.out.println("Sorry, you already turned the crank");
    }
 
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }
 
    public void dispense() {
        if (gumballMachine.getCount() > 0) {
            gumballMachine.releaseBall();
            if(gumballMachine.getCurrentValueOfInsertedCoins() > 0) {
                gumballMachine.releaseChange();
            } 
            gumballMachine.setState(gumballMachine.getHasGumballInSlotState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.releaseChange();
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
 
    public String toString() {
        return "dispensing a gumball";
    }
    
    public void takeGumball() {
        System.out.println("Please wait, we're already giving you a gumball");
    }
}


