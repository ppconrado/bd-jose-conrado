package com.ppconrado.bdjoseconrado;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ppconrado.bdjoseconrado.domain.Categoria;
import com.ppconrado.bdjoseconrado.domain.Cidade;
import com.ppconrado.bdjoseconrado.domain.Cliente;
import com.ppconrado.bdjoseconrado.domain.Endereco;
import com.ppconrado.bdjoseconrado.domain.Estado;
import com.ppconrado.bdjoseconrado.domain.Produto;
import com.ppconrado.bdjoseconrado.domain.enums.TipoCliente;
import com.ppconrado.bdjoseconrado.repositories.CategoriaRepository;
import com.ppconrado.bdjoseconrado.repositories.CidadeRepository;
import com.ppconrado.bdjoseconrado.repositories.ClienteRepository;
import com.ppconrado.bdjoseconrado.repositories.EnderecoRepository;
import com.ppconrado.bdjoseconrado.repositories.EstadoRepository;
import com.ppconrado.bdjoseconrado.repositories.ProdutoRepository;

@SpringBootApplication
public class BdJoseConradoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BdJoseConradoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        // ComandLineRunner vai executar esta rotina no inicio do programa		
		
		
		/////////////////////// RELACAO - CATEGORIA <-> PRODUTO (ManyToMany) /////////////////////
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		// Salva no BD
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//////////////////////// RELACAO - ESTADO <-> CIDADE (ManyToOne) ////////////////////////
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		// Salva no BD atraves da camada repository (salva estado primeiro)
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		/////////////////// RELACAO - CLIENTE <-> ENDERECO <-> TELEFONE //////////////////////////
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		// Lista de Enderecos do cliente 
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		// Salvar o Cliente primeiro
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
