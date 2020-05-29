package java_android.enum_;

public enum Weekend {
    Saturday,
    Sunday;

    Weekend() {
    }


    @Override
    public String toString() {
        return "fun day " + (this.ordinal() + 1);
    }

    public static void main(String[] args) {
        System.out.println(Weekend.Saturday);
        System.out.println(Weekend.Saturday);

        System.out.println(Weekend.Saturday.getClass());

        System.out.println(Weekend.Saturday.getClass().getName());
        for (Weekend w : Weekend.values()) {
            System.out.println(w.name() + ": " + w);
        }

    }
}