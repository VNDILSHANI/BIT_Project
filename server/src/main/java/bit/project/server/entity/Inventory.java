package bit.project.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.Id;
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
public class Inventory{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min=10, max=10, message="Character count should be 10")
    private String code;

    private Integer qty;

    private Integer initqty;

    private LocalDate domanufactured;

    private LocalDate doexpire;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime tocreation;


    @ManyToOne
    private Porder porder;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties({"creator","status","tocreation","roleList"})
    private User creator;


    @JsonIgnore
    @OneToMany(mappedBy = "inventory")
    private List<Productdisposalinventory> productdisposalinventoryList;

    @JsonIgnore
    @OneToMany(mappedBy = "inventory")
    private List<Saleinventory> saleinventoryList;


    public Inventory(Integer id){
        this.id = id;
    }

    public Inventory(Integer id, String code){
        this.id = id;
        this.code = code;
    }

}