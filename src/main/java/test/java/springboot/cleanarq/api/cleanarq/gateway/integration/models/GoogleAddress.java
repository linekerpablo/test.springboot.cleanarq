package test.java.springboot.cleanarq.api.cleanarq.gateway.integration.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GoogleAddress {
    public List<GoogleResult> results;
}
