package com.example.demo.SOLID;

import java.util.List;

public class DependencyInversion {
//    Upper classes and modules should not depend on the lower classes and modules; and either of them should't depend on the abstraction layer.
//    Due to a single simple modify in one has huge impact on the upper classes.
}

class FrontEndDeveloper implements Developer {

    @Override
    public void develop() {
        writeJavascript();
    }

    public void writeJavascript() {
    }

}

class BackEndDeveloper implements Developer {

    @Override
    public void develop() {
        writeJava();
    }

    private void writeJava() {
    }

}

interface Developer {
    void develop();
}

class Project {
    private List<Developer> developers;

    public Project(List<Developer> developers) {
        this.developers = developers;
    }

    public void implement() {
        developers.forEach(d -> d.develop());
    }
}
