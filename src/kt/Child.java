package kt;

public class Child extends People {
    People father;
    static String s = "ads";

    public Child(String name) {
        System.out.print(3);
        this.name = name;
        father = new People(name + ":F");
    }

    public Child() {
        System.out.print(4);

    }

    public void aa(){
    }

    public void bb(){
        this.aa();
    }

    static abstract class My {

    }
}
