/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho03;
import java.util.Random;
/**
 *
 * @author gustavocoradin
 */
public class Trabalho03 {
    
    static long insere_resto(int chave,int tabela []){
        long colisao=0;
        int i = chave % tabela.length;
        while(tabela[i]!= 0){
            colisao+=1;
            i= (i+1)% tabela.length;
        }
        tabela[i] = chave;
        return colisao;
    }
    
    static long busca_resto(int chave,int tabela []){
        long comparacoes=1;
        int i = chave % tabela.length;
        while(tabela[i]!= 0 && tabela[i]!=chave){
            comparacoes+=1;
            i= (i+1)% tabela.length;
        }
        return comparacoes;
    }
    
    static long insere_multiplica(int chave,int tabela []){
        long colisao=0;
        double valor = 0.6180339887;
        double r = chave * valor;
        r = r - (int) r;
        r= (int)(r * tabela.length);
        while(tabela[(int)r]!= 0){
            colisao+=1;
            r= (r+1)% tabela.length;
        }
        tabela[(int)r] = chave;
        return colisao;
    }
    static long busca_multiplica(int chave,int tabela []){
        long comparacoes=1;
        double valor = 0.6180339887;
        double r = chave * valor;
        r = r - (int) r;
        r= (int)(r * tabela.length);
        while(tabela[(int)r]!= 0 && tabela[(int)r]!=chave){
            comparacoes+=1;
            r= (r+1)% tabela.length;
        }
        return comparacoes;
    }

    static long insere_dobra(int chave,int tabela []){
        int a=0,b=0,c=0;
        long colisao=0;
        a = chave / tabela.length;
        b = ((chave / tabela.length))%tabela.length;
        c = chave % tabela.length;
        int soma = a+b+c;
        int i = soma % tabela.length;
        while(tabela[i]!= 0){
            colisao+=1;
            i= (i+1)% tabela.length;
        }
        tabela[i] = chave;
        return colisao;
    }
    static long busca_dobra(int chave,int tabela []){
        int a=0,b=0,c=0;
        long comparacoes=1;
        a = chave / tabela.length;
        b = ((chave / tabela.length))%tabela.length;
        c = chave % tabela.length;
        int soma = a+b+c;
        int i = soma % tabela.length;
        while(tabela[i]!= 0 && tabela[i]!=chave){
            comparacoes+=1;
            i= (i+1)% tabela.length;
        }
        return comparacoes;
    }
public static float elapsedTime(long endTime, long startTime) {
    return (endTime - startTime) / 1e6f; // Convertendo de nanossegundos para milissegundos
}

public static void main(String[] args) {
    long startTime;
    long endTime;
    float tempo = 0.0f;
    float tempoBusca = 0.0f;
    int semente = 12345;
    int insercoes = 0;
    Registro r = new Registro(1);

    // criando vetores da tabela hash
    int[] tabelaA = new int[20500];
    int[] tabelaB = new int[105000];
    int[] tabelaC = new int[505000];
    int[] tabelaD = new int[1050000];
    int[] tabelaE = new int[5050000];

    Registro[] conjuntoA = new Registro[20000];
    Registro[] conjuntoB = new Registro[100000];
    Registro[] conjuntoC = new Registro[500000];
    Registro[] conjuntoD = new Registro[1000000];
    Registro[] conjuntoE = new Registro[5000000];

    conjuntoA = r.gerarAleatorio(conjuntoA, semente);
    conjuntoB = r.gerarAleatorio(conjuntoB, semente);
    conjuntoC = r.gerarAleatorio(conjuntoC, semente);
    conjuntoD = r.gerarAleatorio(conjuntoD, semente);
    conjuntoE = r.gerarAleatorio(conjuntoE, semente);
    long somaColisao=0;
    long somaComparacoes=0;
    
    // inserindo resto
    for (int i = 0; i < conjuntoE.length; i++) {
        insercoes++;
        startTime = System.nanoTime();
        somaColisao += insere_resto(conjuntoE[i].getCodigo(), tabelaE);
        endTime = System.nanoTime();
        tempo += elapsedTime(endTime, startTime);
    }
    
    float tempoFloat = tempo / insercoes;
    System.out.println("Numero de colisao: "+somaColisao);
    System.out.printf("\n\nTempo de inserção: %.2f milissegundos\n\n", tempoFloat);
    
    // numeros para encontrar
    int codigo1 =conjuntoA[19000].getCodigo();
    int codigo2 =conjuntoA[1400].getCodigo();
    int codigo3 =conjuntoA[2020].getCodigo();
    int codigo4 =conjuntoA[1].getCodigo();
    int codigo5 =conjuntoA[40].getCodigo();

    startTime=0;
    endTime=0;
    tempo = 0.0f;
    tempoBusca = 0.0f;
    startTime = System.nanoTime();
    somaComparacoes = busca_resto(codigo1, tabelaE);
    somaComparacoes += busca_resto(codigo2, tabelaE);
    somaComparacoes += busca_resto(codigo3, tabelaE);
    somaComparacoes += busca_resto(codigo4, tabelaE);
    somaComparacoes += busca_resto(codigo5, tabelaE);
    endTime = System.nanoTime();
    tempo = elapsedTime(endTime, startTime);
    System.out.println("####### B U S C A #######");
    System.out.println("\n");
    System.out.println(codigo1);
    System.out.println(codigo2);
    System.out.println(codigo3);
    System.out.println(codigo4);
    System.out.println(codigo5);
    System.out.println("\n");
    System.out.printf("Tempo de busca: %.2f ns\n\n",tempo);
    System.out.println("Numero de comparacoes: "+somaComparacoes);
        /*
        =======================================B U S C A R===============================
        */
        
        
    }
}