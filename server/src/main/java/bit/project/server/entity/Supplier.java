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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Supplier{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    @Size(min=0, max=255, message="Maximum character count is 255")
    private String name;

    @Size(min=10, max=10, message="Character count should be 10")
    private String contact1;

    @Size(min=10, max=10, message="Character count should be 10")
    private String contact2;

    private String fax;

    private String email;

    @Lob
    private String address;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;


    @ManyToOne
    private Supplierstatus supplierstatus;

    @ManyToOne
    private Route route;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    private List<Collection> supplierCollectionList;


    public Supplier(Integer id){
        this.id = id;
    }

    public Supplier(Integer id, String code, String name){
        this.id = id;
        this.code = code;
        this.name = name;
    }

}