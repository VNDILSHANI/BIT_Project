package bit.project.server.entity;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Material{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    private BigDecimal unitprice;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String description;

    private LocalDateTime tocreation;


    @ManyToOne
    private Tealeaftype tealeaftype;

    @ManyToOne
    private Teatreetype teatreetype;

    @ManyToOne
    private Materialstatus materialstatus;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    @JsonIgnore
    @OneToMany(mappedBy = "material")
    private List<Categorizedmaterial> materialCategorizedmaterialList;

    @JsonIgnore
    @OneToMany(mappedBy = "material")
    private List<Collection> materialCollectionList;

    @JsonIgnore
    @OneToMany(mappedBy = "material")
    private List<Productmaterial> productmaterialList;


    public Material(Integer id){
        this.id = id;
    }

    public Material(Integer id, String code){
        this.id = id;
        this.code = code;
    }

}