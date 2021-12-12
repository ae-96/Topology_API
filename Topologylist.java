import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * this class aims to store all topologies and provide the interface to
 * the required APIs
 */
public class Topologylist {
    private final ArrayList<Topology> topologies = new ArrayList<>();
    public ArrayList<Topology> getTopologies() {
        return topologies;
    }

    /**
     * this function can be used to insert a topology as a JSON object to any topology lists
     * @param top  JSONObject to topology
     */
    public void addtopology(JSONObject top){
        String id = (String)top.get("id");
        JSONArray compnonents = (JSONArray) top.get("components");
        Topology temp_topology = new Topology(id , compnonents);
        topologies.add(temp_topology);
    }

    /**
     * this function  read json file which contains one topology and store it
     * @param file a string contains the filename
     * @throws IOException an exception may happen in case of any access permission problems
     * @throws ParseException an exception may happen if there is any error at json format
     */
    public void readjsonandstore(String file) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(file));
        JSONObject top = (JSONObject) obj;
        this.addtopology(top);
    }

    /**
     * this function write a given topology to a json file
     * @param file a string contains the filename
     * @param id a given topology ID
     * @throws FileNotFoundException an exception may happen in case of any access permission problems
     * @throws JsonProcessingException an exception may happen if any problems occurred while convert to json
     */
    public void writetopologytojson(String file , String id) throws FileNotFoundException, JsonProcessingException {
        for (Topology i : topologies){
            if (i.getId().equals(id)){
                JSONObject top = new JSONObject();
                top.put("id",id);
                top.put("compnonents",i.getcomponents());
                PrintWriter pw = new PrintWriter(file);
                ObjectMapper mapper = new ObjectMapper();
                pw.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(top));
                pw.flush();
                pw.close();
                break;
            }
        }
    }

    /**
     * this function delete any topology
     * @param id the id of the topology that will be deleted
     */
    public void deletetopology(String id){
        for (int i =0;;i++){
            if (topologies.get(i).getId().equals(id)){
                topologies.remove(i);
                break;
            }
        }
    }

    /**
     * this function return the components in a given topology
     * @param id the topology id
     * @return the components
     */
    public ArrayList<Component> topologycomponents(String id){
        for (Topology i : topologies) {
            if (i.getId().equals(id))  return i.getcomponent_list();
        }
        return null;
    }

    /**
     * this function get from a given topology the components which is connected to a given node
     * @param id topology id
     * @param node name of the node
     * @return
     */
    public ArrayList<Component> topologycomponentsconnectedtonode(String id, String node){
        for (Topology i : topologies) {
            if (i.getId().equals(id))  return i.getcomponent_list_connecected_tonode(node);
        }
        return null;
    }
}
