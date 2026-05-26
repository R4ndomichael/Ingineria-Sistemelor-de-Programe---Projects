import java.util.List;

public class ExportTimerDecorator implements IStudentiExport {
    private IStudentiExport wrapped;

    public ExportTimerDecorator(IStudentiExport wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void doExport(List<Student> studenti) {
        long start = System.currentTimeMillis();
        wrapped.doExport(studenti);
        long end = System.currentTimeMillis();
        System.out.println("Timp export: " + (end - start) + " ms");
    }
}
