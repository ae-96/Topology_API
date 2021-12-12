import org.json.simple.JSONObject;
import java.util.Map;

/**
 * this class represents any component as JSONObject and can be easily modified to get any
 * information about any type of components
 */
public class Component {
    private JSONObject comp ;
    public void setComp(final JSONObject comp) {
        this.comp = comp;
    }
    public JSONObject getComp() {
        return comp;
    }

    /**
     * this function is called to any component to tell if it was connected to a given node
     * @param netlistnode a string contains the node name
     * @return true if the component is connected to that node
     */
    public boolean is_connected_to_netlistnode(String netlistnode){
        if(comp.containsKey("netlist") && comp.get("netlist") instanceof JSONObject ) {
            Map netlist = ((Map)comp.get("netlist"));
            for (Map.Entry pair : (Iterable<Map.Entry>) netlist.entrySet()) {
                if (pair.getValue().equals(netlistnode) ) return true;
            }
        }
        return false;
    }
}
