import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        //entitmanagerfactory by persistance

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        //Instancite client
        Bank bank = new Bank();
        bank.setName("AB");


        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //begain transection

        entityManager.getTransaction().begin();

        //Retrive object by primary key
         entityManager.persist(bank);

        Bank bnk = entityManager.find(Bank.class,bank.getId());

        System.out.println("Got "+ bank.getName() +" "+ bnk.getId());


        //fetch all bank

        //@SuppressWarnings("unchecked")

       //List<Bank> bankList = entityManager.createQuery("from banks_table").getResultList();

        List<Bank> bankList = entityManager.createQuery("select e from Bank e").getResultList();

        if (bankList == null){
            System.out.println("Not data Found");
        }else{
            for (Bank banko:bankList)
            {
                System.out.println("Bank Name: "+ banko.getName());
            }
        }

        //commiting transaction

        entityManager.getTransaction().commit();

        entityManagerFactory.close();
    }
}
