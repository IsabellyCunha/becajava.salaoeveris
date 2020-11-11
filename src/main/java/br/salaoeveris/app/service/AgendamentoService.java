package br.salaoeveris.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Agendamento;
import br.salaoeveris.app.repository.AgendamentoRepository;
import br.salaoeveris.app.request.AgendamentoList;
import br.salaoeveris.app.request.AgendamentoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.AgendamentoResponse;

@Service
public class AgendamentoService {
	final AgendamentoRepository _repository;

	@Autowired
	public AgendamentoService(AgendamentoRepository repository) {
		_repository = repository;
	}

	public BaseResponse inserir(AgendamentoRequest agendamentoRequest) {
		Agendamento agendamento = new Agendamento();
		BaseResponse base = new BaseResponse();

		if (agendamentoRequest.getCliente().equals("")) {
			base.Message = "O id do cliente não foi preenchido.";
			return base;
		}

		if (agendamentoRequest.getServico().equals("")) {
			base.Message = "O id do servico não foi preenchido.";
			return base;
		}
		if (agendamentoRequest.getDataHora().equals("")) {
			base.Message = "A Data e Hora do agendamento não foi preenchido.";
			return base;
		}

		agendamento.setCliente(agendamentoRequest.getCliente());
		agendamento.setServico(agendamentoRequest.getServico());
		agendamento.setDataHora(agendamentoRequest.getDataHora());

		_repository.save(agendamento);
		base.StatusCode = 201;
		base.Message = "Agendamento inserido com sucesso.";
		return base;
	}

	public AgendamentoResponse obter(Long id) {
		Optional<Agendamento> agendamento = _repository.findById(id);
		AgendamentoResponse response = new AgendamentoResponse();

		if (agendamento == null) {
			response.Message = "Agendamento não encontrado";
			response.StatusCode = 404;
			return response;
		}

		response.setCliente(agendamento.get().getCliente());
		response.setServico(agendamento.get().getServico());
		response.setDataHora(agendamento.get().getDataHora());

		response.Message = "Agendamento obtido com sucesso";
		response.StatusCode = 200;
		return response;
	}

	public AgendamentoList pesquisa(Date dataInicio, Date dataFinal) {
		
		
		List<Agendamento> lista = _repository.findPesquisa(dataInicio, dataFinal);

		AgendamentoList response = new AgendamentoList();
		response.setAgendamentos(lista);
		response.StatusCode = 200;
		response.Message = "Agendamentos obtidos com sucesso.";

		return response;
	}

	public BaseResponse atualizar(Long id, AgendamentoRequest agendamentoRequest) {
		Agendamento agendamento = new Agendamento();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (agendamentoRequest.getCliente().equals("")) {
			base.Message = "O id do cliente não foi preenchido.";
			return base;
		}

		if (agendamentoRequest.getServico().equals("")) {
			base.Message = "O id do servico não foi preenchido.";
			return base;
		}
		if (agendamentoRequest.getDataHora().equals("")) {
			base.Message = "A Data e Hora do agendamento não foi preenchido.";
			return base;
		}

		agendamento.setCliente(agendamentoRequest.getCliente());
		agendamento.setServico(agendamentoRequest.getServico());
		agendamento.setDataHora(agendamentoRequest.getDataHora());

		_repository.save(agendamento);
		base.StatusCode = 200;
		base.Message = "Agendamento atualizado com sucesso.";
		return base;
	}

	public BaseResponse deletar(Long id) {
		BaseResponse response = new BaseResponse();

		if (id == null || id == 0) {
			response.StatusCode = 400;
			return response;
		}

		_repository.deleteById(id);
		response.StatusCode = 200;
		return response;
	}

}
