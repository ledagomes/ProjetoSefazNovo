package controle;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="LoginBean")
@RequestScoped
public class LoginBean {

	
	private String usarioAdmin = "admin";
	private String senhaAdmin = "admin";
	
	private String usuarioTXT;
	private String senhaTXT;
	
	private static final String PESQUISAR = "paginas/pessoa/pesquisarPessoa.xhtml"; 
	
	public LoginBean() { }
	
	
	public void entrar() throws IOException {
		if(this.usuarioTXT.equals(this.usarioAdmin)
		  && this.senhaTXT.equals(this.senhaAdmin)) {
			FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
		}else { 
			
		}
	}

	public String getUsuarioTXT() {
		return usuarioTXT;
	}

	public void setUsuarioTXT(String usuarioTXT) {
		this.usuarioTXT = usuarioTXT;
	}

	public String getSenhaTXT() {
		return senhaTXT;
	}

	public void setSenhaTXT(String senhaTXT) {
		this.senhaTXT = senhaTXT;
	}
}
