package studio.thinkground.testproject.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import studio.thinkground.testproject.data.dto.ProductDTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "product")
public class ProductEntity extends BaseEntity{

    @Id
    String id;
    String name;
    Integer price;
    Integer stock;

  /*
  @Column
  String sellerId;

  @Column
  String sellerPhoneNumber;
   */

    public ProductDTO toDto(){
        return ProductDTO.builder()
                .productID(id)
                .productName(name)
                .productPrice(price)
                .productStock(stock)
                .build();
    }

}