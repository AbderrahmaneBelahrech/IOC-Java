package dao;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class DaoImpl implements IDao{

       public double getData(){
        System.out.println("Version de base de donnees");
        return 1;
    }
    public double getMe(){
        System.out.println("Vme");
        return 1;
    }

}
