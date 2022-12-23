package bit.project.server.seed;

import java.util.Hashtable;
import bit.project.server.util.seed.SeedClass;
import bit.project.server.util.seed.AbstractSeedClass;

@SeedClass
public class MaterialstatusData extends AbstractSeedClass {

    public MaterialstatusData(){
        addIdNameData(1, "Good");
        addIdNameData(2, "not");
        addIdNameData(3, "normal");
    }

}