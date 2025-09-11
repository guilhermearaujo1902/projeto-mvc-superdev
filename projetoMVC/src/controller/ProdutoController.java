package controller;

import DAO.GenericDAO;
import DAO.ProdutoDAO;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    public String insert(Produto produto) throws Exception {
        GenericDAO dao = new ProdutoDAO();
        boolean isCadastrado = dao.insert(produto);
        if (isCadastrado) {
            return "Cadastro realizado com sucesso!";
        } else {
            return "Erro ao cadastrar produto";
        }
    }

    public List<Produto> getAll() throws Exception {
        List<Produto> produtoList = new ArrayList<>();
        GenericDAO dao = new ProdutoDAO();

        // Obter a lista genérica vinda da ProdutoDAO
        List<Object> listaGenerica = dao.getAll();

        // Converter o List<Object>, ou seja, a lista de objetos genéricos
        // que é retornada da ProdutoDAO em uma lista propriamente da
        // classe Produto
        for (Object objetoGenerico : listaGenerica) {
            // Converter para um objeto do tipo Produto
            produtoList.add( (Produto) objetoGenerico);
        }

        return produtoList;
    }

    public String getFormatedList() throws Exception {
        List<Produto> produtoList = this.getAll();

        if (produtoList.isEmpty()) {
            return "Nenhum produto cadastrado no momento.";
        }

        StringBuilder listaImprimir = new StringBuilder();

        for (Produto produto : produtoList) {
            listaImprimir.append(produto.getId());
            listaImprimir.append(" - ");
            listaImprimir.append(produto.getDescricao());
            listaImprimir.append(" - ");
            listaImprimir.append(produto.getPreco());
            listaImprimir.append("\n");
        }

        return listaImprimir.toString();
    }

}
