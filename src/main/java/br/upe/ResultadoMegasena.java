package br.upe;

import java.util.ArrayList;
import com.microsoft.playwright.*;


public class ResultadoMegasena {
    public static void obtemUltimoResultado(){

        try (Playwright playwright = Playwright.create()){
            
            ResultadoMegasena rm = new ResultadoMegasena();
            final BrowserType chromium = playwright.chromium();
            final Browser browser = chromium.launch();
            final Page page = browser.newPage();

            page.navigate("http://loterias.caixa.gov.br/wps/portal/loterias/landing/megasena/");
            

            final ElementHandle contElement = page.querySelector("[id=ulDezenas]");

            String numeroSorteados = contElement.innerText();

            rm.pairsNumbers(numeroSorteados); 
            
        } catch (Exception e) {
            System.out.println("DEUUUUUUUUUUU ERRRRRRRRRRRRROOOOOOOOO");
            e.printStackTrace();
        }
    }

    private ArrayList<String> pairsNumbers(String numbers){

        final ArrayList<String> numbersArr = new ArrayList<>();
        for(int i = 0; i < numbers.length(); i+=2){
            numbersArr.add(numbers.substring(i, Math.min(numbers.length(), i + 2)));
            
        }

        for(String dezenas: numbersArr){
            System.out.print(dezenas + " ");
        }
        return numbersArr;
    }
    
}
