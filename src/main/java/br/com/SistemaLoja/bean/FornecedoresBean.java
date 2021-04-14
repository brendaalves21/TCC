package br.com.SistemaLoja.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

import br.com.SistemaLoja.DAO.FornecedoresDAO;
import br.com.SistemaLoja.domain.Fornecedores;
import br.com.SistemaLoja.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {
	
private Fornecedores fornecedores = new Fornecedores();

public Fornecedores getFornecedores() {
	return fornecedores;
}

public void setFornecedores(Fornecedores fornecedores) {
	this.fornecedores = fornecedores;
}
private ListDataModel<Fornecedores> itens;

public ListDataModel<Fornecedores> getItens() {
	return itens;
}

public void setItens(ListDataModel<Fornecedores> itens) {
	this.itens = itens;
}
@PostConstruct
public void prepararPesquisa() {

	try {
		FornecedoresDAO fdao = new FornecedoresDAO();
		ArrayList<Fornecedores> lista = fdao.listar();
		itens = new ListDataModel<Fornecedores>(lista);
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro("e.getMessage()");
		e.printStackTrace();
	}
}

public void prepararNovo() {
	fornecedores = new Fornecedores();
	
}

public void novo() {
	try {
		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.salvar(fornecedores);
		
		ArrayList<Fornecedores> lista = fdao.listar();
		itens = new ListDataModel<Fornecedores> (lista);
		JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro("e.getMessage()");
		e.printStackTrace();
	}
}

public void prepararExcluir() {
	fornecedores = itens.getRowData();
	System.out.println(fornecedores);
}

public void excluir() {
	
	try {
		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.excluir(fornecedores);
		ArrayList<Fornecedores> lista = fdao.listar();
		itens = new ListDataModel<Fornecedores> (lista);
		JSFUtil.adicionarMensagemSucesso("Fornecedor excluido com sucesso");
	} catch (SQLException e) {
		JSFUtil.adicionarMensagemErro("e.getMessage()");
		e.printStackTrace();
	}
}

}