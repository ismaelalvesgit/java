package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import util.GeradorIDs;
import model.Pessoa;


public class PessoaHashMap implements DAOPessoa
{
	private HashMap<Long,model.Pessoa> map;
	
	public PessoaHashMap()
	{
		if(isHashMapVazio())
		{
			this.map = new HashMap<Long,Pessoa>();
		}
	}

	@Override
	public List<Pessoa> list() 
	{
		List<Pessoa> lista = new ArrayList<Pessoa>();
		Set<Long> chaves = this.map.keySet();
		for(Long chave:chaves)
		{
			lista.add(this.map.get(chave));
		}
		return lista;
	}

	@Override
	public void persistir(Pessoa pessoa)
	{
		if(isHashMapVazio())
		{
			this.map = new HashMap<Long,Pessoa>();
		}
		pessoa.setId(GeradorIDs.gerador());
		if(this.map.containsKey(pessoa.getId()) == false)
		{
			this.map.put(pessoa.getId(), pessoa);
		}
	}

	@Override
	public void excluir(Pessoa pessoa) 
	{
		if(!isHashMapVazio())
		{
			this.map.remove(pessoa.getId());
		}
	}

	@Override
	public Pessoa get(Long id) 
	{
		if(isHashMapVazio())
		{
			return null;
		}
		return this.map.get(id);
	}

	@Override
	public Pessoa getPessoa(long id) 
	{
		if(isHashMapVazio())
		{
			return null;
		}
		return this.map.get(id);
	}


	private boolean isHashMapVazio()
	{
		if(this.map == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void alterar(Pessoa pessoa) 
	{
		if(!isHashMapVazio())
		{
			this.map.remove(pessoa.getId());
			this.map.put(pessoa.getId(), pessoa);
		}
	}

}
