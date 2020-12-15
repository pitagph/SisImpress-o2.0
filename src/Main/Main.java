/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Classe.Carrinho_de_Servico;
import Classe.Preco_servicos;
import Classe.Servico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PhillipeNoteTec
 */
public class Main extends Servico {
    Scanner ler = new Scanner(System.in);
    Scanner qnt_servi = new Scanner(System.in);
    int token, id;
    double total_servico;
    ArrayList<Carrinho_de_Servico> lista = new ArrayList<>();
    Carrinho_de_Servico carrinho = new Carrinho_de_Servico();

   void ler_arquivoId() throws FileNotFoundException, IOException {
  File DIR = new File("c:\\caixa2.0");
  File ler_arquivo_id = new File(DIR, "arquivo_id_venda2.txt");
  FileReader arquivo_id_leitura = new FileReader(ler_arquivo_id);
  BufferedReader buff = new BufferedReader(arquivo_id_leitura);
  
  String linha = "";
  List result = new ArrayList();
  
   while ((linha = buff.readLine()) != null) {
          //      System.out.println(linha);
                if (linha != null && !linha.isEmpty()) {
                    result.add(linha);
                }
            }
            arquivo_id_leitura.close();
            buff.close();
    
            for (Object s : result) {
                String l = (String.valueOf(s));
                //Usamos o método split da classe String
                // para separar as partes entre os ponto e vírgulas.
                //Guardamos o resultado em um array
                String[] user = l.split(" ");

                //Criamos um objeto User e setamos em seus atributos
                //as posições correspondentes do array
                for (int i = 0; i < user.length; i++) {
                    int d = Integer.parseInt(user[i]);
                    setId(d);
                }
            }
  
  }
  
  void gravar_id_venda(int id_venda) throws IOException {
    File DIR = new File("c:\\caixa2.0");
   File arquivo = new File(DIR, "arquivo_id_venda2.txt");
   FileWriter arquivo_caixa = new FileWriter(arquivo, false);    

      PrintWriter escrever_caixa = new PrintWriter(arquivo_caixa);
    //  double soma = getId()+1;
           escrever_caixa.print(id_venda);
           escrever_caixa.flush();
           escrever_caixa.close();
      
      
  }   
    
    
  void ler_arquivoCaixa() throws FileNotFoundException, IOException{
  File DIR = new File("c:\\caixa2.0");
  File ler_arquivo = new File(DIR, "entrada_caixa_impressao2.txt");
  FileReader arquivo_leitura = new FileReader(ler_arquivo);
  BufferedReader buff = new BufferedReader(arquivo_leitura);
  
  String linha = "";
  List result = new ArrayList();
  
   while ((linha = buff.readLine()) != null) {
          //      System.out.println(linha);
                if (linha != null && !linha.isEmpty()) {
                    result.add(linha);
                }
            }
            arquivo_leitura.close();
            buff.close();
    
            for (Object s : result) {
                String l = (String.valueOf(s));
                //Usamos o método split da classe String
                // para separar as partes entre os ponto e vírgulas.
                //Guardamos o resultado em um array
                String[] user = l.split(" ");

                //Criamos um objeto User e setamos em seus atributos
                //as posições correspondentes do array
                for (int i = 0; i < user.length; i++) {
                    double d = Double.parseDouble(user[i]);
                    setDinheiro_caixa(d);
                }
            }
            }  
    
      void entrada_caixa(double entrada_caixa) throws IOException {
   File DIR = new File("c:\\caixa2.0");
   File arquivo = new File(DIR, "entrada_caixa_impressao2.txt");
   FileWriter arquivo_caixa = new FileWriter(arquivo, false);    

      PrintWriter escrever_caixa = new PrintWriter(arquivo_caixa);
      double soma = getDinheiro_caixa() + entrada_caixa;
           escrever_caixa.print(soma);
           escrever_caixa.flush();
           escrever_caixa.close();
         }

    
    void imprimir_nota_Cliente(int id, ArrayList<Preco_servicos> car_service , double valor_total) throws IOException {
 File dir = new File("C:\\caixa2.0");
 File notafiscal_arquivo_cliente = new File(dir, "NotaFiscal_Cliente2.txt");
 FileWriter arquivo_ler = new FileWriter(notafiscal_arquivo_cliente, false);
      
    PrintWriter escrever_txt = new PrintWriter(arquivo_ler);
       escrever_txt.println("----- Nota Fiscal ------");
       escrever_txt.println("Id da Venda: "+ id);
       escrever_txt.println(car_service);
       escrever_txt.println();
       escrever_txt.println("Valor Total: R$"+ valor_total);
       escrever_txt.println("Nome: "+ Nome_Cliente);
       escrever_txt.println("Data: "+ getDateTime());
       escrever_txt.println("------------------------- \n");
       escrever_txt.flush();
       escrever_txt.close();
 
 } 
    
    void imprimir_nota(ArrayList<Preco_servicos> car_service, double valor_total) throws IOException{
     int token = getId()+1;
 File dir = new File("C:\\caixa2.0");
 File notafiscal_arquivo = new File(dir, "Caixa2.0_impressão_historico.txt");
 FileWriter arquivo_ler = null;
  if(notafiscal_arquivo.exists() == true){
       arquivo_ler = new FileWriter(notafiscal_arquivo, true);
       } else {arquivo_ler = new FileWriter(notafiscal_arquivo);}
      
    PrintWriter escrever_txt = new PrintWriter(arquivo_ler);
       escrever_txt.println("----- Nota Fiscal ------");
       escrever_txt.println("Id da Venda: "+ token);
       escrever_txt.println(car_service);
       escrever_txt.println();
       escrever_txt.println("Valor Total: R$"+ valor_total);
       escrever_txt.println("Nome: "+ Nome_Cliente);
       escrever_txt.println("Data: "+ getDateTime());
       escrever_txt.println("------------------------- \n");
       escrever_txt.flush();
       escrever_txt.close();
       entrada_caixa(valor_total);
       gravar_id_venda(token);
       imprimir_nota_Cliente(token, car_service,valor_total);
       carrinho.limpar_carrinho();
 }
    
  public void Caixa(String Nome_servico, double Valor_servico) throws IOException{
     System.out.println("Digite a quantidade do serviço escolhido");
     int qnt_servico = qnt_servi.nextInt();
     total_servico = total_servico + (Valor_servico*qnt_servico);
     carrinho.adicionarProduto(new Preco_servicos(Nome_servico, Valor_servico, qnt_servico));
     System.out.println("Lista de Serviços:");
     carrinho.listarProdutos();
     System.out.println("Valor Total: R$"+ total_servico);
     System.out.println("Deseja adicionar mais outro serviço?");
      int l = ler.nextInt();
      if(l == 1) {
        lista_de_servico();
   } else if (l == 2){
          System.out.println("Concluir o serviço?");
          l = ler.nextInt();
                         if(l == 1) {
                             System.out.println("Venda concluida!");
                          imprimir_nota(carrinho.serviços, total_servico);
                          total_servico = 0.0;
                          Maquina();
                           } else if (l == 2){ 
                               total_servico = 0.0;
                               carrinho.limpar_carrinho();
                               Maquina();
                           }
   }
      
   }
    
   public void Carrinho(int Codigo_serviço) throws IOException{
    int token = 0;
       
    if (Codigo_serviço == 1){
        setPreco_Impressao(1.50);
        Impressao();
        Caixa(Nome_Impressao, getPreco_Impressao());  
    } else if (Codigo_serviço == 2){
        setPreco_Xerox(0.50);
        Xerox();
        Caixa(Nome_Xerox, getPreco_Xerox());
    
    } else if (Codigo_serviço == 3){
        setPreco_Curriculun(5.00);
        Curriculun();
        Caixa(Nome_Curriculun, getPreco_Curriculun());
    } else if (Codigo_serviço == 4){
        setPreco_Cartao_visita(3.00);
        Cartao_de_visita();
        Caixa(Nome_Cartao_visita, getPreco_Cartao_visita());
    } else if (Codigo_serviço == 5){
        setPreco_Impressao_foto(2.50);
        Impressao_Foto();
        Caixa(Nome_Impressao_foto, getPreco_Impressao_foto());
    } else if (Codigo_serviço == 6){
        setPreco_Scanner(2.00);
        Scanner();
        Caixa(Nome_Scanner, getPreco_Scanner());
    }    
    
    }
    
    void lista_de_servico() throws IOException {
    Scanner ler = new Scanner(System.in);
    Scanner ler1 = new Scanner(System.in);
    int entrada = 0;    
    ler_arquivoId();
    ler_arquivoCaixa();
     //   Scanner ler = new Scanner(System.in);
       
        System.out.println("Dinheiro em caixa: "+"R$"+ getDinheiro_caixa());
        System.out.println("Selecione qual Serviço de Impressão você deseja:\n");
        System.out.println("Selecione 1: Serviço de Impressão (1 Folha) : R$1.50");
        System.out.println("Selecione 2: Serviço de Xerox (1 Folha) : R$0.50");
        System.out.println("Selecione 3: Serviço de Curriculun (1 Folha) : R$5.00");
        System.out.println("Selecione 4: Serviço de Cartão de Visita (1 Folha) : R$3.00");
        System.out.println("Selecione 5: Serviço de Impressão de Foto(1 Folha) : R$2.50");
        System.out.println("Selecione 6: Serviço de Scanner (1 Folha): R$2.00");
        System.out.println("Selecione Qualquer número alem do 6: Sair do Programa");    
        entrada = ler1.nextInt();
        switch(entrada){
        case 1: Carrinho(entrada); break;
        case 2: Carrinho(entrada); break;
        case 3: Carrinho(entrada); break;
        case 4: Carrinho(entrada); break;
        case 5: Carrinho(entrada); break;
        case 6: Carrinho(entrada); break;
        default: System.out.println("Programa Encerrado"); break;
        }
         
    }
    
    
    void Maquina() throws IOException{
        System.out.println("Bem vindo ao Sistema de Serviço Impressão.");
        lista_de_servico();
       
    }
    
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.Maquina();
    }
    
    
}
