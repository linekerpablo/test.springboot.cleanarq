package test.java.springboot.cleanarq.api.cleanarq.controller.models;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressModelRequest {
    @NotNull(message = "Street name must be informed")
    public String streetName;
    @NotNull(message = "Number must be informed")
    public Integer number;
    public String complement;
    @NotNull(message = "Neighbourhood name must be informed")
    public String neighbourhood;
    @NotNull(message = "City name must be informed")
    public String city;
    @NotNull(message = "State name must be informed")
    public String state;
    @NotNull(message = "Country name must be informed")
    public String country;
    @NotNull(message = "ZipCode name must be informed")
    public String zipCode;
    public Double latitude;
    public Double longitude;
}
