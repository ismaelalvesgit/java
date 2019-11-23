package dao;

import java.util.List;

public interface DAOBase<T> {
	
	public List<T> list();
	
	public void persistir(T objeto);
	
	public void excluir(T objeto);
	
	public void alterar(T objeto);
	
	public T get(Long id);
	
}
