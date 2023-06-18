package DesignPattern.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class ChainFilter implements Filter {
    List<Filter> filters = new ArrayList<>();

    public ChainFilter add(Filter filter){
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Message msg) {
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }

}
