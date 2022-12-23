package bit.project.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import javax.persistence.*;
import java.time.LocalDate;
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
public class Distribution{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    @NotNull(message="Name is required")
    private String contactpersonname;

    @NotNull(message="NIC is required")
    @Size(min=0, max=12, message="Maximum character count is 12")
    private String contactpersonnic;

    @NotNull(message="Contact is required")
    @Size(min=10, max=10, message="Character count should be 10")
    private String contactpersontel;

    private LocalDate date;

    @NotNull(message="Name is required")
    private BigDecimal fee;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;


    @ManyToOne
    private Sale sale;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Distributionstatus distributionstatus;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    @ManyToMany
        @JoinTable(
        name="distributionemployee",
        joinColumns=@JoinColumn(name="distribution_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="employee_id", referencedColumnName="id")
    )
    private List<Employee> employeeList;


    public Distribution(Integer id){
        this.id = id;
    }

    public Distribution(Integer id, String code){
        this.id = id;
        this.code = code;
    }

}