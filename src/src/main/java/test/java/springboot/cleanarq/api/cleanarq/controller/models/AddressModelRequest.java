package test.java.springboot.cleanarq.api.cleanarq.controller.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressModelRequest {
    @NotNull(message = "Street name must be informed")
    @ApiModelProperty(value = "Rua")
    public String streetName;

    @NotNull(message = "Number must be informed")
    @ApiModelProperty(value = "Número")
    public Integer number;

    @ApiModelProperty(value = "Complemento")
    public String complement;

    @NotNull(message = "Neighbourhood name must be informed")
    @ApiModelProperty(value = "Bairro")
    public String neighbourhood;

    @NotNull(message = "City name must be informed")
    @ApiModelProperty(value = "Cidade")
    public String city;

    @NotNull(message = "State name must be informed")
    @ApiModelProperty(value = "Estado")
    public String state;

    @NotNull(message = "Country name must be informed")
    @ApiModelProperty(value = "País")
    public String country;

    @NotNull(message = "ZipCode name must be informed")
    @ApiModelProperty(value = "CEP")
    public String zipCode;

    @ApiModelProperty(value = "Latitude")
    public BigDecimal latitude;

    @ApiModelProperty(value = "Longitude")
    public BigDecimal longitude;
}
