package tienda;

import java.util.Scanner;

public class Tienda {

    public static void main(String[] args) {
    Scanner teclado=new Scanner(System.in);
    final double[] precio={20.50,25.30,40.10,30,80.99};
    int[] stock={10,3,1,2,3};
    final String[] articulo={"PUÑO AMERICANO ACERO COLOR BRONCE MODELO GRILLETES","PUÑO AMERICANO ACERO COLOR DORADO MODELO CARAVERAS",
    "PUÑO AMERICANO ACERO COLOR NEGRO MOD.MURCIELAGO", "PUÑO AMERICANO ACERO COLOR MORADO MODELO RATA", "PUÑO AMERICANO PERSONALIZADO A SU GUSTO"};
    int cantidad[];
    cantidad = new int[5];
    double puño[];
    puño = new double[5];
    double totalsiniva=0,iva,recargo, precioplazos;
    int cantidadtotal=0,esperando,stocktotal=0,pagar, plazos;
    String nombre;
        do{
        System.out.println("\u001b[35m------------------------------------------------------------\n"+
            "\u001b[35m------------------------------------------------------------\n"+
            "\u001b[31m                   BIENVENIDO A LA CALAVERA®\n"+
            "\u001b[31m              TU TIENDA ONLINE DE PUÑOS AMERICANOS\n"+
            "\u001b[31m                     PARA TODA LA FAMILIA\n"+
            "\u001b[35m------------------------------------------------------------\n"+
            "\u001b[35m------------------------------------------------------------\n"+
            "                      _,.-------.,_\n"+
            "                  ,;~'             '~;,\n"+
            "                ,;                     ;,\n"+
            "               ;                         ;\n"+
            "              ,'                         ',\n"+
            "             ,;                           ;,\n"+
            "             ; ;      .           .      ; ;\n"+
            "             | ;   ______       ______   ; |\n"+
            "             |  `/~!     ~! . !~     !~\'  |\n"+
            "             |  ~  ,-~~~^~, | ,~^~~~-,  ~  |\n"+
            "              |   |        }:{        |   |\n"+
            "              |   l       $ | $       !   |\n"+
            "              .~  (__,.--! .^. !--.,__)  ~.\n"+
            "              |     ---;' / | ª `;---     |\n"+
            "               !__.       !ª^ª/       .__/\n"+
            "               V| !                 ª |V\n"+
            "                | |T~!___!___!___/~T| |\n"+
            "                | |`IIII_I_I_I_IIII'| |\n"+
            "                |  !,III I I I III,/  |\n"+
            "                 !   `~~~~~~~~~~'    /\n"+
            "                   !   .       .   /\n"+
            "                     !.    ^    ./\n"+
            "                       ^~~~^~~~^\n"+
            "\u001b[35m------------------------------------------------------------\n"+
            "\u001b[35m------------------------------------------------------------\n"+
            "                   ARTÍCULOS EN STOCK:\n");
            for (int i=0;i<articulo.length;i++) {
                System.out.print(articulo[i]+"  - "+precio[i]+" €"+" HAY "+stock[i]+" EN STOCK\n");
            }
            System.out.print("\u001b[35m------------------------------------------------------------\n"+
            "\u001b[35m------------------------------------------------------------\u001b[0m\n");
            for (int i=0; i<articulo.length;i++){
                if(stock[i]>0){
                    do{
                        System.out.println("¿Cuántos "+articulo[i]+" quiere?");
                        System.out.println("Quedan "+stock[i]);
                        System.out.println();
                        cantidad[i]=teclado.nextInt();
                    }while(cantidad[i]>stock[i]);
                    puño[i]=cantidad[i]*precio[i];
                    stock[i]=stock[i]-cantidad[i];
                }
                else{
                    cantidad[i]=0;
                    puño[i]=0;
                }
            }
            for (int i=0;i<cantidad.length;i++) {
                cantidadtotal=cantidadtotal+cantidad[i];
            }
            
            if(cantidadtotal>0){
                do{
                    teclado.nextLine();
                    System.out.println("Introduzca su nombre y apellidos: ");
                    nombre=teclado.nextLine(); 
                }while(nombre.equals(""));
                System.out.println("\u001b[35m------------------------------------------------------------\n"+
                "\u001b[35m------------------------------------------------------------\n"+
                "                        FACTURA:\n"+
                "NOMBRE: "+nombre+"\n");
                for (int i=0; i<articulo.length; i++) {
                    System.out.print(articulo[i]+": "+cantidad[i]+" \n");
                    totalsiniva=totalsiniva+puño[i];
                }
                iva=totalsiniva*21/100;

                System.out.println("Total sin IVA: "+totalsiniva+" €");
                System.out.println("IVA(21%):"+iva+" €");
                iva=iva+totalsiniva;
                System.out.println("Total con IVA: "+iva+" €\n");
                do{
                System.out.println("Quiere pagar:\n"
                        + "1) En tarjeta\n"
                        + "2) En efectivo");
                pagar=teclado.nextInt();
                }while(pagar!=1 && pagar!=2);
                
                switch(pagar){
                    case 1:
                        recargo=iva*2/100;
                        iva=recargo+iva;
                        System.out.println("Recargo(2%): "+recargo+" €");
                        System.out.println("Precio final: "+ iva+" €\n");
                        do{
                            System.out.println("¿En cuántos plazos desea pagar?(1-24)");
                           plazos=teclado.nextInt();
                        }while(plazos<=0 && plazos>=24);
                        if(plazos>1 && plazos<25){
                            precioplazos=iva*(plazos-1)/100;
                            iva=iva+precioplazos;
                            System.out.println("Plazos: "+plazos);
                            plazos=plazos-1;
                            System.out.println("Aumento por pago a plazos("+plazos+"%):"+precioplazos+ " €");
                            System.out.println("Su precio final es: "+iva+" €");
                        }
                    break;
                    case 2:
                        do{
                            System.out.println("¿En cuántos plazos desea pagar?(1-24)");
                            plazos=teclado.nextInt();
                        }while(plazos<=0 && plazos>=24);
                        if(plazos>1 && plazos<25){
                            precioplazos=iva*(plazos-1)/100;
                            iva=iva+precioplazos;
                            System.out.println("Plazos: "+plazos);
                            plazos=plazos-1;
                            System.out.println("Aumento por pago a plazos("+plazos+"%):"+precioplazos+ " €");
                            System.out.println("Su precio final es: "+iva+" €");
                        }
                    break;
                }
                
                

                System.out.println("\u001b[35m------------------------------------------------------------\n"+
                "\u001b[35m------------------------------------------------------------\n"+
                "\u001b[31m  GRACIAS POR SU COMPRA SU PEDIDO LLEGARÁ EN 2 O 3 DÍAS\n"+
                "\u001b[31m           UN CORDIAL SALUDO DESDE LA CALAVERA®\n"+
                "\u001b[35m------------------------------------------------------------\n"+
                "\u001b[35m------------------------------------------------------------");
                stocktotal=0;
                for (int i=0; i<stock.length; i++) {
                    stocktotal=stocktotal+stock[i];
                }
                do{
                    if(stocktotal>0){
                        System.out.println("Hay alguien mas esperando?\n"
                            + "1)Si hay alguien esperando\n"
                            + "2)No hay nadie esperando");
                        esperando=teclado.nextInt();
                        if (esperando==2){
                            System.out.println("Cerramos por falta de clientes");
                        }
                        else{
                            
                        }
                    }
                    else{
                        System.out.println("Lo siento nos hemos quedado sin artículos en Stock");
                        esperando=2;
                    }
                }while(esperando!=1 && esperando!=2);
            }
            else{
                System.out.println("No has introducido ningún artículo");
                esperando=1;
            }
            
            
        }while(esperando!=2 && stocktotal>0);
    }
    
}
