public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        boolean first = l.changeCode("1234", "5678");
        System.out.println("l.changeCode(\"1234\", \"5678\") -> " + (first ? "success" : "rejected"));

        boolean second = l.changeCode("0000", "9999");
        System.out.println("l.changeCode(\"0000\", \"9999\") -> " + (second ? "success" : "rejected, code is still \"5678\""));
    }
}
