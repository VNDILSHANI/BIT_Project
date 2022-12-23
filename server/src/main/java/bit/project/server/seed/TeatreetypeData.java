package bit.project.server.seed;

import java.util.Hashtable;
import bit.project.server.util.seed.SeedClass;
import bit.project.server.util.seed.AbstractSeedClass;

@SeedClass
public class TeatreetypeData extends AbstractSeedClass {

    public TeatreetypeData(){
        addIdNameData(1, "ok");
        addIdNameData(2, "normal");
        addIdNameData(3, "bad");
    }

}