import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by evilFrog5477 on 10/12/2018.
 */
public class FilteredImage extends SimpleImage {
    private List<Filter> filters;

    public FilteredImage(String url) throws IOException {
        super(url);
        filters = new ArrayList<Filter>();
    }

    //TODO make utility classes for this
    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public void applyAllFilters() {
        for (Filter filter : this.filters) {
            filter.applyFilter();
        }
    }

}
