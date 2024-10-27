package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component
public class DaoImpl2 implements IDao {
       public double getData(){
        System.out.println("Version de web service");
        return 2;
    }

}
