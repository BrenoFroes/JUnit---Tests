package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
    Carrinho carrinho;
	private ArrayList items;
	Produto tenis = new Produto("Air Jordan", 900.00);
	Produto jaqueta = new Produto("Jaqueta de couro", 320.00);
	Produto bota = new Produto("Bota preta", 580.00);
    Produto regata = new Produto("Regata Slim", 55.00);

    @BeforeEach
    public void inicializa(){
        carrinho = new Carrinho();
        items = new ArrayList();
        carrinho.addItem(tenis);
        items.add(tenis);
        carrinho.addItem(jaqueta);
        items.add(jaqueta);
        carrinho.addItem(bota);
        items.add(bota);
    }

    @Test
    public void testValorTotal(){
        double total = carrinho.getValorTotal();
        int tamanho = items.size();
        double totalL = 0;
        for (int i; i < tamanho; i++){
            Produto item = (Produto) items.get(i);
            totalL += item.getPreco();

        }
        assertEquals(totalL, total);
    }

    @Test
    public void testAddItem(){
        int carrinhoInicial = carrinho.getQtdeItems();
        carrinho.addItem(regata);
        int carrinhoFinal = carrinho.getQtdeItems();
        assertEquals(carrinhoInicial, carrinhoFinal - 1);
    }

    @Test
    public void testRemoveItem(){
        int carrinhoInicial = carrinho.getQtdeItems();
        carrinho.addItem(regata);
        int carrinhoFinal = carrinho.getQtdeItems();
        assertEquals(carrinhoInicial, carrinhoFinal + 1);
    }

    @Test
    public void testGetdeItem(){
        int carrinhoTamanho = carrinho.getQtdeItems();
        int tamanhoItems = items.size();
        assertEquals(carrinhoTamanho, tamanhoItems);
    }

    @Test
    public void testEsvazia(){
        carrinho.esvazia();
        int carrinhoTamanho = carrinho.getQtdeItems();
        assertEquals(0, carrinhoTamanho);
    }
}
