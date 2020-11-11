package br.salaoeveris.app.request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.model.Servico;

public class AgendamentoRequest {
	private Date dataHora;
	private String data;
    private Cliente cliente;
    private Servico servico;
    
	/*
	 * public String formatarData() { SimpleDateFormat formatar = new
	 * SimpleDateFormat("dd/MM/yyyy - hh:mm"); return
	 * formatar.format(getDataHora()); }
	 */
    
	public Date getDataHora(){	
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora; 
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
