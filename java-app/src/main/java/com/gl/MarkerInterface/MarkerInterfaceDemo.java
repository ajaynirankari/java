package com.gl.MarkerInterface;

import java.io.Serializable;
import java.rmi.Remote;

public class MarkerInterfaceDemo {
    public static void main(String[] args) throws Exception {

        Serializable s;
        Cloneable c;
        Remote r;

        Test obj = new Test();
        obj.clone();
        BusinessLogic b = new BusinessLogic();
        //b.delete(obj);
        DeletableEntity deletableEntity = new DeletableEntity();
        b.delete(deletableEntity);
    }
}

interface DeletableObject {

}

class BusinessLogic {
    void delete(Object o) {
        if (!(o instanceof DeletableObject)) {
            throw new RuntimeException("Object can not be deleted");
        }
        System.out.println("Object is deleted");
    }
}

class DeletableEntity implements DeletableObject {

}

class Test implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
