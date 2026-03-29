package appconsole;

import com.db4o.ObjectContainer;
import util.Util;

public class Consultar {
    private ObjectContainer manager;

    public Consultar() {
        Util.conectar();

        manager = Util.getManager();

    }
}
