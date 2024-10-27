package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class presSpringXml {
    public static void main(String[] args) {
        ApplicationContext springContext= new ClassPathXmlApplicationContext("Config.xml");
        IMetier metier = springContext.getBean(IMetier.class);
        System.out.println("RES"+metier.calcul());



    }
}
