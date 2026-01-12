package kt;


class People {
    String name;

    public People() {
        System.out.print(1);
    }

    public People(String name) {
        System.out.print(2);
        this.name = name;
    }
}

public class Teacher extends People {
    private String name = "tom";

    public Teacher() {
        super();
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
    }
}


