package bit.project.server.seed;

import java.util.Hashtable;
import bit.project.server.util.seed.SeedClass;
import bit.project.server.util.seed.AbstractSeedClass;

@SeedClass
public class DesignationData extends AbstractSeedClass {

    public DesignationData(){
        addIdNameData(1, "Manager");
        addIdNameData(2, "Asssitanet Estate Manger");
        addIdNameData(3, "Factory Officer");
        addIdNameData(4, "Junior Asst.Factory Officer 1,2,3");
        addIdNameData(5, "Asst.Factory Officer 1,2");
        addIdNameData(6, "Asst.Factory Officer 03 ");
        addIdNameData(7, "Factory Worker");
    }

}