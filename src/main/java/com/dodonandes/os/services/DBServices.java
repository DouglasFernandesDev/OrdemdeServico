package com.dodonandes.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodonandes.os.domain.Cliente;
import com.dodonandes.os.domain.OS;
import com.dodonandes.os.domain.Tecnico;
import com.dodonandes.os.domain.enuns.Prioridade;
import com.dodonandes.os.domain.enuns.Status;
import com.dodonandes.os.repositories.ClienteRepository;
import com.dodonandes.os.repositories.TecnicoRepository;

@Service
public class DBServices {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private com.dodonandes.os.repositories.OSRepository OSRepository;
	
	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Valdir Cezar", "918.540.148-03", "(83) 92031-2723", null);
		Tecnico t2 = new Tecnico(null, "Linus Trovalds", "859.005.190-07", "(83) 93531-2623", null);	
		Cliente c1 = new Cliente(null, "Betina Campos", "192.599.078-88", "(62) 93578-0460");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste Create OD", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		OSRepository.saveAll(Arrays.asList(os1));
	}

}
