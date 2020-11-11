package br.salaoeveris.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salaoeveris.app.request.AgendamentoList;
import br.salaoeveris.app.request.AgendamentoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.AgendamentoResponse;
import br.salaoeveris.app.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController extends BaseController {

	private final AgendamentoService _service;

	@Autowired
	public AgendamentoController(AgendamentoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody AgendamentoRequest agendamentoRequest) {
		try {
			BaseResponse response = _service.inserir(agendamentoRequest);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {
			AgendamentoResponse response = _service.obter(id);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

	@GetMapping(path = "/agendamentos/{dataInicio},{dataFinal}")
	public ResponseEntity listar(@PathVariable Date dataInicio, @PathVariable Date dataFinal) {
		try {
			AgendamentoList agendamentos = _service.pesquisa(dataInicio, dataFinal);
			return ResponseEntity.status(HttpStatus.OK).body(agendamentos);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		try {
			BaseResponse response = _service.deletar(id);
			return ResponseEntity.status(response.StatusCode).build();
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody AgendamentoRequest agendamentoRequest, @PathVariable Long id) {
		try {
			BaseResponse response = _service.atualizar(id, agendamentoRequest);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

}
