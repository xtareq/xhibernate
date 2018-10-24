import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="banks_table")
public class Bank {
    @Id
    @Column(name="id")
    @GeneratedValue(generator="incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
