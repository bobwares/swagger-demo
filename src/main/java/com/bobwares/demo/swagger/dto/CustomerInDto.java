package com.bobwares.demo.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerInDto {
    @ApiModelProperty(value = "The first name of the customer.")
    private String firstName;

    @ApiModelProperty(value = "The last name of the customer.")
    private String lastName;
}
