package bit.project.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.Id;
import java.math.BigDecimal;
import javax.persistence.Lob;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customerrefund{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    @Lob
    @NotNull(message="Reason is required")
    private String reason;

    @NotNull(message="Date is required")
    private LocalDate date;

    @NotNull(message="Amount is required")
    private BigDecimal amount;

    private String chequeno;

    private String chequebank;

    private String chequebranch;

    private LocalDate chequedate;

    @Lob
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;


    @ManyToOne
    private Paymenttype paymenttype;

    @ManyToOne
    private Paymentstatus paymentstatus;

    @ManyToOne
    private Sale sale;

    @OneToMany(mappedBy="customerrefund", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customerrefundproduct> customerrefundproductList;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    public Customerrefund(Integer id){
        this.id = id;
    }

    public Customerrefund(Integer id, String code){
        this.id = id;
        this.code = code;
    }

}