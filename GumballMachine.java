
public class GumballMachine implements IGumballMachine {
 
    State soldOutState;
    State noCoinState;
    State hasCoinState;
    State soldState;
    State hasGumballInSlotState;
 
    State state;
    int count = 0;
    int numOfGumballInSlot = 0;
    int currentValueOfInsertedCoins = 0;
    public static final int gumballPrice = 50;
 
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        hasGumballInSlotState = new HasGumballInSlotState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noCoinState;
        } else {
            state = soldOutState;
        }
    }
    
    public int getNumOfGumballInSlot() {
          return this.numOfGumballInSlot;
    }
    
    public void setNumOfGumballInSlot(int numOfGumballInSlot) {
          this.numOfGumballInSlot = numOfGumballInSlot;
    }
    
        public int getCurrentValueOfInsertedCoins() {
          return this.currentValueOfInsertedCoins;
    }
    
    public void setCurrentValueOfInsertedCoins(int currentValueOfInsertedCoins) {
          this.currentValueOfInsertedCoins = currentValueOfInsertedCoins;
    }

    public boolean isGumballInSlot(){
        if(getState().equals(hasGumballInSlotState)) {
            System.out.println("Gumball is present in slot");
            return true;
        }
        System.out.println("No Gumball is present in slot");
        return false;
    }
    
    public void takeGumballFromSlot(){
        state.takeGumball();
    }
 
    public void insertQuarter() {
        state.insertCoin(25);
    }
    
    public void insertDime(){
        state.insertCoin(10);
    }
    public void insertNickel(){
        state.insertCoin(5);
    }
 
    public void ejectCoin() {
        state.ejectCoin();
    }
 
    public void turnCrank() {
        state.turnCrank();
        if(getState().equals(soldState)) {
            state.dispense();
        }
    }

    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        if (count != 0) {
            if(getState().equals(soldState)) {
                System.out.println("A gumball comes rolling out in the slot...");
                count = count - 1;
                this.currentValueOfInsertedCoins -= gumballPrice;
                this.numOfGumballInSlot++;
            }
        } else {
            System.out.println("Sorry! No Gumball to release. Machine is sold out.");
            this.state = soldOutState;
        }
    }
    
    void releaseChange(){
        System.out.println("Releasing change: "+ this.currentValueOfInsertedCoins);
        this.currentValueOfInsertedCoins = 0;
    }
 
    int getCount() {
        return count;
    }
 
    void refill(int count) {
        this.count = count;
        state = noCoinState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }
    
    public State getHasGumballInSlotState() {
        return hasGumballInSlotState;
    }

    public State getSoldState() {
        return soldState;
    }
 
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
