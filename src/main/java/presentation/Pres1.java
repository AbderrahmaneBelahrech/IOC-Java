package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres1 {
    public static void main(String[] args) {
        try {
            // Chargement du nom de la classe Dao depuis le fichier de configuration
//            Scanner scanner = new Scanner(new File("Configure.txt"));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Dao:");
            String daoClassName = scanner.nextLine();
            Class<?> cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();
            System.out.println("aaa");
            System.out.println("Données du Dao : " + dao.getData());
            System.out.println("aaa");
            // Chargement du nom de la classe Metier depuis le fichier de configuration
            System.out.println("Metieer:");
            String metierClassName = scanner.nextLine();
            Class<?> cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getConstructor().newInstance();
//            IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);


            // Injection de la dépendance Dao dans Metier via la méthode setDao
            Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);

            // Calcul avec l'instance de Metier
            System.out.println("Calcul avec MetierImpl : " + metier.calcul());


        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Classe spécifiée dans Configure.txt non trouvée.");
        } catch (NoSuchMethodException e) {
            System.out.println("Erreur : Méthode setDao non trouvée dans la classe Metier.");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Erreur lors de l'instanciation ou de l'invocation de la méthode.");
            e.printStackTrace();
        }
    }
}
