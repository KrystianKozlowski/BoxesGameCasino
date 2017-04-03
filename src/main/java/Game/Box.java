package Game;

/**
 * Created by Krystian on 2017-03-16.
 */
public class Box {

    private boolean isOpen;
    private String bounty;

    public Box() {
        isOpen = false;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public String getBounty() {
        return bounty;
    }

    public void setBounty(String bounty) {
        this.bounty = bounty;
    }

    public void open(){
        isOpen = true;
    }

}
