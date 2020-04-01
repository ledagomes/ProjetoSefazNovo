package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco {
	
	@Id
	@Column(name="id_endereco")
	@GeneratedValue(generator = "S_ENDERECO")
	@SequenceGenerator(name = "S_ENDERECO", sequenceName = "S_ENDERECO", allocationSize = 1)
	private long id;

	@Column(name="rua")
	private String rua;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="compl")
	private String compl;

	@ManyToOne
	@JoinColumn(name = "cpf", referencedColumnName = "cpf", nullable = false)
	private Pessoa pessoa;
		
	public Endereco() {
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getCompl() {
		return compl;
	}

	public void setCompl(String compl) {
		this.compl = compl;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
