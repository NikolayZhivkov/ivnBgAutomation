package pojo;

import lombok.Data;

@Data
public class Item {

    private String name;
    private int price_for_quantity;
    private String quantity_unit;
}
