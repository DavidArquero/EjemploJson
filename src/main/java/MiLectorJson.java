import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
public class MiLectorJson {

    public static void main(String[] args) {
        String filePath = "src/main/java/datosUsuario.json"; // Cambia esto por la ruta real de tu archivo JSON
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la nueva habilidad de Yeneffer");
        String newHabilidad = scanner.nextLine();



        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject objetoJSON = new JSONObject(content);
            JSONArray habilidades = objetoJSON.getJSONArray("habilidades");
            habilidades.put(newHabilidad);
            try(FileWriter file = new FileWriter(filePath)){
                file.write(objetoJSON.toString(4));
                file.flush();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            // Acceder al elemento "nombre" y mostrarlo:
            String nombre = objetoJSON.getString("nombre");
            System.out.println("El nombre en el JSON es: " + nombre);

        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }


    }
}
