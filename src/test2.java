public class test2 {

    int dotPos;
    int pos;

    private long GCD(long a, long b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    int getPos(char str[], char c) {
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i] == c) {
                return i;
            }
        }
        return -1;
    }

    int isDig(char str[]) {
        for (int i = dotPos + 1; i < str.length - 1; i++) {
            if (str[i] < 0 || str[i] > 9) {
                return i;
            }
        }
        return -1;
    }


}
