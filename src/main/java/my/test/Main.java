package my.test;

import my.test.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public void test(Class... classes) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        for (Class clazz :classes ){
            test1(clazz);
        }
    }

    private void test1(Class clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
//        Object instance = cl.newInstance();
        // Method[] publicMethods = cl.getMethods();
        List<Method> publicMethods = Stream.of(clazz.getMethods()).filter(method ->
                method.getReturnType() == void.class
                        && method.getParameterTypes().length == 0
                        && method.getAnnotation(Test.class) != null)
                .collect(Collectors.toList());

        if(publicMethods.size() == 0 ){
            return;
        }


        ClassLoader loader = ClassLoader.getSystemClassLoader();
        loader.setDefaultAssertionStatus(true);
        Class<?> c = loader.loadClass(clazz.getName());
        Object instance = clazz.newInstance();
        for (Method method : publicMethods) {
            try {
                method.invoke(instance);
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        new Main().test(MessageService.class,MessageService.class);

        System.out.println("sdfdfsd");

        new MessageService().ff1111();


    }


}
