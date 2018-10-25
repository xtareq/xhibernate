import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {

    public static void main(String[] args) {
        //Bank bank = new Bank();


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Bank bank;

        try{
           bank = entityManager.find(Bank.class,3);
            System.out.println("Name :" + bank.getName());

            entityManager.getTransaction().begin();
            entityManager.remove(bank);
            entityManager.getTransaction().commit();

            System.out.println("Data Removed Successfully");
        }catch (NullPointerException e)
        {
            System.out.println("Error: "+ e);
        }





        entityManager.close();
        entityManagerFactory.close();




    }
}
