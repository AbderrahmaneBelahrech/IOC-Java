package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres3 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Instaciation dynamique de IDao
        Scanner sc= new Scanner(new File("Configure.txt"));
        String daoClassName = sc.nextLine();
        // Creation de class dans la memoire
        Class<?> cDao = Class.forName(daoClassName);
        // Instanciation de l Object
        IDao dao = (IDao) cDao.getConstructor().newInstance();


        // Instanciation dynamique de Metier
        String metierClassName = sc.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

        // Injection de dependence
        Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);
        setDao.invoke(metier,dao);
        // Calcul avec l'instance de Metier
        System.out.println("Calcul avec MetierImpl : " + metier.calcul());



    }
}
