package repasoc;

import java.util.Scanner;

public class RepasoC {

    public static void main(String[] args) {
        
        for (int i = 0; i <= 10; i++) {
            System.out.println("a");
        }
        
        // validarNota();
        //rs232();
        //ejercicio18();
    }

    /*
12. Escriba un método que valide si una nota ingresada por teclado está entre 0 y 10, sino está
entre 0 y 10 la nota se pedirá de nuevo hasta que la nota sea correcta.
    
     */
    public static void validarNota() {
        Scanner sc = new Scanner(System.in);

        int nota = 0;

        do {
            System.out.println("Ingrese la nota (1-10)");
            nota = sc.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("nota incorrecta");
            } else {
                System.out.println("Correcto");
            }
        } while (nota < 0 || nota > 10);
    }

    /*13. Escriba un método en el cual se ingrese un valor límite positivo, y a continuación solicite
números al usuario hasta que la suma de los números introducidos supere el límite inicial.*/
    public static void limite() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero limite");
        int limit = sc.nextInt();
        int sumando = 0;
        while (sumando <= limit) {
            System.out.println("Ingrese un numero que será sumado al siguiente");
            sumando = sumando + sc.nextInt();

        }
        System.out.println("");
    }

    /*
    14. Realizar un método que pida dos números enteros positivos por teclado y muestre por pantalla
el siguiente menú:
MENU
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elija opción:

El usuario deberá elegir una opción y el programa deberá mostrar el resultado por pantalla y luego
volver al menú. El método deberá ejecutarse hasta que se elija la opción 5. Tener en cuenta que,
si el usuario selecciona la opción 5, en vez de salir del programa directamente, se debe mostrar el
siguiente mensaje de confirmación: ¿Está seguro que desea salir (S/N)? Si el usuario selecciona
el carácter ‘S’ termina, caso contrario se vuelve a mostrar el menú.
     */
    public static void ejercicio14() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dos numeros:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        String respuesta = "";
        System.out.println("--------BIENVENIDO--------");

        do {
            System.out.println("1.SUMAR");
            System.out.println("2.RESTAR");
            System.out.println("3.MULTIPLICAR");
            System.out.println("4.DIVIDIR");
            System.out.println("5.SALIR");
            System.out.println("Ingrese la operacion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(num1 + num2);
                    break;
                case 2:
                    System.out.println(num1 - num2);
                    break;
                case 3:
                    System.out.println(num1 * num2);
                    break;
                case 4:
                    if(num2!=0 ){
                        System.out.println(num1 / num2);
                    }else{
                        System.out.println("Imposible dividir");
                    }
                    
                    break;
                case 5:
                    System.out.println("Seguro que quieres salir del programa? (S/N)");
                    respuesta = sc.next();
                    break;
                default :
                    System.out.println("Operation no found");
                    break;
            }
            
        } while (!respuesta.equalsIgnoreCase("S"));

    }

    /*
    15. Escriba un método que lea 20 números. Si el número leído es igual a cero se debe salir del
bucle y mostrar el mensaje "Se capturó el número cero". El método deberá calcular y mostrar el
resultado de la suma de los números leídos, pero si el número es negativo no debe sumarse. Nota:
recordar el uso de la sentencia break.
     */
    
    public static void ejercicio15(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese 20 números: ");
        int suma = 0;
        int acumulador = 0 ;
        int i;
        for ( i = 1; i <= 20; i++) {
            System.out.print("Ingrese el "+i+"° número: ");
            suma = sc.nextInt();
            if(suma==0){
                System.out.println("Se capturo el número 0.FIN DEL PROGRAMA");
                break;//Sale del bucle
            }
            if(suma>0){
                acumulador+=suma;
            }
            
        }
        System.out.println("La suma total de los "+i+" número lehidos es: "+acumulador);
    }
 /*
    16. Escribir un método que simule el funcionamiento de un dispositivo RS232, este tipo de
dispositivo lee cadenas enviadas por el usuario. Las cadenas deben llegar con un formato fijo:
tienen que ser de un máximo de 5 caracteres de largo, el primer carácter tiene que ser X y el último
tiene que ser una O.
Las secuencias leídas que respeten el formato se consideran correctas, la secuencia especial
“&&&&&” marca el final de los envíos (llamémosla FDE), y toda secuencia distinta de FDE, que
no respete el formato se considera incorrecta. Al finalizar el proceso, se imprime un informe
indicando la cantidad de lecturas correctas e incorrectas recibidas. Para resolver el ejercicio deberá
investigar cómo se utilizan los siguientes métodos de la clase String: Substring(), Length(),
equals().
    |charAt(int index) Retorna el carácter especificado en la posición index
    |equals(String str) Sirve para comparar si dos cadenas son iguales. Devuelve true si son
    |iguales y false si no.
    |length() Retorna la longitud de la cadena
    
     */
    public static void rs232() {
        Scanner sc = new Scanner(System.in);
        String cadena;
        int secuenciasCorrectas = 0;
        int secuenciasIncorrectas = 0;
        System.out.println("Bienvenido al (RS232)");
        do {
            System.out.println("_________________________________");
            System.out.println("Ingrese la secuencia de mensajes");
            cadena = sc.nextLine();
            if (cadena.length() == 5 && (cadena.charAt(0) == 'x') && (cadena.charAt(4) == 'o')) {
                secuenciasCorrectas++;

            } else if (cadena.equals("&&&&&")) {
                break;
            } else {
                secuenciasIncorrectas++;
            }

        } while (!cadena.equals("&&&&&"));//secuencia especial “&&&&&” marca el final de los envíos (llamémosla FDE)
        System.out.println("---------------INFORME---------------");
        System.out.println("Correctas: " + secuenciasCorrectas);
        System.out.println("Incorrectas: " + secuenciasIncorrectas);

    }
    /*
    17. Crear un método que dibuje un cuadrado de N elementos por lado utilizando el carácter “*”.
Por ejemplo, si el cuadrado tiene 4 elementos por lado se deberá dibujar lo siguiente:
    
    
* * * *
*     *
*     *
* * * *
   
El valor de N se ingresará por teclado y en este caso utilice la estructura while para dibujarlo.
     */
    
    public static void ejercicio17(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el valor límite del cuadrado: ");
        
        int limite = sc.nextInt();
        int fila = 1;
        
        while(fila<=limite){
            int columna = 1;
            while(columna<=limite){
                if(fila==1 || fila==limite || columna==1 || columna==limite){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
                columna++;
            }
            System.out.println();
            fila++;
        }
        
    }
    /*
    18. Realizar un método que lea 4 números (comprendidos entre 1 y 20) e imprima el número
ingresado seguido de tantos asteriscos como indique su valor. Por ejemplo:
5 *****
3 ***
11 ***********
2 **
    */
    
    public static void ejercicio18(){
        Scanner sc = new Scanner(System.in);
        
        for (int i = 1; i < 4; i++) {
            System.out.println("Ingrese el "+i+"° valor: ");
            int num = sc.nextInt();
            
            
            if(num>=1 && num<=20){
                System.out.print(num+" ");
                for (int j = 1; j <= num; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }else{
                System.out.println("El numero está fuera del rango comprendido");
                i--;
            }
        }
        
    }
}
