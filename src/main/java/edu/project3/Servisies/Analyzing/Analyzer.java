package edu.project3.Servisies.Analyzing;

import edu.project3.Entities.Log;
import edu.project3.Models.TableCreater;
import java.io.IOException;
import java.util.List;

public interface Analyzer {
    TableCreater analyze(List<Log> logs) throws IOException;
}
