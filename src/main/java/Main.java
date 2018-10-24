import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {


    public static void main(String[] args) {
        //entitmanagerfactory by persistance

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        //Instancite client

        Client client = new Client();
        client.setId(3);
        client.setName("Hossain");

        //new Bank

        Bank bank = new Bank();
        bank.setName("HSBC");


        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //begain transection

        entityManager.getTransaction().begin();

        //persist bank and client

        entityManager.persist(bank);
        entityManager.persist(client);

        //commiting transaction

        entityManager.getTransaction().commit();

        entityManagerFactory.close();
    }
}
