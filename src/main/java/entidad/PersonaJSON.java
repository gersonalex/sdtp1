package entidad;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PersonaJSON {

    public static void main(String[] args) throws Exception {

        System.out.println("Ejemplo de uso 1: pasar de objeto a string");
        Persona p = new Persona();
        p.setNombre("Alex");
        p.setUsuario("alexgerson");
        p.setPassword("alexgerson0");

        String r1 = PersonaJSON.objetoString(p);
        System.out.println(r1);

        System.out.println("\n*************************************************************************");
        System.out.println("\nEjemplo de uso 2: pasar de string a objeto");
        String un_string = "{\"nombre\":\"Alex\",\"usuario\":\"alexgerson\",\"password\":\"alexgerson0\"}";
        Persona r2 = PersonaJSON.stringObjeto(un_string);
        System.out.println(r2.nombre + " " + r2.usuario + " " + r2.password);

    }
    
    public static String objetoString(Persona p) {	 	
        JSONObject obj = new JSONObject();
        obj.put("nombre", p.getNombre());
        obj.put("usuario", p.getUsuario());
        obj.put("password", p.getPassword());

        return obj.toJSONString();
    }
    
    public static Persona stringObjeto(String str) throws Exception {
    	Persona p = new Persona();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(str.trim());
        JSONObject jsonObject = (JSONObject) obj;

        p.setNombre((String)jsonObject.get("nombre"));
        p.setUsuario((String)jsonObject.get("usuario"));
        p.setPassword((String)jsonObject.get("password"));

        return p;
    }
}
