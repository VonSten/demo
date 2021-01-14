package ee.bcs.valiit.tasks;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    public static void main(String[] args) {
        //evenFibonacci(10);
        //  morseCode("Tee see TEXT morsekoodiks");
        //  randomGame();
    }


    //liida kokku kõik paaris fibonacci arvud kuni numbrini x
    public static int evenFibonacci ( int x){

        int temp =0;
        int count = 0;
        int fibon = 0;

        while(x > fibon) {
            fibon = Lesson2.fibon(count);
            if(fibon % 2 == 0) {
                temp = temp + fibon;
            }
            count++;
        }

        System.out.println((temp));

        return temp;
    }

    public static void randomGame ( ) {
        // kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        Random random = new Random();
        int guess = random.nextInt(100);

        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();
        boolean win = false;
        int count = 0;

        while(!win) {
            count ++;
            if ( input > guess ) {
                System.out.println("Number on väiksem!!!");
                input = scn.nextInt();
            }

            else if( input < guess){
                System.out.println("Number on suurem!!" );
                input =  scn.nextInt();
            }

            else if( input == guess){
                win = true;
            }
        }
        System.out.println("VÕIT ! " + count+ " -käiku" );
    }

    public static String morseCode (String text){
        // kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        Map<Character, String> morseMap = new HashMap<Character, String>();
        morseMap.put('a', "• −");
        morseMap.put('b', "− • • •");
        morseMap.put('c', "− • − •");
        morseMap.put('d', "− • •");
        morseMap.put('e', "− • •");
        morseMap.put('f', "• • − •");
        morseMap.put('g', "− − •");
        morseMap.put('h', "• • • •");
        morseMap.put('i', "• •");
        morseMap.put('j', "• − − −");
        morseMap.put('k', "− • −");
        morseMap.put('l', "• − • •");
        morseMap.put('m', "− •");
        morseMap.put('n', "− − −");
        morseMap.put('o', "• − − •");
        morseMap.put('p', "− − • −");
        morseMap.put('r', "• − •");
        morseMap.put('s', "• • •");
        morseMap.put('t', "−");
        morseMap.put('u', "• • −");
        morseMap.put('v', "• • • −");
        morseMap.put('w', "• − −");
        morseMap.put('x', "− • • −");
        morseMap.put('z', "− • − −");
        morseMap.put('y', "− − • •");


        text = text.toLowerCase();
        char[] txt = text.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < txt.length; i++) {
            if ( morseMap.containsKey(txt[i]) ) {
                sb.append(morseMap.get(txt[i]));

            } else {
                sb.append(" * ");
            }
        }
        System.out.println(( sb.toString() ));


        return sb.toString();
    }
}
