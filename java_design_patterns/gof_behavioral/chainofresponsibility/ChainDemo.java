// package java_design_patterns.gof_behavioral.chainofresponsibility;

abstract class Chain {
    protected Chain nextChain;

    public void setNext(Chain nextChain) {
        this.nextChain = nextChain;
    }

    abstract public String process(int number);
}

class ZeroProcessor extends Chain {
    public String process(int number) {
        if(number == 0)
            return "ZeroProcessor : " + number;
            
        return this.nextChain.process(number);
    }
}

class NegativeProcessor extends Chain {
    public String process(int number) {
        if(number < 0)
            return "NegativeProcessor : " + number;
            
        return this.nextChain.process(number);
    }
}

class PositiveProcessor extends Chain {
    public String process(int number) {
        if(number > 0)
            return "PositiveProcessor : " + number;
            
        return this.nextChain.process(number);
    }
}

public class ChainDemo {
    public static void main(String[] args) {

        //Configure Chain of Responsibility
        Chain c1 = new NegativeProcessor();
        Chain c2 = new ZeroProcessor();
        Chain c3 = new PositiveProcessor();

        c1.setNext(c2);
        c2.setNext(c3);

        //Calling Chain of Responsibility
        System.out.println( c1.process(68) );
        System.out.println( c1.process(-86) );
        c1.process(0);
        c1.process(156);
    }
}