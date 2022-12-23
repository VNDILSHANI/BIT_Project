package bit.project.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
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
public class Withering{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    @NotNull(message="start date is required")
    private LocalDateTime tostart;

//    @NotNull(message="end date is required")
    private LocalDateTime toend;

    private BigDecimal initweight;

//    @NotNull(message="final weight is required")
    private BigDecimal finalweight;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;


    @ManyToOne
    private Witheringstatus witheringstatus;

    @ManyToOne
    private Categorizedmaterial categorizedmaterial;

    @OneToMany(mappedBy="withering", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Witheringwitherline> witheringwitherlineList;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    @ManyToMany
        @JoinTable(
        name="witheringemployee",
        joinColumns=@JoinColumn(name="withering_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="employee_id", referencedColumnName="id")
    )
    private List<Employee> employeeList;


    public Withering(Integer id){
        this.id = id;
    }

    public Withering(Integer id, String code){
        this.id = id;
        this.code = code;
    }

}