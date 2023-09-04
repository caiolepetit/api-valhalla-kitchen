package br.com.apivalhallakitchen.adapter.driver.form;

import lombok.Getter;

import java.util.Date;
@Getter
public class MLTransacaoForm {

    private Long id;
    private boolean live_mode;
    private String type;
    private Date date_created;
    private Long user_id;
    private String api_version;
    private String action;

}
