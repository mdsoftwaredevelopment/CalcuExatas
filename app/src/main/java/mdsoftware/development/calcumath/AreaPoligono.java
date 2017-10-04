package mdsoftware.development.calcumath;

public class AreaPoligono{
    public String quadrado(float l){
        float resultado = l*l;
        String saida = "Área do quadrado = Lado x Lado ;     Área = "+resultado;

        return saida;
    }
    public String retangulo(float l1, float l2){
        float resultado = l1*l2;
        String saida = "Área do retângulo = Lado x Comprimento ;     Área = "+resultado;

        return saida;
    }
    public String triangulo(float b, float h){
        float resultado = (h*b)/2;
        String saida = "Área do triângulo = (Base x Altura)/2 ;     Área = "+resultado;

        return saida;
    }
    public String losango(float d, float di){
        float resultado = (d*di)/2;
        String saida = "Área do losango = (Diagonal maior x Diagonal Menor)/2 ;     Área = "+resultado;

        return saida;
    }
    public String trapezio(float b, float bm, float h){
        float resultado = (b*bm)/2*h;
        String saida = "Área do trapézio = (Base x Base Maior)/2 * Altura ;     Área = "+resultado;

        return saida;
    }
    public String poligonoReg(float p, float a){
        float resultado = (p/2)*a;
        String saida = "Área de um polígono regular = (Perímetro/2)*Apótema ;     Área = "+resultado;

        return saida;
    }
    public String circulo(float r){
        float resultado = r*r;
        String saida = "Área do circulo = π*raio² ;     Área = "+"π"+resultado+" ou considerando  π = 3,14 // Área = "+resultado*3.14;

        return saida;
    }
}