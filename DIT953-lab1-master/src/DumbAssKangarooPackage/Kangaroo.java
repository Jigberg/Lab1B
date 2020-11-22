package DumbAssKangarooPackage;

import Carriers.Carrier;
import Carriers.IKangarooCarrier;
import Carriers.KangarooCarrier;

public class Kangaroo {
    Carrier<IKangarooCarrier, Kangaroo> carrier = new KangarooCarrier(this);

    public Carrier<IKangarooCarrier, Kangaroo> getCarrier(){ return this.carrier; }
}
