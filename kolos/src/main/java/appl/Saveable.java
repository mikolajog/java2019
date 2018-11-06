package appl;

import java.io.FileNotFoundException;

public interface Saveable {
    public void SaveToFile(double x, String filename) throws FileNotFoundException;
}
