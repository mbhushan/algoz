
public class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The class method in Cat.");
    }
//    public void testInstanceMethod() {
//        System.out.println("The instance method in Cat.");
//    }

    public static void main(String[] args) {
        
        Animal myAnimal = new Cat();
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
        
        System.out.println();
        Cat myCat = (Cat)new Animal();
        myCat.testInstanceMethod();
        Cat.testClassMethod();
    }
}
