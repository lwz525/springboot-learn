package com.demo.readconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@ConfigurationProperties("my-profile")
@Validated
public class ProfileProperties {
    @NotEmpty
    private String name;
    @Email
    @NotEmpty
    private String email;

    private Boolean handsome = Boolean.TRUE;
}
