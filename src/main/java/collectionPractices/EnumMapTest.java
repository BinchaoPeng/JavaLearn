package collectionPractices;

import java.util.Comparator;

public class EnumMapTest {
    enum Weekday {
        SUN(1), MON(2), TUE(3), WED(4), THU(5), FRI(6), SAT(7);
        /**
         * 添加额外属性
         */
        public final int dayValue;

        // 不能有这个构造方法，会报错
//        private Weekday(){
//
//        }

        private Weekday(int dayValue) {
            this.dayValue = dayValue;
        }
    }


    public static void main(String[] args) {
        new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };


    }
}
