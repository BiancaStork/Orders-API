package codoacodo.orders.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BrandDto {
    private Long id;
    private String logo;
    private String name;
    private String web;

}
