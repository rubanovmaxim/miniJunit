package my.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MiniJUnitMain {

    private static ClassLoader loader = ClassLoader.getSystemClassLoader();

    public static void test(Class... classes) {
        MiniJUnitMain miniJUnitMain = new MiniJUnitMain();
        //устанавливаем свойство для срабатывания assert
        loader.setDefaultAssertionStatus(true);

        for (Class clazz : classes) {
            try {
                miniJUnitMain.testClass(clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void testClass(Class clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        //выбираем все Public методы с пустыми параметрами и возвращаемым значением void, которые помечены нашей аннотацией @Test
        List<Method> publicMethods = Stream.of(clazz.getMethods()).filter(method ->
                method.getReturnType() == void.class
                        && method.getParameterTypes().length == 0
                        && method.getAnnotation(my.test.annotation.Test.class) != null)
                .collect(Collectors.toList());

        if (publicMethods.size() == 0) {
            return;
        }


        loader.loadClass(clazz.getName());
        Object instance = clazz.newInstance();
        // запускаем все методу, подходящие для теста
        for (Method method : publicMethods) {
            try {
                method.invoke(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
//        new MiniJUnitMain().test(MessageService.class, MessageService.class);
//
//        System.out.println("sdfdfsd");
//
//        new MessageService().ff1111();


    }


}
