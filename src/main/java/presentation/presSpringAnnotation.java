package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class presSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext springContext= new AnnotationConfigApplicationContext("dao","ext","metier");
        IMetier metier = springContext.getBean(IMetier.class);
        System.out.println("RES"+metier.calcul());



    }
}
