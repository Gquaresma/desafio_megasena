package br.upe;

import java.util.ArrayList;
import com.microsoft.playwright.*;


public class ResultadoLoteria {
    public static void obtemUltimoResultado(){

        try (Playwright playwright = Playwright.create()){
            
            String[] loterias = {"megasena", "quina", "diadesorte", "lotofacil", "lotomania"};
            String element = "[id=ulDezenas]";

            final BrowserType chromium = playwright.chromium();
            final Browser browser = chromium.launch();
            final Page page = browser.newPage();

            for(int i = 0; i < loterias.length; i++){
                if(loterias[i] == "lotofacil"){
                    element = ".lotofacil";

                } else if (loterias[i] == "lotomania") {
                    element = ".lotomania";
                }
                
                page.navigate("http://loterias.caixa.gov.br/wps/portal/loterias/landing/" + loterias[i]);
                
                final ElementHandle contElement = page.querySelector(element);

                String numeroSorteados = contElement.innerText();

                ResultadoLoteria.pairsNumbers(numeroSorteados, loterias[i]); 
                System.out.println("");
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pairsNumbers(String numbers, String loteria){

        final ArrayList<String> numbersArr = new ArrayList<>();

        for(int i = 0; i < numbers.length(); i+=2){
            numbersArr.add(numbers.substring(i, Math.min(numbers.length(), i + 2))); 
        }
        
        System.out.print( "Resultado " + loteria + " - ");
        for(String dezenas: numbersArr){
            System.out.print( dezenas + " ");
        }
        
    }
    
}
