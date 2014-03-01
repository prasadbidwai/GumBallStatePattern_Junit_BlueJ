

import java.util.Random;

public class HasCoinState implements State {
    GumballMachine gumballMachine;
   
 
    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    public void insertCoin(int coin) {
        gumballMachine.setCurrentValueOfInsertedCoins(gumballMachine.getCurrentValueOfInsertedCoins()+ coin);
        System.out.println("A coin has been inserted.Total money inserted is: "+gumballMachine.getCurrentValueOfInsertedCoins()+" cents");
    }
 
    public void ejectCoin() {
        System.out.println("ejecting the coins...");
        gumballMachine.setState(gumballMachine.getNoCoinState());
        gumballMachine.setCurrentValueOfInsertedCoins(0);
    }
 
    public void turnCrank() {
        System.out.println("crank turned...");
        if(gumballMachine.getCurrentValueOfInsertedCoins() - GumballMachine.gumballPrice < 0) {
            System.out.println("you inserted only "+gumballMachine.getCurrentValueOfInsertedCoins()+ " cents. you need at least 50 cents to get gumball.");
        }else {
            gumballMachine.setState(gumballMachine.getSoldState());
        } 
    }

    public void dispense() {
        System.out.println("no gumball dispenesed");
    }
 
    public String toString() {
        return "waiting for turn of crank";
    }
    
    public void takeGumball(){
        if(gumballMachine.getNumOfGumballInSlot() > 0) {
            System.out.println(gumballMachine.getNumOfGumballInSlot()+ " gumball has been picked up from slot.");
            gumballMachine.setNumOfGumballInSlot(0);
        } else {
            System.out.println("there are no gumballs left in slot");
        }
    }
}
