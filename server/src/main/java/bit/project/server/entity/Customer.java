package bit.project.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    @NotNull(message="Name is required")
    @Size(min=0, max=255, message="Maximum character count is 255")
    private String name;

    @NotNull(message="Contact is required")
    @Size(min=10, max=10, message="Character count should be 10")
    private String contact1;

    @Size(min=10, max=10, message="Character count should be 10")
    private String contact2;

    private String fax;

    private String email;

    @Lob
    @NotNull(message="Address is required")
    @Size(min=10, max=65535, message="Maximum character count is 65535")
    private String address;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;


    @ManyToOne
    private Customertype customertype;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Sale> customerSaleList;


    public Customer(Integer id){
        this.id = id;
    }

    public Customer(Integer id, String code, Customertype customertype, String name){
        this.id = id;
        this.code = code;
        this.customertype = customertype;
        this.name = name;
    }

}