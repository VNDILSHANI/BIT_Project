package bit.project.server.entity;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Packing{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    private LocalDateTime tostart;

    private LocalDateTime toend;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String description;

    private LocalDateTime tocreation;


    @ManyToOne
    private Packingstatus packingstatus;

    @ManyToOne
    private Porder porder;

    @OneToMany(mappedBy="packing", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Packingproduct> packingproductList;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    @ManyToMany
        @JoinTable(
        name="packingemployee",
        joinColumns=@JoinColumn(name="packing_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="employee_id", referencedColumnName="id")
    )
    private List<Employee> employeeList;


    public Packing(Integer id){
        this.id = id;
    }

    public Packing(Integer id, String code){
        this.id = id;
        this.code = code;
    }

}