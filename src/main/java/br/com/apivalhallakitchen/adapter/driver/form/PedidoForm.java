package br.com.apivalhallakitchen.adapter.driver.form;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class PedidoForm {
    private List<Long> produtosId;
    private UUID clienteId;
}