/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbermultiplier;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class PrimeNumberMultiplier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PrimeNumberMultiplier object = new PrimeNumberMultiplier();
        object.run();
    }
    
    
    
    public void run(){
        int value = getInput();
        
        int[] primeArray = new int[value];
        
        primeArray = createArray(value);
        createTable(value, primeArray);
    }
    
    public int getInput(){
        Scanner user_input = new Scanner(System.in);
        
        int value;
        System.out.print("Enter a numerical value: \t");
        value = user_input.nextInt();
        
        return value;
    }
    
    public int[] createArray(int max){
        int[] primeNumber = new int[max];
        
        
        
        for(int i = 0; i < max; i++){     
            switch(i){
                case 0:
                    primeNumber[i] = 2;
                    break;
                case 1:
                    primeNumber[i] = 3;
                    break;
                case 2:
                    primeNumber[i] = 5;
                    break;
                case 3:
                    primeNumber[i] = 7;
                    break;
                case 4:
                    primeNumber[i] = 11;
                    break;
                case 5:
                    primeNumber[i] = 13;
                    break;
                case 6:
                    primeNumber[i] = 17;
                    break;
                case 7:
                    primeNumber[i] = 19;
                    break;
                case 8:
                    primeNumber[i] = 23;
                    break;
                case 9:
                    primeNumber[i] = 29;
                    break;
                default:
                    primeNumber[i] = calculatePrime(primeNumber, i);
                    break;
            }
        }
        return primeNumber;
    }
    
    public int calculatePrime(int[] array, int position){
        int primeInt = 0;
        boolean isPrime = false;
        int divisible;
        int current = array[position-1] + 1;
        int j = 0;
        
        while(isPrime == false){
            divisible = 0;
            j = 2;
            while(divisible == 0 && j < current){                                
                int remainder = current % j;
                if(remainder == 0){
                    divisible++;
                }
                j++;
            }
            
                
            if(j == current && divisible == 0){
                primeInt = current;
                isPrime = true;
            }else{
                divisible = 0;
                current++;
            }    
        }
        
        return primeInt;
    }
    
    public void createTable(int value, int[] array){
        int N = value;
        
        for(int r = 0; r <= N; r++){
            for(int c = 0; c <= N; c++){
                if(r == 0 && c == 0){
                    System.out.print("\t");
                }else if(r == 0){
                    System.out.print("|" + Integer.toString(array[c-1]) + "\t");
                    }else if(c == 0){
                            System.out.print("|" + Integer.toString(array[r-1]) + "\t");
                            }else{
                                int number = array[r-1] * array[c-1];
                                System.out.print("|" + Integer.toString(number) + "\t");
                }
            }
            System.out.println();
        }
    }
    
}
