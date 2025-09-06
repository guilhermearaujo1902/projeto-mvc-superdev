package controller;

import DAO.GenericDAO;
import DAO.ProdutoDAO;
import model.Produto;

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

}
