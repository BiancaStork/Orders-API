package codoacodo.orders.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor


public class Order {
    private Long id;
    private ProductDto product;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

}
