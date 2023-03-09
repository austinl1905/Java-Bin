import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class StackElements {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> elementInput = new ArrayList<>();
    private static String[] nonMetals = {"H", "He", "C", "N", "O", "F", "Ne", "P", "S", "Cl", "Ar", "Se", "Br", "Kr", "I", "Xe", "Rn"};
    private static String[] syntheticElements = {"Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og"};
    private static String[] metalloids = {"B", "Ge", "Si", "As", "Sb", "Te", "Po"};
    private static String[] metals = {"Be", "Li", "Na", "K", "Rb", "Cs", "Fr", "Mg", "Ca"};

    static void APIRequest() throws Exception {
        try {
            URL url = new URL("https://neelpatel05.pythonanywhere.com/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            JSONObject responseJson = new JSONObject(sb.toString());

            // Extract atomic symbols from the JSON response
            JSONArray elementsArray = responseJson.getJSONArray("elements");
            for (int i = 0; i < elementsArray.length(); i++) {
                JSONObject elementObject = elementsArray.getJSONObject(i);
                String symbol = elementObject.getString("symbol");
                System.out.println(symbol);
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void checkForSyntheticElement(ArrayList<String>elementInput) {
        for (int i = 0; i < elementInput.size(); i++) {
            String s1 = elementInput.get(i);
            for (String s2 : syntheticElements) {
                if (s1.equals(s2)) {
                    System.out.println("Cannot form ionic compound because element " + s1 + " is synthetic");
                    elementInput.clear();
                    scanner.close();
                    return;
                }
            }
        }
    }

    static void checkForElementMismatch(ArrayList<String> elementInput) {
        int nonMetalCount = 0;
        int metalloidCount = 0;
        int metalCount = 0;

        for (int i = 0; i < elementInput.size(); i++) {
            String element = elementInput.get(i);
            for (int j = 0; j < nonMetals.length; j++) {
                if (element.equals(nonMetals[j])) {
                    nonMetalCount++;
                }
            }

            for (int j = 0; j < metalloids.length; j++) {
                if (element.equals(metalloids[j])) {
                    metalloidCount++;
                }
            }

            for (int j = 0; j < metals.length; j++) {
                if (element.equals(metals[j])) {
                    metalCount++;
                }
            }
        }

        if (nonMetalCount > 1 || metalloidCount > 1 || metalCount > 1) {
            System.out.println("Cannot form ionic compound with multiple elements of the same type");
            return;
        }
    }



    public static void main(String[]args) {
        System.out.println("Please enter two symbols of valid elements to form an ionic bond, separated by spaces (case sensitive):");
        String userInput = scanner.nextLine();

        String[] tokens = userInput.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            elementInput.add(tokens[i]); }

        checkForSyntheticElement(elementInput);
        checkForElementMismatch(elementInput);
    }
}