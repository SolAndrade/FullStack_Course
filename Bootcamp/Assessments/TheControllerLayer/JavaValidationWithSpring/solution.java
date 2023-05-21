package midterm.JavaValidationWithSpring;

import javax.validation.constraints.*;
import java.math.*;

public class MenuItem {
  @NotNull
  private Integer id;
  
  @NotNull
  @Size(min = 1, max = 255)
  private String name;
  
  @NotNull
  @DecimalMax(value = "18.50", inclusive = true)
  private BigDecimal price;
  
  @NotNull
  @Digits(integer = 4, fraction = 0)
  private Integer year;
  
   public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}