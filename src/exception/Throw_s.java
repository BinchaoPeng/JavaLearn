package exception;

import java.io.IOException;

@SuppressWarnings("all")
public class Throw_s {

    public void throw_() throws IOException {

    }

    public void throw_1() {
        try {
            this.throw_();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


class Throw extends Throw_s {
    @Override
    public void throw_() {
        System.out.println("throw in child class");

    }

    public static void main(String[] args) {
        Throw t = new Throw();
        t.throw_();
    }
}