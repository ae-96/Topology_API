import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

/**
 * this class represent any topology
 * each  topology must has an ID and a list of components
 * note there is no need to store components as JSONArray
 * but component cannot have any modification so if we want to
 * write to json there is no need to concatenate the array again
 */
public class Topology {
    private final String id;
    private final ArrayList<Component> component_list = new ArrayList<>();
    private final JSONArray comps;

    /**
     * this constructor just store topology data
     * @param id topology id
     * @param components topology components
     */
    public Topology(String id , JSONArray components){
        this.id = id;
        comps = components;
        for (Object i : components ){
            JSONObject temp = (JSONObject) i ;
            Component temp_comp = new Component() ;
            temp_comp.setComp(temp);
            component_list.add(temp_comp);
        }
    }
    public String getId() {
        return id;
    }
    public JSONArray getcomponents(){
       return comps;
    }
    public ArrayList<Component> getcomponent_list() {
        return component_list;
    }

    /**
     * this function is called to any topology to get the the components
     * which is connected to a given node
     * @param node a string contains the node name
     * @return alist of components connected to that node
     */
    public ArrayList<Component> getcomponent_list_connecected_tonode(String node){
        ArrayList<Component> components = new ArrayList<>();
        for(Component i : component_list){
            if(i.is_connected_to_netlistnode(node)) components.add(i);
        }
        return components;
    }
}
