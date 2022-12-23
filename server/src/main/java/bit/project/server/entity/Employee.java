package bit.project.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import javax.persistence.*;
import java.time.LocalDate;
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
public class Employee{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    @NotNull(message="Calling is required")
    @Size(min=0, max=255, message="Maximum character count is 255")
    private String callingname;

    @Size(min=0, max=255, message="Maximum character count is 255")
    private String fullname;

    @NotNull(message="Name is required")
    @Size(min=0, max=12, message="Maximum character count is 12")
    private String nic;

    private LocalDate dobirth;

    @NotNull(message="Mobile is required")
    @Size(min=10, max=10, message="Character count should be 10")
    private String mobile;

    @Size(min=10, max=10, message="Character count should be 10")
    private String land;

    private String email;

    private String photo;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String address;

    private LocalDate dorecruit;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;


    @ManyToOne
    private Nametitle nametitle;

    @ManyToOne
    private Gender gender;

    @ManyToOne
    private Civilstatus civilstatus;

    @ManyToOne
    private Employeestatus employeestatus;

    @ManyToOne
    private Designation designation;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    @JsonIgnore
    @ManyToMany(mappedBy = "employeeList")
    private List<Categorization> categorizationList;

    @JsonIgnore
    @ManyToMany(mappedBy = "employeeList")
    private List<Distribution> distributionList;

    @JsonIgnore
    @ManyToMany(mappedBy = "employeeList")
    private List<Dryering> dryeringList;

    @JsonIgnore
    @ManyToMany(mappedBy = "employeeList")
    private List<Grinding> grindingList;

    @JsonIgnore
    @ManyToMany(mappedBy = "employeeList")
    private List<Packing> packingList;

    @JsonIgnore
    @ManyToMany(mappedBy = "employeeList")
    private List<Permenting> permentingList;

    @JsonIgnore
    @ManyToMany(mappedBy = "employeeList")
    private List<Tasting> tastingList;

    @JsonIgnore
    @ManyToMany(mappedBy = "employeeList")
    private List<Withering> witheringList;


    public Employee(Integer id){
        this.id = id;
    }

    public Employee(Integer id, String code, Nametitle nametitle, String callingname, String photo){
        this.id = id;
        this.code = code;
        this.nametitle = nametitle;
        this.callingname = callingname;
        this.photo = photo;
    }

}