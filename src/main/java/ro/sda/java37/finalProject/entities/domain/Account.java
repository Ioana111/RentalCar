package ro.sda.java37.finalProject.entities.domain;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
import ro.sda.java37.finalProject.entities.Customer;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    @Column(unique=true)
    @Size(min=4, max=15)
    @NotEmpty(message="Please enter Your username")
    private String username;
    //@Size(min=6, max=10)
    @NotEmpty(message="Please enter Your password")
    private String password;
    private Boolean active;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToOne(mappedBy = "account")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Customer customerOwner;
    public Integer getAccountId() {
        return accountId;
    }




}