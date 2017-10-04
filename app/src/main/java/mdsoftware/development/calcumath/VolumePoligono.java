package main.java.mdsoftware.development.calcumath;

public class VolumePoligono{
    public String Cubo(float l){
        float resultado = l*l*l;
        String saida = "Volume do Cubo = Lado³ ;     Volume = "+resultado;        

        return saida;
    }
    public String Paralelepípedo(float c,float l,float a){
        float resultado = c*l*a;
        String saida = "Volume do Paralelepípedo = Comprimento x Largura x Altura ;     Volume = "+resultado;        

        return saida;
    }
    public String PrismaReg(float b,float hb,float h){
        float resultado = (b*hb)/2*h;
        String saida = "Volume do Prisma Regular = Área da Base '(Base x Altura)/2' * Altura ;     Volume = "+resultado;        

        return saida;
    }
    public String Cilindro(float r,float h){
        float resultado = r*r*h;
        String saida = "Volume do Cilíndro = π x Raio² x Altura ;     Volume = "+"π"+resultado+" ou considerando π = 3,14 // "+resultado*3.14;        

        return saida;
    }
    public String Cone(float r,float h){
        float resultado = 1/3*r*r*h;
        String saida = "Volume do Cone = 1/3 x Área da Base 'π x Raio²' x Altura ;     Volume = π"+resultado+" ou considerando π = 3,14 // "+resultado*3.14;        

        return saida;
    }
    public String Esfera(float r){
        float resultado = 4/3*r*r*r;
        String saida = "Volume da Esfera = 4/3 x π x Raio³ ;     Volume = π"+resultado+" ou considerando π = 3,14 // "+resultado*3.14;        

        return saida;
    }
}