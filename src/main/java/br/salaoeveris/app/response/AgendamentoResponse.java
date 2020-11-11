package br.salaoeveris.app.response;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.model.Servico;

public class AgendamentoResponse extends BaseResponse{
	private Date dataHora;
    private Cliente cliente;
    private Servico servico;

    
	public Date getDataHora() {	
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss aa");
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
