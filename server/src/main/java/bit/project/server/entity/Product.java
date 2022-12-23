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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    @NotNull(message="Name is required")
    private String name;

    private String photo;

    private Integer rop;

    private BigDecimal weight;

    private BigDecimal price;

    @Lob
    @Size(min=0, max=65535, message="Maximum character count is 65535")
    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;


    @ManyToOne
    private Productstatus productstatus;

    @ManyToOne
    private Grade grade;

    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Productmaterial> productmaterialList;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Customerrefundproduct> customerrefundproductList;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Inventory> productInventoryList;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Packingproduct> packingproductList;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Porderproduct> porderproductList;


    public Product(Integer id){
        this.id = id;
    }

    public Product(Integer id, String code, String name, String photo){
        this.id = id;
        this.code = code;
        this.name = name;
        this.photo = photo;
    }

}