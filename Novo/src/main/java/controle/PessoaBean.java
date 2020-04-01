package controle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import entidade.Endereco;
import entidade.Pessoa;
import util.JpaUtil;


@ManagedBean(name = "PessoaBean")
@SessionScoped
public class PessoaBean {

	private Pessoa pessoa;
	private Endereco endereco;
	private List<Pessoa> listaPessoa;
	private String cpfSelecionado;

	private PessoaDAO pessoaDAO;

	private static final String MANTER = "manterPessoa.xhtml";
	private static final String PESQUISAR = "pesquisarPessoa.xhtml";
	
	public PessoaBean() {

		this.pessoa = new Pessoa();
		this.pessoa.setEnderecos(new ArrayList<Endereco>());

		this.endereco = new Endereco();
		this.listaPessoa = new ArrayList<Pessoa>();

		this.pessoaDAO = new PessoaDAOImpl(JpaUtil.getEntityManager());

		this.listaPessoa = this.pessoaDAO.listarTodos();

		System.out.println(this.listaPessoa);
	}

	public void pesquisar() {
		this.listaPessoa = this.pessoaDAO.listarTodos();
		System.out.println("Entrou PEsquisar ====");
	}

	public void salvar() throws IOException {

		if (this.pessoaDAO.inserir(this.pessoa)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Sucesso !!!"));
			
			abrirPesquisarPessoa();
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Erro ao inserir !!!"));
		}

	}
	
	public void adicionarEndereco() {

		Endereco enderecoNovo = new Endereco();

		enderecoNovo.setRua(this.endereco.getRua());
		enderecoNovo.setNumero(this.endereco.getNumero());
		enderecoNovo.setCompl(this.endereco.getCompl());
		enderecoNovo.setPessoa(this.pessoa);

		this.pessoa.getEnderecos().add(enderecoNovo);

		this.endereco = new Endereco();

	}

	public void criarPessoa() throws IOException {
		this.pessoa = new Pessoa();
		this.pessoa.setEnderecos(new ArrayList<Endereco>());
		this.endereco = new Endereco();
		abrirManterPessoa();
	}

	public void abrirManterPessoa() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(MANTER);
	}

	public void abrirPesquisarPessoa() throws IOException {
		this.listaPessoa = this.pessoaDAO.listarTodos();
		FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
	}

	public void editar() throws IOException {
		Pessoa pessoaEdicao = this.pessoaDAO.pesquisar(cpfSelecionado);
		this.pessoa = pessoaEdicao;
		abrirManterPessoa();
	}
	
	public void remover() throws IOException {
		Pessoa pessoaRemocao = this.pessoaDAO.pesquisar(cpfSelecionado);
		this.pessoaDAO.remover(pessoaRemocao);
		abrirPesquisarPessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public String getCpfSelecionado() {
		return cpfSelecionado;
	}

	public void setCpfSelecionado(String cpfSelecionado) {
		this.cpfSelecionado = cpfSelecionado;
	}

	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}
	
	
	
}
