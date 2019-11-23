package dao;

import model.Pessoa;

public interface DAOPessoa extends DAOBase<Pessoa> 
{
	public Pessoa getPessoa(long id);
}
