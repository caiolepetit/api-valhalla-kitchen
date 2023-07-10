package br.com.apivalhallakitchen.adapter.driver.form;

import lombok.Getter;

import java.util.List;

@Getter
public class PedidoForm {
    private List<Long> produtosId;
    private Long clienteId;
}