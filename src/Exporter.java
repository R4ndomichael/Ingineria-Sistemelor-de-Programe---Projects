import java.util.List;

public class Exporter {
    void startExport(IStudentiExport strategyInstance, List<Student> studenti) {
        strategyInstance.doExport(studenti);
    }
}
