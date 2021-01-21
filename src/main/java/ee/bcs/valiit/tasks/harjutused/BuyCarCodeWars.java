package ee.bcs.valiit.tasks.harjutused;

public class BuyCarCodeWars {

    public static void main(String[] args){

        nbMonths(2000, 8000, 1000, 1.5);

    }


    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int month = 1;

    Double startPriceOldD =(double) startPriceOld;
    Double startPriceNewD =(double) startPriceNew;
        Double  asset = startPriceOldD;
        Double savings = 0.0;
   int [] ret = new int [2];


        while(asset < startPriceNewD) {
            if ( month % 2 == 0 ) {
                percentLossByMonth =  percentLossByMonth + 0.5;
            }

            startPriceOldD = startPriceOldD -( startPriceOldD * ( percentLossByMonth / 100 ) );
            savings = savings + savingperMonth;
            asset = savings + startPriceOldD;


            startPriceNewD = startPriceNewD - ( startPriceNewD * ( percentLossByMonth / 100 ) );

            month++;


        }
        int ans = (int) Math.round(asset-startPriceNewD);
        ret[0] = month-1;
        ret[1] = ans;
        return ret;
    }

}



