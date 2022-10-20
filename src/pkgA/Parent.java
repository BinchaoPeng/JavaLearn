package pkgA;

/**
 * @author pbc
 */
public class Parent {
    public String pub;
    private int pri;
    protected double dou;
    char def;
    final String fina = "final";

    static String stati;

    private class PriClazz {
        public String s;
    }

    class Iner extends Parent {
        @Override
        public void pubFunc() {
            super.pubFunc();
        }

        @Override
        protected void proFunc() {
            super.proFunc();
        }

        @Override
        void defFunc() {
            super.defFunc();
        }


    }

    public static void staticFunc() {

    }

    public void pubFunc() {

    }

    protected void proFunc() {

    }

    private void priFunc() {

    }

    void defFunc() {

    }

    public float defFunc(int a) {

        return 1.1f;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public int getPri() {
        return pri;
    }

    public void setPri(int pri) {
        this.pri = pri;
    }

    public double getDou() {
        return dou;
    }

    public void setDou(double dou) {
        this.dou = dou;
    }

    public char getDef() {
        return def;
    }

    public void setDef(char def) {
        this.def = def;
    }

    public String getFina() {
        return fina;
    }

    public static String getStati() {
        return stati;
    }

    public static void setStati(String stati) {
        Parent.stati = stati;
    }
}

