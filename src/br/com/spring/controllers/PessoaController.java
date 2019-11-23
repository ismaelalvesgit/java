package br.com.spring.controllers;

import model.Pessoa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DAOPessoa;
import dao.PessoaHashMap;

@Controller
public class PessoaController {

	private DAOPessoa dao;

	@RequestMapping("cadastroPessoa")
	public String cadastroPessoa() {
		if (dao == null)
			dao = new PessoaHashMap();
		return "pessoa/pessoaForm";
	}

	@RequestMapping(value="adicionaPessoa",method= RequestMethod.POST)
	public String cadastroPessoa(@RequestParam("nome") String nome,@RequestParam("cpf") String cpf, @RequestParam("email") String email){
		if(dao == null){
		 dao = new PessoaHashMap();
		}
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(cpf);
		pessoa.setEmail(email);
		pessoa.setNome(nome);
		dao.persistir(pessoa);
		return "redirect:cadastroPessoa";
	}

	@RequestMapping("editarPessoa")
	public String alterarPessoa(Long id, Model model){
		if(dao == null){
			dao = new PessoaHashMap();
		}
		return "pessoa/editarPessoa";
	}

	@RequestMapping("alterarPessoa")
	public String alteraPessoa(Pessoa pessoa) {
		if (dao == null){
			dao = new PessoaHashMap();
		}	
		dao.alterar(pessoa);
		return "redirect:listaPessoas";
	}

	@RequestMapping("removePessoa")
	public String removerPessoa(Pessoa pessoa) {
		if (dao == null){
			dao = new PessoaHashMap();
		}	
		dao.excluir(pessoa);
		return "redirect:listaPessoas";
	}

	@RequestMapping("listaPessoas")
	public String listaCadastroPessoa(Model model){
	 if(dao == null){
		 dao = new PessoaHashMap();
	 }
	 return "pessoa/listaPessoa";
	}

	public DAOPessoa getDao() {
		return dao;
	}

	public void setDao(DAOPessoa dao) {
		this.dao = dao;
	}
}
