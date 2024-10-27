package presentation;

import dao.DaoImpl;
import dao.IDao;
import ext.DaoImpl2;
import metier.IMetier;
import metier.MetierImpl;

public class Pres2{
    public static void main(String[] args) {

        //Instancier Idao
        IDao dao;
        dao= new DaoImpl();
//        ((DaoImpl) dao).getMe(); // Qualifier
        //instancier Metier
        MetierImpl metier= new MetierImpl();
        metier.setDao(dao);
//        IMetier metier= new MetierImpl();
//        ((MetierImpl)metier).setDao(dao);
        System.out.println(metier.calcul());




    }



}
