package test.java.springboot.cleanarq.api.cleanarq.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class AddressDomain {
    private Long id;
    private String streetName;
    private Integer number;
    private String complement;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
