package bit.project.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
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
public class Customerpayment{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    @NotNull(message="Date is required")
    private LocalDate date;

    @NotNull(message="Amount is required")
    private BigDecimal amount;

    private String chequeno;

    private String chequebank;

    private String chequebranch;

    private LocalDate chequedate;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;


    @ManyToOne
    private Paymenttype paymenttype;

    @ManyToOne
    private Paymentstatus paymentstatus;

    @ManyToOne
    private Sale sale;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    public Customerpayment(Integer id){
        this.id = id;
    }

    public Customerpayment(Integer id, String code){
        this.id = id;
        this.code = code;
    }

}