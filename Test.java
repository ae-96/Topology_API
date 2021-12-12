import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * this class is test examples for all APIs and classes
 */
public class Test {
    public static void main(String[] args) throws IOException, ParseException {
        try {
            Topologylist top = new Topologylist();

            top.readjsonandstore("topology.json");

            top.writetopologytojson("test.json","top1");

            //ArrayList<topology> topologies = top.getTopologies();
            //System.out.println(topologies.get(0).getId());

            //top.deletetopology("top1");

            //ArrayList<component> topologycomponents = top.topologycomponents("top1");
            //System.out.println(topologycomponents.get(0).getComp().toJSONString());

            //ArrayList<component> topologycomponentsnode = top.topologycomponentsconnectedtonode("top1", "vdd");
            //System.out.println(topologycomponentsnode.get(0).getComp().toJSONString());
        } catch (Exception e){
            System.out.println("invalid use");
        }




    }
}
