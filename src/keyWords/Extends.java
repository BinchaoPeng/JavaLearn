package keyWords;


public class Extends {
    /**
     * 内部静态类，可以 被继承
     */
    private static class StaticPara {
        public String val = "StaticPara";

        public Extends get() {
            return new Extends();
        }
    }

    class StaticChild extends StaticPara {
        @Override
        public Extends get() {
            return super.get();
        }
    }
}
