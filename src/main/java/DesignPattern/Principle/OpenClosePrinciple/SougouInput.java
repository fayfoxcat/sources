package DesignPattern.Principle.OpenClosePrinciple;

public class SougouInput {

    private Skin skin;

    public void setSkin(Skin skin){
        this.skin = skin;
    }

    public void display(){
        skin.display();
    }
}
