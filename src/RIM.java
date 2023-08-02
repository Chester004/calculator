import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public enum RIM {
    C(100),L(50),X(10),
    IX(9),VIII(8),VII(7),
    VI(6),V(5),IV(4),
    III(3),II(2),I(1);

    private int convertion;

    RIM(int convertion){
        this.convertion = convertion;
    }
    public int getConvertion(){
        return convertion;
    }
}
