package bit.project.server.seed;

import java.util.Hashtable;
import bit.project.server.util.seed.SeedClass;
import bit.project.server.util.seed.AbstractSeedClass;

@SeedClass
public class DistributionstatusData extends AbstractSeedClass {

    public DistributionstatusData(){
        addIdNameData(1, "ok");
        addIdNameData(2, "not");
    }

}