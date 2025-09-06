package test;

import controller.ProdutoController;
import model.Produto;

import javax.swing.*;

public class ProdutoTest {

    public static void main(String[] args) throws Exception {

        ProdutoController controller = new ProdutoController();

        Produto novoProduto = new Produto();
        novoProduto.setDescricao("Garrafinha de inox 500ml");
        novoProduto.setPreco(59.90);
        novoProduto.setStatus(true);

        String mensagemInsert = controller.insert(novoProduto);
        JOptionPane.showMessageDialog(null, mensagemInsert);

    }

}
