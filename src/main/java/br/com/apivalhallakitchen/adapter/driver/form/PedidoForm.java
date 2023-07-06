package br.com.apivalhallakitchen.adapter.driver.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class PedidoForm {
    @JsonProperty(value = "combo")
    private List<ComboForm> combosForm;
}