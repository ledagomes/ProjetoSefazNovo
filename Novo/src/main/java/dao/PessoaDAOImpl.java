package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Pessoa;


public class PessoaDAOImpl implements PessoaDAO {

	private EntityManager ent;

		public PessoaDAOImpl(EntityManager ent) {
		this.ent = ent;
	}

	public boolean inserir(Pessoa pessoa) {

		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.persist(pessoa);
		tx.commit();

		return true;

	}
	public void alterar(Pessoa pessoa) {

		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.merge(pessoa);
		tx.commit();

	}


	public void remover(Pessoa pessoa) {
		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.remove(pessoa);
		tx.commit();
		
	}
	public Pessoa pesquisar(String cpf) {

		Pessoa pessoa = ent.find(Pessoa.class, cpf);
		
		return pessoa;
		
	}

	public List<Pessoa> listarTodos() {

		Query query = ent.createQuery("from Pessoa p");
		
		List<Pessoa> pessoas = query.getResultList();
	
		return pessoas;
		
	}

}
