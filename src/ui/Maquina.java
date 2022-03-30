package ui;
import java.util.Scanner;
import java.util.Random;
/*Descripcion: Este programa es una maquina de touring finita la cual permite realizar movimientos de cabezal, 
cambios de numero, sobreescrimir, ver el estador de la maquina y generarla manualmente
Entradas: 
numeroCaso:Esta variable de tipo int le pide al usuario un numero, de este numero dependera el caso al que entrara el usuario (crear maquina, verificar estado de la maquina, ingresar instruccion o salida)
tamañoCinta: Esta variable es de tipo int y le pedira al usuario el tamaño del arreglo




*/

public class Maquina {

	public static char[] arregloGlobal;
	public static char[] arregloCabezal;

	public static int salida=0;
	public static String instruction;
	public static int posCabezal=0;
	//public static char estado;
	public static String estadoVaria;
	public static char resta=1;
	//public static int sizeArrayAle;
	//public static int numAle=0;
	public static int num=0;
	//ublic static int sizeArrayAle=numAle.nextInt(100);
	/*Random numAle = new Random();
	int sizeArrayAle=numAle.nextInt(100);*/
	public static int estado=0;
	public static int cabezalFinal=0;

	
	/**
	* Descripción: Toda la ejecucion de el codigo principal, crear maquina, vereficar estado, introducir instruccion
	* y salir
	* pre: arregloGlobal= se introduciran ahi los caracteres que el usuario escoja
	* 			   instruction= Capturara la instruccion del usuario
	*              estadoVaria=tomara el estado inical de la maquinam introducido por el usuario 
	* pos: arregloGblobal= cambia dependiendo de la instruccion del usuario
	* 			   instruction=Cabiara cuando el usuario quiera dar una nueva instruccion
	*              estadoVaria=Cambiara dependiendo de la instruccion del usuario
	*/


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		while (salida!=5){

	
			//System.out.println("arreglo random"+randomArray(arregloGlobal));
			//System.out.println("su arreglo generado es" +imprimirArreglo(arregloGlobal));
			System.out.println("¿Que desea hacer?");
		
			System.out.println("1. Crear su maquina manualmente");
		
			System.out.println("2. Crear su maquina automaticamente (FUNCION DESHABILITADA TEMPORALMENTE)");
		
			System.out.println("3. Ingresar un instruccion");
		
			System.out.println("4. Verificar estado de la maquina");
		
			System.out.println("5. Salir");
			
			int numeroCaso= sc.nextInt();
				switch (numeroCaso){
					case 1:
					System.out.println("ingrese el tamaño de cinta que desea");
					int tamañoCinta= sc.nextInt();
					arregloGlobal = new char[tamañoCinta];
					arregloCabezal= new char[tamañoCinta];
					for(int i=0; i<tamañoCinta; i++){
						System.out.println("Digite los caracteres que desee, en orden: ");
						arregloGlobal[i] = sc.next().charAt(0);
					}
				
						
							System.out.println("Ingrese el estado en el que desea que empiece la maquina");
							
							String estadoUser = sc.next();
							estadoVaria=estadoUser;
						
							System.out.println("Ingrese la posicion en la que desea que se ubique el cabezal");
						
							int cabezal= sc.nextInt();
							
							posCabezal= cabezal-1;
							//int cabezalFinal= cabezal-1;
							//posCabezal=cabezalFinal;


							System.out.println("Su maquina iniciara en el estado: " +estadoVaria);
							System.out.println("El cabezal de su maquina iniciara en la posicion: " +cabezal);
							System.out.println("Su cinta contine los siguientes valores: " +imprimirArreglo(arregloGlobal));
						cabezalFinal=posCabezal+1;
					

							break;
					case 2:


						/*aleatorio*/

						break;

					case 3:
						boolean flag = true;
						while (flag==true){
							System.out.println("Digite una instruccion valida");
							String instruction=sc.nextLine();
							instruction=sc.nextLine();
							//Revisar por que la pide dos veces despues de la 2da repeticion
							
							//orma de recuperar caracter individual ntruction.charAt()
							if (instruction.length()!=5){
								System.out.println("error ha introducido una instruccion invalida, por favor vuelva a intentarlo.");

									//revisar el else if
							} else if(instruction.charAt(0)!=arregloGlobal[posCabezal]){
								System.out.println("Error, la posicion introducida no es en la que la maquina se encuentra actualmente");
								//revisar!
							}else if(!(instruction.charAt(1)+"").equals(estadoVaria)){
								System.out.println("Error, el estado introducido no es en el que la maquina se encuentra actualmente");
							}else if (instruction.charAt(0)==arregloGlobal[posCabezal]){
								arregloGlobal[posCabezal]=instruction.charAt(2);
								//(SOLO PARA PRUEBA) System.out.println("Su cinta contine los siguientes valores: " +imprimirArreglo(arregloGlobal));
							}
							if (instruction.charAt(3)=='L'){
									posCabezal=posCabezal-1;	
							
							}else if(instruction.charAt(3)=='R'){
									posCabezal=posCabezal+1;
							}


							 if(!(instruction.charAt(4)+"").equals(estadoVaria)){
								estadoVaria=instruction.charAt(4)+"";
								flag=false;
							
							}
								//estadoVaria=posCabezal+"";

								//estado=estadoVaria+1+"";	
							cabezalFinal=posCabezal+1;
									

							/*else if (!(instruction.charAt(3)+"").equals("L")){
								System.out.println(instruction.charAt(3)+"La instruccion dada es incorrecta, no especifica asi donde se debe mover el ca bezal");
							}

									System.out.println(instruction.charAt(3));*/
									


						}

						break;
					case 4:
						System.out.println("La maquina se encuentra en la posicion:"+cabezalFinal);
						System.out.println("El estado actual de la maquina es: " +estadoVaria);
							
							System.out.println("Su cinta contine los siguientes valores: " +imprimirArreglo(arregloGlobal));

						break;

					case 5:
						System.out.println("Adios!");
						salida=5;
						break;
			}
		}

	
	}
	/**
	* Descripción: Imprimira el arreglo de una forma grafica
	* 
	* @return msg String
	* @param cinta char[] 
	*/

	public static String imprimirArreglo(char[] cinta){
		String msg = "";

		for (int j=0; j<cinta.length; j++){

			if (j==0){
				msg=msg+"["+cinta[j];
			}else if (j==cinta.length-1){
				msg=msg+"|"+cinta[j]+"]";
			}else {
				msg=msg+"|"+cinta[j];
			}
			
		}

		return msg;
	}
	/*public static String imprimirArreglo2(char[] cint){
		String msg2 = "";

		for (int l=0; l<cint.length; l++){

			if (l==0){
				msg2=msg2+"["+cint[l];
			}else if (l==cint.length-1){
				msg2=msg2+"|"+cint[l]+"]";
			}else {
				msg2=msg2+"|"+cint[l];
			}
			
		}

		return msg2;
	}*/
	

	/*public static String randomArray(char[]array){
		Random numAle = new Random();
		char sizeArrayAle=10;
		array = new char[sizeArrayAle];
		
		String setOfCharacters = "123456789";
		String msg2="";
		//arregloGlobal=[sizeArrayAle];
		
		for (int l=0; l<array[sizeArrayAle]; l++){
			//num=numAle.nextInt(9);
			int randomInt = numAle.nextInt(setOfCharacters.length());
			//array[l]=numAle.nextInt(9);
				char randomChar = setOfCharacters.charAt(randomInt);

		}
		msg2=msg2+array;

		return msg2;
	}*/
}






	