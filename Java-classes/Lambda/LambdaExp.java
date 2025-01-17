public class LambdaExp{
    public static void main(String[] args) {


// Lambda is a anonymous function having
// no name
// no modifier
// no return type

// Reduces the number of line code.
// >It is always and only used with functional interface.
// >Supports paralled and sequential executaion support by passing behaivour as an argument in method
// >use api effectively
// >more readable and concise


// No functional dependency-> no lambda

        test t1=() -> System.out.println("Hello World");
        t1.test();
        // Lambda expression to add two numbers
        Addable ad1 = (a, b) -> (a + b);
        System.out.println(ad1.add(10, 20));

        // Lambda expression to multiply two numbers
        Addable ad2 = (int a, int b) -> (a * b);
        System.out.println(ad2.add(12, 20));

        // Runnable as lambda
        Runnable thread1=()->{
            for(int i=0;i<5;i++){
                System.out.println("Thread-"+i+" is running");
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    System.out.println(e);
                }
            }
            };

            Thread th1=new Thread(thread1);
            th1.start();
    }
    // ()->Sysout.out.println("Hello World");
}