package bit.project.server.seed;

import java.util.Hashtable;
import bit.project.server.util.seed.SeedClass;
import bit.project.server.util.seed.AbstractSeedClass;

@SeedClass
public class PorderstatusData extends AbstractSeedClass {

    public PorderstatusData(){
        addIdNameData(1, "notok");
        addIdNameData(2, "ok");
    }

}