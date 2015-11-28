package com.edminstallerjp;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Json   
{
    public static Json instance = new Json();
    private String RunLocation = System.getProperty("user.dir");
    public static Config config = new Config();
    public static EDMI es = new EDMI();
    public static void genDefaults(){
        config.setname("MinecraftForge");
        config.setvalue("false");
        es.setname("EDM");
        es.setvalue("false");
    }

    public void run() {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(es);
            String json2= gson.toJson(config);
            // File.WriteAllText(RunLocation + "/config.json", gson.toJson(config));
            // File.WriteAllText(RunLocation + "/config.json", Gson.SerializeObject(es));
            // serialize JSON directly to a file
            // PrintWriter file = new PrintWriter(new OutputStreamWriter(new FileOutputStream(RunLocation + "/config.json"), Charset.forName("UTF-8")));
            
            //  System.out.print(json);
            //  System.out.print(json2);
            FileWriter writer = new FileWriter(RunLocation+"/config.json");
            writer.write(json);
            writer.write(json2);
            writer.close();
            //  serializer.Serialize(file, config);
            //  serializer.Serialize(file, es);
        } catch (IOException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

}


