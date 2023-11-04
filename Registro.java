/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho03;
import java.util.Random;
/**
 *
 * @author gustavocoradin
 */
class Registro {
    int codigo;

    public Registro(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public  Registro[] gerarAleatorio(Registro vetor[], long seed) {
        Random rand = new Random(seed);
        for (int i = 0; i < vetor.length; i++) {
            int aleatorio = rand.nextInt(900000000) + 100000000;
            vetor[i] = new Registro(aleatorio);
        }
        return vetor;
    }

}
