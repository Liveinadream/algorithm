public class SwitchWithNull {
    public static void main(String args[]) {
        String gender = null;
        switch (gender+"") {
            case "女":
                System.out.print("女");
                break;
            default:
                System.out.print("保密");
                break;

        }

    }
}
