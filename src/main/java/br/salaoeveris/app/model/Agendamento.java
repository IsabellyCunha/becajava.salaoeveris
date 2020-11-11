package br.salaoeveris.app.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataHora;
	
	@ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "servicoId")
    private Servico servico;

    
	public Date getDataHora() {	
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
