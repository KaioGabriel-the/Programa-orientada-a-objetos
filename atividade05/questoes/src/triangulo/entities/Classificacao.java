package triangulo.entities;

public class Classificacao {

    public float ladoum;
    public float ladodois;
    public float ladotres;

    public Classificacao(float ladoum, float ladodois, float ladotres){
        this.ladoum = ladoum;
        this.ladodois = ladodois;
        this.ladotres = ladotres;
    }

    public boolean ehTriangulo(){
        return (ladoum + ladodois > ladotres) &&
                (ladoum + ladotres > ladodois) &&
                (ladodois + ladotres > ladoum);
    }

    public void ehIsoceles(){
        if(ladoum == ladodois || ladodois == ladotres || ladoum == ladotres){
            System.out.println("É isoceles");
        }
    }

    public void ehEquilatero(){
        if(ladoum == ladodois && ladoum == ladotres){
            System.out.println("É equilatero");
        }
    }

    public void ehEscaleno(){
        if(ladoum != ladodois && ladodois != ladotres && ladoum != ladotres){
            System.out.println("É escaleno");
        }
    }
}
