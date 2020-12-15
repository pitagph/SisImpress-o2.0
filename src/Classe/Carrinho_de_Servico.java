/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.util.ArrayList;

/**
 *
 * @author PhillipeNoteTec
 */
public class Carrinho_de_Servico {
    
            
       	public ArrayList<Preco_servicos> serviços;
        
        
	public Carrinho_de_Servico() {
		super();
		this.serviços = new ArrayList<Preco_servicos>();
	}
	
	public void adicionarProduto(Preco_servicos servico) {
		this.serviços.add(servico);
	}
	
	public void removerProduto(int numeroProduto) {
		if(numeroProduto < 0 ) {
			System.out.println("\n Produto invalido para remocao");
		}
		else {
			if(numeroProduto > this.serviços.size()) {
				System.out.println("\n Produto maior do que tamanho da colecao. Produto invalido para remocao");
			}
			else {
				this.serviços.remove(numeroProduto);		
			}
		}		
	}
        
        public void limpar_carrinho(){
            
               this.serviços.clear();
            
        
        }

	public double listarProdutos() {
		Double total = 0.00;
		
		for( Preco_servicos cadaProduto : this.serviços) {
			total = total + cadaProduto.getValor_do_item();
                	System.out.println("<=================> "+ cadaProduto);
           //             System.out.println("\nValor Total:"+ total);
             }
		  return total;
	}

        


    
    
    

}
