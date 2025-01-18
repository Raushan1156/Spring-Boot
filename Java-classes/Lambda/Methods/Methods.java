package Methods;

// This class covers the boxing and unboxing concept.

public  class Methods {
    public static void  main(String [] args){
        System.out.println("Hello world");

        // boxing
        int a=5;
        System.out.println("This is boxing:"+Integer.valueOf(a));

        // Auto-boxing
        Integer b=a;
        System.out.println("Auto-boxing:"+b);

        // unboxing
        Integer c = Integer.valueOf("10");
        int d = c.intValue();
        System.out.println("unboxing:"+d);

        //Auto-unboxing
        int e=c;
        System.out.println("Auto-unboxing:"+e);
    }
}