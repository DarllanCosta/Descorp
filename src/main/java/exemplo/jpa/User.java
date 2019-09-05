package exemplo.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Access(AccessType.FIELD)
@Table(name = "USER_TABLE")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "TXT_NAME", length = 50, nullable = false)
    String name;
    @Column(name = "USERNAME", length = 50, nullable = false, unique = true)
    String username;
    @Column(name = "PASSWORD", length = 20, nullable = false)
    String password;
    @Column(name = "TXT_PHONE", length = 20)
    String phone;
    @Column(name = "TXT_EMAIL", length = 50,nullable = false)
    String email;
   
    
    
    //mapeamento 1 pra 1 de usuário para conta bancária
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "ID_BANK_DETAILS", referencedColumnName = "ID")
    private Bank_Details bank_Details;
    
    //mapeamento 1 pra 1 de usuário para Endereço
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "ID_ADDRESS", referencedColumnName = "ID")
    private Address address;

    
    //mapeamento 1 pra n de usuário para requests
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Request> requests;
    
    
    //mapeamento n pra n de usuário para projetos
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_USER_PROJECT", joinColumns = {
        @JoinColumn(name = "ID_USER")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PROJECT")}
         )
    private List<Project> projetos;

    public User() {
    }

    public Integer getId() {
        return id;
    }
    

     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bank_Details getBank_Details() {
        return bank_Details;
    }

    public void setBank_Details(Bank_Details bank_Details) {
        this.bank_Details = bank_Details;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Project> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Project> projetos) {
        this.projetos = projetos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
