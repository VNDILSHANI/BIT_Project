package bit.project.server.seed;

import java.util.Hashtable;
import bit.project.server.util.seed.SeedClass;
import bit.project.server.util.seed.AbstractSeedClass;

@SeedClass
public class SalestatusData extends AbstractSeedClass {

    public SalestatusData(){
        addIdNameData(1, "Sold");
        addIdNameData(2, "Not");
    }

}