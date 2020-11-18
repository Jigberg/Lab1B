package Carriers;
import DumbAssKangarooPackage.Kangaroo;
import java.util.Stack;

public class KangarooCarrier extends Carrier<IKangarooCarrier, Kangaroo>{
    public KangarooCarrier(Kangaroo attachedTo) {
        super(2, new Stack<>(), attachedTo);
    }


    @Override
    void unload() {}

    @Override
    void load(IKangarooCarrier loadType) {

    }

    @Override
    boolean isLoadable(IKangarooCarrier loadType) {
        return false;
    }
}
