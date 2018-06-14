package java8;

interface FunctionalInterfaceTest{
void display();
default void method(){
    System.out.println("Default Method");
}
static void method2(){
    System.out.println("Static method");
}
}

public class FunctionalInterfaceTestImpl {
    public static void main(String[] args) {
        FunctionalInterfaceTest test = ()-> System.out.println("Functional Interface");
        test.display();
        test.method();
        FunctionalInterfaceTest.method2();
    }
}
