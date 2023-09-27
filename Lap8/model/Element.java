package Lap8.model;

public class Element {
  
    private String s;

    public Element(String s) {
        this.s = s;
    }

    public Element() {
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Element{" + "s=" + s + '}';
    }
    
}

